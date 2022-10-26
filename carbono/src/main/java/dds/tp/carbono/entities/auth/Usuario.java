package dds.tp.carbono.entities.auth;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import dds.tp.carbono.services.seguridad.Hash;
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
        Hash hasheador = new Hash();
        this.password = hasheador.setHashPassword(password2);          
    }
    public Usuario(Integer id, String username){
        this.id = id;
        this.username = username;
    }
    public Usuario(Integer id){
        this.id = id;
    }
    public Usuario(){
    }
}
