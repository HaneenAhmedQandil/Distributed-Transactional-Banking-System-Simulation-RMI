package Regions_1;

import Client.ClientInfo;
import Master_1.MasterServerImp_1;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Banha_Implementation extends UnicastRemoteObject implements Banha_Interface
{
    public ArrayList<ClientInfo> clients;
    public MasterServerImp_1 masterServerImp_1;

        Registry registry = LocateRegistry.createRegistry(1000);

    public Banha_Implementation() throws RemoteException
    {
        super();
        this.clients = new ArrayList<>();
        clients.add(new ClientInfo("Jana", 1000, "Banha"));
        clients.add(new ClientInfo("Marrwa", 5000, "Banha"));
        clients.add(new ClientInfo("Mai", 9000, "Banha"));
        clients.add(new ClientInfo("Farida", 1000, "Banha"));
        clients.add(new ClientInfo("Mohamed", 5000, "Banha"));
        registry.rebind("banha", this);

        
    }
    @Override
    public void deposit(ClientInfo c) throws RemoteException
    {
        double amount = c.balance;
        for (ClientInfo client : clients)
        {
            if (client.name.equals(c.name))
            {
                client.balance += amount;
                for (ClientInfo client1 : MasterServerImp_1.clients)
                {
                    if (client1.name.equals(c.name))
                    {
                        client1.balance += amount;
                    }
                }
                break;
            }
        }
    }
    @Override
    public void withdraw(ClientInfo c) throws RemoteException
    {
        double amount = c.balance;
        for (ClientInfo client : clients)
        {
            if (client.name.equals(c.name))
            {
                if (client.balance < amount)
                {
                    throw new RemoteException("Insufficient funds");
                } else
                {
                    client.balance -= amount;
                    for (ClientInfo client1 : MasterServerImp_1.clients)
                    {
                        if (client1.name.equals(c.name))
                        {
                            client1.balance -= amount;
                        }
                    }
                }
                break;
            }
        }
    }
    @Override
    public double checkBalance(ClientInfo c) throws RemoteException
    {
        for (ClientInfo client : clients)
        {
            if (client.name.equals(c.name))
            {
                return client.balance;
            }
        }
        return -1;
    }
}