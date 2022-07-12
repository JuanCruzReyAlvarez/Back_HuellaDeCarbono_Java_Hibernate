package dds.tp.carbono.entities.organization.notifications;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dds.tp.carbono.entities.organization.Organizacion;

public class Notification implements Job {

    private Organizacion org;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // TODO acá se implemetaría el envío del mail y del wpp 
        System.out.println("Hola, esto es una prueba");
    }
    
}
