package com.gt.analizador;

import com.gt.vista.GUI.Principal;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inicio Git");       
        
        EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }
    
}
