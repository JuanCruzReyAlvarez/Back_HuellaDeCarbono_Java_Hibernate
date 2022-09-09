package dds.tp.carbono.entities.agenteSectorial;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;

@Entity
@Table(name="sectorTerritorial")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name= "tipoDeTerritorio")

public abstract class SectorTerritorial {
    
    @Id
    @GeneratedValue
    @Getter @Setter Integer id;
    
    @OneToOne
    @Getter @Setter protected Usuario usuario;
    
    
    @ManyToMany
    @Getter @Setter List<Organizacion> organizaciones;
}
