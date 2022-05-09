package dds.tp.carbono.contracts.IoC;

public interface IModule {
    IContext build(IContext ctx);
}
