package com.iot.bean;

public class Connect {
    String Type;
    String equipmentState;

    public void setType(String type) {
        Type = type;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Connect{" +
                "Type='" + Type + '\'' +
                ", equipmentState='" + equipmentState + '\'' +
                '}';
    }
}
