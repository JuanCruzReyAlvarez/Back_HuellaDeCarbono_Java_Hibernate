package dds.tp.carbono.http.exceptions;

import com.google.gson.Gson;

public class HttpException extends Exception {
    
    public HttpException(int code, Object response) {
        super(new Gson().toJson(new HttpExceptionMessage(code, response)));
    }
}
