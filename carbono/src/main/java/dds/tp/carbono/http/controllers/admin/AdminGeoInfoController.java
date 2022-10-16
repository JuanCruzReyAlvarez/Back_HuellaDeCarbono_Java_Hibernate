package dds.tp.carbono.http.controllers.admin;



import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.ubicacion.UbicacionesCacheDecorator;
import dds.tp.carbono.services.ubicacion.UbicacionesService;
import spark.Spark;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;

public class AdminGeoInfoController extends Controller {

    // Es una interfaz que le asignamos un decorador:

    UbicacionesService service;

    public AdminGeoInfoController(){
        this.service = new UbicacionesCacheDecorator();
    }


    @Override
    public void routes(TemplateEngine engine) {
        Spark.post(path(Uri.ADMIN_GEOINFO), (rq, rs) -> this.refreshGeoInfo(rq, rs));
    }
 

    private String  refreshGeoInfo(Request rq, Response rs) throws Exception {

        try{
                this.service.listadoDeProvincias();
                this.service.listadoDeMunicipios();
                this.service.listadoDeLocalidades();
                return json(goodAnswer()); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting Organizaciones was fail: The error is print in controller,is possible that the error will be in folder ubicacion");
            }
  
    }
}
