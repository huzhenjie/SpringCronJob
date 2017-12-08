package com.scrat.cron.controller;

import com.scrat.cron.job.SampleJob;
import com.scrat.cron.model.JobInfo;
import com.scrat.cron.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by scrat on 2017/12/8.
 */
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/job", method = RequestMethod.POST)
    public String createJob(@RequestBody JobInfo info) {
        boolean success = jobService.addJob(info, SampleJob.class);
        return "{\"status\":" + success + "}";
    }

    @RequestMapping(value = "/job", method = RequestMethod.DELETE)
    public String deleteJob(@RequestBody JobInfo info) {
        jobService.removeJob(info);
        return "{\"status\":true}";
    }

    @RequestMapping("/job/start_all")
    public String startAllJob() {
        jobService.startAllJob();
        return "{\"status\":true}";
    }

    @RequestMapping("/job/shutdown_all")
    public String shutdownAllJob() {
        jobService.shutdownAllJob();
        return "{\"status\":true}";
    }
}
