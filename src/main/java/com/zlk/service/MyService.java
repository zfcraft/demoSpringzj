package com.zlk.service;

public interface MyService {

    public void before();
    
    public void after();
    
    public void around();
    
    public void afterReturning();
    
    public void afterThrowing();

}
