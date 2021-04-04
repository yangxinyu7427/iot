package com.iot.sevlet.impl;

import com.iot.bean.Equipment;
import com.iot.bean.EquipmentState;
import com.iot.bean.User;
import com.iot.mapper.UserMapper;
import com.iot.sevlet.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(String username){
        return userMapper.getUserByid(username);
    }

    public void saveUser(User user){
        userMapper.insertUser(user);
    }

    public List<Equipment> getEquipmentByUsername(String username){
        return userMapper.getEquipmentByUsername(username);
    }

    public void saveEquipment(String UserName,String EquipmentUid){
        userMapper.insertEquipment(UserName,EquipmentUid);
    }
    public Equipment getEquipmentByUid(String EquipmentUid){

        return userMapper.getEquipmentByUid(EquipmentUid);
    }
    public void updatePsd(User user){
        userMapper.updatePsd(user);
    };
    public void saveEquipmentState(EquipmentState equipmentState){
        userMapper.saveEquipmentState(equipmentState);
    }
    public void insertEquipmentWithoutName(Equipment equipment){
        userMapper.insertEquipmentWithoutName(equipment);
    }
    public void updateEquipment(Equipment equipment){
        userMapper.updateEquipment(equipment);
    }
    public void updateEquipmentState(EquipmentState equipmentState){
        userMapper.updateEquipmentState(equipmentState);
    }
    public EquipmentState getEquipmentStateByUid(String EquipmentUid){
        return userMapper.getEquipmentStateByUid(EquipmentUid);
    }
}
