package dds.tp.carbono.repository.organization;


import dds.tp.carbono.entities.organization.metrics.Actividad;

public class ActividadOrganizacionRepository  {
    
    private ActividadOrganizacionDao dao; 

    public ActividadOrganizacionRepository() {
        this.dao = ActividadOrganizacionDao.getInstance();
        this.dao.setClazz(Actividad.class);
    }

    
    public Actividad getActividadOrganizacion(Integer idActOrg) {
        return this.dao.getActividadOrganizacion(idActOrg);
    }

}
