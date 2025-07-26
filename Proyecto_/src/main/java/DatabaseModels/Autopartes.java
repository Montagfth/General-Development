
package DatabaseModels;


public class Autopartes {
    
    private int ID_Autoparte;
    private String Nombre_Autoparte;
    private String Categoria_Autoparte;
    private int Stock_Autoparte;
    private int Precio_Autoparte;
    
    private byte[] Imagen_Autoparte;

    public byte[] getImagen_Autoparte() {
        return Imagen_Autoparte;
    }

    public void setImagen_Autoparte(byte[] imagen_Autoparte) {
        Imagen_Autoparte = imagen_Autoparte;
    }

    public int getID_Autoparte() {
        return ID_Autoparte;
    }

    public void setID_Autoparte(int ID_Autoparte) {
        this.ID_Autoparte = ID_Autoparte;
    }

    public String getNombre_Autoparte() {
        return Nombre_Autoparte;
    }

    public void setNombre_Autoparte(String Nombre_Autoparte) {
        this.Nombre_Autoparte = Nombre_Autoparte;
    }

    public String getCategoria_Autoparte() {
        return Categoria_Autoparte;
    }

    public void setCategoria_Autoparte(String Categoria_Autoparte) {
        this.Categoria_Autoparte = Categoria_Autoparte;
    }

    public int getStock_Autoparte() {
        return Stock_Autoparte;
    }

    public void setStock_Autoparte(int Stock_Autoparte) {
        this.Stock_Autoparte = Stock_Autoparte;
    }

    public int getPrecio_Autoparte() {
        return Precio_Autoparte;
    }

    public void setPrecio_Autoparte(int Precio_Autoparte) {
        this.Precio_Autoparte = Precio_Autoparte;
    }
}
