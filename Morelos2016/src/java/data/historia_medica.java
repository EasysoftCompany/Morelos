/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author easysoft
 */
@WebServlet(name = "historia_medica", urlPatterns = {"/historia_medica"})
public class historia_medica extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String ap = request.getParameter("ap").toUpperCase();
            String am = request.getParameter("am").toUpperCase();
            String name = request.getParameter("name").toUpperCase();
            String curp = request.getParameter("curp").toUpperCase();
            String can = request.getParameter("can");
            
            

            if (ap.isEmpty() || am.isEmpty() || name.isEmpty() || curp.isEmpty() || can.isEmpty()) {

                String script = "<script>"
                        + "alert('Todos los campos son requeridos');"
                        + " window.history.back();"
                        + "</script>";
                out.print(script);

            } else {

                if (curp.length() != 18) {
                    String script = "<script>"
                            + "alert('Hay un error en la CURP, Porfavor reviselo');"
                            + " window.history.back();"
                            + "</script>";
                    out.print(script);
                } else {

                    HandlerDate hd = new HandlerDate();

                    out.print(hd.fecha_formal());
                    out.print("<br>");

                    out.print(ap);
                    out.print("<br>");
                    out.print(am);
                    out.print("<br>");
                    out.print(name);
                    out.print("<br>");
                    out.print(curp);
                    out.print("<br>");
                    out.print(can + " Tiene Cancer");
                    
                 
                 
                  

                  
                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(500, "Metodo bloqueado por el Administrador");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Genera la historia medica del alumno en formato PDF imprimible";
    }// </editor-fold>

}
