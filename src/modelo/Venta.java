

package modelo;

/**
 *
 * @author Mariana Portela
 */
public class Venta {

    private String fechaVenta;
    private int unidadesVendidas;
    private Articulo articulo;

    public Venta(String fechaVenta, int unidadesVendidas, Articulo articulo) {
        this.fechaVenta = fechaVenta;
        this.unidadesVendidas = unidadesVendidas;
        this.articulo = articulo;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
}
