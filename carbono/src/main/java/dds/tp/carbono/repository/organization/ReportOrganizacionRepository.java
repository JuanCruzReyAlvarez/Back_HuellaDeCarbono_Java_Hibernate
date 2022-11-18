package dds.tp.carbono.repository.organization;

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
}
