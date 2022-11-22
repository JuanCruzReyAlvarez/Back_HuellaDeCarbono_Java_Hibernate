package dds.tp.carbono.http.context;

import java.util.Arrays;

import com.google.gson.Gson;

import dds.tp.carbono.contracts.http.IController;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.exceptions.HttpExceptionMessage;
import spark.Spark;
//import spark.TemplateEngine;

public class HttpContext {

    //private TemplateEngine templateEngine;

    public HttpContext addRouting(IController ...controllers) {
        Arrays.stream(controllers).forEach(c -> c.routes());
        return this;
    }

    public HttpContext setPort(int port) {
        Spark.port(port);
        return this;
    }

    public HttpContext setip() {
        Spark.ipAddress("0.0.0.0");
        return this;
    }

    public HttpContext setStaticFilesLocation(String dir) {
        Spark.staticFiles.location(dir);
        return this;
    }

    public HttpContext addExceptionHandling() {
        Spark.exception(HttpException.class, (exception, request, response) -> {
            HttpExceptionMessage data = new Gson().fromJson(exception.getMessage(), HttpExceptionMessage.class);
            response.status(data.getCode());
            response.body(data.getResponse());
        });
        return this;
    }

   // public HttpContext setTemplateEngine(TemplateEngine templateEngine) {
        //this.templateEngine = templateEngine;
       // return this;
    //}
}