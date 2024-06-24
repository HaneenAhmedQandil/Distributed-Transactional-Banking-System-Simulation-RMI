package Master_2;

import Master_1.MasterServerGUI_1;
import Client.ClientInfo;
import Master_1.MasterServerInterface_1;
import Regions_2.Maadi_Implementation;
import Regions_2.Zayed_Implementation;
import Regions_2.Mohandeseen_Implementation;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import Regions_2.Maadi_Interface;
import Regions_2.Zayed_Interface;
import Regions_2.Mohandeseen_Interface;
import java.rmi.AccessException;
import java.rmi.NotBoundException;

public class MasterServerGUI_2 extends javax.swing.JFrame {

    MasterServerInterface_2 middleServer2;

    public MasterServerGUI_2() throws RemoteException {
        initComponents();
        Maadi_Interface serverMaadi = new Maadi_Implementation();
        Zayed_Interface serverZayed = new Zayed_Implementation();
        Mohandeseen_Interface serverMohandeseen = new Mohandeseen_Implementation();
        Registry registry = LocateRegistry.createRegistry(3099);
        middleServer2 = new MasterServerImp_2(serverMaadi, serverZayed, serverMohandeseen);
        registry.rebind("Master_2", middleServer2);
        jTextArea1.setEditable(false);
        this.setTitle("Master 2");
        updateClientList();
    }

    private void updateClientList() {
        StringBuilder sb = new StringBuilder();
        for (ClientInfo client : MasterServerImp_2.clients) {
            sb.append(client.name).append(": ").append(client.balance).append(", ").append(client.Region).append("\n");
        }
        jTextArea1.setText(sb.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        UpdateMaster_1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        UpdateMaster_1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateMaster_1.setForeground(new java.awt.Color(0, 51, 255));
        UpdateMaster_1.setText("Update Master 1");
        UpdateMaster_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMaster_1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Master 2 Clients List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UpdateMaster_1)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(UpdateMaster_1))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateMaster_1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_UpdateMaster_1ActionPerformed
    {//GEN-HEADEREND:event_UpdateMaster_1ActionPerformed

        try {
            Registry M1registry = LocateRegistry.getRegistry("localhost", 5004);
            try {
                MasterServerInterface_1 m1 = (MasterServerInterface_1) M1registry.lookup("m1");
                
                m1.UpdateMaster2(MasterServerImp_2.clients);
            } catch (NotBoundException ex) {
                Logger.getLogger(MasterServerGUI_2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AccessException ex) {
                Logger.getLogger(MasterServerGUI_2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(MasterServerGUI_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateMaster_1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        updateClientList();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MasterServerGUI_2 frame = new MasterServerGUI_2();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (RemoteException ex) {
                    Logger.getLogger(MasterServerGUI_2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateMaster_1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
