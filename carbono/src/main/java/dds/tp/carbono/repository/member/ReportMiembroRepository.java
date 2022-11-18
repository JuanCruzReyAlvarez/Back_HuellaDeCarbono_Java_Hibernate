package dds.tp.carbono.repository.member;

import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.member.ReportMiembroRepositoryDao;
import dds.tp.carbono.services.reportes.ReportMiembro;

public class ReportMiembroRepository {
    private ReportMiembroRepositoryDao dao;
 
    public ReportMiembroRepository() {
        this.dao = ReportMiembroRepositoryDao.getInstance();
        this.dao.setClazz(ReportMiembro.class);
    }

    public void guardar(ReportMiembro reporte) {
        this.dao.save(reporte); 
    }

    public List<ReportMiembro> getAllReportes(){
        return dao.getAll();
    }

    public List<ReportMiembro> getAllReportesByIdMiembro(Integer idMiembro){
        return dao.getAll().stream().filter(l -> l.getIdMiembro().equals(idMiembro)).collect(Collectors.toList());
    }
    
}
