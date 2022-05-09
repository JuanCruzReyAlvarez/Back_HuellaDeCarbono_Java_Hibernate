package dds.tp.carbono.reader.importable;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import dds.tp.carbono.contracts.Importable;
import lombok.Getter;
import lombok.Setter;

public class ImportableSheet {
    @Getter @Setter private Class<? extends Importable> clazz;
    @Getter @Setter private List<Row> rows;

    public ImportableSheet(Class<? extends Importable> clazz) {
        this.clazz = clazz;
        this.rows = new ArrayList<>();
    }
}