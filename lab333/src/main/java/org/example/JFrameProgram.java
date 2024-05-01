package org.example;

import org.example.reactors.ReactorManipulation;
import org.example.parserManipulatiom.ParserManipulation;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author dimgusar
 */
public class JFrameProgram extends javax.swing.JFrame {

    public static ParserManipulation pm = new ParserManipulation();
    public static ReactorManipulation rm = new ReactorManipulation();
    public JFrameProgram() {
        initComponents();
        try {
            pm.createFiles();
        }catch (Exception e){
            JOptionPane.showMessageDialog (null, "Ошибка добавления файлов с расширениями", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
        jTreeReactors.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Реакторы")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeReactors = new javax.swing.JTree();
        jButtonOpenJFileChooser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTreeReactors);

        jButtonOpenJFileChooser.setText("Выбрать файл");
        jButtonOpenJFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonOpenJFileChooserActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jButtonOpenJFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButtonOpenJFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenJFileChooserActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButtonOpenJFileChooserActionPerformed

    JFileChooser chooser = new JFileChooser();
    String currentDir = System.getProperty("user.dir");
    chooser.setCurrentDirectory(new File(currentDir));
    chooser.setDialogTitle("Выберите файл");

    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        jTreeReactors.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Реакторы")));
       try {
           File file = chooser.getSelectedFile();
           rm.setReactors(pm.importData(String.valueOf(file)));
           if(rm.getReactors().isEmpty()) throw new Exception();
           jTreeReactors.setModel(new DefaultTreeModel(rm.addInfo2GUI()));
       }catch (Exception r){
           JOptionPane.showMessageDialog (null, "Ошибка чтения файла", "Oшибка", JOptionPane.ERROR_MESSAGE);
       }
      }
    }//GEN-LAST:event_jButtonOpenJFileChooserActionPerformed

    /**
     * @param args the command line arguments
     */

3
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOpenJFileChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTreeReactors;
    // End of variables declaration//GEN-END:variables
}
