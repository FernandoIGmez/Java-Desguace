/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import pieza.PiezaCamion;
import pieza.PiezaFurgoneta;

/**
 *
 * @author nano
 */
public class PiezaBuilderFurgoneta extends PiezaBuilder{

    public PiezaBuilderFurgoneta() {
    }
    
    @Override
    public void crearNuevaPieza() {
        setPieza(new PiezaFurgoneta());
    }
    
}
