package com.emergentes.controlador;

import com.emergentes.dao.BlogDAO;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.modelo.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            BlogDAO dao = new BlogDAOimpl();
            int id;
            Blog log = new Blog();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            
            switch(action){
                case "add":
                    request.setAttribute("blog", log);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    log = dao.getById(id);
                    //System.out.println(avi);
                    request.setAttribute("blog", log);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    request.getRequestDispatcher("Inicio").forward(request, response);
                    //response.sendRedirect(request.getContextPath()+"/inicio");
                    break;
                default:
                    List<Blog> lista = dao.getAll();
                    request.setAttribute("posts", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e){
            System.out.println("Error" +e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BlogDAO dao = new BlogDAOimpl();       
        int id = Integer.parseInt(request.getParameter("id"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");        
        Blog log = new Blog();        
        log.setId(id);
        log.setFecha(fecha);
        log.setTitulo(titulo);
        log.setContenido(contenido);        
        if(id==0){
            try{        
                dao.insert(log);
                response.sendRedirect("LoginSession");
            }catch (Exception e){
                System.out.println("Error" + e.getMessage());
            }
        }
        else{
            try{                
                dao.update(log);
                response.sendRedirect ("Inicio");
            }catch(Exception e){
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}
