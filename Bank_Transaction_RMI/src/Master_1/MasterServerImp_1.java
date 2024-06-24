package Master_1;

import Regions_1.Banha_Interface;
import Regions_1.Zamalek_Interface;
import Regions_1.Nasr_City_Interface;
import java.rmi.RemoteException;
import Client.ClientInfo;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Master_2.MasterServerImp_2;
import java.rmi.AccessException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasterServerImp_1 extends UnicastRemoteObject implements MasterServerInterface_1 {
    
    private Banha_Interface serverBanha;
    private Nasr_City_Interface serverNasrCity;
    private Zamalek_Interface serverZmalek;
    public static ArrayList<ClientInfo> clients;
    public static ArrayList<ClientInfo> clients_master_2;
    public MasterServerImp_2 masterImp_2;
    private MasterServerGUI_1 masterServerGUI;
    
    Registry registry1 = LocateRegistry.getRegistry("localhost", 1000);
    Registry registry2 = LocateRegistry.getRegistry("localhost", 1001);
    Registry registry3 = LocateRegistry.getRegistry("localhost", 1002);
    
    Registry M2registry = LocateRegistry.getRegistry("localhost", 3099);
    Registry M1registry = LocateRegistry.createRegistry(5004);
    
    public MasterServerImp_1(Banha_Interface serverBanha, Nasr_City_Interface serverNasrCity, Zamalek_Interface serverZmalek) throws RemoteException {
        super();
        this.serverBanha = serverBanha;
        this.serverNasrCity = serverNasrCity;
        this.serverZmalek = serverZmalek;
        this.clients = new ArrayList<>();
        clients.add(new ClientInfo("Noura", 100000, "Nasr city"));
        clients.add(new ClientInfo("Omnia", 10000, "Nasr city"));
        clients.add(new ClientInfo("Farah", 15000, "Nasr city"));
        clients.add(new ClientInfo("Aya", 6000, "Nasr city"));
        clients.add(new ClientInfo("Shehab", 4000, "Nasr city"));
        
        clients.add(new ClientInfo("Jana", 1000, "Banha"));
        clients.add(new ClientInfo("Marwa", 5000, "Banha"));
        clients.add(new ClientInfo("Mai", 9000, "Banha"));
        clients.add(new ClientInfo("Farida", 1000, "Banha"));
        clients.add(new ClientInfo("Mohamed", 5000, "Banha"));
        
        clients.add(new ClientInfo("Rawda", 1000, "Zamalek"));
        clients.add(new ClientInfo("Nayera", 5000, "Zamalek"));
        clients.add(new ClientInfo("Mostafa", 9000, "Zamalek"));
        clients.add(new ClientInfo("Hany", 1000, "Zamalek"));
        clients.add(new ClientInfo("Omar", 5000, "Zamalek"));
        M1registry.rebind("m1", this);
    }
    
    public void UpdateMaster2(ArrayList <ClientInfo> clients ) throws RemoteException {
        clients_master_2=clients;
            for (ClientInfo client : clients_master_2) {
                System.out.println(client.name + ": " + client.balance);
            }

    }
    
    public void deposit(ClientInfo c) throws RemoteException, AccessException {
        try {
            switch (c.Region) {
                case "Banha":
                    Banha_Interface banha = (Banha_Interface) registry1.lookup("banha");
                    banha.deposit(c);
                    break;
                case "Nasr city":
                    Nasr_City_Interface nasr_city = (Nasr_City_Interface) registry2.lookup("nasr city");
                    nasr_city.deposit(c);
                    break;
                case "Zamalek":
                    Zamalek_Interface zamalek = (Zamalek_Interface) registry3.lookup("zamalek");
                    zamalek.deposit(c);
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(MasterServerImp_1.class.getName()).log(Level.SEVERE, null, e);
            
        }
    }
    
    public void withdraw(ClientInfo c) throws RemoteException {
        try {
            switch (c.Region) {
                case "Banha":
                    Banha_Interface banha = (Banha_Interface) registry1.lookup("banha");
                    banha.withdraw(c);
                    break;
                case "Nasr city":
                    Nasr_City_Interface nasr_city = (Nasr_City_Interface) registry2.lookup("nasr city");
                    nasr_city.withdraw(c);
                    break;
                case "Zamalek":
                    Zamalek_Interface zamalek = (Zamalek_Interface) registry3.lookup("zamalek");
                    zamalek.withdraw(c);
                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(MasterServerImp_1.class.getName()).log(Level.SEVERE, null, e);
            
        }
    }
    
    public double checkBalance(ClientInfo c) throws RemoteException {
        try {
            switch (c.Region) {
                case "Banha":
                    Banha_Interface banha = (Banha_Interface) registry1.lookup("banha");
                    return banha.checkBalance(c);
                
                case "Nasr city":
                    Nasr_City_Interface nasr_city = (Nasr_City_Interface) registry2.lookup("nasr city");
                    return nasr_city.checkBalance(c);
                
                case "Zamalek":
                    Zamalek_Interface zamalek = (Zamalek_Interface) registry3.lookup("zamalek");
                    return zamalek.checkBalance(c);
                
            }
        } catch (Exception e) {
            Logger.getLogger(MasterServerImp_1.class.getName()).log(Level.SEVERE, null, e);
            
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
