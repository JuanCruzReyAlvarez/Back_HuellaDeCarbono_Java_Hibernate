package dds.tp.carbono.huella;

import com.google.gson.Gson;
import dds.tp.carbono.distancia.ObtenerDistanciaTramo;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.*;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import dds.tp.carbono.services.huella.CalculadorHuellaTrayecto;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scala.collection.immutable.IntMap;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class HuellaTrayecto {

    private EstacionesData data = null;
    private FactorEmisionRepository repositoryMock;
    private CalculadorDistanciaServicioExterno calculadorMock;

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
    public void inicializarRepositoryMock(){
        this.repositoryMock = mock(FactorEmisionRepository.class);
        FactorEmision factorGNC = new FactorEmision(1, TipoDeConsumo.GNC, 4.00, Unidad.M3);
        FactorEmision factorNafta = new FactorEmision(1, TipoDeConsumo.Nafta, 3.00, Unidad.LT);
        FactorEmision factorDiesel = new FactorEmision(1, TipoDeConsumo.Diesel, 2.00, Unidad.LT);

        when(this.repositoryMock.get(TipoDeConsumo.GNC)).thenReturn(factorGNC);
        when(this.repositoryMock.get(TipoDeConsumo.Nafta)).thenReturn(factorNafta);
        when(this.repositoryMock.get(TipoDeConsumo.Diesel)).thenReturn(factorDiesel);
    }

    @Before
    public void inicializarAPImock() throws Exception {
        this.calculadorMock = mock(CalculadorDistanciaServicioExterno.class);

        when(this.calculadorMock.calcularDistancia(this.puntoUno, this.puntoDos)).thenReturn(100.00);
        when(this.calculadorMock.calcularDistancia(this.puntoDos, this.puntoTres)).thenReturn(50.00);
        when(this.calculadorMock.calcularDistancia(this.puntoCuatro, this.puntoCinco)).thenReturn(75.00);
    }

    @Test
    public void calcularHuellaTrayectoCompletoTest(){
        Trayecto trayecto = this.crearTrayectoConTodosLosTiposDeTramos();
        CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto);

        calculador.setTrayecto(trayecto);
        calculador.setRepository(this.repositoryMock);

        Assert.assertEquals(Double.valueOf(1425.46), calculador.calcular().getValor());
    }

    @Test
    public void calcularHuellaTrayectoSinTramosTest(){
        Trayecto trayecto = this.crearTrayectoSinTramos();
        CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto);

        calculador.setTrayecto(trayecto);
        calculador.setRepository(this.repositoryMock);

        Assert.assertEquals(Double.valueOf(0.00), calculador.calcular().getValor());
    }

    @Test
    public void calcularHuellaTrayectoNoMotorizado(){
        Trayecto trayecto = this.crearTrayectoNoMotorizado();
        CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto);

        calculador.setTrayecto(trayecto);
        calculador.setRepository(this.repositoryMock);

        Assert.assertEquals(Double.valueOf(0.00), calculador.calcular().getValor());
    }

    //------------------------------- INSTANCIAS -----------------------------------------------------------------------
    private Trayecto crearTrayectoConTodosLosTiposDeTramos() {
        Trayecto trayecto = new Trayecto();

        Tramo tramoNoMotorizado = this.crearTramoNoMotorizado();
        Tramo tramoServicioContratado = this.crearTramoServicioContratado();
        Tramo tramoTransportePublico = this.crearTramoTransportePublico();
        Tramo tramoVehiculoParticular = this.crearTramoVehiculoParticular();

        trayecto.setTramos(Arrays.asList(tramoNoMotorizado, tramoServicioContratado, tramoTransportePublico, tramoVehiculoParticular));

        return trayecto;
    }

    private Trayecto crearTrayectoSinTramos(){
        Trayecto trayecto = new Trayecto();
        return trayecto;
    }

    private Trayecto crearTrayectoNoMotorizado(){
        Trayecto trayecto = new Trayecto();

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
        punto.setIdLocalidad(localidadId);

        return punto;
    }

    private Tramo buildTramo(int id, PuntoGeografico puntoA, PuntoGeografico puntoB, MedioDeTransporte transporte){
        Tramo tramo = new Tramo();
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
