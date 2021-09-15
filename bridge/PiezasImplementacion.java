/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;
import java.util.ArrayList;
import trabajopatronessoftware.DatosPrograma;
import pieza.*;

/**
 *
 * @author nano
 */
public abstract class PiezasImplementacion {
    DatosPrograma datos;
    ArrayList<Pieza> piezasTemporales;
    
    public abstract ArrayList<Pieza> getPiezas();
    public ArrayList<Pieza> getPiezasFabricanteModeloAño(String fabricante, String modelo, int año){         
        ArrayList<Pieza> piezasAux = new ArrayList<Pieza>();
        getPiezas();
        System.out.println("COMIENZA LA BUSQUEDA DE PIEZAS, TAMAÑO DEL ARRAY EN EL QUE SE BUSCA->>"+piezasTemporales.size());
        for (int i = 0; i < piezasTemporales.size(); i++) {
            System.out.println("Bucle -"+i+"-");
            if (fabricante.equals("")) { 
                if (modelo.equals("")) {
                    if (año == -1) {
                        //NINGUNA OPCION SELECCIONADA
                        return piezasTemporales;
                    }
                    else {   
                        ///SELECCIONAMOS UNICAMENTE LA OPCION DE AÑO
                        if (piezasTemporales.get(i).getAño() == (año)) {
                            piezasAux.add(piezasTemporales.get(i));
                        }
                        }    

                } else {   ////FABRICANTE SIN SELECCIONAR///
                    if (año == -1) {
                        ///Solo seleccionamos el modelo
                        if (piezasTemporales.get(i).getModelo().equals(modelo)) {
                            piezasAux.add(piezasTemporales.get(i));
                        }
                       
                    } else {
                        //Seleccionamos modelo y año
                        if (piezasTemporales.get(i).getAño()== año) {
                            if (piezasTemporales.get(i).getModelo().equals(modelo)) {
                                piezasAux.add(piezasTemporales.get(i));
                            }
                        }
                    }

                }

            }
            else{   ///SI HAY QUE BUSCAR POR FABRICANTE
                //*************************************
                if (modelo.equals("")) {
                    if (año == -1) {
                        //SIN MODELO NI AÑO
                        if (piezasTemporales.get(i).getMarca()== (fabricante)) {
                            piezasAux.add(piezasTemporales.get(i));
                        }
                    }
                    else {   
                        ///SELECCIONAMOS AÑO Y FABRICANTE
                        if (piezasTemporales.get(i).getAño() == (año)) {
                            if (piezasTemporales.get(i).getMarca()== (fabricante)) {
                            piezasAux.add(piezasTemporales.get(i));
                        }
                        }
                        }   

                } else {   
                    if (año == -1) {
                        ///SELECCIONAMOS MODELO Y FABRICANTE
                        if (piezasTemporales.get(i).getModelo().equals(modelo)) {
                           if (piezasTemporales.get(i).getMarca().equals(fabricante)) { piezasAux.add(piezasTemporales.get(i));}
                        }
                       
                    } else {
                        //SELECCIONAMOS AÑO MODELO Y FABRICANTE
                        if (piezasTemporales.get(i).getMarca().equals(fabricante)) {
                if (piezasTemporales.get(i).getModelo().equals(modelo)) {
                    if (piezasTemporales.get(i).getAño() == (año)) {
                        piezasAux.add(piezasTemporales.get(i));
                    }
                }
            }
                    }

                }
            }          
           
        }
        System.out.println("Tamaño del array de piezas buscadas -> "+piezasAux.size());
        return piezasAux;
    
    }

    public ArrayList<Pieza> getPiezasTemporales() {
        return piezasTemporales;
    }

    public void setPiezasTemporales(ArrayList<Pieza> piezasTemporales) {
        this.piezasTemporales = piezasTemporales;
    }

    public DatosPrograma getDatos() {
        return datos;
    }

    public void setDatos(DatosPrograma datos) {
        this.datos = datos;
    }
    
    

}
