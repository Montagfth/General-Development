package DatabaseModels;

public class Auto {
    
    private int ID_Auto;
    private String Marca_Auto;
    private String Modelo_Auto;
    private String Anio_Auto;
    private int Precio_Auto;
    private byte[] Imagen_Auto;  

    public int getID_Auto() {
        return ID_Auto;
    }

    public void setID_Auto(int ID_Auto) {
        this.ID_Auto = ID_Auto;
    }

    public String getMarca_Auto() {
        return Marca_Auto;
    }

    public void setMarca_Auto(String Marca_Auto) {
        this.Marca_Auto = Marca_Auto;
    }

    public String getModelo_Auto() {
        return Modelo_Auto;
    }

    public void setModelo_Auto(String Modelo_Auto) {
        this.Modelo_Auto = Modelo_Auto;
    }

    public String getAnio_Auto() {
        return Anio_Auto;
    }

    public void setAnio_Auto(String Anio_Auto) {
        this.Anio_Auto = Anio_Auto;
    }

    public int getPrecio_Auto() {
        return Precio_Auto;
    }

    public void setPrecio_Auto(int Precio_Auto) {
        this.Precio_Auto = Precio_Auto;
    }

    public byte[] getImagen_Auto() {
        return Imagen_Auto;
    }

    public void setImagen_Auto(byte[] Imagen_Auto) {
        this.Imagen_Auto = Imagen_Auto;
    }
}
