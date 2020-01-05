package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class UsuarioDAO {
  private static ResultSet resultadoConsulta;
  
  
  public Usuario iniciarSesion(Usuario usuario) throws SQLException, ClassNotFoundException{
    ArrayList<Usuario> usuarios = cargarListaUsuarios();
    int cantidad = usuarios.size();
    for (int j = 0; j<cantidad; j++){
      if (usuario.equalsUsuario(usuarios.get(j))){
        return usuario;  
      }
    }
    return null;
  }
  
  
  public ArrayList<Usuario> cargarListaUsuarios() throws SQLException, ClassNotFoundException{
    resultadoConsulta =  ConexionSQL.createConsult("exec cargarUsuarios;");
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    while (resultadoConsulta.next()) {
      Usuario usuarioEncontrado = new Usuario(resultadoConsulta.getString(1),
          resultadoConsulta.getString(2));
      usuarios.add(usuarioEncontrado);
    }
    return usuarios;
  }
}
