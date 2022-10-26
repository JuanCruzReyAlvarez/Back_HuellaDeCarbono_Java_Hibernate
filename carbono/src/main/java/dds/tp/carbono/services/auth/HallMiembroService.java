package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.TipoDocumento;
import dds.tp.carbono.repository.auth.UsuarioRepository;
import dds.tp.carbono.repository.member.MiembroRepository;

public class HallMiembroService {

private MiembroRepository repository;
private UsuarioRepository urepository;

public HallMiembroService() {
    this.repository = new MiembroRepository();
    this.urepository = new UsuarioRepository();
}

public Miembro register(String nombre, String apellido,String tipoDocumento,  String nroDocumento, String user)  {
  
    Miembro miembro = this.buildMiembro(nombre, apellido, tipoDocumento, nroDocumento, user);
    return this.repository.guardar(miembro);
}

private Miembro buildMiembro(String nombre, String apellido, String tipoDocumento, String nroDocumento,String user) {
    
    Miembro miembro = new Miembro();
    miembro.setNombre(nombre);
    miembro.setApellido(apellido);
    miembro.setNroDocumento(nroDocumento);
    miembro.setTipoDocumento(TipoDocumento.valueOf(tipoDocumento.toUpperCase()));

    Usuario usuario = urepository.getUsuarioById(Integer.parseInt(user)); 
    miembro.setUser(usuario);

    return miembro;
}

}
