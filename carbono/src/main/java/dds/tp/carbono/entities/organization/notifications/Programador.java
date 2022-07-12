package dds.tp.carbono.entities.organization.notifications;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class Programador {

    private Scheduler sc;

    public Scheduler buildScheduler() throws SchedulerException {
        return sc = StdSchedulerFactory.getDefaultScheduler();  
    }

   public void startScheduler() throws SchedulerException {
        this.sc.start();
   }
   
   public void scheduleJob(JobDetail job, CronTrigger trigger) throws SchedulerException {
        this.sc.scheduleJob(job, trigger);
   }

   public void shutodwnScheduler() throws SchedulerException {
    this.sc.shutdown();
}

}
