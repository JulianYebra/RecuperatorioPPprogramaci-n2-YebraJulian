package recuperatoriopp.yebra.julian;


public class Pizza extends Producto implements IVendible {

    private TipoPizza sabor;
    private TamanoPizza tamano;
    
    public Pizza(String nombre, double precio,Fabricante fabricante,TipoPizza sabor, TamanoPizza tamano){
        super(nombre,precio,fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
        
    }
    
    @Override
    public double getPrecioTotal(){
        if (this.tamano == TamanoPizza.CHICA){
            return precio + (precio * 0.05);
        }
        else if (this.tamano == TamanoPizza.MEDIANA){
            return precio + (precio * 0.1);
    }
        else{
            return precio + (precio * 0.2);
        }
    
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Pizza{");
        sb.append("sabor=").append(sabor);
        sb.append(", tamano=").append(tamano);
        sb.append("Precio total de la pizza: ").append(this.getPrecioTotal());
        sb.append('}');
        return sb.toString();
    }
    
 @Override
public boolean equals(Object obj) {
    if (!super.equals(obj)) return false; 
    if (!(obj instanceof Pizza)) return false;

    Pizza otra = (Pizza) obj;
    return this.sabor == otra.sabor &&
           this.tamano == otra.tamano;
    
}
}
