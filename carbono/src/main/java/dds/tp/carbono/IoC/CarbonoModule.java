package dds.tp.carbono.IoC;

import dds.tp.carbono.contracts.IInsecurePasswordCheckerBuilder;
import dds.tp.carbono.contracts.IoC.IContext;
import dds.tp.carbono.contracts.IoC.IModule;
import dds.tp.carbono.contracts.services.auth.ILoginService;
import dds.tp.carbono.contracts.services.auth.IRegisterService;
import dds.tp.carbono.contracts.services.org.IOrgMetricsService;
import dds.tp.carbono.services.auth.LoginService;
import dds.tp.carbono.services.auth.RegisterService;
import dds.tp.carbono.services.org.metrics.MetricsService;

public class CarbonoModule implements IModule {
    
    public IContext build(IContext ctx) {
        ctx = this.buildModules(ctx);
        ctx = this.registerServices(ctx);

        return ctx;
    }

    private IContext buildModules(IContext ctx) {
        ctx = new PasswordsModule().build(ctx);
        // ctx = new ExcelReaderModule().build(ctx);
        // ...

        return ctx;
    }

    private IContext registerServices(IContext ctx) {
        IInsecurePasswordCheckerBuilder ipcBuilder = ctx.get(IInsecurePasswordCheckerBuilder.class);
        
        ctx.register(IRegisterService.class, new RegisterService(ipcBuilder));
        ctx.register(ILoginService.class, new LoginService());
        ctx.register(IOrgMetricsService.class, new MetricsService());

        return ctx;
    }
}
