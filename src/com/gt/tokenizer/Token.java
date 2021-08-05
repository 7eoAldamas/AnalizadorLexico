package com.gt.tokenizer;

import com.gt.tokenizer.enums.Tipos;

public class Token {
//---

    private String cadena;
    private Tipos tipo;
    
    //--- Constructor Token
    public Token() {
    }

    public Token(String cadena, Tipos tipo) {
        this.cadena = cadena;
        this.tipo = tipo;
    }
    
    //--- Getters and Setters

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }    
    
}
