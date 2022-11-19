package dds.tp.carbono.entities.agenteSectorial;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;

@Entity
@Table(name="sector_Territorial")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name= "tipo_Territorio")

public abstract class SectorTerritorial {
    
    @Id
    @GeneratedValue
    @Getter @Setter Integer id;

    
    @OneToOne
    @Getter @Setter protected Usuario usuario;
    
    
    @OneToMany(mappedBy = "sectorTerritorial",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)  
    @Getter @Setter List<Organizacion> organizaciones;

    
    public void agregarOrganizacion (Organizacion x) {
        this.organizaciones.add(x);
        x.setSectorTerritorial(this);
    }

    public String tipo() {
        return " ";
    }

}
