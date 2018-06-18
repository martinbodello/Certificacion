/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Categoria;
import entity.Competidor;
import entity.Disciplina;
import entity.Escuela;
import entity.Inscripcion;
import entity.InscripcionId;
import entity.Torneo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Expression.sql;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Martin
 */
public class inscripcion extends javax.swing.JFrame {

    /**
     * Creates new form inscripcion
     */
    
    public inscripcion() {
        initComponents();
        llenarListaEscuelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        escuelasList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        aspirantesList = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtCompetencias = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        categoriasList = new javax.swing.JList<>();
        btnCancelar = new javax.swing.JButton();
        btnGuadar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione una Entidad Educativa"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        escuelasList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                escuelasListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(escuelasList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aspirantes"));

        aspirantesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                aspirantesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(aspirantesList);

        btnNuevo.setText("Nuevo Aspirante");
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Competencias"));

        jtCompetencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(true), null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "", "Disciplina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCompetencias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtCompetencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCompetenciasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtCompetencias);
        if (jtCompetencias.getColumnModel().getColumnCount() > 0) {
            jtCompetencias.getColumnModel().getColumn(0).setPreferredWidth(60);
            jtCompetencias.getColumnModel().getColumn(1).setPreferredWidth(255);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias"));

        jScrollPane3.setViewportView(categoriasList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuadar.setText("Guardar");
        btnGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuadarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnGuadar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuadar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked

    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevoAspirante na = new nuevoAspirante(escuelasList.getSelectedValue());
        
        na.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void escuelasListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_escuelasListValueChanged

        Session sesion = null;
        sesion = NewHibernateUtil.getSessionFactory().openSession();

        Object e = escuelasList.getSelectedValue();
        Escuela es = (Escuela) e;
        String sql = "SELECT * FROM competidor WHERE idEscuela = " + es.getId();

        SQLQuery query = sesion.createSQLQuery(sql);
        query.addEntity(Competidor.class);
        List results = query.list();

        DefaultListModel modelo = new DefaultListModel();
        for (Object c : results){
            Competidor co = (Competidor) c;
            modelo.addElement(co);
        }

        aspirantesList.setModel(modelo);
        sesion.close();
    }//GEN-LAST:event_escuelasListValueChanged

    private void aspirantesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_aspirantesListValueChanged
        Session sesion = null;
        sesion = NewHibernateUtil.getSessionFactory().openSession();

        Object e = aspirantesList.getSelectedValue();
        Competidor competidor = (Competidor) e;
        String s = "" + competidor.getDni();

        String sql = "SELECT * FROM disciplina";
        SQLQuery query = sesion.createSQLQuery(sql);
        query.addEntity(Disciplina.class);
        List results = query.list();
        
        DefaultTableModel modelo = (DefaultTableModel) jtCompetencias.getModel();
        modelo.getDataVector().removeAllElements();

        for (Object c : results){
            Disciplina di = (Disciplina) c;
            modelo.addRow(new Object[]{false, di});
        }
        
        String sql1 = "SELECT d.* FROM disciplina d JOIN inscripcion i ON d.id=i.idDisciplina WHERE i.dniCompetidor = " + s;
        SQLQuery query1 = sesion.createSQLQuery(sql1);
        query1.addEntity(Disciplina.class);
        List results1 = query1.list();
        
        for (Object o : results1){
            Disciplina di  = (Disciplina) o;
            for (int j = 0; j < jtCompetencias.getModel().getRowCount(); j++) {
                Object o1 = jtCompetencias.getValueAt(j, 1);
                Disciplina di1 = (Disciplina) o1;
                
                if(di.getId()==di1.getId()){
                    jtCompetencias.setValueAt(true, j, 0);
                }
        }
        }
        
        
        sesion.close();
        
        categoriasList.clearSelection();
    }//GEN-LAST:event_aspirantesListValueChanged

    private void jtCompetenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCompetenciasMouseClicked
        //DefaultTableModel modelo = (DefaultTableModel)jtCompetencias.getModel();
        //int selectedRowIndex = jtCompetencias.getSelectedRow();
        
        Session sesion = null;
        sesion = NewHibernateUtil.getSessionFactory().openSession();

        String sql = "SELECT * FROM categoria";
        SQLQuery query = sesion.createSQLQuery(sql);
        query.addEntity(Categoria.class);
        List results = query.list();
             
        DefaultListModel modelo = new DefaultListModel();
        for (Object c : results){
            Categoria ca = (Categoria) c;
            modelo.addElement(ca);
        }

        categoriasList.setModel(modelo);
        categoriasList.setSelectedIndex(2);
        sesion.close();
    }//GEN-LAST:event_jtCompetenciasMouseClicked

    private void btnGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuadarActionPerformed
             
        for (int j = 0; j < jtCompetencias.getModel().getRowCount(); j++) {
                Boolean checked = (Boolean) jtCompetencias.getValueAt(j, 0);
                 
                if (checked){
                    Object o = categoriasList.getSelectedValue();
                    Categoria c = (Categoria) o;
                    
                    Object o1 = jtCompetencias.getValueAt(j, 1);                 
                    Disciplina d = (Disciplina) o1;                    
                    
                    Object o2 = aspirantesList.getSelectedValue();
                    Competidor co = (Competidor) o2;
                    
                    InscripcionId id = new InscripcionId(co.getDni(),d.getId(),c.getId());
                    
                    Inscripcion nuevaInscripcion = new Inscripcion();
                    nuevaInscripcion.setTorneo(new Torneo(1));
                    nuevaInscripcion.setCategoria(c);
                    nuevaInscripcion.setCompetidor(co);
                    nuevaInscripcion.setDisciplina(d);
                    nuevaInscripcion.setAprobada("N");
                    nuevaInscripcion.setId(id);
        
                    Session session = NewHibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
 
                    session.save(nuevaInscripcion); //<|--- Aqui guardamos el objeto en la base de datos.
 
                    session.getTransaction().commit();
                    session.close();   
                } 
        }
    }//GEN-LAST:event_btnGuadarActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inscripcion().setVisible(true);
            }
        });
    }
    
    public void llenarListaEscuelas () {
            Session sesion = null;
            
            try{    
                sesion = NewHibernateUtil.getSessionFactory().openSession();
                Criteria cri = sesion.createCriteria(Escuela.class);  
                List <Escuela> result = cri.list();     
                
                DefaultListModel modelo = new DefaultListModel();      
                for (Escuela e : result){
                    modelo.addElement(e);
                } 
                escuelasList.setModel(modelo);
                sesion.close();              
            }
            catch (Exception e){ 
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> aspirantesList;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuadar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JList<String> categoriasList;
    private javax.swing.JList<String> escuelasList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtCompetencias;
    // End of variables declaration//GEN-END:variables
}
