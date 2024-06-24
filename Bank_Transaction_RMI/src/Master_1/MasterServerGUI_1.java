package Master_1;

import Client.ClientInfo;
import Master_2.MasterServerInterface_2;
import Regions_1.Nasr_City_Implementation;
import Regions_1.Banha_Implementation;
import Regions_1.Zamalek_Implementation;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import Regions_1.Zamalek_Interface;
import Regions_1.Nasr_City_Interface;
import Regions_1.Banha_Interface;
import java.rmi.AccessException;
import java.rmi.NotBoundException;

public class MasterServerGUI_1 extends javax.swing.JFrame {

    private MasterServerInterface_1 middleServer;

    public MasterServerGUI_1() throws RemoteException {
        initComponents();

        Banha_Interface serverBanha = new Banha_Implementation();
        Nasr_City_Interface serverNasrCity = new Nasr_City_Implementation();
        Zamalek_Interface serverZamalek = new Zamalek_Implementation();
        Registry registry = LocateRegistry.createRegistry(2099);
        middleServer = new MasterServerImp_1(serverBanha, serverNasrCity, serverZamalek);
        registry.rebind("Master_1", middleServer);
        updateClientList();
        jTextArea1.setEditable(false);
        this.setTitle("Master 1");
    }

    private void updateClientList() {
        StringBuilder sb = new StringBuilder();
        for (ClientInfo client : MasterServerImp_1.clients) {
            sb.append(client.name).append(": ").append(client.balance).append(", ").append(client.Region).append("\n");
        }
        jTextArea1.setText(sb.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        UpdateMaster_2 = new javax.swing.JButton();
        RefreshButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        UpdateMaster_2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateMaster_2.setForeground(new java.awt.Color(0, 51, 255));
        UpdateMaster_2.setText("Update Master 2");
        UpdateMaster_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMaster_2ActionPerformed(evt);
            }
        });

        RefreshButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RefreshButton1.setForeground(new java.awt.Color(0, 51, 255));
        RefreshButton1.setText("Refresh");
        RefreshButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Master 1 Clients List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UpdateMaster_2)
                        .addGap(44, 44, 44)
                        .addComponent(RefreshButton1)))
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateMaster_2)
                    .addComponent(RefreshButton1))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateMaster_2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_UpdateMaster_2ActionPerformed
    {//GEN-HEADEREND:event_UpdateMaster_2ActionPerformed
         try {
            Registry M1registry = LocateRegistry.getRegistry("localhost", 5005);
            try {
                MasterServerInterface_2 m2 = (MasterServerInterface_2) M1registry.lookup("m2");
                
                m2.UpdateMaster1(MasterServerImp_1.clients);
            } catch (NotBoundException ex) {
                Logger.getLogger(MasterServerGUI_1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AccessException ex) {
                Logger.getLogger(MasterServerGUI_1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(MasterServerGUI_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateMaster_2ActionPerformed

    private void RefreshButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButton1ActionPerformed

        updateClientList();
    }//GEN-LAST:event_RefreshButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MasterServerGUI_1 frame = new MasterServerGUI_1();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (RemoteException ex) {
                    Logger.getLogger(MasterServerGUI_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshButton1;
    private javax.swing.JButton UpdateMaster_2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
