package dds.tp.carbono.http.utils;

import dds.tp.carbono.contracts.http.session.SessionTokenEncoding;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.services.auth.session.Base64SessionTokenEncoding;
import lombok.Getter;

public class SessionCookie {
    
    @Getter private Usuario user;
    @Getter private String token;

    private SessionTokenEncoding tokenEncoder = new Base64SessionTokenEncoding();

    public SessionCookie(Usuario usuario) {
        this.user = usuario; 
        this.token = this.tokenEncoder.encode(usuario);
    }

    public SessionCookie(String token) {
        this.token = token;
        this.user = this.tokenEncoder.decode(token);
    }
}
