package com.he.multi.config
        ;

import com.he.multi.quartz.SampleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {


    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Scheduler scheduler() throws Exception {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");

        schedulerFactoryBean.setApplicationContext(this.applicationContext);

        schedulerFactoryBean.afterPropertiesSet();

        return schedulerFactoryBean.getScheduler();
    }


    @Bean
    public Trigger sampleTrigger(JobDetail sampleJobDetail){

        return TriggerBuilder.newTrigger()
                .withIdentity("sampleTrigger","sampleGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/15 * * ? * * *"))
                .forJob(sampleJobDetail)
                .build();
    }

    @Bean
    public JobDetail sampleJobDetail(){

        return JobBuilder.newJob(SampleJob.class)
                .withIdentity("sampleJob","sampleGroup")
                .storeDurably()
                .build();
    }

}
