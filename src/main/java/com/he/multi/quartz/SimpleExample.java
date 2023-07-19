//package com.he.multi.quartz;
//
//import org.quartz.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SimpleExample implements ApplicationRunner {
//
//  public static   Logger log = LoggerFactory.getLogger(SimpleExample.class);
//
//  private  Scheduler scheduler;
//
//  public SimpleExample(){}
//
//  @Autowired
//  public SimpleExample(Scheduler scheduler) {
//    this.scheduler = scheduler;
//  }
//
//
//
//
//
//  @Override
//  public void run(ApplicationArguments args) throws Exception {
//
//
////    StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
////
////    Scheduler scheduler = stdSchedulerFactory.getScheduler();
////
////
////    long time = TriggerUtils.getNextGivenSecondDate(null, 15).getTime();
////
////
////    JobDetail jobDetail = new JobDetail("job1", "group1", Test1Job.class);
////
////    SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1", "group1", new Date(time));
////
////    Date date = scheduler.scheduleJob(jobDetail, simpleTrigger);
//
//    String jobName ="job1";
//    String groupName ="group1";
//
//    JobDetail jobDetail;
//    Trigger trigger;
//
//    if(!scheduler.checkExists(new JobKey(jobName,groupName))) {
//      // 创建任务
//       jobDetail = JobBuilder.newJob(Test1Job.class)
//              .withIdentity(jobName, groupName
//              ).build();
//
//      // 创建触发器
////       trigger = TriggerBuilder.newTrigger()
////              .withIdentity("trigger1", "group1")
////              .startNow()
////              .withSchedule(SimpleScheduleBuilder.simpleSchedule()
////                      .withIntervalInSeconds(10)
////                      .repeatForever())
////              .build();
//
//      trigger = TriggerBuilder.newTrigger()
//              .withIdentity("trigger1", "group1")
//              .startNow()
//              .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * ? * * *"))
//              .build();
//
//      scheduler.scheduleJob(jobDetail,trigger);
//    }
//
//
//    scheduler.start();
//
//  }
//}
