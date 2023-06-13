/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.io.FilenameUtils;

import com.compressor_decompressor.Compressor;
import com.compressor_decompressor.Decompressor;

/**
 *
 * @author drekh
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    String ext="";
    public AppFrame() {
        compressButton = new JButton("Compress");
        compressButton.setBounds(50, 50, 100, 30);
        compressButton.addActionListener(this);
        decompressButton = new JButton("Decompress");
        decompressButton.setBounds(50, 100, 100, 30);
        
        decompressButton.addActionListener(this);
        this.add(compressButton);
        this.add(decompressButton);
        this.setTitle("Compressor&Decompressor");
        this.setLayout(new BorderLayout());
        this.setSize(450, 450);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
        add(background);
        background.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
            	String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                File file = new File(filePath);
                ext = "."+FilenameUtils.getExtension(filePath);
                try {
                    Compressor.method(file);
                }
                catch(Exception ee) {
                	System.out.println(ee);
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if(e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file, ext);
                }
                catch(Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
