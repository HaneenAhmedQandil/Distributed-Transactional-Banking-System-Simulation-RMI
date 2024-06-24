package Master_2;

import Regions_2.Maadi_Interface;
import Regions_2.Mohandeseen_Interface;
import Regions_2.Zayed_Interface;
import Master_1.MasterServerImp_1;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Client.ClientInfo;
import java.rmi.AccessException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasterServerImp_2 extends UnicastRemoteObject implements MasterServerInterface_2 {

    private Maadi_Interface serverMaadi;
    private Zayed_Interface serverZayed;
    private Mohandeseen_Interface serverMohandeseen;
    public static ArrayList<ClientInfo> clients;
    public static ArrayList<ClientInfo> clients_master_1;
    public MasterServerImp_1 masterImp_1;

    Registry registry4 = LocateRegistry.getRegistry("localhost", 1003);
    Registry registry5 = LocateRegistry.getRegistry("localhost", 1004);
    Registry registry6 = LocateRegistry.getRegistry("localhost", 1005);

    Registry M1registry = LocateRegistry.getRegistry("localhost", 2099);
   Registry M2registry = LocateRegistry.createRegistry(5005);

    public MasterServerImp_2(Maadi_Interface serverMaadi, Zayed_Interface serverZayed, Mohandeseen_Interface serverMohandeseen)
            throws RemoteException {
        super();
        this.serverMaadi = serverMaadi;
        this.serverZayed = serverZayed;
        this.serverMohandeseen = serverMohandeseen;
        this.clients = new ArrayList<>();
        clients.add(new ClientInfo("Sajed", 6000, "Maadi"));
        clients.add(new ClientInfo("Nour", 7000, "Maadi"));
        clients.add(new ClientInfo("Khaled", 8000, "Maadi"));
        clients.add(new ClientInfo("Fawzy", 10000, "Maadi"));
        clients.add(new ClientInfo("Ahmed", 20000, "Maadi"));

        clients.add(new ClientInfo("Nageeb", 200000, "Zayed"));
        clients.add(new ClientInfo("Sameeh", 300000, "Zayed"));
        clients.add(new ClientInfo("Nasef", 400000, "Zayed"));
        clients.add(new ClientInfo("Yousra", 150000, "Zayed"));
        clients.add(new ClientInfo("Nelly", 100000, "Zayed"));

        clients.add(new ClientInfo("Fawzy", 3000, "Mohandeseen"));
        clients.add(new ClientInfo("Belal", 4000, "Mohandeseen"));
        clients.add(new ClientInfo("Rawy", 5000, "Mohandeseen"));
        clients.add(new ClientInfo("Aseel", 25000, "Mohandeseen"));
        clients.add(new ClientInfo("Rawan", 8000, "Mohandeseen"));
        M2registry.rebind("m2", this);
        
    }

     public void UpdateMaster1(ArrayList <ClientInfo> clients ) throws RemoteException {
        clients_master_1=clients;
            for (ClientInfo client : clients_master_1) {
                System.out.println(client.name + ": " + client.balance);
            }

    }

    public void deposit(ClientInfo c) throws RemoteException, AccessException {
        try {
            switch (c.Region) {
                case "Maadi":
                    Maadi_Interface maadi = (Maadi_Interface) registry4.lookup("maadi");
                    maadi.deposit(c);
                    break;
                case "Mohandeseen":
                    Mohandeseen_Interface mohandeseen = (Mohandeseen_Interface) registry5.lookup("mohandeseen");
                    mohandeseen.deposit(c);
                    break;
                case "Zayed":
                    Zayed_Interface zayed = (Zayed_Interface) registry6.lookup("zayed");
                    zayed.deposit(c);
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(MasterServerImp_2.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public void withdraw(ClientInfo c) throws RemoteException {
        try {
            switch (c.Region) {
                case "Maadi":
                    Maadi_Interface maadi = (Maadi_Interface) registry4.lookup("maadi");
                    maadi.withdraw(c);
                    break;
                case "Mohandeseen":
                    Mohandeseen_Interface mohandeseen = (Mohandeseen_Interface) registry5.lookup("mohandeseen");
                    mohandeseen.withdraw(c);
                    break;
                case "Zayed":
                    Zayed_Interface zayed = (Zayed_Interface) registry6.lookup("zayed");
                    zayed.withdraw(c);
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(MasterServerImp_2.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public double checkBalance(ClientInfo c) throws RemoteException {
        try {
            switch (c.Region) {
                case "Maadi":
                    Maadi_Interface maadi = (Maadi_Interface) registry4.lookup("maadi");
                    return maadi.checkBalance(c);

                case "Mohandeseen":
                    Mohandeseen_Interface mohandeseen = (Mohandeseen_Interface) registry5.lookup("mohandeseen");
                    return mohandeseen.checkBalance(c);

                case "Zayed":
                    Zayed_Interface zayed = (Zayed_Interface) registry6.lookup("zayed");
                    return zayed.checkBalance(c);

            }
        } catch (Exception e) {
            Logger.getLogger(MasterServerImp_2.class.getName()).log(Level.SEVERE, null, e);

        }
        return -1;
    }

    public boolean isClientExists(String name, String region) throws RemoteException {
        for (ClientInfo client : clients) {
            if (client.name.equals(name) && client.Region.equals(region)) {
                return true;
            }
        }
        return false;
    }
}
