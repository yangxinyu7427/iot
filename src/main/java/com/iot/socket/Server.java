package com.iot.socket;

import com.iot.bean.Connect;
import com.iot.bean.Equipment;
import com.iot.bean.EquipmentState;
import com.iot.sevlet.UserService;
import com.iot.sevlet.impl.UserSeviceImpl;
import com.iot.utils.EquipmentStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Objects;
@Service
public class Server {
    @Autowired
    UserSeviceImpl userSeviceImpl;
    public static ServerSocket serverSocket;
    static {
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void begin() throws Exception {
        while(true){
            //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket
            Socket socket = serverSocket.accept();
            new ServerThread(socket,serverSocket,userSeviceImpl).start();

        }
    }
}

class ServerThread extends Thread {

    private Socket socket;
    private ServerSocket serverSocket;
    String readline = null;
    String inTemp = null;
    String turnLine = "\n";
    final String client = "Client:";
    final String server = "Server:";
    UserSeviceImpl userSeviceImpl;
    ServerThread(Socket s,ServerSocket sc,UserSeviceImpl us) {
        socket = s;
        serverSocket=sc;
        userSeviceImpl=us;
    }

    public void run() {

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader socketIn = null;
        EquipmentStateUtils JsonUtil=new EquipmentStateUtils();
        try {
            socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter socketOut = null;
        try {
            socketOut = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date time=new Date();
        String stateString=null;
        while (!Objects.equals(readline, "received")) {
            System.out.println(time.getTime());
            System.out.println(socket.getRemoteSocketAddress().toString());
            try {
                inTemp = socketIn.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(client + turnLine + inTemp);
            Connect connect=JsonUtil.TransformConnectJson(inTemp);
            EquipmentState state=JsonUtil.TransformStateJson(connect.getEquipmentState());
            System.out.println(connect);
            System.out.println(state);
            if(userSeviceImpl.getEquipmentStateByUid(state.getEquipmentUid())!=null)
                userSeviceImpl.updateEquipmentState(state);
            else userSeviceImpl.saveEquipmentState(state);
            long times=time.getTime();
            BigInteger big = new BigInteger(String.valueOf(times));
            System.out.println(big);
            Equipment equipment=new Equipment(socket.getRemoteSocketAddress().toString(),state.getEquipmentUid(),big,1);
            if(userSeviceImpl.getEquipmentByUid(state.getEquipmentUid())!=null)
                userSeviceImpl.updateEquipment(equipment);
            else userSeviceImpl.insertEquipmentWithoutName(equipment);


            System.out.println(state);
//            try {
//                readline = systemIn.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            readline="received";
            socketOut.println(readline);
            socketOut.flush();    //赶快刷新使Client收到，也可以换成socketOut.println(readline, ture)
        }
        try {
//            systemIn.close();
            socketIn.close();
            socketOut.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



