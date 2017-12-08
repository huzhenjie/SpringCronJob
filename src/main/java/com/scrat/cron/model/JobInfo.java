package com.scrat.cron.model;

/**
 * Created by scrat on 2017/12/8.
 */
public class JobInfo {
    private String jobName;
    private String jobGroupName;
    private String triggerName;
    private String triggerGroupName;
    private String cron;

    public String getJobName() {
        return jobName;
    }

    public JobInfo setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public JobInfo setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
        return this;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public JobInfo setTriggerName(String triggerName) {
        this.triggerName = triggerName;
        return this;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public JobInfo setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
        return this;
    }

    public String getCron() {
        return cron;
    }

    public JobInfo setCron(String cron) {
        this.cron = cron;
        return this;
    }
}
