

package modelo;

/**
 *
 * @author Mariana Portela
 */
public class Venta {

    private String codVenta;
    private String fechaVenta;
    private int unidadesVendidas;
    private int totalPago;
    private Articulo articulo;

    public Venta(String codVenta, String fechaVenta, int unidadesVendidas, Articulo articulo) {
        this.codVenta = codVenta;
        this.fechaVenta = fechaVenta;
        this.unidadesVendidas = unidadesVendidas;
        this.articulo = articulo;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
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

    public int getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(int totalPago) {
        this.totalPago = totalPago;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    public int calcularTotal(){
        int total = unidadesVendidas * articulo.getPrecio();
        totalPago = total;
        return total;
    }

    
    
}
