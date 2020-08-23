/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
//import org.dfa.util.SistemaOperativo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author dieguito
 */

public class GeneralController {
 
    String msj = "";
    
     public String getParameter( JSONObject jObj,String nombre){
        String param=null;
         if(jObj!=null){
                try {
                    if(!jObj.isNull(nombre)){
                        param = jObj.getString(nombre);
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
        return param;
    }
    
     
    public JSONArray getParameterArray(String json,String nombre){
        JSONArray array =null;
        try {
           
            System.out.println("cadena:"+json);
            JSONObject jObj = new JSONObject(json);
            array = (JSONArray) jObj.get(nombre);
            
            /*for (int i = 0; i < array.length(); i++) {
                 Object obj=  array.get(i);
                 JSONObject row = array.getJSONObject(i);
                 
                 //row.getInt("id");
                 //row.getString("name");
                 System.out.println("objeto: " + obj.toString()+"\n");
                 System.out.println("idDocumento: "+ row.getString("id_documento"));
                 System.out.println("row: " + row.toString()+"\n");
            }*/
           
        } catch (JSONException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
        
    
    public JSONArray getParameterArray(JSONObject jObj,String nombre){
        JSONArray array =null;
        try {
            array = (JSONArray) jObj.get(nombre);
            
            /*for (int i = 0; i < array.length(); i++) {
                 Object obj=  array.get(i);
                 JSONObject row = array.getJSONObject(i);
                 
                 //row.getInt("id");
                 //row.getString("name");
                 System.out.println("objeto: " + obj.toString()+"\n");
                 System.out.println("idDocumento: "+ row.getString("id_documento"));
                 System.out.println("row: " + row.toString()+"\n");
            }*/
           
        } catch (JSONException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
    public String getJSON(HttpServletRequest request){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = request.getReader();
            String str = "";
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            System.out.println("esta dentro");
            
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hubo error");
        }
        
        System.out.println("json:"+sb.toString());
        return sb.toString();
    }
    
    protected JSONObject getJsonObject(String json){
       JSONObject jObj=null;
        try {
            jObj = new JSONObject(json);
        } catch (JSONException ex) {
            System.out.println("JSON MAL FORMADO");
        }
        return jObj;
    }
    
    protected String getMD5(String entrada) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            byte[] messageDigest = md.digest(entrada.getBytes());  
            BigInteger number = new BigInteger(1, messageDigest);  
            String hashtext = number.toString(16);  
            while (hashtext.length() < 32) {  
                hashtext = "0" + hashtext;  
            }  
            return hashtext;  
        }  
        catch (NoSuchAlgorithmException e) {  
            throw new RuntimeException(e);  
        }  
    }  
    
    
    protected String UTF8(String cad){
        String r=cad;
        byte[] b;
        try {
            b = cad.getBytes();
            r = new String(b,"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    protected java.sql.Date fechaToSQl(String fecha){
        java.sql.Date fechaConvert;
           SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDocumento= new Date();
            long t1 =0;
            try {
                fechaDocumento = formatoDelTexto.parse(fecha);
                t1 = fechaDocumento.getTime();
            } catch (ParseException ex) {
                Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
            }

       fechaConvert=new java.sql.Date(t1);
       return  fechaConvert;
    }
    
    protected java.sql.Date fechaJSToSQl(String fecha){
        java.sql.Date fechaConvert;
           SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S");
            Date fechaDocumento= new Date();
            long t1 =0;
            try {
                fechaDocumento = formatoDelTexto.parse(fecha);
                t1 = fechaDocumento.getTime();
            } catch (ParseException ex) {
                Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
            }

       fechaConvert=new java.sql.Date(t1);
       return  fechaConvert;
    }
    
    
    /*

    public ResponseEntity<byte[]> getReporte( String reportPath, Map<String,Object> parametros ) {

        try {    

                try (
                        
                    Connection con = DBFactory.getBD(DBEnum.sqlserver).getConexion()) {
                 
                    File reportFile = new File(reportPath);
                    
                    byte[] bytes =JasperRunManager.runReportToPdf(reportPath,parametros,con);
                    String filename = "test.pdf";
                    System.out.println("bytes: " +bytes);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.parseMediaType("application/pdf"));
                  
                    headers.setContentDispositionFormData(filename, filename);
                    ResponseEntity<byte[]> respon = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
                    
                    return respon;
                    
                }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ControllerREST.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return null;
    }
    
    
    
    
    public String getReporteSaveDeleteServer( String reportPath, Map<String,Object> parametros ,String filename ) {
        String ruta=null;
        String carpetaServer="DOCUMENTOS_GENERADOS";
        try {    

                try (
                        
                    Connection con = DBFactory.getBD(DBEnum.sqlserver).getConexion()) {
                 
                        byte[] bytes =JasperRunManager.runReportToPdf(reportPath,parametros,con);
                        

                        String rutaServidor=getRutaServidor()+carpetaServer+SistemaOperativo.getSeparador();
                        System.out.println("ruta servidor: "+rutaServidor);
                        FileOutputStream fos;
                        try {
                            fos = new FileOutputStream(rutaServidor+filename);
                            fos.write(bytes);
                            fos.close();
                            
                            //***********CONVERTIR RUTA PARA SERVIDOR WEB**************
                            ruta=convertRutaServer(carpetaServer+SistemaOperativo.getSeparador()+filename);
                            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ControllerREST.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(ControllerREST.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
        } catch (SQLException | JRException ex) {
            Logger.getLogger(ControllerREST.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return ruta;
    }
    
    */
    
    /*
      public String getDocumentoSaveDeleteServer(byte[] bytes,String filename ) {
        String ruta=null;
        String carpetaServer="DOCUMENTOS_GENERADOS";
        String rutaServidor=getRutaServidor()+carpetaServer+SistemaOperativo.getSeparador();
        System.out.println("ruta servidor: "+rutaServidor);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(rutaServidor+filename);
            fos.write(bytes);
            fos.close();
            
            //***********CONVERTIR RUTA PARA SERVIDOR WEB**************
            ruta=convertRutaServer(carpetaServer+SistemaOperativo.getSeparador()+filename);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) { 
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ruta;
    }
      
    
     public boolean eliminarDocumento( String carpetaServer, String file) {
        boolean rpta;
        String rutaFile=getRutaServidor()+carpetaServer+SistemaOperativo.getSeparador()+file;
         System.out.println("ruta a eliminar: "+rutaFile);
        File fichero = new File(rutaFile);
        rpta=fichero.delete();
   
        return rpta;
    }
    
     
     */
    
    public  ResponseEntity<byte[]> getReporteExcel(  byte[] bytes){
                
                    System.out.println("bytes: " +bytes);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
                    String filename = "file.xlsx";
                    headers.setContentDispositionFormData(filename, filename);
                    ResponseEntity<byte[]> respon = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
                    
          return respon;
    }
            
    /*
    
    public String getRutaServidor(){
        URL rutaURL = GeneralController.class.getProtectionDomain().getCodeSource().getLocation();
        String ruta=rutaURL.toString();
        
        ruta=ruta.replace("%20"," ");
        if(SistemaOperativo.isWindows()){
            System.out.println("rutaantes :"+ruta);
            ruta=ruta.replace("/","\\");
        }
        
        
        ruta=ruta.substring(6,ruta.length());
        ruta=ruta.substring(0,ruta.indexOf("WEB-INF"));
        //*******FIN OBTENER RUTA*****
       
 
        return ruta;
    }
    
    */
    
    public String convertRutaServer(String ruta){
        ruta=ruta.replace("\\","/");
        return ruta;
    }
    
}