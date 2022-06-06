package dds.tp.carbono.Organizacion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;


import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import lombok.Getter;
import lombok.Setter;

public class ContestadorDeSolicitudesVinculacion {

    private OrganizacionData data = null;

    @Before
    public void init() {
        String fileName = "organizacion.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {  //preguntar
            this.data = new Gson().fromJson(new InputStreamReader(is), OrganizacionData.class); 
        } catch (Exception ex) {                                                                         
            System.out.println(ex.getMessage());
        }
    }

    private class OrganizacionData {
        @Getter @Setter private List<Organizacion> organizaciones;
    }

    


}