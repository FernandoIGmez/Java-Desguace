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
public class PiezaMoto extends Pieza {

    public PiezaMoto() {
        setTipoVehiculo("Moto");
    }
  
    

    public PiezaMoto(String nombre , String marca, String modelo, String estado, int año, float precio){
       setNombre(nombre);
       setMarca(marca);
       setModelo(modelo);
       setEstado(estado);
       setAño(año);
       setPrecio(precio);
       setTipoVehiculo("Moto");
    }

    
}
