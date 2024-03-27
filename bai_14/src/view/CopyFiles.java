/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author maiso
 */
public class CopyFiles extends javax.swing.JFrame {

    /**
     * Creates new form CopyFiles
     */
    public CopyFiles() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jText_Directory = new javax.swing.JTextField();
        jButton_Browse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText_Content = new javax.swing.JTextPane();
        jButton_Delete = new javax.swing.JButton();
        jButton_Create = new javax.swing.JButton();
        jButton_Rename = new javax.swing.JButton();
        jButton_Copy = new javax.swing.JButton();
        jButton_Move = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Directory");

        jText_Directory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton_Browse.setText("Browse");
        jButton_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BrowseActionPerformed(evt);
            }
        });

        jText_Content.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jText_Content);

        jButton_Delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Delete.setText("Delete");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jButton_Create.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Create.setText("Create");
        jButton_Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateActionPerformed(evt);
            }
        });

        jButton_Rename.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Rename.setText("Rename");
        jButton_Rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RenameActionPerformed(evt);
            }
        });

        jButton_Copy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Copy.setText("Copy");
        jButton_Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CopyActionPerformed(evt);
            }
        });

        jButton_Move.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Move.setText("Move");
        jButton_Move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MoveActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Copy, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Move, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Rename, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jText_Directory, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_Directory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Rename, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Copy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Move, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            jText_Directory.setText(path);
            jText_Content.setText(listFiles(path,0));
        }
    }//GEN-LAST:event_jButton_BrowseActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this,"Are you sure ?","Delete",JOptionPane.YES_NO_OPTION);
        if(choice==JOptionPane.YES_OPTION){
            String path = jText_Directory.getText();
            File deleteFile = new File(path);
            if(path.isEmpty()){
                JOptionPane.showMessageDialog(this,"Cannot Delete");
                return;
            }
            deleteFiles(path);
            File parentFile = new File(deleteFile.getParent());
            jText_Directory.setText(parentFile.getAbsolutePath());
            jText_Content.setText(listFiles(parentFile.getAbsolutePath(),0));
            
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_RenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RenameActionPerformed
        // TODO add your handling code here:
        String newFileName = JOptionPane.showInputDialog(this,"Enter a new name");
        if(newFileName != null){
            String oldFileName = jText_Directory.getText();
            File oldFile = new File(oldFileName);
            File newFile = new File(oldFile.getParent()+"\\"+newFileName);
            if(oldFile.renameTo(newFile)){
                jText_Directory.setText(newFile.getAbsolutePath());
                jText_Content.setText(listFiles(newFile.getAbsolutePath(), 0));
            }
            else{
                JOptionPane.showMessageDialog(this, "Cannot rename");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Name cannot be null");
        }
    }//GEN-LAST:event_jButton_RenameActionPerformed

    private void jButton_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateActionPerformed
        // TODO add your handling code here:
        String newFileName = JOptionPane.showInputDialog("Enter new file name");
        String currentLocation = jText_Directory.getText();
        File currentFile = new File(currentLocation);
        if(currentFile.isFile()){
            File newFile = new File(currentFile.getParent()+"\\"+newFileName);
            if(!newFile.exists()){
                try {
                    newFile.createNewFile();
                    File parentFile = new File(newFile.getParent());
                    jText_Content.setText(listFiles(parentFile.getAbsolutePath(), 0));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Cannot create file");
                }
               
            }
            else{
                 JOptionPane.showMessageDialog(this, "File is already exists");
            }
        }else{
            File newFile = new File(currentLocation+"\\"+newFileName);
            try {
                newFile.createNewFile();
                 File parentFile = new File(newFile.getParent());
                 jText_Content.setText(listFiles(parentFile.getAbsolutePath(), 0));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Cannot create file");
            }
        }
    }//GEN-LAST:event_jButton_CreateActionPerformed

    private void jButton_CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CopyActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            String source = jText_Directory.getText();
            String dest = fileChooser.getSelectedFile().getAbsolutePath();
            copyFiles(source, dest+"\\");
            jText_Content.setText(listFiles(dest, 0));
            jText_Directory.setText(dest);
        }
    }//GEN-LAST:event_jButton_CopyActionPerformed

    private void jButton_MoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MoveActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            String source = jText_Directory.getText();
            String dest = fileChooser.getSelectedFile().getAbsolutePath();
            moveFiles(source,dest);
            jText_Content.setText(listFiles(dest, 0));
            jText_Directory.setText(dest);
        }
    }//GEN-LAST:event_jButton_MoveActionPerformed
    private void moveFiles(String source,String destination){
        File sourceFile = new File(source);
        File destFile = new File(destination);
        sourceFile.renameTo(new File(destFile.getAbsolutePath()+"\\"+sourceFile.getName()));      
        File fileSource = new File(source);
        if(fileSource.isDirectory()){
            for(File f: fileSource.listFiles()){
                moveFiles(f.getAbsolutePath(),destFile.getAbsolutePath());
            }
        }
       
    }
    private void copyFiles(String source,String destination){
        Path sourcePath = Path.of(source);
        Path destPath = Path.of(destination);
        
        Path newPath = destPath.resolve(sourcePath.getFileName());
         try {
            Files.copy(sourcePath, newPath, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot copy !");
        }
        File fileSource = new File(source);
        if(fileSource.isDirectory()){
            for(File f: fileSource.listFiles()){
                copyFiles(f.getAbsolutePath(), newPath.toString());
            }
        }
       
        
    }
    
    
    
    
    private void deleteFiles(String path){
        File f = new File(path);
        if(f.isDirectory()){
            for(File file: f.listFiles()){
                deleteFiles(file.getAbsolutePath());
            }
        }
        f.delete();
    }
    private String listFiles(String path,int level){
        String result="";
        File f = new File(path);
        for(int i = 0; i < level; i++){
            result+="\t";
        }
        result+=(level==0?"":"|_")+f.getName()+"\n";
        if(f.isFile()){
            return result;
        }
        else{
            for(File file: f.listFiles()){
                result += listFiles(file.getAbsolutePath(),level+1);
            }
            return result;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CopyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CopyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CopyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CopyFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CopyFiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton_Browse;
    private javax.swing.JButton jButton_Copy;
    private javax.swing.JButton jButton_Create;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Move;
    private javax.swing.JButton jButton_Rename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jText_Content;
    private javax.swing.JTextField jText_Directory;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
