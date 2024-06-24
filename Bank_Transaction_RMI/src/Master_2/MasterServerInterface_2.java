package Master_2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Client.ClientInfo;
import java.util.ArrayList;

public interface MasterServerInterface_2 extends Remote
{

    public void deposit(ClientInfo c) throws RemoteException;

    public void withdraw(ClientInfo c) throws RemoteException;

    public double checkBalance(ClientInfo c) throws RemoteException;

    public void UpdateMaster1(ArrayList <ClientInfo> clients) throws RemoteException;

    public boolean isClientExists(String name, String region) throws RemoteException;

}
