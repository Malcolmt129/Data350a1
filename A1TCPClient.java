import java.io.*;
import java.net.*;


public class A1TCPClient {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Enter an integer 1, 2, or 3: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //This basically like creating scanner class 

        Socket clientSocket = new Socket("localhost", 11111);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        

        //Send the integer to the server...
        outToServer.writeBytes(br.readLine());

        //Response
    }
}