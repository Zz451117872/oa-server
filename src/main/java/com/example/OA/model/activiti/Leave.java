package com.example.OA.model.activiti;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class Leave implements Serializable{

    private Integer id;
    //请假类型
    @Size(max = 10)
    private String leaveType;
    //请假天数

    @Max(value = 7)
    @Min(value = 1)
    private Integer leaveNumber;
    //请假原因
    @NotEmpty
    @Size(max = 100)
    private String reason;
    //状态
    private Integer status;
    //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    //结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Date createTime;

    private Date updateTime;
    //对应的流程实例ID
    private String processinstanceid;

    private Integer application;


    public Leave() {
    }

    public Leave(Integer id, String leaveType, Integer leaveNumber, String reason, Integer status,Integer application, Date startTime, Date endTime, Date createTime, Date updateTime, String processinstanceid) {
        this.application = application;
        this.id = id;
        this.leaveType = leaveType;
        this.leaveNumber = leaveNumber;
        this.reason = reason;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.processinstanceid = processinstanceid;
    }

    public Integer getApplication() {
        return application;
    }

    public void setApplication(Integer application) {
        this.application = application;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    public Integer getLeaveNumber() {
        return leaveNumber;
    }

    public void setLeaveNumber(Integer leaveNumber) {
        this.leaveNumber = leaveNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProcessinstanceid() {
        return processinstanceid;
    }

    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid == null ? null : processinstanceid.trim();
    }


}