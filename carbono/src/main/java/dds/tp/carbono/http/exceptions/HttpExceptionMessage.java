package dds.tp.carbono.http.exceptions;

import com.google.gson.Gson;

import lombok.Getter;

public class HttpExceptionMessage {
    
    @Getter private int code;
    @Getter private String response;

    public HttpExceptionMessage(int code, Object response) {
        this.code = code;
        this.response = new Gson().toJson(response);
    }
}
