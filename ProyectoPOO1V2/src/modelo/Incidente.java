package modelo;

/**
 *
 * @author Xtreme
 */
public class Incidente {
  
  private int idReserva; 
  private String detalle;
  private int rebajoPuntos;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getRebajoPuntos() {
        return rebajoPuntos;
    }

    public void setRebajoPuntos(int rebajoPuntos) {
        this.rebajoPuntos = rebajoPuntos;
    }

  
  public Incidente(int pIdReserva, String pDetalle, int pRebajoPuntos) {
    this.idReserva = pIdReserva;
    this.detalle = pDetalle;
    this.rebajoPuntos = pRebajoPuntos;
  } 
}
