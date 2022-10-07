

package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Articulo;
import modelo.Conexion;
import modelo.Usuario;
import modelo.Venta;

/**
 *
 * @author Mariana Portela
 */
public class ControladorGestion {

    Conexion conexion = new Conexion();

    public ControladorGestion() {
    }
    
    public boolean guardarUsuario(String cedula, String nombre, String apellido,
             String correo, String contrasenia) {
        Usuario usuario = new Usuario(cedula, nombre, apellido, correo, contrasenia);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("insert into usuario(cedula,nombre,apellido,correo,contrasenia) "
                + "values('" + usuario.getCedula()+ "','" +
                usuario.getNombre()+ "','" +
                usuario.getApellido() + "','" +
                usuario.getCorreo()+ "'," +
                usuario.getContrasenia()+ ")");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }

    public List<String> buscarUsuario(String cedula) {
        
        List<String> temp = new ArrayList<>();
        
        conexion.conectar();

        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select cedula,nombre,apellido,correo,"
                            + "contrasenia from usuario where "
                            + "cedula='" + cedula + "'"));        

            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("cedula"));
                temp.add(conexion.getResultadoDB().getString("nombre"));
                temp.add(conexion.getResultadoDB().getString("apellido"));
                temp.add(conexion.getResultadoDB().getString("correo"));
                temp.add(conexion.getResultadoDB().getString("contrasenia"));
            }
            conexion.desconectar();                
        } catch (SQLException ex) {            
            Logger.getLogger(ControladorGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }
        return temp;
    }

    public boolean modificarUsuario(String nombre, String apellido,
            String cedula, String correo, String contrasenia) {
        Usuario usuario = new Usuario(nombre, apellido, cedula, correo, contrasenia);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("update usuario set nombre='" + usuario.getNombre() + 
                "',apellido='" + usuario.getApellido() + "'," + 
                "correo='" + usuario.getCorreo()+"'," +
                "contrasenia=" + usuario.getContrasenia()     
                + " where cedula='" + usuario.getCedula()+"'");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }

    public boolean eliminarUsuario(String cedula) {
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("delete from usuario where cedula='" + cedula+"'");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }
    
//-----------------------------------------------------------------------------
    
    
    public boolean guardarArticulo(String codProducto, String nombre, int precio, 
            int cantidad, String descripcion, String categoria) {
        Articulo articulo = new Articulo(codProducto,nombre, precio, cantidad, descripcion, categoria);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("insert into articulo(codProducto,nombre,precio,cantidad,descripcion,categoria) "
                + "values('" + articulo.getCodProducto()+ "','" +
                articulo.getNombre() + "','" +
                articulo.getPrecio()+ "','" +
                articulo.getCantidad()+ "','" +
                articulo.getDescripcion()+  "'," +
                articulo.getCategoria()+")");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }

    public List<String> buscarArticulo(String codProducto) {
        
        List<String> temp = new ArrayList<String>();
        
        conexion.conectar();

        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select codProducto,nombre,precio,cantidad,"
                            + "descripcion,categoria from articulo where "
                            + "codProducto='" + codProducto + "'"));        

            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("codProducto"));
                temp.add(conexion.getResultadoDB().getString("nombre"));
                temp.add(conexion.getResultadoDB().getInt("precio")+"");               
                temp.add(conexion.getResultadoDB().getInt("cantidad")+"");
                temp.add(conexion.getResultadoDB().getString("descripcion"));
                temp.add(conexion.getResultadoDB().getString("categoria"));
            }
            conexion.desconectar();                
        } catch (SQLException ex) {            
            Logger.getLogger(ControladorGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }
        return temp;
    }

    public boolean modificarArticulo(String codProducto,String nombre, int precio,
            int cantidad, String descripcion, String categoria) {
        Articulo articulo = new Articulo(codProducto,nombre,precio,cantidad,descripcion,categoria);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("update articulo set nombre='" + articulo.getNombre() + 
                "',precio='" + articulo.getPrecio() + "'," + 
                "cantidad='" + articulo.getCantidad() + "'," +
                "descripcion'=" + articulo.getDescripcion() + "'," +
                "categoria=" + articulo.getCategoria()
                + " where codProducto='" + articulo.getCodProducto()+"'");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }

    public boolean eliminarArticulo(String codProducto) {

        conexion.conectar();

        try {
            conexion.getSentenciaSQL().execute
        ("delete from articulo where codProducto='" + codProducto+"'");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }
    
     public DefaultTableModel listarArticulo() {
        DefaultTableModel temporal;
        String nombreColumnas[] =
        {
            "Codigo articulo", "nombre", "precio", "cantidad","descripcion","categoria"
        };
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        conexion.conectar();
        try
        {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select codProducto,nombre,precio,cantidad,descripcion,categoria"
                            + " from articulo order by codProducto"));
            while (conexion.getResultadoDB().next())
            {
                temporal.addRow(new Object[]
                {
                    conexion.getResultadoDB().getString("codProducto"),
                    conexion.getResultadoDB().getString("nombre"),
                    conexion.getResultadoDB().getInt("precio"),
                    conexion.getResultadoDB().getInt("cantidad"),
                    conexion.getResultadoDB().getString("descripcion"),
                    conexion.getResultadoDB().getString("categoria"),
                });
            }
            conexion.desconectar();
        } catch (SQLException ex)
        {
            Logger.getLogger(ControladorGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }
        return temporal;
    }
    
     public boolean guardarVenta(Venta venta) {
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("insert into articulo(codVenta,fechaVenta,unidadesVendidad,codProductoVenta) "
                + "values('" + venta.getCodVenta()+ "','" +
                venta.getFechaVenta() + "','" +
                venta.getUnidadesVendidas()+ "'," +
                venta.getArticulo()+")");
            conexion.desconectar();          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();          
            return false;
        }
    }
     
     
}
