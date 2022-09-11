package dds.tp.carbono.entities.organization.notifications;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class NotifiactionBuilder {

    public JobDetail buildJob() {
        return JobBuilder
               .newJob(Notification.class)
               .withIdentity("notificacion a los contactos")
               .build();
    }   
}
