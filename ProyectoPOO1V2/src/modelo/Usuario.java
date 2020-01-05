package modelo;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class Usuario {
  String idUsuario;
  String contrasena;
  
  
  public Usuario() {
      
  }
  
  
  public Usuario(String pIdUsuario, String pContrasena) {
    this.idUsuario = pIdUsuario;
    this.contrasena = pContrasena;
  }
  
  
  public String getIdUsuario(){
    return this.idUsuario;
  }
  
  
  public String getContrasena(){
    return this.contrasena;
  }
  

  public boolean equalsUsuario(Object o){
    if (this == o){
      return true;
    }
    if (o == null){
      return false;
    }
    if (getClass() != o.getClass()){
      return false;
    }
    Usuario usuario = (Usuario) o;
    return idUsuario.equals(usuario.idUsuario) && contrasena.equals(usuario.contrasena);
  }
}
