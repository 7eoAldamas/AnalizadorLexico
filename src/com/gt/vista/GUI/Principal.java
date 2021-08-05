package com.gt.vista.GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Principal extends JFrame {
//---
    
    private ImageIcon image, icon;
    
    //--- Contructor Principal(GUI) 
    public Principal() {
        super("Tokenizer");
        initComponents();
        addImage();
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);          
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //--- Agregar Imágenes
    private void addImage(){
        image = new ImageIcon(getClass().getResource("/com/gt/vista/images/flecha-correcta.png"));
        icon = new ImageIcon(image.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH));
        this.imageLbl.setIcon(icon);
        this.panelP.add(imageLbl);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelP = new javax.swing.JPanel();
        scrollPInput = new javax.swing.JScrollPane();
        inputTxtA = new javax.swing.JTextArea();
        analizarBtn = new javax.swing.JButton();
        scrollPShow = new javax.swing.JScrollPane();
        ouputTxtA = new javax.swing.JTextArea();
        reiniciarBtn = new javax.swing.JButton();
        imageLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tokenizer");
        setResizable(false);

        panelP.setBackground(new java.awt.Color(213, 250, 155));

        inputTxtA.setColumns(20);
        inputTxtA.setRows(5);
        scrollPInput.setViewportView(inputTxtA);

        analizarBtn.setText("Analizar");
        analizarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analizarBtnMouseClicked(evt);
            }
        });

        ouputTxtA.setEditable(false);
        ouputTxtA.setColumns(20);
        ouputTxtA.setRows(5);
        scrollPShow.setViewportView(ouputTxtA);

        reiniciarBtn.setText("Reiniciar");
        reiniciarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reiniciarBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPLayout = new javax.swing.GroupLayout(panelP);
        panelP.setLayout(panelPLayout);
        panelPLayout.setHorizontalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(scrollPInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(scrollPShow, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(panelPLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(analizarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(reiniciarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPLayout.setVerticalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPInput, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(scrollPShow)))
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analizarBtn)
                    .addComponent(reiniciarBtn))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analizarBtnMouseClicked
        // Evento - Realizar Análisis
        
    }//GEN-LAST:event_analizarBtnMouseClicked

    private void reiniciarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reiniciarBtnMouseClicked
        // Evento - Reiniciar Análisis
        
    }//GEN-LAST:event_reiniciarBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarBtn;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JTextArea inputTxtA;
    private javax.swing.JTextArea ouputTxtA;
    private javax.swing.JPanel panelP;
    private javax.swing.JButton reiniciarBtn;
    private javax.swing.JScrollPane scrollPInput;
    private javax.swing.JScrollPane scrollPShow;
    // End of variables declaration//GEN-END:variables
}
