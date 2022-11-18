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

        public List<ReportOrganizacion> getAllReportesByProvinciaOrganizacion(Integer idProvincia){
            OrganizacionRepository orgrepo = new OrganizacionRepository();
            List<ReportOrganizacion> listaReportes = new ArrayList<ReportOrganizacion>();
            List<ReportOrganizacion> listaReportesFiltrada = new ArrayList<ReportOrganizacion>();

            listaReportes = dao.getAll().stream().collect(Collectors.toList());

            for(ReportOrganizacion reporte : listaReportes){
                if( orgrepo.getById(reporte.getIdOrganizacion()).getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId() == idProvincia){
                    listaReportesFiltrada.add(reporte);
                }
            }
            return listaReportesFiltrada;
        }
        public List<ReportOrganizacion> getAllReportesByMunicipioOrganizacion(Integer idMunicipio){
            OrganizacionRepository orgrepo = new OrganizacionRepository();
            List<ReportOrganizacion> lista = new ArrayList<ReportOrganizacion>();
            List<ReportOrganizacion> listaFiltrada = new ArrayList<ReportOrganizacion>();
            lista = dao.getAll().stream().collect(Collectors.toList());

            for(ReportOrganizacion reporte : lista){
                if( orgrepo.getById(reporte.getIdOrganizacion()).getUbicacion().getLocaldiad().getMunicipio().getId() == idMunicipio){
                    listaFiltrada.add(reporte);
                }
            }
            return listaFiltrada;
        }
}
