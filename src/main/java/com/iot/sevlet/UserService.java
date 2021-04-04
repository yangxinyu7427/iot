package com.iot.sevlet;

import com.iot.bean.Equipment;
import com.iot.bean.EquipmentState;
import com.iot.bean.User;

import java.util.List;

public interface UserService {

    public User getUserById(String username);
    public Equipment getEquipmentByUid(String EquipmentUid);
    public List<Equipment> getEquipmentByUsername(String username);
    public void saveUser(User user);
    public void saveEquipment(String UserName,String EquipmentUid);
    public void updatePsd(User user);
    public void saveEquipmentState(EquipmentState equipmentState);
    public void insertEquipmentWithoutName(Equipment equipment);
    public void updateEquipment(Equipment equipment);
    public void updateEquipmentState(EquipmentState equipmentState);
    public EquipmentState getEquipmentStateByUid(String EquipmentUid);
}
