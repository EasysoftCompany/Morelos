/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author easysoft
 */
@WebServlet(name = "inscripcion", urlPatterns = {"/inscripcion"})
public class inscripcion extends HttpServlet {

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

        String ap = request.getParameter("ap").toUpperCase();
        String am = request.getParameter("am").toUpperCase();
        String name = request.getParameter("name").toUpperCase();
        String curp = request.getParameter("curp").toUpperCase();
        String años = request.getParameter("anos");
        String meses = request.getParameter("meses");
        String sexo = request.getParameter("sexo");
      
        String pesokg = request.getParameter("pesokg");
        String pesog = request.getParameter("pesog");
        String estaturam = request.getParameter("estaturam");
        String estaturacm = request.getParameter("estaturacm");

        String sangre_letra = request.getParameter("sangre_letra");
        String sangre_rh = request.getParameter("sangre_rh");

        String gdo = request.getParameter("gdo");
        String gpo = request.getParameter("gpo");

        String turno = request.getParameter("turno");
        String escuela_procedencia = request.getParameter("escuela_procedencia").toUpperCase();
        String escuela_procedencia_dir = request.getParameter("escuela_procedencia_dir").toUpperCase();

        //Datos Padre de Familia
        String _ap = request.getParameter("_ap").toUpperCase();
        String _am = request.getParameter("_am").toUpperCase();
        String _name = request.getParameter("_name").toUpperCase();
        String _curp = request.getParameter("_curp").toUpperCase();
        String _años = request.getParameter("_anos");
        String parentesco = request.getParameter("parentesco").toUpperCase();
        String Grado_Academico = request.getParameter("Grado_Academico").toUpperCase();
        String lee = request.getParameter("lee");
        String Ocupacion = request.getParameter("Ocupacion").toUpperCase();
        String tel = request.getParameter("tel");
        String no_recibo = request.getParameter("no_recibo");
        String domicilio = request.getParameter("domicilio").toUpperCase();
        String entre_calles = request.getParameter("entre_calles").toUpperCase();
        String frente_a = request.getParameter("frente_a").toUpperCase();
        String email = request.getParameter("email");

        if (ap.isEmpty() || am.isEmpty() || name.isEmpty() || curp.isEmpty() || _años.isEmpty() || _ap.isEmpty() || _am.isEmpty() || _name.isEmpty() || _curp.isEmpty()
                || años.isEmpty() || meses.isEmpty() || sexo.isEmpty() || pesokg.isEmpty() || pesog.isEmpty() || estaturam.isEmpty() || estaturacm.isEmpty()
                || sangre_letra.isEmpty() || sangre_rh.isEmpty() || gdo.isEmpty() || gpo.isEmpty() || turno.isEmpty() || escuela_procedencia.isEmpty() || escuela_procedencia_dir.isEmpty()
                || parentesco.isEmpty() || Grado_Academico.isEmpty() || lee.isEmpty() || Ocupacion.isEmpty() || tel.isEmpty() || no_recibo.isEmpty() || domicilio.isEmpty() || entre_calles.isEmpty() || frente_a.isEmpty() || email.isEmpty()) {

            response.sendError(400, "Todos los campos son requeridos!");

        } else {

            if (curp.length() != 18 || _curp.length() != 18) {
                response.sendError(400, "Error en la CURP!");

            } else {

                HandlerDate hd = new HandlerDate();

                try {
                    InputStream is = getServletContext().getResourceAsStream("/files/TurnadoSRC.pdf");

                    PdfReader reader = new PdfReader(is);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    PdfStamper stamper = new PdfStamper(reader, baos);

                    stamper.getAcroFields().setField("fecha_elaboracion", hd.fecha_formal());

                    stamper.close();
                    reader.close();
                    // setting the content type
                    response.setContentType("application/pdf");
                    // the contentlength
                    response.setContentLength(baos.size());
                    // Lo sacamos a la pagina directamente
                    OutputStream os = response.getOutputStream();
                    baos.writeTo(os);
                    os.flush();
                    os.close();
                } catch (DocumentException e) {
                    throw new IOException(e.getMessage());
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
        processRequest(request, response);
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
        return "Short description";
    }// </editor-fold>

}
