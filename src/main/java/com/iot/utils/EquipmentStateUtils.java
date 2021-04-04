package com.iot.utils;

import com.alibaba.fastjson.JSON;
import com.iot.bean.EquipmentState;

public class EquipmentStateUtils {

    public EquipmentState TransformStateJson(String StateJson){
        EquipmentState equipmentState = JSON.parseObject(StateJson, EquipmentState.class);
        return equipmentState;
    }

    public boolean CheckTemperature(EquipmentState EquipmentState , String temperature){

        String EquipmentTemperature = EquipmentState.getTemperature();
        if(Double.parseDouble(EquipmentTemperature)>Double.parseDouble(temperature)){
            return false;
        }else return true;
    }





}
