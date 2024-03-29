/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.GUI;
import deepspace.SpaceStationToUI;
import controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author shao
 */
public class StationView extends javax.swing.JPanel {
    
    private WeaponListView weaponListView;
    private ShieldBoosterListView shieldBoosterListView;
    private DamageView damageView;
    private HangarView hangarView;
    
    /**
     * Creates new form StationView
     */
    StationView() {
        initComponents();
        
        damageView = new DamageView();
        jpPendingDamage.add(damageView);
        
        weaponListView = new WeaponListView();
        jpWeapon.add(weaponListView);
        
        shieldBoosterListView = new ShieldBoosterListView();
        jpShield.add(shieldBoosterListView);
        
        hangarView = new HangarView();
        jpHangar.add(hangarView);
        
        repaint();
        revalidate();
    }
    
    void setStation(SpaceStationToUI station) {
        // General information.
        
        jlName.setText(station.getName());
        jlPower.setText(Float.toString(station.getAmmoPower()));
        jlShieldPower.setText(Float.toString(station.getShieldPower()));
        jlFuelUnits.setText(Float.toString(station.getFuelUnits()));
        jlMedals.setText(Integer.toString(station.getnMedals()));
        
        // Pending Damage
                
        if (station.getPendingDamage() != null)
            damageView.setDamage(station.getPendingDamage());
        else
            damageView.clearDamage();
        
        // Weapons
        
        weaponListView.clearView();
        weaponListView.setWeapons(station.getWeapons());
        
        // ShieldBooster
        
        shieldBoosterListView.clearView();
        shieldBoosterListView.setShieldBoosters(station.getShieldBoosters());
        
        // Hangar
        
        if (station.getHangar() != null)
            hangarView.setHangar(station.getHangar());
        else
            hangarView.clearView();
        
        repaint();
        revalidate();
    }
    
    private ArrayList<Integer> getSelectedWeapons() {
        return weaponListView.getSelectedWeapons();
    }
    
    private ArrayList<Integer> getSelectedShields() {
        return shieldBoosterListView.getSelectedShields();
    }
    
    private ArrayList<Integer> getSelectedWeaponsInHangar() {
        return hangarView.getSelectedWeapons();
    }
    
    private ArrayList<Integer> getSelectedShieldsInHangar() {
        return hangarView.getSelectedShields();
    }
    
    public void updateView() {
        this.setStation(Controller.getInstance().getUIversion().getCurrentStation());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlShieldPower = new javax.swing.JLabel();
        jlPower = new javax.swing.JLabel();
        jlFuelUnits = new javax.swing.JLabel();
        jlMedals = new javax.swing.JLabel();
        jpPendingDamage = new javax.swing.JPanel();
        jbDiscard = new javax.swing.JButton();
        jbEquip = new javax.swing.JButton();
        jbDiscardHangar = new javax.swing.JButton();
        jpHangar = new javax.swing.JPanel();
        jpWeapon = new javax.swing.JPanel();
        jpShield = new javax.swing.JPanel();

        jlName.setBackground(new java.awt.Color(255, 255, 255));
        jlName.setFont(new java.awt.Font("Ubuntu", 0, 21)); // NOI18N
        jlName.setForeground(new java.awt.Color(0, 102, 0));
        jlName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlName.setText("Nombre de estación");

        jLabel2.setText("Potencia de Ataque:");

        jLabel3.setText("Nivel de Combustible:");

        jLabel4.setText("Potencia de Defensa: ");

        jLabel5.setText("Medallas:");

        jlShieldPower.setText("0,00");

        jlPower.setText("0,00");

        jlFuelUnits.setText("0,00");

        jlMedals.setText("0");

        jpPendingDamage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Castigo Pendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 17), new java.awt.Color(102, 0, 0))); // NOI18N
        jpPendingDamage.setForeground(new java.awt.Color(102, 0, 0));
        jpPendingDamage.setName(""); // NOI18N

        jbDiscard.setText("Descartar");
        jbDiscard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbDiscardMouseClicked(evt);
            }
        });
        jbDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDiscardActionPerformed(evt);
            }
        });

        jbEquip.setText("Equipar");
        jbEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEquipMouseClicked(evt);
            }
        });
        jbEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEquipActionPerformed(evt);
            }
        });

        jbDiscardHangar.setText("Descartar Hangar");
        jbDiscardHangar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbDiscardHangarMouseClicked(evt);
            }
        });

        jpHangar.setBorder(javax.swing.BorderFactory.createTitledBorder("Hangar"));

        jpWeapon.setBorder(javax.swing.BorderFactory.createTitledBorder("Potenciadores de Fuego"));

        jpShield.setBorder(javax.swing.BorderFactory.createTitledBorder("Potenciadores de Defensa"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlShieldPower, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlFuelUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMedals, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlPower, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(210, 210, 210))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpWeapon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpShield, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbEquip)
                        .addGap(18, 18, 18)
                        .addComponent(jbDiscard)
                        .addGap(50, 50, 50)
                        .addComponent(jbDiscardHangar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jpPendingDamage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpHangar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPower)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlShieldPower)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jlFuelUnits))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jlMedals)))
                    .addComponent(jpPendingDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jpShield, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpWeapon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpHangar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEquip)
                    .addComponent(jbDiscard)
                    .addComponent(jbDiscardHangar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEquipActionPerformed

    private void jbDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDiscardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbDiscardActionPerformed

    private void jbEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEquipMouseClicked
        Controller.getInstance().mount(this.getSelectedWeaponsInHangar(), this.getSelectedShieldsInHangar());
        updateView();
    }//GEN-LAST:event_jbEquipMouseClicked

    private void jbDiscardHangarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbDiscardHangarMouseClicked
        Controller.getInstance().discardHangar();
        updateView();
    }//GEN-LAST:event_jbDiscardHangarMouseClicked

    private void jbDiscardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbDiscardMouseClicked
        Controller.getInstance().discard(Controller.WEAPON, this.getSelectedWeapons(), this.getSelectedShields());
        Controller.getInstance().discard(Controller.SHIELD, this.getSelectedWeapons(), this.getSelectedShields());
        Controller.getInstance().discard(Controller.HANGAR, this.getSelectedWeaponsInHangar(), this.getSelectedShieldsInHangar());
        updateView();
    }//GEN-LAST:event_jbDiscardMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbDiscard;
    private javax.swing.JButton jbDiscardHangar;
    private javax.swing.JButton jbEquip;
    private javax.swing.JLabel jlFuelUnits;
    private javax.swing.JLabel jlMedals;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlPower;
    private javax.swing.JLabel jlShieldPower;
    private javax.swing.JPanel jpHangar;
    private javax.swing.JPanel jpPendingDamage;
    private javax.swing.JPanel jpShield;
    private javax.swing.JPanel jpWeapon;
    // End of variables declaration//GEN-END:variables
}
