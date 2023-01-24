package MaXx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * source: https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client
 */

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        //read the server response message
        ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                String message = (String) ois.readObject();
                if(!message.equalsIgnoreCase("lol")) System.out.println(message);
                if (message.equalsIgnoreCase("exit")) break;
                if(message.equalsIgnoreCase("lol")) oos.writeObject(HMI.read());
            }

            ois.close();
            oos.close();
            Thread.sleep(100);

    }
}

