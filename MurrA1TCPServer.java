import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//Code was compiled and ran using Eclipse 
public class MurrA1TCPServer {

  public static void main(String argv[]) throws Exception
    {
      LocalDateTime ST1;
      LocalDateTime ST2;
      LocalDateTime ST3;
      LocalDateTime ST4;
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
      
      ServerSocket welcomeSocket = new ServerSocket(12211);
 
      while(true) {
    	  String w1 = "https://www.";
          String w2 = "https://www.";
           Socket connectionSocket = welcomeSocket.accept();
           
           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
           DataOutputStream  outToClient =
                   new DataOutputStream(connectionSocket.getOutputStream());

           w1 += inFromClient.readLine();
           
           w2 += inFromClient.readLine();
           
           
           System.out.println("Strings recieved:");
           System.out.println(w1);
           System.out.println(w2);
           
           ST1 = LocalDateTime.now();
           
           // w1
           
           System.out.println("W1 request sent at: " + ST1.format(formatter));
           
           String inputLine;
           URL obj = new URL(w1);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           con.setRequestMethod("GET");
           con.setRequestProperty("User-Agent","Mozilla/5.0");
           BufferedReader in = new BufferedReader(
                 new InputStreamReader(con.getInputStream())); 
                         while ((inputLine = in.readLine()) != null) 
                        	  outToClient.writeBytes(inputLine);                       
                         
                         
           ST2 = LocalDateTime.now();
           
           System.out.println("W1 response recieved sent at: " + ST2.format(formatter));
           
           //w2
           
           ST3 = LocalDateTime.now();
           
           System.out.println("W2 request sent at: " + ST3.format(formatter));
           
           String inputLine2;
           obj = new URL(w2);
           HttpURLConnection con2 = (HttpURLConnection) obj.openConnection();
           con2.setRequestMethod("GET");
           con2.setRequestProperty("User-Agent","Mozilla/5.0");
           BufferedReader in2 = new BufferedReader(
                   new InputStreamReader(con2.getInputStream())); 
                         while ((inputLine2 = in2.readLine()) != null) 
                        	 outToClient.writeBytes(inputLine2);   
           
          ST4 = LocalDateTime.now();
           
          System.out.println("W2 response recieved sent at: " + ST4.format(formatter));
                
        }
    }
}