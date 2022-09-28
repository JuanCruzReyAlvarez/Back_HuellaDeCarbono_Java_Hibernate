package dds.tp.carbono.entities.organization.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import dds.tp.carbono.entities.organization.Organizacion;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contactos")
public class Contacts implements Contactable{
    
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    
    @Column
    @Getter @Setter private String name;
    
    @Column
    @Getter @Setter private String mail;
    
    @Column
    @Getter @Setter private String celular;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    @Setter @Getter private Organizacion organizacion;

    @Override
    public String telefono() {
        return celular;
    }
}
