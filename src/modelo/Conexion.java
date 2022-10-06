

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariana Portela
 */
public class Conexion {

    private String driver = "org.postgresql.Driver"; 
    private String connectString = "jdbc:mysql://localhost:3306/parcial2";
    private String user = "root"; 
    private String password = "123456789Malu";
    private Connection conexionDB; 
    private Statement sentenciaSQL;
    private ResultSet resultadoDB;
    
   public void conectar() {
        try {
            Class.forName(driver); 
            conexionDB = DriverManager.getConnection(connectString, user, password);            
            sentenciaSQL = conexionDB.createStatement(); 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 
   
   public void desconectar() {
        try {
            sentenciaSQL.close();
            conexionDB.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    public Statement getSentenciaSQL() {
        return sentenciaSQL;
    }

    public void setSentenciaSQL(Statement sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    public ResultSet getResultadoDB() {
        return resultadoDB;
    }

    public void setResultadoDB(ResultSet resultadoDB) {
        this.resultadoDB = resultadoDB;
    }
}
