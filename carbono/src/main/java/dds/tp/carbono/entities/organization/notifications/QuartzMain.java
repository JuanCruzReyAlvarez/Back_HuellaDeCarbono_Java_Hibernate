package dds.tp.carbono.entities.organization.notifications;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

    public void run() throws SchedulerException {
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = JobBuilder
                        .newJob(Notification.class)
                        .build();

        CronTrigger trigger = TriggerBuilder
                              .newTrigger()
                              .withIdentity("trigger 1")
                              .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
                              .build();
        
        sc.start();
        sc.scheduleJob(job, trigger);

    }
    public static void main(String[] args) throws SchedulerException {
        QuartzMain example = new QuartzMain();
        example.run();
    }
}
