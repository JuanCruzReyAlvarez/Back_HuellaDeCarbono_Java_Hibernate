package dds.tp.carbono.services.distancia;


import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.member.TrayectoRepository;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.ServicioContratado;
import dds.tp.carbono.entities.transport.TipoServicioContratado;
import dds.tp.carbono.entities.transport.TipoTransportePublico;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.TransportePublico;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.http.controllers.member.trayectos.AcompanianteDTO;
import dds.tp.carbono.http.controllers.member.trayectos.TramoDTO;
import dds.tp.carbono.repository.PuntoGeografico.PuntoGeograficoRepository;
//import dds.tp.carbono.repository.PuntoGeografico.PuntoGeograficoRepository;
import dds.tp.carbono.repository.admin.LineaRepository;
import dds.tp.carbono.services.distancia.TrayectoService;

public class TrayectoService {

    private TrayectoRepository repository;
    private MiembroRepository miembroRepository;
    private PuntoGeograficoRepository puntoGeograficoRepository;


    public TrayectoService() {
        this.repository = new TrayectoRepository();
        this.miembroRepository = new MiembroRepository();
        this.puntoGeograficoRepository = new PuntoGeograficoRepository();
    }

    public void crear(Trayecto trayecto)  {
           
           //puntoGeograficoRepository.saveOne(trayecto.getPuntoLlegada());
           //puntoGeograficoRepository.saveOne(trayecto.getPuntoPartida());
           this.procesarTransporte(trayecto);
           
           repository.guardar(trayecto);
    }

    public Tramo setPuntosLlegadasTramo( TramoDTO tramoDTO ){

        PuntoGeografico inicio = new PuntoGeografico(tramoDTO.getAlturaInicial()
                                    ,tramoDTO.getCalleInicial()
                                    ,Integer.parseInt(tramoDTO.getLocalidadInicial()));                         
        
        PuntoGeografico finall = new PuntoGeografico(tramoDTO.getAlturaFinal()
                                    ,tramoDTO.getCalleFinal()
                                    ,Integer.parseInt(tramoDTO.getLocalidadFinal())); 


        Tramo tramo = new Tramo();
        tramo.setPuntoA(inicio);
        tramo.setPuntoB(finall);

        return tramo;
    }
    
    public Tramo setTransporte(Tramo tramo, TramoDTO tramoDTO){
        System.out.println("Entre a set transporte");
        String medioDTO = tramoDTO.getTipo_Medio_De_Transporte();
        System.out.println(tramoDTO.getTipo_Medio_De_Transporte());

        switch (medioDTO) {
            case "No_Motorizado":
                MedioNoMotorizado medioNoMotorizado = new MedioNoMotorizado();
                medioNoMotorizado.setTipoMedioNoMotorizadoByString(tramoDTO.getTipo_de_No_Motorizado());
                tramo.setTransporte(medioNoMotorizado);
                
                return tramo; 
            case "Servicio_Contratado": 
                ServicioContratado medioContratado = new ServicioContratado();
                TipoServicioContratado tipoServicioContratado = new TipoServicioContratado(
                                                                    tramoDTO.getLinea_Servicio_Contratado());
                medioContratado.setTipo(tipoServicioContratado);
                medioContratado.setCombustible(TipoDeConsumo.getByDTO(tramoDTO.getTipo_combustible_Servicio_Contratado()));
                tramo.setTransporte(medioContratado);
                
                return tramo;
            case "Transporte_Publico": 
                System.out.println("Entre Atransporte publico");
                TransportePublico transportePublico = new TransportePublico(TipoTransportePublico.getByDTO(tramoDTO.getTipo_transporte_publico())
                                                                           ,TipoDeConsumo.getByDTO(tramoDTO.getTipo_combustible_Transporte_Publico()));
                
                System.out.println(111111111);
                LineaRepository lineaRepository = new LineaRepository();
                System.out.println(111111111);
                Linea linea = new Linea();
                System.out.println(111111111);
                linea = lineaRepository.getById(Integer.parseInt(tramoDTO.getIdLinea()));
                System.out.println(111111111);
                transportePublico.setLinea(linea); 
                System.out.println(111111111);
                tramo.setTransporte(transportePublico);
                return tramo;
            case "Vehiculo_Particular": 
                VehiculoParticular vehiculoParticular = new VehiculoParticular(TipoVehiculoParticular.getByDTO(tramoDTO.getTipo_Vehiculo_Particular())
                                                                             ,TipoDeConsumo.getByDTO(tramoDTO.getTipo_combustible_Vehiculo_Particular()));
                tramo.setTransporte(vehiculoParticular);
                return tramo;
            default: System.out.println("Medio De Transporte Desconocido");
        }

        return null;

    }

        public Tramo setAcompaniantes(Tramo tramo, TramoDTO tramoDTO){
           List<AcompanianteDTO> acompaniantes = new ArrayList<AcompanianteDTO>();
           List<Miembro> miembros = new ArrayList<Miembro>(); 
           acompaniantes = tramoDTO.getAcompaniante();

            for(AcompanianteDTO acompaniante: acompaniantes){
                Miembro miembro = new Miembro();
                miembro = miembroRepository.getByNameAndLastName(acompaniante.getApellido_Acompaniante(), acompaniante.getNombre_Acompaniante());
                miembros.add(miembro);           
            }

            tramo.setCompartidos(miembros);

            return tramo;
                 
        }

        public Trayecto setInicioYFin(Trayecto trayecto){ 

            PuntoGeografico inicio = new PuntoGeografico();                         
            PuntoGeografico finall = new PuntoGeografico(); 

            inicio = trayecto.getTramos().get(0).getPuntoA();
            finall = trayecto.getTramos().get(trayecto.getTramos().size() - 1).getPuntoB();

            trayecto.setPuntoPartida(inicio);
            trayecto.setPuntoLlegada(finall);

            return trayecto;
            
        }  

        public void procesarTransporte (Trayecto trayecto){



        }
    
}
