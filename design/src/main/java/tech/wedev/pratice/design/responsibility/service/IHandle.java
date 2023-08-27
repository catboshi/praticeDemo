package tech.wedev.pratice.design.responsibility.service;

public interface IHandle {
    void setNextIHandle(IHandle iHandle);

    IHandle getNextIHandle();

    boolean doHandle();

    boolean handle();
}
