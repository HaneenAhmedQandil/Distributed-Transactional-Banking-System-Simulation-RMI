package Regions_1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Client.ClientInfo;

public interface Zamalek_Interface extends Remote
{
    public void deposit(ClientInfo c) throws RemoteException;

    public void withdraw(ClientInfo c) throws RemoteException;

    public double checkBalance(ClientInfo c) throws RemoteException;
}