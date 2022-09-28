package dds.tp.carbono.entities.auth;

import java.nio.charset.StandardCharsets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.hash.Hashing;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String username;
    
    @Column
    @Getter private String password;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private Rol rol;

    public void setHashPassword(String password2) {
        String sha256hex = Hashing.sha256()
                            .hashString(password2, StandardCharsets.UTF_8)
                            .toString();
                            

        this.password = sha256hex;
       
    }
}
