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
public class PiezaBuilderCamion extends PiezaBuilder {

    public PiezaBuilderCamion() {
    }

    
    @Override
    public void crearNuevaPieza() {
        setPieza(new PiezaCamion());
    }
    
}
