package dds.tp.carbono.services.organizacion.metrics.builder;

import java.util.stream.Stream;

import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.LogisticaDeProductosServicios;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.logistica.CategoriaLogistica;
import dds.tp.carbono.entities.organization.metrics.logistica.TransporteLogistica;

public class LogisticaDeProductosServiciosBuilder {
 
    private LogisticaDeProductosServicios actividad;
    private Stream<ImportableModel> data;

    public LogisticaDeProductosServiciosBuilder(Stream<ImportableModel> stream) {
        this.actividad = new LogisticaDeProductosServicios();

        
        this.data = stream;
    }

    public LogisticaDeProductosServiciosBuilder addPeso() throws Exception {
        Double peso = (Double)this.data.filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("peso"))
            .findFirst().orElseThrow(Exception::new).getValor();

        this.actividad.setPeso(peso);
        
        return this;
    }

    public LogisticaDeProductosServiciosBuilder addDistancia() throws Exception {
        Double distancia = (Double)this.data.filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("distancia"))
            .findFirst().orElseThrow(Exception::new).getValor();
        
        this.actividad.setDistancia(distancia);

        return this;
    }

    public LogisticaDeProductosServiciosBuilder addCategoria() throws Exception {
        
        String categoria = (String)this.data.filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("categoria"))
            .findFirst().orElseThrow(Exception::new).getValor();
            
        this.actividad.setCategoria(CategoriaLogistica.getBy(categoria));
        return this;
    }

    public LogisticaDeProductosServiciosBuilder addTransporte() throws Exception {
        
        String categoria = (String)this.data.filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("medio_transporte"))
            .findFirst().orElseThrow(Exception::new).getValor();
            
        this.actividad.setCategoria(CategoriaLogistica.getBy(categoria));

        return this;
    }

    public LogisticaDeProductosServiciosBuilder addTipoConsumo() throws Exception {
        CategoriaLogistica categoria = this.actividad.getCategoria();
        TransporteLogistica transporte = this.actividad.getTransporte();
        TipoDeConsumo tipo = TipoDeConsumo.getBy(transporte, categoria);
        this.actividad.setTipoDeConsumo(tipo);
        return this;
    }

    public Actividad build() {
        return this.actividad;
    }

    
}
