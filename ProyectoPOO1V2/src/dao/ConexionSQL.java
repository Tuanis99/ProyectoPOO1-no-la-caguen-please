package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionSQL extends javax.swing.JFrame{
  public static Connection CON = null;
  public static ResultSet RESULT = null;
    

  public static Connection getConexionSQL() throws SQLException, ClassNotFoundException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
    String urlConexion = "jdbc:sqlserver://localhost:1433;databaseName=PrimerProyectoProgramado7;user=sa;password=1234";
    ConexionSQL.CON = DriverManager.getConnection(urlConexion);
    return CON;
  }
    
  
  public static ResultSet createConsult(String query) throws ClassNotFoundException {
    try {
      Connection con = getConexionSQL();
      RESULT = con.createStatement().executeQuery(query);
    } 
    catch (SQLException ex) {
      System.out.println(String.valueOf(ex));
    }
    return RESULT;
    }  
}
