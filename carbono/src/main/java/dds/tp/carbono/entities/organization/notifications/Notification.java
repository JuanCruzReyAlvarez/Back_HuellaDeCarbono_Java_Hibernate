package dds.tp.carbono.entities.organization.notifications;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class Notification implements Job {

    //private Organizacion org;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // acá se implemetaría el envío del mail y del wpp 
        System.out.println("Hola, esto es una prueba");
    }
    
} // testear el funcionamiento sin necesidad de testear el job, la logica antes.
