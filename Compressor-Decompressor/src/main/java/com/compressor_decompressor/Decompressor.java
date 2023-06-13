/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compressor_decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author drekh
 */
public class Decompressor {
    public static void method(File file, String ext) throws FileNotFoundException, IOException {
        String fileDirectory = file.getParent();
        FileInputStream input = new FileInputStream(file);
        GZIPInputStream input_zp = new GZIPInputStream(input);
        FileOutputStream output = new FileOutputStream(fileDirectory + "\\decompressedFile" + ext);
        byte[] buffer = new byte[1024];
        int len;
        while((len = input_zp.read(buffer)) != -1) {
            output.write(buffer, 0, len);
        }
        input_zp.close();
        output.close();
        input.close();
    }
    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\PARAS\\Downloads");
        method(path,"");
    }
}
