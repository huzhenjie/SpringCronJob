package com.scrat.cron.service;

import com.scrat.cron.job.SampleJob;
import com.scrat.cron.model.JobInfo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by scrat on 2017/12/8.
 */
@Service
public class JobService {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public boolean addJob(JobInfo info, Class<? extends Job> jobClass) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .setJobData(SampleJob.createJobDataMap(info.getJobName()))
                    .withIdentity(info.getJobName(), info.getJobGroupName())
                    .build();

            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger()
                    .withIdentity(info.getTriggerName(), info.getTriggerGroupName())
                    .startNow();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(info.getCron()));
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void removeJob(JobInfo info) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(info.getTriggerName(), info.getTriggerGroupName());
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(info.getJobName(), info.getJobGroupName()));
        } catch (Exception e) {
            e.printStackTrace();
            // ignore
        }
    }

    public void startAllJob() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
            // ignore
        }
    }

    public void shutdownAllJob() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // ignore
        }
    }

}
