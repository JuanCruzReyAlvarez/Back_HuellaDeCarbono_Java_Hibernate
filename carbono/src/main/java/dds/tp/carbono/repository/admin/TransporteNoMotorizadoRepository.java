package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.TransporteNoMotorizadoDao;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;

public class TransporteNoMotorizadoRepository {

    private TransporteNoMotorizadoDao dao;
   

    public TransporteNoMotorizadoRepository() {
        this.dao = TransporteNoMotorizadoDao.getInstance();
        this.dao.setClazz(MedioNoMotorizado.class);
    }
    
    public void guardar(MedioNoMotorizado servicio) {
        this.dao.save(servicio);
    }



}
