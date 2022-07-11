package dds.tp.carbono.http.utils;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.http.exceptions.ForbiddenException;
import dds.tp.carbono.http.exceptions.HttpException;

public class Redirect {
    private static final String FORBIDDEN_MESSAGE = "Usuario sin roles validos";

    public static Uri defaultUriByRol(Rol rol) throws HttpException {
        switch (rol) {
            case ADMINISTRADOR : return Uri.ADMIN_ORG;
            case MIEMBRO       : return Uri.MEMBER_TRAYECTOS;
            case ORGANIZACION  : return Uri.ORG_METRICS;
            case AGENTE_SECTORIAL : return Uri.AGENTE_SECTORIAL;
            default: throw new ForbiddenException(FORBIDDEN_MESSAGE);
        }
    }   
}
