/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.hc.util.SistemaOperativo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author dieguito
 */
public class GeneralController {

    String msj = "";

    public String getParameter(JSONObject jObj, String nombre) {
        String param = null;
        if (jObj != null) {
            try {
                if (!jObj.isNull(nombre)) {
                    param = jObj.getString(nombre);
                }
            } catch (JSONException ex) {
                Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return param;
    }

    public JSONArray getParameterArray(String json, String nombre) {
        JSONArray array = null;
        try {

            System.out.println("cadena:" + json);
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

    public JSONArray getParameterArray(JSONObject jObj, String nombre) {
        JSONArray array = null;
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

    public String getJSON(HttpServletRequest request) {
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

        System.out.println("json:" + sb.toString());
        return sb.toString();
    }

    protected JSONObject getJsonObject(String json) {
        JSONObject jObj = null;
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    protected String UTF8(String cad) {
        String r = cad;
        byte[] b;
        try {
            b = cad.getBytes();
            r = new String(b, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    protected java.sql.Date fechaToSQl(String fecha) {
        java.sql.Date fechaConvert;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDocumento = new Date();
        long t1 = 0;
        try {
            fechaDocumento = formatoDelTexto.parse(fecha);
            t1 = fechaDocumento.getTime();
        } catch (ParseException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        fechaConvert = new java.sql.Date(t1);
        return fechaConvert;
    }

    protected java.sql.Date fechaJSToSQl(String fecha) {
        java.sql.Date fechaConvert;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S");
        Date fechaDocumento = new Date();
        long t1 = 0;
        try {
            fechaDocumento = formatoDelTexto.parse(fecha);
            t1 = fechaDocumento.getTime();
        } catch (ParseException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        fechaConvert = new java.sql.Date(t1);
        return fechaConvert;
    }

    public byte[] getReportePdfJasper(String reportPath, Map<String, Object> parametros) {
        byte[] bytes = null;
        try {

            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_novum", "root","");

            bytes = JasperRunManager.runReportToPdf(reportPath, parametros, con);

            System.out.println("bytes: " + bytes);

        } catch (JRException ex) {
            System.out.println("error jaasper");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("error driver");
        } catch (SQLException ex) {
            System.out.println("error conexion");
        }

        return bytes;
    }

    public HSSFColor setColor(HSSFWorkbook workbook, Color c) {
        byte r = (byte) c.getRed();
        byte g = (byte) c.getGreen();
        byte b = (byte) c.getBlue();

        HSSFPalette palette = workbook.getCustomPalette();
        HSSFColor hssfColor = null;
        try {
            hssfColor = palette.findColor(r, g, b);
            if (hssfColor == null) {
                palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g, b);
                hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hssfColor;
    }

    public byte[] getExcel(String nombreFile, HashMap<String, Object> modelo) {

        ArrayList<Object[]> data = (ArrayList<Object[]>) modelo.get("datos");
        String[] headers = (String[]) modelo.get("cabecera");

        //int tamFilas=(int) modelo.get("nroFilas");
        //int tamCol=(int) modelo.get("nroColum");
        //*******OBTENER RUTA*****
        URL rutaURL = GeneralController.class.getProtectionDomain().getCodeSource().getLocation();
        String ruta = rutaURL.toString();

        ruta = ruta.replace("%20", " ");
        if (SistemaOperativo.isWindows()) {
            System.out.println("rutaantes :" + ruta);
            ruta = ruta.replace("/", "\\");
        }

        ruta = ruta.substring(6, ruta.length());
        //*******FIN OBTENER RUTA*****
        System.out.println("rutaFile:" + ruta);
        String rutaArchivo = ruta + nombreFile + ".xls";

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Hoja excel");

        HSSFColor colorFondo = setColor(workbook, Color.BLUE);
        HSSFColor colorTexto = setColor(workbook, Color.white);

        CellStyle headerStyle = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(colorTexto.getIndex());
        headerStyle.setFont(font);

        headerStyle.setFillForegroundColor(colorFondo.getIndex());
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        CellStyle style = workbook.createCellStyle();

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }

        for (int i = 0; i < data.size(); ++i) {
            HSSFRow dataRow = sheet.createRow(i + 1);

            for (int j = 0; j < headers.length; ++j) {
                String valor = (String) data.get(i)[j];
                dataRow.createCell(j).setCellValue(valor);
            }
        }

        FileOutputStream file = null;
        try {
            file = new FileOutputStream(rutaArchivo);
            workbook.write(file);
            file.close();
        } catch (FileNotFoundException ex) {
           
        } catch (IOException ex) {
           
        }

        Path fileLocation = Paths.get(rutaArchivo);
        byte[] da = null;
        try {
            da = Files.readAllBytes(fileLocation);

            File f = new File(rutaArchivo);
            f.delete();

        } catch (IOException ex) {
           
        }

        System.out.println("bytes:  " + workbook.getBytes().length);

        return da;

    }

   
    public String convertRutaServer(String ruta) {
        ruta = ruta.replace("\\", "/");
        return ruta;
    }

}
