package dds.tp.carbono.services.auth.session;

import com.google.gson.Gson;

import dds.tp.carbono.contracts.http.session.SessionTokenEncoding;
import dds.tp.carbono.entities.auth.Usuario;
import java.util.Base64;

public class Base64SessionTokenEncoding implements SessionTokenEncoding {

    @Override
    public String encode(Usuario usuario) {
        String json = new Gson().toJson(usuario);
        return Base64.getEncoder().encodeToString(json.getBytes());
    }

    @Override
    public Usuario decode(String token) {
        String json = new String(Base64.getDecoder().decode(token));
        return new Gson().fromJson(json, Usuario.class);
    }
}
