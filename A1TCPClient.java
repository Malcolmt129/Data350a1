import java.io.*;
import java.net.*;


public class A1TCPClient {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Enter an integer 1, 2, or 3: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //This basically like creating scanner class 
        int choice = br.read();
        br.close();

        System.out.println(choice);

        //Send the integer to the server...
        




    }
}