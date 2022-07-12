package dds.tp.carbono.Organizacion;

import org.junit.Test;

import dds.tp.carbono.entities.organization.notifications.QuartzMain;

public class TareaTest {
    @Test
    public void run() throws Exception {
        QuartzMain example = new QuartzMain();
        example.run();

        Thread.sleep(15000); // Sleep 4 minutes (4*60*1.000 = 240.000)
    }
}
