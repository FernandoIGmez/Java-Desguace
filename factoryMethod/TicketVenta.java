/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethod;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import pieza.*;

/**
 *
 * @author nano
 */
public class TicketVenta extends Venta{

    public TicketVenta(ArrayList <Pieza> venta) {
        setPiezasVenta(venta);
    }
    
    public void escribirFicheroTicket(ArrayList<Pieza> listaPiezas, int numeroTicketUsuario, boolean cuentaPremium){
    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            
            fichero = new FileWriter("c:/Users/nano/Documents/NetBeansProjects/TrabajoPatronesSoftware/Tickets/Ticket"+(numeroTicketUsuario+1)+".txt");
            pw = new PrintWriter(fichero);

          //  for (int i = 0; i < 10; i++)
          //      pw.println("Linea " + i);
          if (cuentaPremium){
              pw.println("-Articulos comprados mediante una cuenta premium. Se aplica un descuento del 5%-");
          }
          else{
              
          }
            for (int i=0; i<listaPiezas.size();i++){
                pw.println("Pieza "+(i+1)+":");
                pw.println("\tPieza: "+listaPiezas.get(i).getNombre());
                pw.println("\tMarca: "+listaPiezas.get(i).getMarca());
                pw.println("\tModelo: "+listaPiezas.get(i).getModelo());
                pw.println("\tAño de fabricación del modelo: "+listaPiezas.get(i).getAño());
                pw.println("\tPrecio: "+listaPiezas.get(i).getPrecio());
            }
          
            if (cuentaPremium){
                getPrecioVenta(true);
                pw.println("\nPrecio total de la compra con descuento: "+getPrecioVentaFinal());
            }
            else{
                getPrecioVenta(false);
                pw.println("\nPrecio total de la compra: "+getPrecioVentaFinal());
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }}
}
