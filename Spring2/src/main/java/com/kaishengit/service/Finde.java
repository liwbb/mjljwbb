package com.kaishengit.service;

import org.junit.runner.RunWith;

public class Finde extends RuntimeException {
    public String find(){
        throw new RuntimeException("出问题了");
    }
}
