/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.util;



/**
 *
 * @author prueba01
 */
public class SistemaOperativo {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String OSArch = System.getProperty("os.arch").toLowerCase();
    private static String OSVersion = System.getProperty("os.version").toLowerCase();

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
 
    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
 
    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
 
    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
    
    public static String getSeparador(){
        
        String separador="";
        if(SistemaOperativo.isWindows()){
            separador="\\";
           
        }
        
         if(SistemaOperativo.isUnix()){
            separador="/";
        }
        
    
 
        return separador;
    }
}

