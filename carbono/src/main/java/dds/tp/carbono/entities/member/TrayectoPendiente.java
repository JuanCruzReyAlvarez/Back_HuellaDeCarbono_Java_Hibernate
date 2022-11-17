package dds.tp.carbono.entities.member;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "trayecto_pendiente")
public class TrayectoPendiente {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    
    @OneToOne
    @Getter @Setter private Tramo tramoCompartido;

    @OneToMany(mappedBy = "trayecto_pendiente")
    @Getter @Setter private List<Miembro> miembrosPendientes;

    
    public TrayectoPendiente() {
        
    }
    
    public TrayectoPendiente(Tramo tramo) {
        this.tramoCompartido = tramo;
        this.miembrosPendientes = tramo.getCompartidos();
    }

    public Integer quitarMiembroPendiente(Miembro miembro) {
        this.miembrosPendientes.stream()
                               .filter(m -> !m.getId().equals(miembro.getId()))
                               .collect(Collectors.toList());

        return this.miembrosPendientes.size();
    }
/* 
    public void agregarMiemrbo (Miembro x) {
        this.miembrosPendientes.add(x);
        x.setTrayecto_pendiente(this);
        }
 */       
}
