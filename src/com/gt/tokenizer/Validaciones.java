package com.gt.tokenizer;

import com.gt.tokenizer.enums.Tipos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class Validaciones {
//---
    
    private Token[] token;
    
    //--- Constructor Validaciones
    public Validaciones() {}

    //--- Método para realizar las - validaciones -
    public void validacionGeneral(JTextArea inputTxtA, JTextArea ouputTxtA) {
        
        String texto = inputTxtA.getText();
        List<Integer> indice = new ArrayList<>(); 
        indice.add(0);
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (" ".equals(texto.substring(i, i + 1))) {
                if (i + 1 != texto.length()) {
                    if (" ".equals(texto.substring(i + 1, i + 2))) {
                    } else {
                        indice.add(i);
                        indice.add(i + 1);
                        contador++; //Incremento
                    }
                }
            }
        }
        indice.add(texto.length());

        List<String> cadena = new ArrayList<>(); //Palabras/Texto
        for (int i = 0; i < indice.size(); i++) {
            cadena.add(texto.substring(indice.get(i), indice.get(i + 1)));
            i++;
        }

        Tipos[] tokens = new Tipos[cadena.size()];
        for (int i = 0; i < cadena.size(); i++) {
            String idCadena = cadena.get(i);
            char[] caracterInput = idCadena.toCharArray(); //Carácter de entrada
            if (Character.isLetter(caracterInput[0])) { //Validaciones Tipo Identificador/Palabra
                boolean isValido = validacionCadena(caracterInput);
                if (isValido) {
                    tokens[i] = Tipos.IDENTIFICADOR;
                } else {
                    tokens[i] = Tipos.ERROR;
                }
            } else if (Character.isDigit(caracterInput[0])) { //Validaciones Tipo Número Entero/Decimal
                int num = validacionEntero(caracterInput);
                switch (num) {
                    case 1 -> tokens[i] = Tipos.NUM_ENTERO;
                    case 2 -> tokens[i] = Tipos.NUM_DECIMAL;
                    case 3 -> tokens[i] = Tipos.ERROR;
                }
            } else if (caracteresValidos(caracterInput[0])){ //Validaciones Tipo Símbolos
                if (caracterInput.length > 1 && caracterInput[0] != ' ') {
                    tokens[i] = Tipos.ERROR;
                } else {
                    tokens[i] = Tipos.SIMBOLO;
                }
            } else if (caracteresErroneos(caracterInput[0])){ //Validaciones Tipo Error 
                tokens[i] = Tipos.ERROR;
            } else if (Character.isWhitespace(caracterInput[0])){ //Validaciones de Espacios
                tokens[i] = Tipos.ESPACIO;
            }
        }        
        
        token = new Token[tokens.length]; //Token - Objeto
        for (int i = 0; i < tokens.length; i++) {
            token[i] = new Token(cadena.get(i), tokens[i]); //Creación de objetos Token
        }
        
        for (Token cadenas : token) { //Mostrar Información -> Tokens
            ouputTxtA.append(cadenas.toString() + "\n");            
        }
    }

    //--- Método Complemento - Evaluar Cadena
    public boolean validacionCadena(char[] caracter) {
        boolean isValido = true;
        for (int i = 0; i < caracter.length; i++) {
            if (caracteresErroneos(caracter[i])) {
                isValido = false;
            }
            if (caracteresValidos(caracter[i])) {
                isValido = false;
            }
        }
        return isValido;
    }

    //--- Método Complemento - Evaluar Entero (Número)
    public int validacionEntero(char[] caracter) {
        int indice = 1;
        for (int i = 0; i < caracter.length; i++) {
            if (caracteresErroneos(caracter[i])) {
                indice = 3; //Error
            }
            if (caracteresValidos(caracter[i])) {
                indice = 3; //Error
            }
            if (Character.isLetter(caracter[i])) {
                indice = 3; //Error
            }
            if (caracter[i] == '.') {
                indice = validacionDecimal(i + 1, caracter);
                i = caracter.length;
            }
        }
        return indice;
    }

    //--- Método Complemento - Evaluar Decimal (Número)
    public int validacionDecimal(int init, char[] caracter) {
        int indice = 2;
        for (int i = init; i < caracter.length; i++) {
            if (caracteresErroneos(caracter[i])) {
                indice = 3; //Error
            }
            if (caracteresValidos(caracter[i])) {
                indice = 3; //Error
            }
            if (Character.isLetter(caracter[i])) {
                indice = 3; //Error
            }
        }
        return indice;
    }

    //--- Método Complemento - Símbolos Permitidos
    public boolean caracteresValidos(char caracter) {
        boolean isValido = false;
        switch (caracter) {
            case '[' -> {isValido = true;}
            case ']' -> {isValido = true;}
            case '{' -> {isValido = true;}
            case '}' -> {isValido = true;}
            case ';' -> {isValido = true;}
            case ',' -> {isValido = true;}
        }
        return isValido;
    }

    //--- Método Complemento - Símbolos NO Permitidos (Posibles Entradas)
    public boolean caracteresErroneos(char caracter) {
        boolean isErroneo = false;
        switch (caracter) {
            case '.' -> {isErroneo = true;}
            case '!' -> {isErroneo = true;}
            case '¡' -> {isErroneo = true;}
            case '"' -> {isErroneo = true;}
            case '#' -> {isErroneo = true;}
            case '$' -> {isErroneo = true;}
            case '%' -> {isErroneo = true;}
            case '&' -> {isErroneo = true;}
            case '/' -> {isErroneo = true;}            
            case '(' -> {isErroneo = true;}
            case ')' -> {isErroneo = true;}           
            case '=' -> {isErroneo = true;}
            case '?' -> {isErroneo = true;}
            case '¿' -> {isErroneo = true;}
            case '+' -> {isErroneo = true;}
            case '-' -> {isErroneo = true;}
            case '*' -> {isErroneo = true;}
            case '>' -> {isErroneo = true;}
            case '<' -> {isErroneo = true;} 
            case ':' -> {isErroneo = true;}
            case '|' -> {isErroneo = true;}
            case '^' -> {isErroneo = true;}
            case '@' -> {isErroneo = true;}
            case '_' -> {isErroneo = true;}
            case '`' -> {isErroneo = true;}
            case '°' -> {isErroneo = true;}
            case '¬' -> {isErroneo = true;} 
            case '¨' -> {isErroneo = true;} 
            case '´' -> {isErroneo = true;} 
            case '~' -> {isErroneo = true;} 
        }
        return isErroneo;
    }
    
}
