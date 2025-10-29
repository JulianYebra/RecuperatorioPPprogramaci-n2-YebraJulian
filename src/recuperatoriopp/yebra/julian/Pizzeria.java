package recuperatoriopp.yebra.julian;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto>{

     private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;

  
    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }


    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }


    private boolean sonIguales(Producto p) {
        for (Producto prod : productos) {
            if (prod.equals(p)) {
                return true;
            }
        }
        return false;
    }
    public void agregar(Producto p) {
        if (productos.size() >= capacidad) {
            System.out.println("Capacidad máxima alcanzada.");
        } else if (sonIguales(p)) {
            System.out.println("El producto ya existe en la pizzería.");
        } else {
            productos.add(p);
            System.out.println("Producto agregado.");
        }
    }
    
    private double getPrecioProductos(TipoProducto tipo) {
    double total = 0;

    for (Producto p : productos) {
        if (tipo == TipoProducto.PIZZAS && p instanceof Pizza) {
            total += ((IVendible) p).getPrecioTotal();
        } else if (tipo == TipoProducto.POSTRES && p instanceof Postre) {
            total += ((IVendible) p).getPrecioTotal();
        } else if (tipo == TipoProducto.TODOS) {
            total += ((IVendible) p).getPrecioTotal();
        }
    }
    return total;
}
    
     private double getPrecioDePizzas() {
        return getPrecioProductos(TipoProducto.PIZZAS);
    }

 
    private double getPrecioDePostres() {
        return getPrecioProductos(TipoProducto.POSTRES);
    }


    private double getPrecioTotal() {
        return getPrecioProductos(TipoProducto.TODOS);
    }
    
   @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
    
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizzería: ").append(nombre)
          .append(" | Capacidad: ").append(capacidad)
          .append(" | Cantidad de productos: ").append(productos.size())
          .append("\n--- Productos ---\n");

        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }

        sb.append("\nPrecios totales:\n")
          .append("Pizzas: $").append(getPrecioDePizzas()).append("\n")
          .append("Postres: $").append( getPrecioDePostres()).append("\n")
          .append("Total: $").append(getPrecioTotal()).append("\n");

        return sb.toString();
    }
}
    


    

