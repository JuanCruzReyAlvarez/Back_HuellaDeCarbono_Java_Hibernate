package dds.tp.carbono.contracts.services.auth;

import dds.tp.carbono.contracts.IoC.Injectable;
import dds.tp.carbono.entities.auth.Usuario;

public interface ILoginService extends Injectable {
    Usuario login(String username, String password);
}
