package com.iot;

import com.iot.sevlet.impl.UserSeviceImpl;
import com.iot.socket.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication(scanBasePackages = {"com.iot"})

public class FridgeIotApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FridgeIotApplication.class, args);
        Server socketserver=(Server) context.getBean("server");
//        UserSeviceImpl userSeviceImpl=(UserSeviceImpl)context.getBean("userSeviceImpl");
        try {
            socketserver.begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
