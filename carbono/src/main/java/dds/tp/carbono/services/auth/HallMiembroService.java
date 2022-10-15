package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.TipoDocumento;
import dds.tp.carbono.repository.member.MiembroRepository;

public class HallMiembroService {

private MiembroRepository repository;

public HallMiembroService() {
    this.repository = new MiembroRepository();
}

public Miembro register(String nombre, String apellido,String tipoDocumento,  String nroDocumento)  {
  
    Miembro miembro = this.buildMiembro(nombre, apellido, tipoDocumento, nroDocumento);
    return this.repository.guardar(miembro);
}

private Miembro buildMiembro(String nombre, String apellido, String tipoDocumento, String nroDocumento) {
    
    Miembro miembro = new Miembro();
    miembro.setNombre(nombre);
    miembro.setApellido(apellido);
    miembro.setNroDocumento(nroDocumento);
    miembro.setTipoDocumento(TipoDocumento.valueOf(tipoDocumento.toUpperCase()));
    return this.repository.guardar(miembro);
}



    
}
