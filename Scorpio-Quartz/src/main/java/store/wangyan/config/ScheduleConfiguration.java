package store.wangyan.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import store.wangyan.task.DemoJob01;

@Configuration
public class ScheduleConfiguration {

    @Bean
    public JobDetail demoJob01() {
        return JobBuilder.newJob(DemoJob01.class)
                .withIdentity("demoJob01") // 名字为 demoJob02
                .storeDurably() // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。
                .build();
    }

    @Bean
    public Trigger demoJob01Trigger() {
        // 基于 Quartz Cron 表达式的调度计划的构造器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");
        // Trigger 构造器
        return TriggerBuilder.newTrigger()
                .forJob(demoJob01()) // 对应 Job 为 demoJob02
                .withIdentity("demoJob02Trigger") // 名字为 demoJob02Trigger
                .withSchedule(scheduleBuilder) // 对应 Schedule 为 scheduleBuilder
                .build();
    }
}
