package dds.tp.carbono.IoC;

import dds.tp.carbono.builder.InsecurePasswordCheckerBuilder;
import dds.tp.carbono.contracts.IInsecurePasswordCheckerBuilder;
import dds.tp.carbono.contracts.IoC.IContext;
import dds.tp.carbono.contracts.IoC.IModule;

public class PasswordsModule implements IModule {

    @Override
    public IContext build(IContext ctx) {

        ctx.register(IInsecurePasswordCheckerBuilder.class, new InsecurePasswordCheckerBuilder());
        
        return ctx;
    }
    
}
