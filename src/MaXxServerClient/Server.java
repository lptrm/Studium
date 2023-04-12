package MaXxServerClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * source: https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client
 */

public class Server {

    //static ServerSocket variable
    private ServerSocket server;
    //socket server port on which it will listen
    private int port = 9876;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket socket;

    public Server() throws IOException {
            //create the socket server object
            server = new ServerSocket(port);
            //keep listens indefinitely until receives 'exit' call or program terminates
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            socket = server.accept();
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            HMI.attachServer(this);
    }

    public String read() throws IOException, ClassNotFoundException {

        //convert ObjectInputStream object to String
        this.oos.writeObject("lol");
        return (String) this.ois.readObject();

    }

    public void write(String message) throws IOException {
        //create ObjectOutputStream object

        //write object to Socket
        this.oos.writeObject(message);
    }

    public void close() throws IOException {
        //close resources
        System.out.println("Shutting down Socket server!!");
        this.ois.close();
        this.oos.close();
        this.socket.close();
        this.server.close();
    }
}
