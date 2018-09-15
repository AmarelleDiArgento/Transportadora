/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Implementar.Admin;
import Modelo.Tabs.AsignarTab;
import Modelo.Tabs.EmpresaTab;
import Modelo.Tabs.UsuarioTab;
import Servicios.Mensajes.Mensaje;
import Servicios.Mensajes.Msj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author Wallas
 */
public class EmpresaServ extends HttpServlet {
    
    @Resource(name = "Pool")
    private DataSource pool;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses = request.getSession(true);
        Mensaje msj = new Mensaje();
        String ruta;
        
        if (ses.getAttribute("loger") != null){
            if(ses.getAttribute("msj") != null){
                msj.m = (Msj) ses.getAttribute("msj");
            }
            if(ses.getAttribute("jsp") != null){
                ruta = (String) ses.getAttribute("jsp");
            } else {
                ruta = "Empresa.jsp";
            }
            
            UsuarioTab uLog = (UsuarioTab) ses.getAttribute("loger");
            AsignarTab acc = null;
            for (AsignarTab a : uLog.getRol().getAccesos()){
                if (a.getPermiso().getNombre().equalsIgnoreCase("Rol")){
                    acc = a;
                }
            }
            
            if(acc != null){
                String Nit;
                String RazonSoc;
                String Representante;
                String Telefono;
                String Direccion;
                String Arl;
                boolean Estado;
                
                EmpresaTab e;
                try {
                    Admin Asql = new Admin(pool);
                    
                    String Accion = request.getParameter("accion");
                    
                    switch (Accion){
                        case "Listar":
                            if(acc.getLeer() == 2 || acc.getLeer() == 3){
                                List<EmpresaTab> el = Asql.getEmpresa().all();
                                ses.setAttribute("EmpresaList", el);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;
                        case "Registrar":
                            if (acc.isNuevo()){
                                Nit = request.getParameter("nit");
                                RazonSoc = request.getParameter("RazonSoc");
                                Representante = request.getParameter("representante");
                                Telefono = request.getParameter("telefono");
                                Direccion = request.getParameter("direccion");
                                Arl = request.getParameter("arl");
                                Estado = request.getParameter("estado") != null;
                                e = new EmpresaTab(Nit, RazonSoc, Representante, Telefono, Direccion, Arl, Estado);
                                msj.m = Asql.getEmpresa().insert(e); 
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;
                        case "Actualizar":
                            if (acc.isModificar()){
                                Nit = request.getParameter("nit");
                                RazonSoc = request.getParameter("RazonSoc");
                                Representante = request.getParameter("representante");
                                Telefono = request.getParameter("telefono");
                                Direccion = request.getParameter("direccion");
                                Arl = request.getParameter("arl");
                                Estado = request.getParameter("estado") != null;
                                e = new EmpresaTab(Nit, RazonSoc, Representante, Telefono, Direccion, Arl, Estado);
                                msj.m = Asql.getEmpresa().update(e);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;
                        case "Eliminar":
                            if(acc.isEliminar()){
                                Nit = request.getParameter("nit");
                                msj.m = Asql.getEmpresa().delete(Nit);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;
                        case "Obtener":
                            if(acc.getLeer() == 2 || acc.getLeer() == 3){
                              Nit = request.getParameter("nit");
                              e = Asql.getEmpresa().one(Nit);
                              ses.setAttribute("empresa", e);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;
                    }
                    
                } catch (SQLException ex) {
                    msj.m = msj.Error(ex);
                } catch (Exception ex) {
                    msj.m = msj.Error(ex);
                }
            }
            
        } else {
            msj.m = msj.NotSession();
            ruta = "index.jsp";
        }
        
        if (msj.m != null){
            ses.setAttribute("msj", msj.m);
        }
        request.getRequestDispatcher(ruta).forward(request, response);
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
