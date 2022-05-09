package dds.tp.carbono.contracts.cell;

import org.apache.poi.ss.usermodel.Cell;

public interface CellParser {
    Object parse(Cell cell);
}
