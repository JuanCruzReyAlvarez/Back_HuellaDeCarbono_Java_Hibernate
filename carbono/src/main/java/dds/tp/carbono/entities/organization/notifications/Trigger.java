package dds.tp.carbono.entities.organization.notifications;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.TriggerBuilder;

public class Trigger {
    public CronTrigger buildTrigger() {
        return TriggerBuilder
               .newTrigger()
               .withIdentity("trigger 1")
               .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
               .build();   
    }
}
