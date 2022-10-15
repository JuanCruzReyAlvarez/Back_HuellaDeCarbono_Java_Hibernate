package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class RegisterDTO {
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private String rol;
    @Getter @Setter private String uri; // Esto viaja nulo
}