package dds.tp.carbono.entities.organization.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contacts")
public class Contacts {
    
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    
    @Column
    @Getter @Setter private String name;
    
    @Column
    @Getter @Setter private String mail;  
}
