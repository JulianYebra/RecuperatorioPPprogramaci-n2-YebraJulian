package recuperatoriopp.yebra.julian;


public class Postre extends Producto implements IVendible {

    private TipoPostre tipoPostre;

       public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }
@Override
     public double getPrecioTotal(){
     
     if (this.tipoPostre == TipoPostre.TIRAMISU){
          return this.precio + (precio * 0.2);
     }
     else if (this.tipoPostre == TipoPostre.HELADO){
          return this.precio + (precio * 0.15);
     }
     else{
          return this.precio + (precio * 0.1);
     }
 }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Postre{");
        sb.append("tipo=").append(tipoPostre);
        sb.append(" Precio total del postre: $").append(this.getPrecioTotal());
        sb.append('}');
        return sb.toString();
    }
    
 @Override
    public boolean equals(Object obj) {
         if (this == obj) return true;
        
        if (!(obj instanceof Postre)) return false;
        
        Postre otro = (Postre) obj;
        return this.tipoPostre == otro.tipoPostre;
    }
    
}
