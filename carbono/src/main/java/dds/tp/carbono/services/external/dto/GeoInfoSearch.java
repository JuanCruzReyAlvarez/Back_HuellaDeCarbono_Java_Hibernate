package dds.tp.carbono.services.external.dto;

import lombok.Getter;

public class GeoInfoSearch {
    @Getter private String type;
    @Getter private Integer id;

    public GeoInfoSearch(String type, Integer id) {
        this.type = type;
        this.id = id;
    }
}
