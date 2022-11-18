package dds.tp.carbono.repository.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.org.ReportOrganizacionDao;
import dds.tp.carbono.services.reportes.ReportOrganizacion;

public class ReportOrganizacionRepository {
    
        private ReportOrganizacionDao dao; 
    
        public ReportOrganizacionRepository() {
            this.dao = ReportOrganizacionDao.getInstance();
            this.dao.setClazz(ReportOrganizacion.class);
        }
    
        public void guardar(ReportOrganizacion reporte) {
            this.dao.save(reporte); 
        }

        public List<ReportOrganizacion> getAllReportesByIdOrganizacion(Integer idOrganizacion){
            return dao.getAll().stream().filter(l -> l.getIdOrganizacion().equals(idOrganizacion)).collect(Collectors.toList());
        }

        public List<ReportOrganizacion> getAllReportesByProvinciaOrganizacion(String nombreProvincia){
            OrganizacionRepository orgrepo = new OrganizacionRepository();
            List<ReportOrganizacion> lista = new ArrayList<ReportOrganizacion>();
            List<ReportOrganizacion> listaFiltrada = new ArrayList<ReportOrganizacion>();
            lista = dao.getAll().stream().collect(Collectors.toList());
            for(ReportOrganizacion reporte : lista){
                if( orgrepo.getById(reporte.getId()).getUbicacion().getLocaldiad().getMunicipio().getProvincia().getNombre()  ==nombreProvincia){
                    listaFiltrada.add(reporte);
                }
            }
            return listaFiltrada;
        }
        public List<ReportOrganizacion> getAllReportesByMunicipioOrganizacion(String nombreMunicipio){
            OrganizacionRepository orgrepo = new OrganizacionRepository();
            List<ReportOrganizacion> lista = new ArrayList<ReportOrganizacion>();
            List<ReportOrganizacion> listaFiltrada = new ArrayList<ReportOrganizacion>();
            lista = dao.getAll().stream().collect(Collectors.toList());
            for(ReportOrganizacion reporte : lista){
                if( orgrepo.getById(reporte.getId()).getUbicacion().getLocaldiad().getMunicipio().getNombre()  == nombreMunicipio){
                    listaFiltrada.add(reporte);
                }
            }
            return listaFiltrada;
        }
}
