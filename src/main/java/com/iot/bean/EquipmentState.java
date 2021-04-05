package com.iot.bean;

public class EquipmentState {

    private String equipmentUid;
    private String temperature;
    private String humidity;
    private Integer eggNumber;

    public void setEquipmentUid(String ID) {
        this.equipmentUid = ID;
    }
    public void setEggNumber(Integer eggNumber){this.eggNumber=eggNumber;}
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public void setHumidity(String humidity){
        this.humidity = humidity;
    }
    public String getHumidity() {
        return humidity;
    }
    public String getTemperature() {
        return temperature;
    }
    public String getEquipmentUid() {
        return equipmentUid;
    }
    public Integer getEggNumber(){return eggNumber;}
    public String toString(){
        return "[equipmentUid=" + equipmentUid
                   + ",temperature=" + temperature
                + ",EggNumber=" + eggNumber
                   + ",humidity=" + humidity + "]";
    }
}
