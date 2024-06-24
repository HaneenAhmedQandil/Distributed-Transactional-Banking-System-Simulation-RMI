package Client;

import java.io.Serializable;

public class ClientInfo implements Serializable {

    public String name;
    public float balance;
    public String Region;

    public ClientInfo(String name, float balance, String Region) {
        this.name = name;
        this.balance = balance;
        this.Region = Region;
    }

}
