/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabajopatronessoftware;

import bridge.PiezasReferencia;
import java.util.ArrayList;
import java.util.StringTokenizer;
import memento.Originador;
import memento.Recuerdo;
import pieza.*;

/**
 *
 * @author nano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  /***        String sTexto = "En un lugar de la mancha de cuyo nombre no quiero acordarme";
StringTokenizer frase = new StringTokenizer(sTexto);

while (frase.hasMoreTokens()) {
 System.out.println(frase.nextToken());
}
    }***/
      
    DatosPrograma datos = new DatosPrograma();
        datos.instanciarListaPiezas();
        datos.instanciarUsuariosVentas();
        
    Loggin loggin = new Loggin(datos);
    loggin.setVisible(true);
    }
    
}
