package dds.tp.carbono.model.workbook;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import dds.tp.carbono.reader.workbook.CellParser;
import lombok.Getter;

public class RowInfo {
    @Getter private Integer index;
    @Getter private List<Object> cellValues;

    public RowInfo(Row row) {
        this.index = row.getRowNum();
        this.cellValues = new ArrayList<>();
        row.iterator().forEachRemaining(cell -> cellValues.add(CellParser.getValue(cell)));
    }
}
