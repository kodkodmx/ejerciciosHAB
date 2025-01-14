package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "peluqueriaSv", urlPatterns = {"/peluqueriaSv"})
public class peluqueriaSv extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
