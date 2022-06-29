package dds.tp.carbono.contracts.http.session;

import dds.tp.carbono.entities.auth.Usuario;

public interface SessionTokenEncoding {
    public String encode(Usuario usuario);
    public Usuario decode(String token);
}
