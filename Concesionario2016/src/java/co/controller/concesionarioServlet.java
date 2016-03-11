/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.controller;

import co.dao.carroDAOLocal;
import co.dao.clienteDAOLocal;
import co.dao.ventaDAOLocal;
import co.model.Carro;
import co.model.Cliente;
import co.model.Venta;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author josepplloo
 */
@MultipartConfig
public class concesionarioServlet extends HttpServlet {

    @EJB
    private ventaDAOLocal ventaDAO;

    @EJB
    private clienteDAOLocal clienteDAO;

    @EJB
    private carroDAOLocal carroDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String llamador = request.getParameter("cmd");

            switch (llamador) {
                case "clientes":

                    //Controlador de Clientes
                    // <editor-fold> 
                    String actioncliente = request.getParameter("actioncliente");

                    //defun
                    String idstr = request.getParameter("id");
                    int id = 0;
                    if (idstr != null && !idstr.equals("")) {
                        id = Integer.parseInt(idstr);
                    }

                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");

                    String edadstr = request.getParameter("edad");
                    int edad = 0;
                    if (edadstr != null && !edadstr.equals("")) {
                        edad = Integer.parseInt(edadstr);
                    }

                    String direccion = request.getParameter("direccion");

                    String telefonostr = request.getParameter("telefono");
                    int telefono = 0;
                    if (telefonostr != null && !telefonostr.equals("")) {
                        telefono = Integer.parseInt(telefonostr);
                    }

                    Cliente cliente = new Cliente(id, nombre, apellido, edad, direccion, telefono);

                    List<Cliente> cl;

                    if ("Agregar Cliente".equalsIgnoreCase(actioncliente)) {
                        clienteDAO.addCliente(cliente);
                    } else if ("Editar Cliente".equalsIgnoreCase(actioncliente)) {
                        clienteDAO.editCliente(cliente);
                    } else if ("Eliminar Cliente".equalsIgnoreCase(actioncliente)) {
                        clienteDAO.deleteCliente(id);
                    } else if ("Buscar Cliente".equalsIgnoreCase(actioncliente)) {
                        cliente = clienteDAO.getCliente(id);

                        out.println("<br>" + cliente.getId()
                                + ".." + cliente.getNombre() + ".." + cliente.getApellido()
                                + ".." + cliente.getEdad() + "</br>");

                        request.setAttribute("msjcliente1", cliente.getId());
                        request.setAttribute("msjcliente2", cliente.getNombre());
                        request.setAttribute("msjcliente3", cliente.getApellido());
                        request.setAttribute("msjcliente4", cliente.getEdad());
                        request.setAttribute("msjcliente5", cliente.getDireccion());
                        request.setAttribute("msjcliente6", cliente.getTelefono());

                        request.getRequestDispatcher("/index.jsp");
                    } else if ("Ver Clientes".equalsIgnoreCase(actioncliente)) {
                        cl = clienteDAO.getAllClientes();
                    }

                    request.setAttribute("cliente", cliente);
                    request.setAttribute("getAllClientes", clienteDAO.getAllClientes());
                    request.setAttribute("t3a", "in active");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                    // </editor-fold> 
                    break;
                case "carros":
                    //Controlador de carros////////////////////////////////////////////////
                    // <editor-fold>  
                    String actioncarro = request.getParameter("actioncarro");

                    //defino la captura de parametros
                    String matricula = request.getParameter("matricula");
                    String modelo = request.getParameter("modelo");
                    String fabricante = request.getParameter("fabricante");

                    String fechastr = request.getParameter("fecha");
                    Date fecha = Date.valueOf(LocalDate.now());
                    if (fechastr != null && !fechastr.equals("")) {

                        fecha = Date.valueOf(fechastr);
                    }

                    String cilindrajestr = request.getParameter("cilindraje");
                    int cilindraje = 0;
                    if (cilindrajestr != null && !cilindrajestr.equals("")) {

                        cilindraje = Integer.parseInt(cilindrajestr);
                    }

                    String potenciastr = request.getParameter("potencia");
                    int potencia = 0;
                    if (potenciastr != null && !potenciastr.equals("")) {

                        potencia = Integer.parseInt(potenciastr);
                    }

                    String preciostr = request.getParameter("precio");
                    int precio = 0;
                    if (preciostr != null && !preciostr.equals("")) {

                        precio = Integer.parseInt(preciostr);
                    }

                    String transmisionstr = request.getParameter("transmision");
                    Boolean transmision;
                    if (transmisionstr != null && !transmisionstr.equals("")) {
                        transmision = Boolean.TRUE;
                    } else {
                        transmision = Boolean.FALSE;
                    }

                    /*
            código para cargar la imagen
                     */
                    Part archivo = request.getPart("imagen");
                    String nombreArchivo = archivo.getSubmittedFileName();
                    System.out.println(nombreArchivo);

                    /*
            fin del código
                     */
                    Carro carro = new Carro(matricula, modelo, fabricante, fecha, cilindraje, potencia, precio, transmision);

                    List<Carro> c;

                    if ("Agregar Carro".equalsIgnoreCase(actioncarro)) {

                        carroDAO.addCarro(carro);
                        
                        try {
                        InputStream is = archivo.getInputStream();
                        File file = new File(getServletContext().getInitParameter("file-upload") + matricula + ".jpg");
                            try (OutputStream os = new FileOutputStream(file)) {
                                byte[] buffer = new byte[1024];
                                int length;
                                while ((length = is.read(buffer)) > 0) {
                                    os.write(buffer, 0, length);
                                }
                                os.flush();
                                os.close();
                            }
                        } catch(Exception e) {
                            System.err.println(e);
                        }

                    } else if ("Editar Carro".equalsIgnoreCase(actioncarro)) {
                        
                        carroDAO.editCarro(carro);
                        
                        try {
                        InputStream is = archivo.getInputStream();
                        File file = new File(getServletContext().getInitParameter("file-upload") + matricula + ".jpg");
                            try (OutputStream os = new FileOutputStream(file)) {
                                byte[] buffer = new byte[1024];
                                int length;
                                while ((length = is.read(buffer)) > 0) {
                                    os.write(buffer, 0, length);
                                }
                                os.flush();
                                os.close();
                            }
                        } catch(Exception e) {
                            System.err.println(e);
                        }
                    } else if ("Eliminar Carro".equalsIgnoreCase(actioncarro)) {
                        carroDAO.deleteCarro(matricula);
                    } else if ("Buscar Carro".equalsIgnoreCase(actioncarro)) {
                        carro = carroDAO.getCarro(matricula);

                        out.println("<br>" + carro.getMatricula()
                                + ".." + carro.getFabricante() + ".." + carro.getModelo()
                                + ".." + carro.getCilindraje() + "</br>");

                        request.setAttribute("msjcarro1", carro.getMatricula());
                        request.setAttribute("msjcarro2", carro.getModelo());
                        request.setAttribute("msjcarro3", carro.getFabricante());
                        request.setAttribute("msjcarro4", carro.getFecha());
                        request.setAttribute("msjcarro4", carro.getCilindraje());
                        request.setAttribute("msjcarro6", carro.getPotencia());
                        request.setAttribute("msjcarro7", carro.getPrecio());
                        request.setAttribute("msjcarro8", carro.getTransmision());

                        request.getRequestDispatcher("/index.jsp");
                    } else if ("Ver Carros".equalsIgnoreCase(actioncarro)) {
                        c = carroDAO.getAllCarros();
                    }

                    request.setAttribute("carro", carro);
                    request.setAttribute("getAllCarros", carroDAO.getAllCarros());
                    request.setAttribute("t2a", "in active");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                    // </editor-fold> 
                    break;
                case "ventas":
                    //Controlador de venta
                    //<editor-fold>
                    String actionventa = request.getParameter("actionventa");

                    String ventaidstr = request.getParameter("ventaid");
                    int ventaid = 0;
                    if (ventaidstr != null && !ventaidstr.equals("")) {
                        ventaid = Integer.parseInt(ventaidstr);
                    }

                    String matriculaid = request.getParameter("carros");
                    String clienteidstr = request.getParameter("clientes");
                    int clienteid = 0;
                    if (clienteidstr != null && !clienteidstr.equals("")) {
                        clienteid = Integer.parseInt(clienteidstr);
                    }

                    request.setAttribute("carros", carroDAO.getAllCarros());
                    request.setAttribute("clientes", clienteDAO.getAllClientes());

                    
                    Venta venta = new Venta(ventaid, matriculaid, clienteid);
                    List<Venta> v;

                    if ("Agregar Venta".equalsIgnoreCase(actionventa)) {

                        ventaDAO.addVenta(venta);
                    } else if ("Editar Venta".equalsIgnoreCase(actionventa)) {
                        ventaDAO.editVenta(venta);
                    } else if ("Eliminar Venta".equalsIgnoreCase(actionventa)) {
                        ventaDAO.deleteVenta(ventaid);
                    } else if ("Buscar Venta".equalsIgnoreCase(actionventa)) {
                        venta = ventaDAO.getVenta(ventaid);

                        out.println("<br>" + venta.getVentaid()
                                + ".." + venta.getMatricula()
                                + ".." + venta.getClienteid() + "</br>");

                        request.setAttribute("msjventa1", venta.getVentaid());
                        request.setAttribute("msjventa2", venta.getMatricula());
                        request.setAttribute("msjventa3", venta.getClienteid());

                        request.getRequestDispatcher("/index.jsp");
                    } else if ("Ver Ventas".equalsIgnoreCase(actionventa)) {
                        v = ventaDAO.getAllVentas();
                    }

                    request.setAttribute("venta", venta);
                    request.setAttribute("getAllVentas", ventaDAO.getAllVentas());
                    request.setAttribute("t4a", "in active");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                    //</editor-fold>
                    break;
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(concesionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(concesionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
