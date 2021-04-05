package com.iot.bean;

import java.math.BigInteger;

//import lombok.Data;
//
//@Data
public class Equipment  {
    private String Username;
    private Integer EquipmentId;
    private String EquipmentUrl;
    private String EquipmentUid;
    private BigInteger connectTime;
    private Integer connectState;

    public Equipment(String username, Integer equipmentId, String equipmentUrl, String equipmentUid, BigInteger connectTime, Integer connectState) {
        Username = username;
        EquipmentId = equipmentId;
        EquipmentUrl = equipmentUrl;
        EquipmentUid = equipmentUid;
        this.connectTime = connectTime;
        this.connectState = connectState;
    }

    public Equipment(String EquipmentUrl, String EquipmentUid, BigInteger connectTime, Integer connectState){
    this.EquipmentUrl=EquipmentUrl;
    this.EquipmentUid=EquipmentUid;
    this.EquipmentId=null;
    this.Username=null;
    this.connectTime=connectTime;
    this.connectState=connectState;
    }
    public Equipment(){

    }

    public void setConnectState(Integer connectState) {
        this.connectState = connectState;
    }
    public Integer getConnectState(){
        return connectState;
    }
    public BigInteger getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(BigInteger connectTime) {
        this.connectTime = connectTime;
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
