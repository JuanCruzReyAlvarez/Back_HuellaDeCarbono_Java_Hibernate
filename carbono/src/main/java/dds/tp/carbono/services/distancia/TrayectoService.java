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
import dds.tp.carbono.repository.admin.ServicioContratadoRepository;
import dds.tp.carbono.repository.admin.TransporteParticularRepository;
import dds.tp.carbono.services.distancia.TrayectoService;

public class TrayectoService {

    private TrayectoRepository repository;
    private MiembroRepository miembroRepository;
    private PuntoGeograficoRepository puntoGeograficoRepository;
    //private TramoRepository tramoRepository;


    public TrayectoService() {
        this.repository = new TrayectoRepository();
        this.miembroRepository = new MiembroRepository();
        this.puntoGeograficoRepository = new PuntoGeograficoRepository();
        //this.tramoRepository = new TramoRepository();
    }

    public void crear(Trayecto trayecto)  {
        System.out.println("Antes de Crear El Trayecto");
        System.out.println(trayecto.getFecha());
        System.out.println(trayecto.getMiembro().getId());
        System.out.println(trayecto.getPuntoLlegada().getCalle());
        System.out.println(trayecto.getPuntoPartida().getCalle());
        System.out.println(trayecto.getId());
        
        repository.guardar(trayecto);
    }

    public Tramo setPuntosLlegadasTramo( TramoDTO tramoDTO, Tramo tramo ){

        PuntoGeografico inicio = new PuntoGeografico(tramoDTO.getAlturaInicial()
                                    ,tramoDTO.getCalleInicial()
                                    ,Integer.parseInt(tramoDTO.getLocalidadInicial()));                         
        
        PuntoGeografico finall = new PuntoGeografico(tramoDTO.getAlturaFinal()
                                    ,tramoDTO.getCalleFinal()
                                    ,Integer.parseInt(tramoDTO.getLocalidadFinal())); 


        
        tramo.setPuntoA(inicio);
        tramo.setPuntoB(finall);

        //this.procesarPuntosGeograficos(inicio,finall);

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
                this.procesarTransporteContratado(medioContratado);
                return tramo;

            case "Transporte_Publico": 
                System.out.println("Entre Atransporte publico");
                TransportePublico transportePublico = new TransportePublico(TipoTransportePublico.getByDTO(tramoDTO.getTipo_transporte_publico())
                                                                           ,TipoDeConsumo.getByDTO(tramoDTO.getTipo_combustible_Transporte_Publico()));
                
                LineaRepository lineaRepository = new LineaRepository();
                Linea linea = new Linea();
                linea = lineaRepository.getById(Integer.parseInt(tramoDTO.getIdLinea()));
                transportePublico.setLinea(linea); 
                tramo.setTransporte(transportePublico);
                return tramo;

            case "Vehiculo_Particular": 
                VehiculoParticular vehiculoParticular = new VehiculoParticular();
                TransporteParticularRepository transporteParticularRepository = new TransporteParticularRepository();

                vehiculoParticular = transporteParticularRepository.getByTipoYCombustible(TipoDeConsumo.getByDTO(tramoDTO.getTipo_combustible_Vehiculo_Particular()),
                                                                     TipoVehiculoParticular.getByDTO(tramoDTO.getTipo_Vehiculo_Particular()));
                System.out.println("BEUNBANAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                System.out.println(vehiculoParticular.getTipo().toString());
                System.out.println(vehiculoParticular.getId());
                tramo.setTransporte(vehiculoParticular);  
                                                                           
                return tramo;
            default: System.out.println("Medio De Transporte Desconocido");
        }

        return null;

    }

        public Tramo setAcompaniantes(Tramo tramo, TramoDTO tramoDTO){

            List<AcompanianteDTO> acompaniantes = new ArrayList<AcompanianteDTO>();
            acompaniantes = tramoDTO.getAcompaniante();
            System.out.println(acompaniantes != null);
           if( acompaniantes != null){
           List<Miembro> miembros = new ArrayList<Miembro>(); 
           acompaniantes = tramoDTO.getAcompaniante();

            for(AcompanianteDTO acompaniante: acompaniantes){
                Miembro miembro = new Miembro();
                System.out.println(acompaniante.getApellido_Acompaniante());
                System.out.println(acompaniante.getNombre_Acompaniante());
                miembro = miembroRepository.getByNameAndLastName(acompaniante.getApellido_Acompaniante(), acompaniante.getNombre_Acompaniante());
                miembros.add(miembro);           
            }

            tramo.setCompartidos(miembros);
            System.out.println(miembros.get(0).getId());
        }
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

        public void procesarTransporteContratado (ServicioContratado medioDeTransporte){

            ServicioContratadoRepository tipoServicioContratadoRepository = new ServicioContratadoRepository();
            if(tipoServicioContratadoRepository.existeEmpresaConEsteCombustible(medioDeTransporte.getTipo().getNombre()
                                                                                ,medioDeTransporte.getCombustible()))
            {
                    tipoServicioContratadoRepository.guardar(medioDeTransporte);
            }
        }

        public void procesarPuntosGeograficos (PuntoGeografico punto1,PuntoGeografico punto2){
           if(puntoGeograficoRepository.ExistePuntoEnBase(punto1)){}else{
            puntoGeograficoRepository.saveOne(punto1);
           }
           if(puntoGeograficoRepository.ExistePuntoEnBase(punto2)){}else{
            puntoGeograficoRepository.saveOne(punto2);
           }
        }

        /* 
        public void setTramosCompartidos(Tramo tramo){

            
            if(tramo.getCompartidos().size()>0){
            TrayectoPendienteRepository trayectoPendienteRepository = new TrayectoPendienteRepository();
            TrayectoPendiente trayectoPendiente = new TrayectoPendiente();

            List<Miembro> listaMiembros = new ArrayList<Miembro>();
            listaMiembros = tramo.getCompartidos();
            trayectoPendiente.setMiembrosPendientes(listaMiembros);

            trayectoPendiente.setTramoCompartido(tramo);
            trayectoPendienteRepository.guardar(trayectoPendiente);
            }
        }
        */


    
}
