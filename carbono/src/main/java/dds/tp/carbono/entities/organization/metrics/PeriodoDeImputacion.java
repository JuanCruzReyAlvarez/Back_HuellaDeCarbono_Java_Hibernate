package dds.tp.carbono.entities.organization.metrics;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="periodoDeImputacion")
public class PeriodoDeImputacion {

    @Id 
    @GeneratedValue 
    @Getter @Setter private Integer id;

    @Enumerated(EnumType.STRING)
    @Setter @Getter private Periodicidad periodicidad;
    
    @Transient
    @Setter @Getter private LocalDate fechaInicio;                //Hay que convertir de localdate tima a loq ue sea.

    public PeriodoDeImputacion(String periodo) throws Exception {
        if (periodo.contains("/"))
            this.periodicidadMensual(periodo);
        else 
            this.periodicidadAnual(periodo);       
    }    
    
    private void periodicidadAnual(String periodo) {
        int anio = Integer.parseInt(periodo);
        this.periodicidad = Periodicidad.ANUAL;
        this.fechaInicio = LocalDate.of(anio, 01, 01);
    }

    private void periodicidadMensual(String periodo) {
        String[] anioYMes = periodo.split("/");
        int anio = Integer.parseInt(anioYMes[1]);
        int mes = Integer.parseInt(anioYMes[0]);
        this.periodicidad = Periodicidad.MENSUAL;
        this.fechaInicio = LocalDate.of(anio, mes, 01);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        
        if (obj instanceof PeriodoDeImputacion) {
            PeriodoDeImputacion period = (PeriodoDeImputacion) obj;

            if (period.getPeriodicidad().equals(this.periodicidad) && 
                period.getFechaInicio().equals(this.fechaInicio))
                return true;
        }

        return false;
    }
}
