/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopatronessoftware;
import factoryMethod.DatosVenta;
import java.io.Serializable;
import pieza.*;
import java.util.ArrayList;
import java.util.Collections;
import factoryMethod.*;

/**
 *
 * @author nano
 */
public class DatosPrograma implements Serializable{
    
    private ArrayList<Usuario> listaUsuarios= new ArrayList<Usuario>();
    private ArrayList<Pieza> listaPiezas= new ArrayList<Pieza>();

    
    public DatosPrograma (){
        Administrador admin = new Administrador();
        listaUsuarios.add(admin);
        instanciarListaPiezas();
        Collections.shuffle(listaPiezas);
    }
    
    ///////FUNCIONES USUARIOS//////////////////
    ///////////////////////////////////////////
    
    public void añadirUsuario (Usuario u){
        listaUsuarios.add(u);
    }
    
    
    public void eliminarUsuario (Usuario u){
            listaUsuarios.remove(u);      
    }
    
    public int tamañoListaUsuarios(){
        return listaUsuarios.size();
    }

    public Usuario getUsuarioPosicion(int pos){
        return listaUsuarios.get(pos);
    }
    
    public void mostrarTamañoUsuarios(){
        System.out.println("USUARIOS : " +listaUsuarios.size());
    }
    
    public void mostrarUsuarios (){ //PARA PRUEBAS DE REGISTRO
        if(listaUsuarios.size()>0){
        for (int i=0; i< listaUsuarios.size(); i++){
            listaUsuarios.get(i).mostrarInfo();
        }}
        else{
                System.out.println("NO HAY USUARIOS");
                        
                        
                }
    }
    
 
    
    public int existeUsuarioDNI(String dni){ //DEVUELVE LA POSICION EN LA QUE SE ENCUENTRA SI EL DNI CORRESPONDE A UN USUARIO REGISTRADO
        for (int i=0; i< listaUsuarios.size(); i++){
            if (listaUsuarios.get(i).getDni().equals(dni))return i;
        }
        return -1; // DEVUELVE -1 SI NO LO ENCUENTRA
    }    
    
    public int existeUsuarioCorreo(String correo){ //DEVUELVE LA POSICION EN LA QUE SE ENCUENTRA SI EL CORREO CORRESPONDE A UN USUARIO REGISTRADO
        for (int i=0; i< listaUsuarios.size(); i++){
            if (listaUsuarios.get(i).getCorreo().equals(correo))return i;
        }
        return -1; // DEVUELVE -1 SI NO LO ENCUENTRA
    }
    
    public Usuario getUsuarioPorDNI(String dni){
        for (int i=0; i< listaUsuarios.size();i++){
            if (listaUsuarios.get(i).getDni().equals(dni)){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }
    
    public Usuario getUsuarioPorCorreo(String correo){
        for (int i=0; i< listaUsuarios.size();i++){
            if (listaUsuarios.get(i).getCorreo().equals(correo)){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }
    
    //DEVUELVE EL DNI DE LA POSICION DE UN USUARIO CONCRETO
    public String getDNIUsuario(int posicionLista){
        if (posicionLista>=0){
            return listaUsuarios.get(posicionLista).getDni();
        }
        return "";
    }
    
    public String getNombreUsuario(int posicionLista){
        if (posicionLista>=0){
            return listaUsuarios.get(posicionLista).getNombre();
        }
        return "";
    }
    
     //AUTENTICA QUE EL USUARIO HA ELEGIDO EL PAR DNI/CORREO + CONTRASEÑA CORRECTO
    public boolean comprobarClienteDNI(String dni, String contraseña){
        int posicionUsuario = existeUsuarioDNI(dni);
        if (posicionUsuario != -1 ){
            String contraseñaUsuario = listaUsuarios.get(posicionUsuario).getClave();
            if (contraseñaUsuario.equals(contraseña)){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
   
    public boolean comprobarClienteCorreo(String dni, String contraseña){
        int posicionUsuario = existeUsuarioCorreo(dni);
        if (posicionUsuario != -1 ){
            String contraseñaUsuario = listaUsuarios.get(posicionUsuario).getClave();
            if (contraseñaUsuario.equals(contraseña)){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    //FUNCIONES PIEZAS/////////////////////////
    ///////////////////////////////////////////
    
    public ArrayList<Pieza> getListaPiezas (){
        return listaPiezas;
    }

    public void añadirPieza(Pieza p) {
        listaPiezas.add(p);
    }
    public void eliminarPieza (Pieza p){
        listaPiezas.remove(p);             
    }
    public ArrayList<Pieza> devolverPiezasTipoVehiculo(String tipoVehiculo){
        ArrayList<Pieza> arrayAuxiliar= new ArrayList<Pieza>();
        for (int i=0 ; i< listaPiezas.size(); i++){
                    if (listaPiezas.get(i).getTipoVehiculo().equals(tipoVehiculo)){
                        arrayAuxiliar.add(listaPiezas.get(i));
                    }
                }
        
       return arrayAuxiliar;
     
    }
    
    public int tamañoListaPiezas(){
        return listaPiezas.size();
    }
    
    
    
    public void instanciarListaPiezas(){
        PiezaMoto m= new PiezaMoto("Tubo de escape", "Chopper", "Harrold", "Nuevo", 1999, (123.2f));
        PiezaMoto m1= new PiezaMoto("Parachoques", "Chopper", "Holmes", "Nuevo", 1999, (12.22f));
        PiezaMoto m2= new PiezaMoto("Motor", "Chopper", "Harrold", "Desgastado", 1999, (20.2f));
        PiezaMoto m3= new PiezaMoto("Frenos", "Chopper", "Cruce", "Usado", 1999, (60.2f));
        PiezaMoto m4= new PiezaMoto("Rueda", "Chopper", "Sly", "Nuevo", 1999, (43.2f));
        PiezaMoto m5= new PiezaMoto("Neumatico", "Chopper", "Recomm", "Nuevo", 1999, (60.2f));
        PiezaMoto m6= new PiezaMoto("Tubo de escape", "Chopper", "Star", "Nuevo", 1999, (1.2f));
        listaPiezas.add(m);
        listaPiezas.add(m1);
        listaPiezas.add(m2);
        listaPiezas.add(m3);
        listaPiezas.add(m4);
        listaPiezas.add(m5);
        listaPiezas.add(m6);
        PiezaTurismo p= new PiezaTurismo("Motor", "Ford", "Fiesta", "Nuevo", 1998, (200.0f));
        PiezaTurismo p1= new PiezaTurismo("Motor", "Ford", "Fiesta", "Nuevo", 1999, (200.0f));
        PiezaTurismo p2= new PiezaTurismo("Capo", "Ford", "Focus", "Seminuevo en perfecto estado", 1998, (200.0f));
        PiezaTurismo p3= new PiezaTurismo("Puerta Delantera Piloto", "Scoda", "Octavia", "Nuevo", 2018, (200.0f));
        PiezaTurismo p4= new PiezaTurismo("Motor", "Ford", "Focus", "Nuevo", 2007, (200.0f));
        PiezaTurismo p5= new PiezaTurismo("Asiento", "Ford", "Kuga", "Como Nuevo", 2004, (200.0f));
        listaPiezas.add(p);
        listaPiezas.add(p1);
        listaPiezas.add(p2);
        listaPiezas.add(p3);
        listaPiezas.add(p4);
        listaPiezas.add(p5);
        PiezaCamion c= new PiezaCamion("Tubo de escape","Pegaso","Troner", "Como nuevo", 2005, 30.99f);
        PiezaCamion c1= new PiezaCamion("Motor","Pegaso","Troner", "Seminuevo 300.000 kms", 2005, 100.99f);
        PiezaCamion c2= new PiezaCamion("Asiento Piloto","Pegaso","Troner", "Algo desgastado", 2005, 77.99f);
        PiezaCamion c3= new PiezaCamion("Palanca de cambios","Iveco","Eurostar", "Como nueva", 2010, 40.99f);
        PiezaCamion c4= new PiezaCamion("Caja de dirección","Iveco","Massif", "Como nuevo", 2004, 250.99f);
        PiezaCamion c5= new PiezaCamion("Manguitos","Iveco","Troner", "Como nuevo", 2010, 30.99f);
        listaPiezas.add(c);
        listaPiezas.add(c1);
        listaPiezas.add(c2);
        listaPiezas.add(c3);
        listaPiezas.add(c4);
        listaPiezas.add(c5);
        PiezaFurgoneta f = new PiezaFurgoneta("Capó", "Mercedes", "Marco Polo", "Como nuevo", 2000, 100.0f);
        PiezaFurgoneta f1 = new PiezaFurgoneta("LLantas", "Citroen", "Berlingo", "Como nuevo", 2010, 120.50f);
        PiezaFurgoneta f2 = new PiezaFurgoneta("Asientos delanteros", "Citroen", "Berlingo", "Como nuevo", 2000, 200.99f);
        PiezaFurgoneta f3 = new PiezaFurgoneta("Motor", "Dacia", "Dokker", "Seminuevo 250.000 kms", 2015, 299.99f);
        PiezaFurgoneta f4 = new PiezaFurgoneta("Cinturón", "Mercedes", "Citan Tourer", "Como nuevo", 2013, 25.0f);
        PiezaFurgoneta f5 = new PiezaFurgoneta("Tubo de escape", "Nissan", "Evalia", "Como nuevo", 2000, 77.0f);
        listaPiezas.add(f);
        listaPiezas.add(f1);
        listaPiezas.add(f2);
        listaPiezas.add(f3);
        listaPiezas.add(f4);
        listaPiezas.add(f5);
    }
    
    public void instanciarUsuariosVentas(){
        FactoriasVenta fV ;
        Cliente cliente1 = new Cliente("03200666X", "Correo@correo.com", "1234", "Fernando", 696969696);
        Cliente cliente2 = new Cliente("03220649Z", "criss@gmail.com", "0000", "Cristina", 65628539);
        Cliente cliente3 = new Cliente("03243924X", "alonso@correo.com", "AdZ213", "Alonso", 703628198);
        Cliente cliente4 = new Cliente("03218245D", "manole@hotmail.com", "ZZl99", "Manolo", 723402113);
        Cliente cliente5 = new Cliente("03224609Z", "christian@gmail.com", "rtAS2", "Christian", 675482934);
        Cliente cliente6 = new Cliente("01234213A", "felipe@hotmail.com", "1234099", "Felipe", 713124583);

        ArrayList <Pieza> a1 = new ArrayList<>();
        a1.add(new PiezaTurismo("Tubo de escape", "Ford", "Focus", "Bueno", 1999, 19.99f));
        a1.add(new PiezaTurismo("Capó", "Ford", "Focus", "Como nuevo", 1999, 150.00f));
        a1.add(new PiezaTurismo("Reposa cabezas delantero", "Ford", "Focus", "Bueno", 1999, 44.99f));
        
        fV= new FactoriasVenta(cliente1);
        cliente1.añadirVenta(fV.getVenta(false, a1));
        
        ArrayList <Pieza> a3 = new ArrayList<>();
        a3.add(new PiezaTurismo("Palanca de Cambios", "Ford", "Focus", "Algo desgastada", 1999, 40.0f));
        a3.add(new PiezaTurismo("Luces traseras", "Ford", "Focus", "Como nuevo", 1999, 22.00f));
        a3.add(new PiezaTurismo("Retrovisor central", "Ford", "Focus", "En perfecto estado", 1999, 33.99f));
        
        
        cliente1.añadirVenta(fV.getVenta(false, a3));
        
        ArrayList <Pieza> a2 = new ArrayList<>();
        a2.add(new PiezaTurismo("Tubo de escape", "Ford", "Fiesta", "Bueno", 2005, 19.99f));
        a2.add(new PiezaTurismo("Capó", "Ford", "Fiesta", "Como nuevo", 2005, 150.00f));
        a2.add(new PiezaTurismo("Reposa cabezas delantero", "Ford", "Fiesta", "Bueno", 2005, 44.99f));
        
        fV= new FactoriasVenta(cliente2);
        cliente2.añadirVenta(fV.getVenta(false, a2));
        
        listaUsuarios.add(cliente1);
        listaUsuarios.add(cliente2);
        listaUsuarios.add(cliente3);
        listaUsuarios.add(cliente4);
        listaUsuarios.add(cliente5);
        listaUsuarios.add(cliente6);
        
    }
    
    public void mostrarDatosPiezas(){
        for(int i=0;i<listaPiezas.size();i++){
            System.out.println("Bucle -"+i+"-");
            System.out.println("\t Nombre :"+listaPiezas.get(i).getNombre());
            System.out.println("\t Marca :"+listaPiezas.get(i).getMarca());
            System.out.println("\t Modelo :"+listaPiezas.get(i).getModelo());
            System.out.println("\t Año :"+listaPiezas.get(i).getAño());
            System.out.println("\t Estado :"+listaPiezas.get(i).getEstado());
            System.out.println("\t TipoveH :"+listaPiezas.get(i).getTipoVehiculo());
        }
    }
    
    public void restaurarUsuarios(){
        
    }
    
    public void restaurarPiezas(){
        
    }
}
