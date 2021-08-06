package com.gt.analizador;

import com.gt.vista.GUI.Principal;
import java.awt.EventQueue;

public class Main {
//---

    public static void main(String[] args) {
        //--- Código Ejecutable
        EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

}
