package com.fabricio;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

@QuarkusMain
public class BackendApplication {

    public static void main(String ... args) {
        Quarkus.run(args);
    }
}