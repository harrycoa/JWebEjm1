package org.hc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReporteController extends GeneralController {

    @RequestMapping(value = "/reporte_jasper/", method = RequestMethod.GET)
    public String reporte_jasper(HttpServletRequest request, HttpServletResponse response) {

        try {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("id_marca",105);

            byte[] bytes = this.getReportePdfJasper(request.getRealPath("/reportes/reporte_marcas.jasper"), parametros);


            //byte[] bytes = this.getReportePdfJasper(request.getRealPath("/reportes/reporte_marcas_id_marca.jasper"), parametros);

          
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            try (ServletOutputStream outputstream = response.getOutputStream()) {
                outputstream.write(bytes, 0, bytes.length);
                outputstream.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/reporte_excel/", method = RequestMethod.GET)
    public String reporte_excel(HttpServletRequest request, HttpServletResponse response) {

        try {

            HashMap<String, Object> modelo_datos = new HashMap<>();

            ArrayList<Object[]> datos = new ArrayList<>();
            String[] fila= new String[3];
            fila[0]="1";
            fila[1]="2";
            fila[2]="3";
            
            datos.add( fila);
            datos.add( fila);
            datos.add( fila);
            
            String[] cabeceras = new String[3];
            cabeceras[0] = "columna 1";
            cabeceras[1] = "columna 2";
            cabeceras[2] = "columna 3";

            modelo_datos.put("datos", datos);
            modelo_datos.put("cabecera", cabeceras);

            String nombre_fichero="excel_prueba";
            byte[] bytes = this.getExcel(nombre_fichero, modelo_datos);

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+nombre_fichero+".xls");
            response.setContentLength(bytes.length);
            try (ServletOutputStream outputstream = response.getOutputStream()) {
                outputstream.write(bytes, 0, bytes.length);
                outputstream.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
