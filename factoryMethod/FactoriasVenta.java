/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethod;

import java.util.ArrayList;
import pieza.Pieza;
import trabajopatronessoftware.*;
/**
 *
 * @author nano
 */
public class FactoriasVenta {
    
    private Cliente cliente;

    public FactoriasVenta(Cliente c) {
        cliente=c;
    }
    
    
    
    public Venta getVenta(boolean ficheroTicket, ArrayList<Pieza> piezas){
        
        if (ficheroTicket){ //SI NO QUIERE TICKET
            DatosVenta datosVenta= new DatosVenta(piezas);
            if(cliente.tieneCuentaPremium()){
                datosVenta.setVentaCuentaPremium(true);
                datosVenta.getPrecioVenta(true);
            }
            else{
                datosVenta.setVentaCuentaPremium(false);
                datosVenta.getPrecioVenta(false);
            }
            return (datosVenta);
            
            
        }
        else{
            TicketVenta ticket = new TicketVenta(piezas);
            ticket.escribirFicheroTicket(piezas,cliente.getNumeroTickets(),cliente.tieneCuentaPremium());
            
            DatosVenta datosVenta= new DatosVenta(piezas);
            if(cliente.tieneCuentaPremium()){
                datosVenta.setVentaCuentaPremium(true);
                datosVenta.getPrecioVenta(true);
            }
            else{
                 datosVenta.setVentaCuentaPremium(false);
                datosVenta.getPrecioVenta(false);
            }
            return (datosVenta);
        }
    }
    
    
}
