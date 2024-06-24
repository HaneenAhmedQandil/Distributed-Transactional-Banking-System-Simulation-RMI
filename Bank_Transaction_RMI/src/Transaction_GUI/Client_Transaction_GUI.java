package Transaction_GUI;

import Client.ClientInfo;
import Master_1.MasterServerInterface_1;
import Master_2.MasterServerInterface_2;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Client_Transaction_GUI extends javax.swing.JFrame {

    public Client_Transaction_GUI() {
        initComponents();
        this.setTitle("Bank Transaction");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Withdraw = new javax.swing.JButton();
        Deposit = new javax.swing.JButton();
        CheckBalance = new javax.swing.JButton();
        Name = new javax.swing.JTextField();
        Amount = new javax.swing.JTextField();
        Regions = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Withdraw.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Withdraw.setForeground(new java.awt.Color(0, 51, 255));
        Withdraw.setText("Withdraw");
        Withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WithdrawActionPerformed(evt);
            }
        });

        Deposit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Deposit.setForeground(new java.awt.Color(0, 51, 255));
        Deposit.setText("Deposit");
        Deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositActionPerformed(evt);
            }
        });

        CheckBalance.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CheckBalance.setForeground(new java.awt.Color(0, 0, 255));
        CheckBalance.setText("Check Balance");
        CheckBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBalanceActionPerformed(evt);
            }
        });

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountActionPerformed(evt);
            }
        });

        Regions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banha", "Nasr city", "Zamalek", "Maadi","Mohandeseen","Zayed" }));
        Regions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegionsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Amount");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Region");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Choose the Transaction");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Deposit)
                        .addGap(54, 54, 54)
                        .addComponent(Withdraw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(CheckBalance))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Regions, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Regions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Deposit)
                    .addComponent(Withdraw)
                    .addComponent(CheckBalance))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBalanceActionPerformed
        String name = Name.getText();
        String amountText = Amount.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedRegion = (String) Regions.getSelectedItem();
        ClientInfo client = new ClientInfo(name, (float) 0.0, selectedRegion);

        try {
            if (selectedRegion.equals("Banha") || selectedRegion.equals("Zamalek") || selectedRegion.equals("Nasr city")) {
                Registry registry1 = LocateRegistry.getRegistry("localhost", 2099);
                MasterServerInterface_1 middleServer = (MasterServerInterface_1) registry1.lookup("Master_1");
                if (middleServer.isClientExists(name, selectedRegion)) {
                    JOptionPane.showMessageDialog(null, "Client exists in " + selectedRegion + " with balance " + middleServer.checkBalance(client));
                } else {
                    JOptionPane.showMessageDialog(null, "Client does not exist in " + selectedRegion, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (selectedRegion.equals("Maadi") || selectedRegion.equals("Mohandeseen") || selectedRegion.equals("Zayed")) {
                Registry registry2 = LocateRegistry.getRegistry("localhost", 3099);
                MasterServerInterface_2 middleServer2 = (MasterServerInterface_2) registry2.lookup("Master_2");
                if (middleServer2.isClientExists(name, selectedRegion)) {
                    JOptionPane.showMessageDialog(null, "Client exists in " + selectedRegion + " with balance " + middleServer2.checkBalance(client));
                } else {
                    JOptionPane.showMessageDialog(null, "Client does not exist in " + selectedRegion, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid region", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_CheckBalanceActionPerformed

    private void WithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WithdrawActionPerformed

        String name = Name.getText();
        String amountText = Amount.getText();
        if (name.isEmpty() || amountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float amount;
        try {
            amount = Float.parseFloat(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String region = (String) Regions.getSelectedItem();
        ClientInfo client = new ClientInfo(name, amount, region);
        if (region.equals("Banha") || region.equals("Zamalek") || region.equals("Nasr city")) {
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry("localhost", 2099);
                MasterServerInterface_1 middleServer = (MasterServerInterface_1) registry.lookup("Master_1");
                if (middleServer.isClientExists(name, region)) {
                    float currentBalance = (float) middleServer.checkBalance(client);
                    if (amount > currentBalance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    middleServer.withdraw(client);
                    JOptionPane.showMessageDialog(null, "current Balance " + middleServer.checkBalance(client));
                } else {
                    JOptionPane.showMessageDialog(null, "Client does not exist in " + region, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (region.equals("Maadi") || region.equals("Mohandeseen") || region.equals("Zayed")) {
            // connect one master two
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry("localhost", 3099);
                MasterServerInterface_2 middleServer2 = (MasterServerInterface_2) registry.lookup("Master_2");
                if (middleServer2.isClientExists(name, region)) {
                    float currentBalance = (float) middleServer2.checkBalance(client);
                    if (amount > currentBalance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    middleServer2.withdraw(client);
                    JOptionPane.showMessageDialog(null, "current Balance " + middleServer2.checkBalance(client));
                } else {
                    JOptionPane.showMessageDialog(null, "Client does not exist in " + region, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_WithdrawActionPerformed

    private void DepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositActionPerformed

         String name = Name.getText();
        String amountText = Amount.getText();
        if (name.isEmpty() || amountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float amount;
        try {
            amount = Float.parseFloat(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String region = (String) Regions.getSelectedItem();
        ClientInfo client = new ClientInfo(name, amount, region);
        if (region.equals("Banha") || region.equals("Zamalek") || region.equals("Nasr city")) {
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry("localhost", 2099);
                MasterServerInterface_1 middleServer = (MasterServerInterface_1) registry.lookup("Master_1");
                
                if (middleServer.isClientExists(name, region)) {
                    middleServer.deposit(client);
                    JOptionPane.showMessageDialog(null, "current Balance " + middleServer.checkBalance(client));
                } else {
                    JOptionPane.showMessageDialog(null, "Client does not exist in " + region, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } 
        else if (region.equals("Maadi") || region.equals("Mohandeseen") || region.equals("Zayed")) {

            Registry registry;
            try {
                registry = LocateRegistry.getRegistry("localhost", 3099);
                MasterServerInterface_2 middleServer2 = (MasterServerInterface_2) registry.lookup("Master_2");
                
                if (middleServer2.isClientExists(name, region)) {
                    middleServer2.deposit(client);
                    JOptionPane.showMessageDialog(null, "current Balance " + middleServer2.checkBalance(client));
                } else {
                    JOptionPane.showMessageDialog(null, "Client does not exist in " + region, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (RemoteException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Client_Transaction_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_DepositActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountActionPerformed

    private void RegionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegionsActionPerformed

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Client_Transaction_GUI frame = new Client_Transaction_GUI();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JButton CheckBalance;
    private javax.swing.JButton Deposit;
    private javax.swing.JTextField Name;
    private javax.swing.JComboBox<String> Regions;
    private javax.swing.JButton Withdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
