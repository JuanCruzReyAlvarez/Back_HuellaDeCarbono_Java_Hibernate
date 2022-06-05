package dds.tp.carbono.services.org.metrics.metrics;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class PeriodoDeImputacion {
    @Setter
    @Getter
    private Periodicidad periodicidad;
    @Setter
    @Getter
    private LocalDate fechaInicio;

    public PeriodoDeImputacion(String periodo) throws Exception{
        if(periodo.contains("/")){
            String[] anioYMes = periodo.split("/");
            int anio = Integer.parseInt(anioYMes[1]);
            int mes = Integer.parseInt(anioYMes[0]);
            this.periodicidad = Periodicidad.MENSUAL;
            this.fechaInicio = LocalDate.of(anio, mes, 01);

        }
        else{
            int anio = Integer.parseInt(periodo);
            this.periodicidad = Periodicidad.ANUAL;
            this.fechaInicio = LocalDate.of(anio, 01, 01);
        }    
    }

}
