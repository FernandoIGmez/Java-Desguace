/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopatronessoftware;

/**
 *
 * @author nano
 */
public abstract class Usuario {
    private String dni, correo, clave, nombre;
    private int numeroTelefono;
    private boolean esAdministrador;

    public Usuario(String dni, String correo, String clave, String nombre, int numeroTelefono) {
        this.dni = dni;
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }
    
    public Usuario(){
        
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    public void mostrarInfo(){
        System.out.println("USUARIO:");
        System.out.println("\tNombre: "+nombre);
        System.out.println("\tDNI: "+dni);
        System.out.println("\tCorreo: "+correo);
        System.out.println("\tNumero tfno: "+numeroTelefono);
        System.out.println("\tClave: "+clave); 
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
    
}
