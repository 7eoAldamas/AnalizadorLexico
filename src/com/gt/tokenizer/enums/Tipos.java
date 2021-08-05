package com.gt.tokenizer.enums;

/*
   Tipos : 
        1. Identificadores
        2. Número Entero
        3. Número Decimal
        4. Símbolos
*/

public enum Tipos {
//---
    
    IDENTIFICADOR("Identificador"),
    NUM_ENTERO("Numero Entero"),
    NUM_DECIMAL("Numero Decimal"),
    SIMBOLO("Simbolo"),
    ERROR("Error");
    
    private String claseTipo;

    //--- Constructor Tipos (Enum)
    private Tipos(String claseTipo) {
        this.claseTipo = claseTipo;
    }    

    //--- Getter
    public String getClaseTipo() {
        return claseTipo;
    }    

}
