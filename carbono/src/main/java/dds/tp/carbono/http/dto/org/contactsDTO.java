package dds.tp.carbono.http.dto.org;

import lombok.Getter;
import lombok.Setter;

public class ContactsDTO {
    @Getter @Setter private String nombre;
    @Getter @Setter private String email;
    @Getter @Setter private String celular;
    @Getter @Setter private String userId;
}

