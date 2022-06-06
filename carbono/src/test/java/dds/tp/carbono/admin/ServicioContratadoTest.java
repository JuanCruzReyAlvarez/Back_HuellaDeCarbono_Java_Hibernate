package dds.tp.carbono.admin;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.entities.transport.TipoServicioContratado;
import dds.tp.carbono.repository.admin.TipoServicioContratadoRepository;
import dds.tp.carbono.services.admin.CreadorDeTipoServicioContratado;

public class ServicioContratadoTest {

    @Test
    public void crearTipoServicioContratado() throws Exception {
        CreadorDeTipoServicioContratado servicio = new CreadorDeTipoServicioContratado();

        servicio.crear("Uber");
        servicio.crear("Cabify");
        servicio.crear("remiseria");
        servicio.crear("Taxi");

        TipoServicioContratadoRepository repo = new TipoServicioContratadoRepository();

        Assert.assertTrue(repo.existe("Uber"));
        Assert.assertTrue(repo.existe("remiseria"));
        Assert.assertFalse(repo.existe("Beat"));
    }

    @Test
    public void existeTipoServicioContratado() throws Exception {
        CreadorDeTipoServicioContratado servicio = new CreadorDeTipoServicioContratado();

        try {
            servicio.crear("Uber");
            TipoServicioContratado tipo = servicio.crear("Uber");
            Assert.assertNull(tipo);
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }
}
