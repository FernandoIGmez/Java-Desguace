/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopatronessoftware;
import builder.*;
import pieza.*;
/**
 *
 * @author nano
 */
public class Administrador extends Usuario{

    private PiezaBuilder piezaBuilder;
    private PiezaBuilderCamion pBcamion = new PiezaBuilderCamion();
    private PiezaBuilderTurismo pBturismo = new PiezaBuilderTurismo();
    private PiezaBuilderMoto pBmoto = new PiezaBuilderMoto();
    private PiezaBuilderFurgoneta pBfurgoneta = new PiezaBuilderFurgoneta();
    
    public Administrador(String dni, String correo, String clave, String nombre, int numeroTelefono) {
        super(dni, correo, clave, nombre, numeroTelefono);
        setEsAdministrador(true);
        
    }
    
    public Administrador() {
        setDni("03200555Z");
        setNombre("Administrador");
        setCorreo("administrador@example.com");
        setClave("admin");
        setNumeroTelefono(600000000);
        setEsAdministrador(true);
        
    }
    
    public void setBuilderTurismo(){
        piezaBuilder=pBturismo;
    }
    
    public void setBuilderMoto(){
        piezaBuilder=pBmoto;
    }
    
    public void setBuilderFurgoneta(){
        piezaBuilder=pBfurgoneta;
    }
    
    public void setBuilderCamion(){
        piezaBuilder=pBcamion;
    }
    
    public void fabricarPieza(String nombre, String marca, String modelo, int año, String estado, float precio){
        piezaBuilder.crearNuevaPieza();
        piezaBuilder.ponerNombrePieza(nombre);
        piezaBuilder.ponerMarca(marca);
        piezaBuilder.ponerModelo(modelo);
        piezaBuilder.ponerPrecio(precio);
        piezaBuilder.ponerAño(año);
        piezaBuilder.ponerEstado(estado);
    }
    
    public Pieza getPiezaFabricada(){
        return piezaBuilder.getPieza();
    }
    
    
}
