import java.io.*;
import java.net.*;

public class A1TCPServer {
    public static void main(String[] args) throws IOException {
    
        String clientString;
        ServerSocket welcomeSocket = new ServerSocket(11111);

        while (true) {
            Socket connSocket = welcomeSocket.accept();

            BufferedReader infromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());

            clientString = infromClient.readLine();
            System.out.println(clientString);



        }
    }
    
}
