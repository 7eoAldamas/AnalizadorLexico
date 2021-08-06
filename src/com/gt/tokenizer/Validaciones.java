package com.gt.tokenizer;

import com.gt.tokenizer.enums.Tipos;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> numero = new ArrayList<>(); 
        numero.add(0);
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (" ".equals(texto.substring(i, i + 1))) {
                if (i + 1 != texto.length()) {
                    if (" ".equals(texto.substring(i + 1, i + 2))) {
                    } else {
                        numero.add(i);
                        numero.add(i + 1);
                        contador++; //Incremento
                    }
                }
            }
        }
        numero.add(texto.length());

        List<String> cadena = new ArrayList<>(); //Palabras/Texto
        for (int i = 0; i < numero.size(); i++) {
            cadena.add(texto.substring(numero.get(i), numero.get(i + 1)));
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
        
        List<Tipos> tipos = new ArrayList<>();
        tipos = Arrays.asList(tokens); //Pasar el arreglo a un ArrayList
        token = new Token[tipos.size()]; //Token - Objeto
        for (int i = 0; i < tipos.size(); i++) {
            token[i] = new Token(cadena.get(i), tipos.get(i)); //Creación de objetos Token
        }
        
        for (Token cadenas : token) { //Mostrar Información -> Tokens
            ouputTxtA.setText(cadenas.toString());
            System.out.println(cadenas.toString());
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
        int entero = 1;
        for (int i = 0; i < caracter.length; i++) {
            if (caracteresErroneos(caracter[i])) {
                entero = 3;
            }
            if (caracteresValidos(caracter[i])) {
                entero = 3;
            }
            if (Character.isLetter(caracter[i])) {
                entero = 3;
            }
            if (caracter[i] == '.') {
                entero = validacionDecimal(i + 1, caracter);
                i = caracter.length;
            }
        }
        return entero;
    }

    //--- Método Complemento - Evaluar Decimal (Número)
    public int validacionDecimal(int init, char[] caracter) {
        int numero = 2;
        for (int i = init; i < caracter.length; i++) {
            if (caracteresErroneos(caracter[i])) {
                numero = 3;
            }
            if (caracteresValidos(caracter[i])) {
                numero = 3;
            }
            if (Character.isLetter(caracter[i])) {
                numero = 3;
            }
        }
        return numero;
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
