package com.itheima.ssm.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

public class SysLog {
    private  String id;
    private Date visitTime;
    private String  visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public SysLog() {
    }

    public SysLog(String id, Date visitTime, String visitTimeStr, String username, String ip, String url, Long executionTime, String method) {
        this.id = id;
        this.visitTime = visitTime;
        this.visitTimeStr = visitTimeStr;
        this.username = username;
        this.ip = ip;
        this.url = url;
        this.executionTime = executionTime;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String visitTimeStr = df.format(visitTime);//获取String类型的时间
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
