/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import factoryMethod.Venta;
import java.util.ArrayList;

/**
 *
 * @author nano
 */
public class CuentaGeneral implements Cuenta{
    ArrayList<Venta> historialCompras = new ArrayList<Venta>();

    @Override
    public ArrayList<Venta> getHistorialCompras(){
        return historialCompras;
    }
    
    public int getNumeroTickets(){
       return  historialCompras.size();
    }

    @Override
    public void añadirVenta(Venta v) {
        historialCompras.add(v);
        }
    
}
