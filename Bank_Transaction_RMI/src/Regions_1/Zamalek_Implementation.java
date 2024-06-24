package Regions_1;

import Client.ClientInfo;
import Master_1.MasterServerImp_1;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Zamalek_Implementation extends UnicastRemoteObject implements Zamalek_Interface {

    public ArrayList<ClientInfo> clients;
    public MasterServerImp_1 masterServerImp_1;
    Registry registry = LocateRegistry.createRegistry(1002);

    public Zamalek_Implementation() throws RemoteException {
        super();
        this.clients = new ArrayList<>();
        clients.add(new ClientInfo("Rawda", 1000, "Zamalek"));
        clients.add(new ClientInfo("Nayera", 5000, "Zamalek"));
        clients.add(new ClientInfo("Mostafa", 9000, "Zamalek"));
        clients.add(new ClientInfo("Hany", 1000, "Zamalek"));
        clients.add(new ClientInfo("Omar", 5000, "Zamalek"));
        registry.rebind("zamalek", this);

    }

    @Override
    public void deposit(ClientInfo c) throws RemoteException {
        double amount = c.balance;
        //System.out.println(clients.size());
        for (ClientInfo client : clients) {
            if (client.name.equals(c.name)) {
                client.balance += amount;
                for (ClientInfo client1 : MasterServerImp_1.clients) {
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
                    for (ClientInfo client1 : MasterServerImp_1.clients) {
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
