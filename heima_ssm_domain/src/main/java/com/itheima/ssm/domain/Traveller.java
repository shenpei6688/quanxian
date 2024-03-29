package com.itheima.ssm.domain;
//旅客
public class Traveller {
    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    /**
     * 证件类型
     */
    private Integer credentialsType;
    private String credentialsTypeStr;
    /**
     * 证件号码
     */
    private String credentialsNum;
    /**
     * 旅客类型
     */
    private Integer travellerType;
    private String travellerTypeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {

       if(credentialsType!=null){
           if(credentialsType==0){
               credentialsTypeStr="身份证";
           }else {
               credentialsTypeStr="军官证";
           }
       }
       return  credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if( travellerType!=null){
            if(travellerType==1){
                travellerTypeStr="儿童";
            }else {
                travellerTypeStr="成人";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;

    }
}
