package dds.tp.carbono.http.controllers;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import dds.tp.carbono.contracts.http.IController;
import dds.tp.carbono.http.Routes;
import dds.tp.carbono.http.exceptions.BadResquestException;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.http.validator.ValidateResult;
import dds.tp.carbono.http.validator.Validator;
import spark.ModelAndView;
import spark.Request;

public abstract class Controller implements IController {

    protected <T> T getBody(Request request, Class<T> type, Validator<T> validator) throws HttpException {
        try {
            T data = new Gson().fromJson(request.body(), type);

            if (validator == null)
                return data;

            ValidateResult validation = validator.validate(data);
            
            if (validation.isValid())
                return data;

            throw new BadResquestException(validation.getErrors());
        } catch (JsonParseException ex) {
            throw new BadResquestException("Malformed Body");
        }
    }

    protected ModelAndView view(String view, Object ...context) {
        return new ModelAndView(context, view);
    }

    protected ModelAndView view(String view, Map<String, Object> context) {
        return new ModelAndView(context, view);
    }

    protected String json(Object obj) {
        return new Gson().toJson(obj);
    }

    protected String path(Uri uri) {
        return Routes.getInstance().getPaths().get(uri);
    }
}
