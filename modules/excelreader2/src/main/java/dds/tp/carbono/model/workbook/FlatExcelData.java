package dds.tp.carbono.model.workbook;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import lombok.Getter;

public class FlatExcelData {

    @Getter private List<RowInfo> rowsInfo;
    
    public FlatExcelData() {
        this.rowsInfo = new ArrayList<RowInfo>();
    }

    public void addRowInfo(Row row) {
        RowInfo rowInfo = new RowInfo(row);

        if (rowInfo.getCellValues().stream().anyMatch(o -> o != null))
            this.rowsInfo.add(rowInfo);
    }
}
