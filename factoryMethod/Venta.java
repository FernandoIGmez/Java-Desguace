/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethod;

import java.util.ArrayList;
import pieza.*;

/**
 *
 * @author nano
 */
public abstract class Venta {
    private ArrayList<Pieza> piezasVenta;
    private float precioVentaFinal=0f;
    private boolean ventaCuentaPremium;
    
    public ArrayList<Pieza> getPiezasVenta(){
        return piezasVenta;
    }
    
    public void setPiezasVenta(ArrayList<Pieza> p){
        piezasVenta= p;
    }

    public boolean isVentaCuentaPremium() {
        return ventaCuentaPremium;
    }
    
    public String getInformacionVenta(){
        String datosVenta="Datos de la venta:";
        
       for (int i=0; i<piezasVenta.size();i++){
                datosVenta+=("\nPieza "+(i+1)+":");
                datosVenta+=("\n\tNombre: "+piezasVenta.get(i).getNombre());
                datosVenta+=("\n\tMarca: "+piezasVenta.get(i).getMarca());
                datosVenta+=("\n\tModelo: "+piezasVenta.get(i).getModelo());
                datosVenta+=("\n\tAño del modelo: "+piezasVenta.get(i).getAño());
                datosVenta+=("\n\tPrecio: "+piezasVenta.get(i).getPrecio());
            }
          
            if (isVentaCuentaPremium()){
                getPrecioVenta(true);
                datosVenta+=("\n\nPrecio total de la compra con descuento: "+getPrecioVentaFinal());
            }
            else{
                getPrecioVenta(false);
                datosVenta+=("\n\nPrecio total de la compra: "+getPrecioVentaFinal());
                
            }
            return datosVenta;
    }

    public void setVentaCuentaPremium(boolean ventaCuentaPremium) {
        this.ventaCuentaPremium = ventaCuentaPremium;
    }
    
    
    
    public void añadirPieza(Pieza p){
        piezasVenta.add(p);
    }
    
    public void eliminarPieza(Pieza p){
        piezasVenta.remove(p);
    }
    
    public int numeroPiezasVenta(){
        return piezasVenta.size();
    }
    
    public float getPrecioVenta(boolean ventaPremium){
        float precioCompra=0f;
        for (int i=0; i<piezasVenta.size();i++){
            precioCompra+=piezasVenta.get(i).getPrecio();
        }
        if (ventaPremium){
            precioVentaFinal= precioCompra - (precioCompra*0.05f);
        }
        else{
            precioVentaFinal= precioCompra;
        }
        return precioVentaFinal;
    }
    
    public float getPrecioVentaFinal(){
        return precioVentaFinal;
    }
    
}
