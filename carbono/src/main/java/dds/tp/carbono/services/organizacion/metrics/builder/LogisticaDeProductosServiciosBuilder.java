package dds.tp.carbono.services.organizacion.metrics.builder;

import java.util.Arrays;

import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.LogisticaDeProductosServicios;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.logistica.CategoriaLogistica;
import dds.tp.carbono.entities.organization.metrics.logistica.TransporteLogistica;

public class LogisticaDeProductosServiciosBuilder {
 
    private LogisticaDeProductosServicios actividad;
    private ImportableModel[] data;

    public LogisticaDeProductosServiciosBuilder(ImportableModel[] importables) {
        this.actividad = new LogisticaDeProductosServicios();
        this.data = importables;
    }

    public LogisticaDeProductosServiciosBuilder addPeso() throws Exception {
        Double peso = (Double)Arrays.stream(this.data).filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("peso"))
            .findFirst().orElseThrow(Exception::new).getValor();

        this.actividad.setPeso(peso);
        
        return this;
    }

    public LogisticaDeProductosServiciosBuilder addDistancia() throws Exception {
        Double distancia = (Double)Arrays.stream(this.data).filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("distancia"))
            .findFirst().orElseThrow(Exception::new).getValor();
        
        this.actividad.setDistancia(distancia);

        return this;
    }

    public LogisticaDeProductosServiciosBuilder addCategoria() throws Exception {
        
        String categoria = (String)Arrays.stream(this.data).filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("categoria"))
            .findFirst().orElseThrow(Exception::new).getValor();
            
        this.actividad.setCategoria(CategoriaLogistica.getBy(categoria));
        return this;
    }

    public LogisticaDeProductosServiciosBuilder addTransporte() throws Exception {
        
        String transporte = (String)Arrays.stream(this.data).filter(i -> i.getTipoDeConsumo().equalsIgnoreCase("medio_transporte"))
            .findFirst().orElseThrow(Exception::new).getValor();
            
        this.actividad.setTransporte(TransporteLogistica.getBy(transporte));

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
