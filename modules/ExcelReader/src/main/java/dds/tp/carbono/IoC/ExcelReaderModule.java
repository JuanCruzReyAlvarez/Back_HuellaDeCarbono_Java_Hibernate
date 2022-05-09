package dds.tp.carbono.IoC;

import dds.tp.carbono.contracts.IoC.IContext;
import dds.tp.carbono.contracts.IoC.IModule;
import dds.tp.carbono.reader.ExcelReader;
import dds.tp.carbono.contracts.IExcelReader;

public class ExcelReaderModule implements IModule {

    @Override
    public IContext build(IContext ctx) {

        ctx.register(IExcelReader.class, new ExcelReader());

        return ctx;
    }
    
}
