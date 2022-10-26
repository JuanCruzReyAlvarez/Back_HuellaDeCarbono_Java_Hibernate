
/* 
package dds.tp.carbono.http.controllers.member.trayectos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.http.validator.ValidateResult;
import dds.tp.carbono.http.validator.Validator;
import dds.tp.carbono.services.external.GeoInformationService;
import dds.tp.carbono.services.external.dto.GeoInfo;
import dds.tp.carbono.services.external.dto.GeoInfoSearch;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Pais;
import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Getter;
import lombok.Setter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;


public class PointController extends Controller {
    
    private static final String VIEW = "member.points.mustache";
    
    @Override
    public void routes() {
        Spark.get(path(Uri.MEMBER_POINTS), (rq, rs) -> this.points(rq, rs), engine);
        Spark.post(path(Uri.MEMBER_POINTS), (rq, rs) -> this.createPoint(rq, rs));
        Spark.get(path(Uri.MEMBER_POINTS_AUTOCOMPLETE), (rq, rs) -> this.autocomplete(rq, rs));
    }

    private String autocomplete(Request rq, Response rs) throws IOException {
        String query = rq.queryParams("q");
        String id = rq.queryParams("id");
        String type = rq.queryParams("type");
        
        GeoInformationService service = new GeoInformationService();
        List<? extends GeoInfo> geoInfo = service.search(new GeoInfoSearch(type, id == null ? 0 : Integer.parseInt(id)));

        return json(geoInfo.stream()
                           .filter(a -> a.getNombre().toLowerCase().contains(query.toLowerCase()))
                           .collect(Collectors.toList()));
    }
    
    private ModelAndView points(Request rq, Response rs) {
        return view(VIEW, Collections.singletonMap("points", new ArrayList<PointDTO>() {{
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
            add(new PointDTO("Argentina", "Buenos Aires", "CABA", "CABA", "AV. Medrano", "234", "Piso 2"));
        }}));
    }

    private String createPoint(Request rq, Response rs) throws HttpException {
        PointDTO dto = getBody(rq, PointDTO.class, new PointDTOValidator());

        dto.getAltura();

        return json(dto);
    }
    
    private class PointDTO {
        @Getter @Setter private Pais pais;
        @Getter @Setter private Provincia provincia;
        @Getter @Setter private Municipio municipio;
        @Getter @Setter private Localidad localidad;
        @Getter @Setter private String calle;
        @Getter @Setter private String altura;
        @Getter @Setter private String detalle;

        public PointDTO(String pais, String provincia, String municipio, String localidad, String calle, String altura, String detalle) {
            this.pais = new Pais(pais);
            this.provincia = new Provincia();
            this.provincia.setNombre(provincia);
            this.municipio = new Municipio(municipio);
            this.localidad = new Localidad(localidad);
            this.calle = calle;
            this.altura = altura;
            this.detalle = detalle;
        }
    }

    private class PointDTOValidator extends Validator<PointDTO> {

        @Override
        public ValidateResult validate(PointDTO dto) {
            return this;
        }
    }
}
*/
