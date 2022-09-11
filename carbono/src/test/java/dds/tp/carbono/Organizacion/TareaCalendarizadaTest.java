package dds.tp.carbono.Organizacion;

import org.junit.Test;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;

import dds.tp.carbono.entities.organization.notifications.NotifiactionBuilder;
import dds.tp.carbono.entities.organization.notifications.Programador;
import dds.tp.carbono.entities.organization.notifications.Trigger;

public class TareaCalendarizadaTest {
    @Test
    public void tareaCalendarizada() throws SchedulerException {
        Programador sc = new Programador();
        NotifiactionBuilder notificacion = new NotifiactionBuilder();
        Trigger t1 = new Trigger();
        sc.buildScheduler();

        JobDetail job = notificacion.buildJob();
        CronTrigger trigger = t1.buildTrigger();
        
        sc.startScheduler();
        sc.scheduleJob(job, trigger);

    }
}
