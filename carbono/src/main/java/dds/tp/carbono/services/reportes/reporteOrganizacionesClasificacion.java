package dds.tp.carbono.services.reportes;

import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Clasificacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;
import lombok.Getter;
import lombok.Setter;

public class reporteOrganizacionesClasificacion extends reporte {

    @Getter @Setter private List<Organizacion> organizacionesTotales;

    @Getter @Setter private Set<Organizacion> organizaciones;
    
    @Getter @Setter private Clasificacion clasificacion;


    private void filtrarOrganizaciones(){
        for (Organizacion org: this.organizacionesTotales){
            if(org.getClasificacion().equals(this.clasificacion)){
                this.organizaciones.add(org);
            }
        }
        
    }

    @Override
    public HuellaCarbono obtenerHuellaTotal() throws Exception {
        filtrarOrganizaciones();

        HuellaCarbono hc = new HuellaCarbono();

        for(Organizacion org: this.organizaciones){
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org, this.getPeriodoDeImputacion());
            hc = hc.suma(calculador.calcula());
        }
        
        return hc;
    }
    
}
