package dds.tp.carbono.distancia;

import java.util.List;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.ubicacion.UbicacionesCacheDecorator;
import dds.tp.carbono.services.ubicacion.UbicacionesService;

public class UbicacionesServicioExternoCacheTest {

    private static final long DELAY = 2000;

    private UbicacionesService service;
    // @Test
    public void requestLocalidades() throws Exception {
        this.service = new UbicacionesCacheDecorator();

        List<Provincia> provincias = this.service.listadoDeProvincias();
        
        System.out.println("Provincias");
        for (Provincia prov : provincias) {
            System.out.println(String.format("%d - %s", prov.getId(), prov.getNombre()));
            System.out.println(String.format("Municipios de %s", prov.getNombre()));
            
            Thread.sleep(DELAY);
            
            List<Municipio> municipios = this.service.listadoDeMunicipios(prov);

            for (Municipio muni : municipios) {
                System.out.println(String.format("%d - %s", muni.getId(), muni.getNombre()));
                System.out.println(String.format("Localidades de %s", muni.getNombre()));

                Thread.sleep(DELAY);

                List<Localidad> localidades = this.service.listadoDeLocalidades(muni);
                for (Localidad loc : localidades) {
                    System.out.println(String.format("%d - %s", loc.getId(), loc.getNombre()));
                }
            }
        }
    }
}
