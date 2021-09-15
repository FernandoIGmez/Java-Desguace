/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;
import pieza.*;
/**
 *
 * @author nano
 */
public abstract class PiezaBuilder {
    /**
     * Producto complejo a construir: Pizza.
     */
    protected Pieza pieza;

    /**
     * Devuelve el producto complejo que se construye.
     *
     * @return Producto Pizza.
     */
    public Pieza getPieza() {
        return pieza;
    }

    /**
     * Establece una pieza.
     */
    public void setPieza(Pieza p){
        pieza=p;
    }
    /**
     * Crea un nuevo producto del tipo complejo Pizza.
     */
    public abstract void crearNuevaPieza() ;

    /**
     * Establece el nombre de la pieza.
     */
    public  void ponerNombrePieza(String nombre){
        pieza.setNombre(nombre);
    }

    /**
     * Establece el precio de la pieza.
     */
    public  void ponerPrecio(Float precio){
        pieza.setPrecio(precio);
    }

    /**
     * Establece la marca de la pieza.
     */
    public void ponerMarca(String marca){
        pieza.setMarca(marca);
    }

    /**
     * Establece el modelo del tipo de coche de la pieza.
     */
    public void ponerModelo(String modelo){
        pieza.setModelo(modelo);
    }
    
    /**
     * Establece el año del modelo de vehiculo de la pieza.
     */
    public  void ponerAño(int año){
        pieza.setAño(año);
    }
    
    /**
     * Establece el estado en el que se encuentra la pieza.
     */
    public  void ponerEstado(String estado){
        pieza.setEstado(estado);
    }
}
