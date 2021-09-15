/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopatronessoftware;

import bridge.PiezasReferencia;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import pieza.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author nano
 */
public class ListaPiezas extends javax.swing.JFrame {

    private Usuario usuario;

    private DefaultTableModel modeloTabla;
    private String tipoVehiculoBusqueda = "all";

    private String marca = "";
    private String modelo = "";
    private int año = -1;
    private int posicionElegidaTabla;

    private DatosPrograma datos;

    private PiezasReferencia piezas;
    private ArrayList<Pieza> datosTabla = new ArrayList<Pieza>();
    private ArrayList<String> arrayMarcas, arrayModelos;
    private ArrayList<Integer> arrayAños;

    /**
     * Creates new form ListaPiezas
     */
    public ListaPiezas() {
        initComponents();

    }

    public ListaPiezas(DatosPrograma d, Usuario u) {
        initComponents();
        datos = d;
        usuario = u;
        this.setTitle("Lista de piezas disponibles");
        piezas = new PiezasReferencia(d);
        //modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla = (DefaultTableModel) jTable1.getModel();

        rellenaTabla("", "", -1);
        rellenarArraysBusqueda();

        if (usuario.isEsAdministrador()) {
            jButton1.setText("Añadir Pieza");
            jButton2.setText("Eliminar Pieza");
        }
        else{
            jButtonModificarPieza.setVisible(false);
        }

    }

    //Funcion que rellena los array de busqueda para poder elegir los parametros de filtrado en los JComboBox
    public void rellenarArraysBusqueda() {
        //Instanciamos los arrayList
        arrayAños = new ArrayList<Integer>();
        arrayModelos = new ArrayList<String>();
        arrayMarcas = new ArrayList<String>();

        //Primero se llenan los array con las marcas modelos y años que aparecen en la tabla
        for (int i = 0; i < datosTabla.size(); i++) {
            if (!arrayAños.contains((datosTabla.get(i).getAño()))) {
                arrayAños.add((datosTabla.get(i).getAño()));
            }
            if (!arrayMarcas.contains(datosTabla.get(i).getMarca())) {
                arrayMarcas.add(datosTabla.get(i).getMarca());
            }
            if (!arrayModelos.contains(datosTabla.get(i).getModelo())) {
                arrayModelos.add(datosTabla.get(i).getModelo());
            }
        }
        //Con los array llenos, llenamos los comboBox con las opciones correspondientes
        jComboBoxAño.removeAllItems();  //Los vaciamos primero por si habia datos anteriores en el ComboBox
        jComboBoxAño.addItem("");
        for (int i = 0; i < arrayAños.size(); i++) {
            jComboBoxAño.addItem(String.valueOf(arrayAños.get(i)));
        }

        jComboBoxMarca.removeAllItems();
        jComboBoxMarca.addItem("");
        for (int i = 0; i < arrayMarcas.size(); i++) {
            jComboBoxMarca.addItem(arrayMarcas.get(i));
        }

        jComboBoxModelo.removeAllItems();
        jComboBoxModelo.addItem("");
        for (int i = 0; i < arrayModelos.size(); i++) {
            jComboBoxModelo.addItem(String.valueOf(arrayModelos.get(i)));
        }
        
        
    }

    //Metodo que actualiza la tabla y los ComboBox con respecto a las opciones de filtrado especificadas
    public void rellenaTabla(String marc, String mod, int year) {

        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);

        }
        datosTabla = piezas.piezasBusqueda(marca, modelo, año);

        for (int i = 0; i < datosTabla.size(); i++) {

            modeloTabla.addRow(new Object[]{datosTabla.get(i).getNombre(),
                datosTabla.get(i).getMarca(),
                datosTabla.get(i).getModelo(),
                String.valueOf(datosTabla.get(i).getAño()),
                datosTabla.get(i).getEstado(),
                Float.toString(datosTabla.get(i).getPrecio())});
        }
        
        

    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jRadioButtonTurismo = new javax.swing.JRadioButton();
        jRadioButtonMoto = new javax.swing.JRadioButton();
        jRadioButtonFurgoneta = new javax.swing.JRadioButton();
        jRadioButtonCamion = new javax.swing.JRadioButton();
        jRadioButtonTodo = new javax.swing.JRadioButton();
        jComboBoxAño = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonModificarPieza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pieza", "Marca", "Modelo", "Año", "Estado", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });

        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTurismo);
        jRadioButtonTurismo.setText("Turismo");
        jRadioButtonTurismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTurismoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMoto);
        jRadioButtonMoto.setText("Motocicleta");
        jRadioButtonMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMotoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonFurgoneta);
        jRadioButtonFurgoneta.setText("Furgoneta");
        jRadioButtonFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFurgonetaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonCamion);
        jRadioButtonCamion.setText("Camion");
        jRadioButtonCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCamionActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTodo);
        jRadioButtonTodo.setSelected(true);
        jRadioButtonTodo.setText("Todos");
        jRadioButtonTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTodoActionPerformed(evt);
            }
        });

        jComboBoxAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAñoActionPerformed(evt);
            }
        });

        jLabel1.setText("Marca");

        jLabel2.setText("Modelo");

        jLabel3.setText("Año");

        jButton1.setText("Añadir al Carrito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Abrir Carrito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonModificarPieza.setText("Modificar Pieza");
        jButtonModificarPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarPiezaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonTurismo)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonMoto)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonFurgoneta)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel2)
                                        .addGap(85, 85, 85))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonModificarPieza)
                                        .addGap(64, 64, 64)
                                        .addComponent(jButton1)
                                        .addGap(39, 39, 39)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3))
                            .addComponent(jRadioButtonCamion)
                            .addComponent(jComboBoxAño, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jRadioButtonTodo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jRadioButtonTodo)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTurismo)
                    .addComponent(jRadioButtonMoto)
                    .addComponent(jRadioButtonFurgoneta)
                    .addComponent(jRadioButtonCamion))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButtonModificarPieza))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonTurismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTurismoActionPerformed
        // TODO add your handling code here:
        piezas.setImplementadorTurismo();
        marca = "";
        modelo = "";
        año = -1;
        rellenaTabla("", "", -1);
        rellenarArraysBusqueda();
    }//GEN-LAST:event_jRadioButtonTurismoActionPerformed

    private void jRadioButtonMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMotoActionPerformed
        // TODO add your handling code here:
        piezas.setImplementadorMoto();
        marca = "";
        modelo = "";
        año = -1;
        rellenaTabla("", "", -1);
        rellenarArraysBusqueda();
    }//GEN-LAST:event_jRadioButtonMotoActionPerformed

    private void jRadioButtonTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTodoActionPerformed
        // TODO add your handling code here:
        piezas.setImplementadorTodosVehiculos();
        marca = "";
        modelo = "";
        año = -1;
        rellenaTabla("", "", -1);
        rellenarArraysBusqueda();
    }//GEN-LAST:event_jRadioButtonTodoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (usuario.isEsAdministrador()) {
            //AÑADIR PIEZA
            AñadirPieza añadirPieza = new AñadirPieza((Administrador) usuario, datos);
            añadirPieza.setVisible(true);
            dispose();
        } else {
            //AÑADIR AL CARRITO
            int posicionPiezas[] = jTable1.getSelectedRows();
            if (posicionPiezas.length > 0) {
                for (int i = 0; i < posicionPiezas.length; i++) {
                    Cliente user = (Cliente) usuario;
                    if (!user.contienePiezaCarrito(datosTabla.get(posicionPiezas[i]))) {
                        user.añadirPiezaCarrito(datosTabla.get(posicionPiezas[i]));

                        if (i == posicionPiezas.length - 1 && posicionPiezas.length == 1) {
                            JOptionPane.showMessageDialog(this, "Pieza añadida satisfactoriamente", "Añadir pieza al carrito", JOptionPane.INFORMATION_MESSAGE);
                        } else if (i == posicionPiezas.length - 1 && posicionPiezas.length > 1) {
                            JOptionPane.showMessageDialog(this, "Piezas añadidas satisfactoriamente", "Añadir piezas al carrito", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
            } else {
                //No hay piezas seleccionadas para añadir al carrito
                JOptionPane.showMessageDialog(this, "Ninguna pieza ha sido seleccionada para ser añadida al carrito", "Error al añadir al carrito", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButtonFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFurgonetaActionPerformed
        // TODO add your handling code here:
        piezas.setImplementadorFurgoneta();
        rellenaTabla("", "", -1);
        rellenarArraysBusqueda();
    }//GEN-LAST:event_jRadioButtonFurgonetaActionPerformed

    private void jRadioButtonCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCamionActionPerformed
        // TODO add your handling code here:
        piezas.setImplementadorCamion();
        rellenaTabla("", "", -1);
        rellenarArraysBusqueda();
    }//GEN-LAST:event_jRadioButtonCamionActionPerformed

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
        // TODO add your handling code here:
        if (jComboBoxMarca.getSelectedIndex() > 0) {
            marca = (String) (jComboBoxMarca.getSelectedItem());
        } else {
            marca = "";
        }
        rellenaTabla(marca, modelo, año);

    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        int indice = jComboBoxModelo.getSelectedIndex() - 1;
        if (jComboBoxModelo.getSelectedIndex() > 0) {
            //  modelo = (String)(jComboBoxMarca.getSelectedItem());
            modelo = arrayModelos.get(indice);
        } else {
            modelo = "";
        }
        rellenaTabla(marca, modelo, año);
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void jComboBoxAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAñoActionPerformed

        int indice = jComboBoxAño.getSelectedIndex() - 1;
        if (jComboBoxAño.getSelectedIndex() > 0) {
            año = arrayAños.get(indice);
        } else {
            año = -1;
        }
        rellenaTabla(marca, modelo, año);

    }//GEN-LAST:event_jComboBoxAñoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        posicionElegidaTabla = jTable1.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        posicionElegidaTabla = jTable1.getSelectedRow();

    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (usuario.isEsAdministrador()) {
            try {
                int piezasSeleccionadas []=jTable1.getSelectedRows();
                if (piezasSeleccionadas.length > 1 || piezasSeleccionadas.length<1){
                    JOptionPane.showMessageDialog(this, "Para realizar el borrado de pieza debe seleccionar una sola pieza", "Borrado de pieza", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                int posicionTabla = jTable1.getSelectedRow();
                Pieza p = datosTabla.get(posicionTabla);
                int decisionBorrado = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere eliminar la siguiente pieza del sistema?" + "\n        Pieza: " + p.getNombre() + "\n        Marca: " + p.getMarca() + "\n        Modelo: " + p.getModelo() + "\n        Año: " + p.getAño() + "\n        Precio: " + p.getPrecio(), "Eliminacion Pieza", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
                if (decisionBorrado == JOptionPane.YES_OPTION) {
                    //BORRAMOS LA PIEZA
                    datos.eliminarPieza(p);
                    JOptionPane.showMessageDialog(this, "La pieza  ha sido eliminada satisfactoriamente", "Borrado de pieza", JOptionPane.INFORMATION_MESSAGE);
                    rellenaTabla(marca, modelo, año);
                } else if (decisionBorrado == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(this, "Borrado de pieza cancelado", "Borrado de pieza", JOptionPane.INFORMATION_MESSAGE);
                }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ningun indice seleccionado", "Borrado de pieza", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            CarritoCompra carritoCompra = new CarritoCompra((Cliente) usuario, datos);
            carritoCompra.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonModificarPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarPiezaActionPerformed
        // TODO add your handling code here:
        int piezasSeleccionadas []=jTable1.getSelectedRows();
        if (piezasSeleccionadas.length <1 || piezasSeleccionadas.length >1){
            JOptionPane.showMessageDialog(this, "Seleccione una unica pieza a modificar", "Modificado de pieza", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Pieza p = datosTabla.get(piezasSeleccionadas[0]);
            ModificarPieza modPieza = new ModificarPieza(p, this);
            modPieza.setVisible(true);
            /*
            
            datosTabla.remove(p);
            datos.eliminarPieza(p);*/
        }
    }//GEN-LAST:event_jButtonModificarPiezaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaPiezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaPiezas().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonModificarPieza;
    private javax.swing.JComboBox<String> jComboBoxAño;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCamion;
    private javax.swing.JRadioButton jRadioButtonFurgoneta;
    private javax.swing.JRadioButton jRadioButtonMoto;
    private javax.swing.JRadioButton jRadioButtonTodo;
    private javax.swing.JRadioButton jRadioButtonTurismo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
