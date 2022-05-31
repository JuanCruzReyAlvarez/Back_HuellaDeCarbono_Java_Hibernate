package dds.tp.carbono.IoC;

import dds.tp.carbono.contracts.IoC.IContext;
import dds.tp.carbono.contracts.IoC.IModule;

public class ContextManager {

    private static IContext context;
    public static IContext getContext() {
        if (context == null)
            context = init();

        return context;
    }

    private static IContext init() {
        IModule mainModule = new CarbonoModule();
        IContext ctx = new InjectableInstanceContainer();

        return mainModule.build(ctx);
    }
}
