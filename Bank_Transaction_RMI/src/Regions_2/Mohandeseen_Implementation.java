package Regions_2;

import Client.ClientInfo;
import Master_2.MasterServerImp_2;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Mohandeseen_Implementation extends UnicastRemoteObject implements Mohandeseen_Interface {

    public ArrayList<ClientInfo> clients;
    public MasterServerImp_2 masterServerImp_2;
    Registry registry = LocateRegistry.createRegistry(1004);

    public Mohandeseen_Implementation() throws RemoteException {
        super();
        this.clients = new ArrayList<>();
        clients.add(new ClientInfo("Fawzy", 3000, "Mohandeseen"));
        clients.add(new ClientInfo("Belal", 4000, "Mohandeseen"));
        clients.add(new ClientInfo("Rawy", 5000, "Mohandeseen"));
        clients.add(new ClientInfo("Aseel", 25000, "Mohandeseen"));
        clients.add(new ClientInfo("Rawan", 8000, "Mohandeseen"));
        registry.rebind("mohandeseen", this);

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
