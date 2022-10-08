import java.io.*;
import java.net.*;


public class A1TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence; 
        System.out.println();
        
        System.out.println("Enter an integer 1, 2, or 3: ");
        BufferedReader infromUser = new BufferedReader(new InputStreamReader(System.in)); //This basically like creating scanner class 

        Socket clientSocket = new Socket("localhost", 11111);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader infromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence =infromUser.readLine();
        //Send the integer to the server...
        outToServer.writeBytes(sentence + "\n");

        //Message from server

        do {
            System.out.println(infromServer.readLine());
        } while (infromServer.readLine() != null);
        
        clientSocket.close();
    }
}