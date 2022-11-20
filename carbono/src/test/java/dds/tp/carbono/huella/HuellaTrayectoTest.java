/* 
package dds.tp.carbono.huella;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.UnidadFE;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Estacion;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.ServicioContratado;
import dds.tp.carbono.entities.transport.TipoMedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoServicioContratado;
import dds.tp.carbono.entities.transport.TipoTransportePublico;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.TransportePublico;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
//import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaTrayecto;
//import javassist.expr.NewArray;
import lombok.Getter;
import lombok.Setter;

public class HuellaTrayectoTest {

    private EstacionesData data = null;
    //private FactorEmisionRepository repositoryMock;
    private CalculadorDistanciaServicioExterno calculadorMock;
    private FactorEmisionRepository buscador;

    private PuntoGeografico puntoUno = this.buildPuntoGeografico(1, "cordoba", "1100",1);
    private PuntoGeografico puntoDos = this.buildPuntoGeografico(2, "cordoba", "1200",1);
    private PuntoGeografico puntoTres = this.buildPuntoGeografico(3, "cordoba", "1300",1);
    private PuntoGeografico puntoCuatro = this.buildPuntoGeografico(4, "cordoba", "1400",1);
    private PuntoGeografico puntoCinco = this.buildPuntoGeografico(5, "cordoba", "1500",1);

    

    
    

    @Before
    public void init() {
        String fileName = "paradas.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.data = new Gson().fromJson(new InputStreamReader(is), EstacionesData.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Before
    public void inicializarBuscador() throws Exception {
        List<FactorEmision> factores = new ArrayList<>();

        FactorEmision factorGNC = new FactorEmision(TipoDeConsumo.GNC, TipoActividad.Trayecto_Miembros, 4.00, UnidadFE.kgCO2eq_M3);
        FactorEmision factorNafta = new FactorEmision(TipoDeConsumo.Nafta, TipoActividad.Trayecto_Miembros, 3.00, UnidadFE.kgCO2eq_LT);
        FactorEmision factorDiesel = new FactorEmision(TipoDeConsumo.Diesel, TipoActividad.Trayecto_Miembros, 2.00, UnidadFE.kgCO2eq_LT);

        factores.add(factorGNC);
        factores.add(factorNafta);
        factores.add(factorDiesel);

        this.buscador = new FactorEmisionRepository();
    }


    //@Before
    //public void inicializarBuscador(){
        //this.repositoryMock = mock(FactorEmisionRepository.class);
        //this.buscadorMock = mock(BuscadorFactorEmision.class);
        

        //when(this.repositoryMock.get(TipoDeConsumo.GNC, TipoActividad.Trayecto_Miembros)).thenReturn(factorGNC);
        //when(this.repositoryMock.get(TipoDeConsumo.Nafta, TipoActividad.Trayecto_Miembros)).thenReturn(factorNafta);
        //when(this.repositoryMock.get(TipoDeConsumo.Diesel, TipoActividad.Trayecto_Miembros)).thenReturn(factorDiesel);


        //when(this.buscadorMock.buscarPorConsumoActividad(TipoDeConsumo.Diesel, TipoActividad.Trayecto_Miembros)).thenReturn(factorDiesel)

    //}

    @Before
    public void inicializarAPImock() throws Exception {
        this.calculadorMock = mock(CalculadorDistanciaServicioExterno.class);

        when(this.calculadorMock.calcularDistancia(this.puntoUno, this.puntoDos)).thenReturn(100.00);
        when(this.calculadorMock.calcularDistancia(this.puntoDos, this.puntoTres)).thenReturn(50.00);
        when(this.calculadorMock.calcularDistancia(this.puntoCuatro, this.puntoCinco)).thenReturn(75.00);
    }

    @Test
    public void calcularHuellaTrayectoCompletoTest() throws Exception {

        Trayecto trayecto = this.crearTrayectoConTodosLosTiposDeTramos();
        
        CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto,this.buscador);

        calculador.setTrayecto(trayecto);
        //calculador.setRepository(this.repositoryMock);

        Assert.assertEquals(Double.valueOf(1425.46), calculador.calcular().getValor());
    }

    @Test
    public void calcularHuellaTrayectoSinTramosTest() throws Exception {
        Trayecto trayecto = this.crearTrayectoSinTramos();
        CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto,this.buscador);

        calculador.setTrayecto(trayecto);
        //calculador.setRepository(this.repositoryMock);

        Assert.assertEquals(Double.valueOf(0.00), calculador.calcular().getValor());
    }

    @Test
    public void calcularHuellaTrayectoNoMotorizado() throws Exception {
        Trayecto trayecto = this.crearTrayectoNoMotorizado();
        CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto,this.buscador);

        calculador.setTrayecto(trayecto);
        //calculador.setRepository(this.repositoryMock);

        Assert.assertEquals(Double.valueOf(0.00), calculador.calcular().getValor());
    }

    //------------------------------- INSTANCIAS -----------------------------------------------------------------------
    private Trayecto crearTrayectoConTodosLosTiposDeTramos() {
        Trayecto trayecto = new Trayecto(0);

        Tramo tramoNoMotorizado = this.crearTramoNoMotorizado();
        Tramo tramoServicioContratado = this.crearTramoServicioContratado();
        Tramo tramoTransportePublico = this.crearTramoTransportePublico();
        Tramo tramoVehiculoParticular = this.crearTramoVehiculoParticular();

        trayecto.setTramos(Arrays.asList(tramoNoMotorizado, tramoServicioContratado, tramoTransportePublico, tramoVehiculoParticular));

        return trayecto;
    }

    private Trayecto crearTrayectoSinTramos(){
        Trayecto trayecto = new Trayecto(0);
        return trayecto;
    }

    private Trayecto crearTrayectoNoMotorizado(){
        Trayecto trayecto = new Trayecto(0);

        Tramo tramoNoMotorizado = this.crearTramoNoMotorizado();
        trayecto.setTramos(Arrays.asList(tramoNoMotorizado));

        return trayecto;
    }

    private Tramo crearTramoNoMotorizado(){
        PuntoGeografico puntoA = this.puntoUno;
        PuntoGeografico puntoB = this.puntoDos;
        MedioNoMotorizado transporte = new MedioNoMotorizado(1, TipoMedioNoMotorizado.BICICLETA);
        transporte.setCalculador(this.calculadorMock);

        return this.buildTramo(1, puntoA, puntoB, transporte);
    }

    private Tramo crearTramoServicioContratado(){
        PuntoGeografico puntoA = this.puntoDos;
        PuntoGeografico puntoB = this.puntoTres;
        ServicioContratado transporte = new ServicioContratado();
        transporte.setId(1);
        transporte.setTipo(new TipoServicioContratado("remis"));
        transporte.setCombustible(TipoDeConsumo.GNC);
        transporte.setCalculador(this.calculadorMock);

       return this.buildTramo(2, puntoA, puntoB, transporte);
    }

    private Tramo crearTramoTransportePublico(){
        PuntoGeografico puntoA = this.puntoTres;
        PuntoGeografico puntoB = this.puntoCuatro;
        TransportePublico transporte = this.buildTransportePublico(1, TipoTransportePublico.SUBTE, 0, TipoDeConsumo.Diesel);

        return this.buildTramo(3, puntoA, puntoB, transporte);
    }

    private Tramo crearTramoVehiculoParticular(){
        PuntoGeografico puntoA = this.puntoCuatro;
        PuntoGeografico puntoB = this.puntoCinco;
        VehiculoParticular transporte = new VehiculoParticular();
        transporte.setTipo(TipoVehiculoParticular.AUTO);
        transporte.setId(1);
        transporte.setCombustible(TipoDeConsumo.Nafta);
        transporte.setCalculador(this.calculadorMock);

        return this.buildTramo(4, puntoA, puntoB, transporte);
    }

    //------------------------------- CONSTRUCTORES --------------------------------------------------------------------

    private PuntoGeografico buildPuntoGeografico(int id, String calle, String altura, int localidadId) {
        PuntoGeografico punto = new PuntoGeografico();
        punto.setId(id);
        punto.setCalle(calle);
        punto.setAltura(altura);
        punto.getLocaldiad().setId(localidadId);

        return punto;
    }

    private Tramo buildTramo(int id, PuntoGeografico puntoA, PuntoGeografico puntoB, MedioDeTransporte transporte){
        Tramo tramo = new Tramo(0);
        tramo.setId(id);
        tramo.setPuntoA(puntoA);
        tramo.setPuntoB(puntoB);
        tramo.setTransporte(transporte);
        return tramo;
    }

    private TransportePublico buildTransportePublico(int id, TipoTransportePublico tipo, int lineaIndex, TipoDeConsumo combustible){
        TransportePublico transporte = new TransportePublico();
        transporte.setId(id);
        transporte.setTipo(tipo);
        transporte.setLinea(this.buildLinea(lineaIndex));
        transporte.setCombustible(combustible);

        return transporte;
    }

    private Linea buildLinea(int lineaIndex) {
        Linea linea = this.data.getLineas().get(lineaIndex);

        for (int i = 0; i < linea.getEstaciones().size(); i++) {
            Estacion siguiente = null;
            if (i < linea.getEstaciones().size() - 1)
                siguiente = linea.getEstaciones().get(i + 1);

            linea.getEstaciones().get(i).setSiguiente(siguiente);
        }

        return linea;
    }

    private class EstacionesData {
        @Getter @Setter private List<Linea> lineas;
    }

}

*/
