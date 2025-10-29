package recuperatoriopp.yebra.julian;

import java.util.Random;


public abstract class Producto {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;
    
    
    public Producto(String nombre ,double precio, Fabricante fabricante){
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }
    
    public Producto(String nombre ,double precio, String nombreFabricante, String ciudadFabricante,int antiguedadFabricante){
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante,ciudadFabricante,antiguedadFabricante);
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }
    
    static{
        generadorAleatorio = new Random();
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
    
    
    public int getCalorias(){
        if (this.calorias == 0){
            calorias = generadorAleatorio.nextInt(601) +200;
        }
        return calorias;
    }
    
    public int getTiempoPreparacion(){
        if(this.tiempoPreparacion == 0){
            tiempoPreparacion = generadorAleatorio.nextInt(16)+5;
        }return tiempoPreparacion;
    }
   
    
    private static String mostrar(Producto p){
        
        return  " nombre producto: " + p.nombre + " precio: " + p.precio + " fabricante: " +
                p.getFabricante().toString() + " calorias: " + p.getCalorias() + " tiempo Preparacion : " + p.getTiempoPreparacion();
        
    }
    
    private static boolean sonIguales(Producto p1 ,Producto p2){
         if (p1 == null || p2 == null)
             return false;
         
         return Fabricante.sonIguales(p1.fabricante, p2.fabricante) &&
                p1.nombre.equals(p2.nombre);    
    }
    
    
     public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Producto)) return false;
        Producto otro = (Producto) obj;
        return this.nombre.equals(otro.nombre) &&
               Fabricante.sonIguales(this.fabricante, otro.fabricante);
    
}
     public String toString(){
         return mostrar(this);
     }
     
     
}