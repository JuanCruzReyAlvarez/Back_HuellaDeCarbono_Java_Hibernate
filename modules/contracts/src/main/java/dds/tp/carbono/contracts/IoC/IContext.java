package dds.tp.carbono.contracts.IoC;

public interface IContext {
    <T extends Injectable>T get(Class<T> type);
    <T extends Injectable>void register(Class<T> type, Injectable obj);
}