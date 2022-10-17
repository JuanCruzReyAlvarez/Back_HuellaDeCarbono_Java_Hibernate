package dds.tp.carbono.http.controllers.huella;



import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.huella.CalculatorDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.huella.CalculatorService;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;
import spark.Spark;



public class CalculatorController extends Controller {

    CalculatorService service;
    
    public CalculatorController ( CalculatorService service){
        this.service = service;
        
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.post(path(Uri.CALCULATOR), (rq, rs) -> this.calculate(rq, rs));
        
    }
   

    public String calculate(Request request, Response response) throws HttpException {
        
        // VALIDAR INPUT !!!

        try {
            
            
            CalculatorDTO input = getBody(request, CalculatorDTO.class, null);

            HuellaCarbono hc = new HuellaCarbono();

            switch(input.getCalculoSolicitado()){

                case "ORG":               
                hc = service.calculateOrg(input);
                
                case "MIEMBRO":
                hc = service.calculateSector(input);

                case "SECTOR":
                hc = service.calculateMiembro(input);
            
            }

 

            return json(hc);
            
        } 
        
        
        catch (Exception ex) {
            System.out.println("Error IN CALCULATORS");
            

           
            
        }
        return json("error"); //puede fallar

    }}

   