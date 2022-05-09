package dds.tp.carbono.reader.parser;

import org.apache.poi.ss.usermodel.Cell;

import dds.tp.carbono.contracts.cell.CellParser;

public class StringCellParser implements CellParser {

    @Override
    public Object parse(Cell cell) {
        return cell.getStringCellValue();
    }
    
}
