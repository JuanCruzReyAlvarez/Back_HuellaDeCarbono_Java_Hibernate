package dds.tp.carbono.entities.auth;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
    @Getter @Setter private Integer id;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private Rol rol;
}
