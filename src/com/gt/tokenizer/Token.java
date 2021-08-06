package com.gt.tokenizer;

import com.gt.tokenizer.enums.Tipos;

public class Token {
//---

    private String palabra;
    private Tipos tipo;
    
    //--- Constructor Token
    public Token(String palabra, Tipos tipo){
        this.palabra = palabra;
        this.tipo = tipo;
    }

    //--- Getters and Setters
    public String getPalabra() {
        return palabra;
    }

    public Tipos getTipo() {
        return tipo;
    }
    
    //--- Información
    @Override
    public String toString() {
        return palabra + " -> " + tipo;
    }
    
}
