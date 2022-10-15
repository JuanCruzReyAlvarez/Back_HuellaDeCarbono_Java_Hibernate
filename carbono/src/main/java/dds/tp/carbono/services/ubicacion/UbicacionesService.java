package dds.tp.carbono.services.ubicacion;

import java.util.List;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;

public interface UbicacionesService {

    public List<Provincia> listadoDeProvincias() throws Exception;
    public List<Municipio> listadoDeMunicipios() throws Exception;
    public List<Localidad> listadoDeLocalidades() throws Exception;
    public List<Municipio> listadoDeMunicipios(Provincia provincia) throws Exception;
    public List<Localidad> listadoDeLocalidades(Municipio municipio) throws Exception;
}
