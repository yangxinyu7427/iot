package com.iot.mapper;

import com.iot.bean.Equipment;
import com.iot.bean.EquipmentState;
import com.iot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    public User getUserByid(String username);
    public void insertUser(User user);
    public List<Equipment> getEquipmentByUsername(String username);
    public void insertEquipment(String UserName,String EquipmentUid);//绑定设备
    public Equipment getEquipmentByUid(String EquipmentUid);
    public void updatePsd(User user);
    public void saveEquipmentState(EquipmentState equipmentState);
    public void insertEquipmentWithoutName(Equipment equipment);
    public void updateEquipment(Equipment equipment);
    public void updateEquipmentState(EquipmentState equipmentState);
    public EquipmentState getEquipmentStateByUid(String EquipmentUid);
}
