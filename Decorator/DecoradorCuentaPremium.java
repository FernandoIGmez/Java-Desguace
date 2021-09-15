/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import factoryMethod.Venta;
import java.util.ArrayList;
import pieza.Pieza;

/**
 *
 * @author nano
 */
public class DecoradorCuentaPremium implements Cuenta{


    @Override
    public ArrayList<Venta> getHistorialCompras() {
        return null;
    }

    @Override
    public void añadirVenta(Venta v) {
    }
    
}
