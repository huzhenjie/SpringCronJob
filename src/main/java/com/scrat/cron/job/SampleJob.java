package com.scrat.cron.job;

import org.quartz.*;

import java.util.Date;

/**
 * Created by scrat on 2017/12/8.
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SampleJob implements Job {
    private static final String JOB_NAME = "jobName";

    public static JobDataMap createJobDataMap(String jobName) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobName", jobName);
        return jobDataMap;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobName = dataMap.getString(JOB_NAME);
        System.out.println("\n ====== executing ====== ");
        System.out.println(jobName);
        System.out.println(" ====== " + new Date() + " ====== \n");
    }
}
