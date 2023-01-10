package com.example.Spring_Batch_Test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Slf4j
@Configuration
@EnableScheduling
public class JobScheduledConfig implements SchedulingConfigurer {

    //동시배치작업1
    private final int POOL_SIZE = 10;
    private final JobLauncher JobLauncher;
    private final Job DEPTJob;
    public JobScheduledConfig(org.springframework.batch.core.launch.JobLauncher jobLauncher, Job DEPTJob) {
        this.JobLauncher = jobLauncher;
        this.DEPTJob = DEPTJob;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("pool");
        threadPoolTaskScheduler.initialize();
        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void scheduled_vds() throws Exception {

        JobLauncher.run(DEPTJob, new JobParameters());
    }

}
