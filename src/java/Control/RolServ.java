/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Implementar.Admin;
import Modelo.Tabs.AsignarTab;
import Modelo.Tabs.RolTab;
import Modelo.Tabs.UsuarioTab;
import Servicios.Mensajes.Mensaje;
import Servicios.Mensajes.Msj;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author freyd
 */
public class RolServ extends HttpServlet {

    @Resource(name = "Pool")
    private DataSource pool;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession ses = request.getSession(true);
        Mensaje msj = new Mensaje();
        String ruta;

        if (ses.getAttribute("loger") != null) {

            if (ses.getAttribute("msj") != null) {
                msj.m = (Msj) ses.getAttribute("msj");
            }
            if (ses.getAttribute("jsp") != null) {
                ruta = (String) ses.getAttribute("jsp");
            } else {
                ruta = "rol.jsp";
            }

            UsuarioTab uLog = (UsuarioTab) ses.getAttribute("loger");
            AsignarTab acc = null;
            for (AsignarTab a : uLog.getRol().getAccesos()) {
                if (a.getPermiso().getNombre().equalsIgnoreCase("Rol")) {
                    acc = a;
                }
            }

            if (acc != null) {

                Long ID;
                String Nombre;
                String Descripcion;
                int Jerarquia;
                boolean Estado;

                RolTab r;
                try {
                    Admin Asql = new Admin(pool);

                    String Accion = request.getParameter("accion");

                    switch (Accion) {
                        case "Listar":
                            if (acc.getLeer() == 2 || acc.getLeer() == 3) {
                                List<RolTab> rl = Asql.getRol().all();
                                ses.setAttribute("RolList", rl);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;

                        case "Registrar":
                            if (acc.isNuevo()) {
                                Nombre = request.getParameter("nombre");
                                Descripcion = request.getParameter("descripcion");
                                Jerarquia = Integer.parseInt(request.getParameter("jerarquia"));
                                Estado = request.getParameter("estado") != null;
                                r = new RolTab(Nombre, Descripcion, Jerarquia, Estado);
                                msj.m = Asql.getRol().insert(r);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;

                        case "Actualizar":
                            if (acc.isModificar()) {
                                ID = Long.valueOf(request.getParameter("id"));
                                Nombre = request.getParameter("nombre");
                                Descripcion = request.getParameter("descripcion");
                                Jerarquia = Integer.parseInt(request.getParameter("jerarquia"));
                                Estado = request.getParameter("estado") != null;
                                r = new RolTab(Nombre, Descripcion, Jerarquia, Estado);
                                msj.m = Asql.getRol().update(r);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;

                        case "Eiminar":
                            if (acc.isEliminar()) {
                                ID = Long.valueOf(request.getParameter("id"));
                                msj.m = Asql.getRol().delete(ID);
                            } else {
                                msj.m = msj.NotAccess();
                            }
                            break;

                        case "Obtener":
                            if (acc.getLeer() == 2 || acc.getLeer() == 3) {
                                ID = Long.valueOf(request.getParameter("id"));
                                r = Asql.getRol().one(ID);
                                ses.setAttribute("rol", r);
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

            } else {
                msj.m = msj.NotAccess();
                ruta = "main.jsp";
            }
        } else {
            msj.m = msj.NotSession();
            ruta = "index.jsp";
        }

        if (msj.m != null) {
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
