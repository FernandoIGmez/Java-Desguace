/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieza;

/**
 *
 * @author nano
 */
public class PiezaCamion extends Pieza {
    
    
   public PiezaCamion(){
       setTipoVehiculo("Camion");
   }

   public PiezaCamion(String nombre , String marca, String modelo, String estado, int año, float precio){
       setNombre(nombre);
       setMarca(marca);
       setModelo(modelo);
       setEstado(estado);
       setAño(año);
       setPrecio(precio);
       setTipoVehiculo("Camion");
    }
    
    
}
