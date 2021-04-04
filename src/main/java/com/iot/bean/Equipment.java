package com.iot.bean;

//import lombok.Data;
//
//@Data
public class Equipment  {
    private String Username;
    private Integer EquipmentId;
    private String EquipmentUrl;
    private String EquipmentUid;

    public Equipment(String EquipmentUrl,String EquipmentUid){
    this.EquipmentUrl=EquipmentUrl;
    this.EquipmentUid=EquipmentUid;
    this.EquipmentId=null;
    this.Username=null;
    }
    public String getEquipmentUid(){return EquipmentUid;}

    public void setEquipmentUid(String equipmentUid) {
        EquipmentUid = equipmentUid;
    }

    public Integer getEquipmentId() {
        return EquipmentId;
    }

    public String getEquipmentUrl() {
        return EquipmentUrl;
    }

    public void setEquipmentId(Integer equipmentId) {
        EquipmentId = equipmentId;
    }

    public void setEquipmentUrl(String equipmentUrl) {
        EquipmentUrl = equipmentUrl;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
    public String toString(){
        return "[Username=" + Username
                + ",EquipmentId=" + EquipmentId
                + ",EquipmentUrl=" + EquipmentUrl
                + ",EquipmentUid=" + EquipmentUid + "]";
    }
}
