package com.kingge.rtm.pojo;

import java.util.Date;

public class TKDeadMessage {
    private String msgId;

    private String msgName;

    private String topic;

    private String queneName;

    private String msgContent;

    private String msgStatus;

    private String msgDStatus;

    private String retryCounts;

    private String checkUrl;

    private String checkTimeout;

    private String checkDuration;

    private String createMsgUid;

    private Date createMsgTime;

    private String updateMsgUid;

    private Date updateMsgTime;

    private Date confirmMsgTime;

    private String resendMsgUid;

    private Date resendMsgTime;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName == null ? null : msgName.trim();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getQueneName() {
        return queneName;
    }

    public void setQueneName(String queneName) {
        this.queneName = queneName == null ? null : queneName.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus == null ? null : msgStatus.trim();
    }

    public String getMsgDStatus() {
        return msgDStatus;
    }

    public void setMsgDStatus(String msgDStatus) {
        this.msgDStatus = msgDStatus == null ? null : msgDStatus.trim();
    }

    public String getRetryCounts() {
        return retryCounts;
    }

    public void setRetryCounts(String retryCounts) {
        this.retryCounts = retryCounts == null ? null : retryCounts.trim();
    }

    public String getCheckUrl() {
        return checkUrl;
    }

    public void setCheckUrl(String checkUrl) {
        this.checkUrl = checkUrl == null ? null : checkUrl.trim();
    }

    public String getCheckTimeout() {
        return checkTimeout;
    }

    public void setCheckTimeout(String checkTimeout) {
        this.checkTimeout = checkTimeout == null ? null : checkTimeout.trim();
    }

    public String getCheckDuration() {
        return checkDuration;
    }

    public void setCheckDuration(String checkDuration) {
        this.checkDuration = checkDuration == null ? null : checkDuration.trim();
    }

    public String getCreateMsgUid() {
        return createMsgUid;
    }

    public void setCreateMsgUid(String createMsgUid) {
        this.createMsgUid = createMsgUid == null ? null : createMsgUid.trim();
    }

    public Date getCreateMsgTime() {
        return createMsgTime;
    }

    public void setCreateMsgTime(Date createMsgTime) {
        this.createMsgTime = createMsgTime;
    }

    public String getUpdateMsgUid() {
        return updateMsgUid;
    }

    public void setUpdateMsgUid(String updateMsgUid) {
        this.updateMsgUid = updateMsgUid == null ? null : updateMsgUid.trim();
    }

    public Date getUpdateMsgTime() {
        return updateMsgTime;
    }

    public void setUpdateMsgTime(Date updateMsgTime) {
        this.updateMsgTime = updateMsgTime;
    }

    public Date getConfirmMsgTime() {
        return confirmMsgTime;
    }

    public void setConfirmMsgTime(Date confirmMsgTime) {
        this.confirmMsgTime = confirmMsgTime;
    }

    public String getResendMsgUid() {
        return resendMsgUid;
    }

    public void setResendMsgUid(String resendMsgUid) {
        this.resendMsgUid = resendMsgUid == null ? null : resendMsgUid.trim();
    }

    public Date getResendMsgTime() {
        return resendMsgTime;
    }

    public void setResendMsgTime(Date resendMsgTime) {
        this.resendMsgTime = resendMsgTime;
    }
}