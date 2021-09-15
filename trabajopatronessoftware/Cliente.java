/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopatronessoftware;

import Decorator.*;
import factoryMethod.*;
import java.util.ArrayList;
import pieza.*;

/**
 *
 * @author nano
 */
public class Cliente extends Usuario{

    private CuentaGeneral cuentaGeneral = new CuentaGeneral();
    private DecoradorCuentaPremium cuentaPremium = null;
    private ArrayList<Pieza> carritoCompra = new ArrayList<Pieza>();

    public Cliente(String dni, String correo, String clave, String nombre, int numeroTelefono) {
        super(dni, correo, clave, nombre, numeroTelefono);
        setEsAdministrador(false);
    }
    
    public void activarDesactivarCuentaPremium(){
        if (cuentaPremium==(null)){
            cuentaPremium=new DecoradorCuentaPremium();
        }
        else{
            cuentaPremium=null;
            
        }
    }
    
    public int getNumeroTickets(){
        return cuentaGeneral.getNumeroTickets();
    }
    
    public boolean tieneCuentaPremium(){
       if (cuentaPremium==(null)){
            return false;
        }
        else{
            return true;
            
        }
    }
    
    public void añadirVenta(Venta v){
        cuentaGeneral.añadirVenta(v);
    }
    
    public boolean contienePiezaCarrito(Pieza p){
        return carritoCompra.contains(p);
    }
    
    public void añadirPiezaCarrito(Pieza p){
        carritoCompra.add(p);
    }
    
    public void eliminarPiezaCarrito(Pieza p){
        carritoCompra.remove(p);
    }
    
    public ArrayList<Pieza> getCarritoCompra(){
        return carritoCompra;
    }
    
    public ArrayList<Venta> getListaDeCompras(){
        return cuentaGeneral.getHistorialCompras();
    }
    
}
