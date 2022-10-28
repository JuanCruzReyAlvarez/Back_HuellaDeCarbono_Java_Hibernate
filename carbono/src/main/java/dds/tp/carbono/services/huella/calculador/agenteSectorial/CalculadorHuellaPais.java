package dds.tp.carbono.services.huella.calculador.agenteSectorial;
/* 
import java.util.List;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.services.external.dto.Pais;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;
import lombok.Getter;
import lombok.Setter;
 
public class CalculadorHuellaPais extends CalculadorHuella {
    @Getter @Setter private Pais pais;
    @Getter @Setter private List<Provincia> provincialTotales;
    @Getter @Setter private List<Provincia> provincias;
    
    
    public List<Provincia> filtrarProvincias(){
        for(Provincia provincia: this.getProvincialTotales()){
            if (provincia.getPais().getId().equals(this.pais.getId())){
                this.provincias.add(provincia);
            }
        }
        return this.provincias;
    }
    
    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huella = new HuellaCarbono();
        
        for (SectorTerritorial sector : this.getPais().get) {
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org,periodo,buscador);
            huella = huella.suma(calculador.calcula());
        }
        return huella;
    }
    */