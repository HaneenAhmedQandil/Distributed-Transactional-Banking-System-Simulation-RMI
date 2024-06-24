package Regions_2;

import Client.ClientInfo;
import Master_2.MasterServerImp_2;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Zayed_Implementation extends UnicastRemoteObject implements Zayed_Interface {

    public ArrayList<ClientInfo> clients;
    public MasterServerImp_2 masterServerImp_2;
    Registry registry = LocateRegistry.createRegistry(1005);

    public Zayed_Implementation() throws RemoteException {
        super();
        this.clients = new ArrayList<>();
        clients.add(new ClientInfo("Nageeb", 200000, "Zayed"));
        clients.add(new ClientInfo("Sameeh", 300000, "Zayed"));
        clients.add(new ClientInfo("Nasef", 400000, "Zayed"));
        clients.add(new ClientInfo("Yousra", 150000, "Zayed"));
        clients.add(new ClientInfo("Nelly", 100000, "Zayed"));
        registry.rebind("zayed", this);

    }

    @Override
    public void deposit(ClientInfo c) throws RemoteException {
        double amount = c.balance;
        for (ClientInfo client : clients) {
            if (client.name.equals(c.name)) {
                client.balance += amount;
                for (ClientInfo client1 : MasterServerImp_2.clients) {
                    if (client1.name.equals(c.name)) {
                        client1.balance += amount;
                    }
                }
                break;
            }
        }
    }

    @Override
    public void withdraw(ClientInfo c) throws RemoteException {
        double amount = c.balance;
        for (ClientInfo client : clients) {
            if (client.name.equals(c.name)) {
                if (client.balance < amount) {
                    throw new RemoteException("Insufficient funds");
                } else {
                    client.balance -= amount;
                    for (ClientInfo client1 : MasterServerImp_2.clients) {
                        if (client1.name.equals(c.name)) {
                            client1.balance -= amount;
                        }
                    }
                }
                break;
            }
        }
    }

    @Override
    public double checkBalance(ClientInfo c) throws RemoteException {
        for (ClientInfo client : clients) {
            if (client.name.equals(c.name)) {
                return client.balance;
            }
        }
        return -1;
    }
}
