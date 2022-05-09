package dds.tp.carbono.IoC;

import java.util.LinkedHashMap;
import java.util.Map;

import dds.tp.carbono.contracts.IoC.IContext;
import dds.tp.carbono.contracts.IoC.Injectable;

public class InjectableInstanceContainer implements IContext {
    
    private final Map<Class<? extends Injectable>, Injectable> injectables = new LinkedHashMap<>();;

    public <T extends Injectable>T get(Class<T> type) {
        Injectable injct = this.injectables.get(type);
        return type != null && type.isInstance(injct) ? type.cast(injct) : null;
    }

    public <T extends Injectable>void register(Class<T> type, Injectable obj) {
        this.injectables.put(type, obj);
    }
}
