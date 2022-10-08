import java.io.*;
import java.net.*;

public class A1TCPServer {
        
    public static void main(String[] args) throws IOException, InterruptedException {
    
        String clientString;
        ServerSocket welcomeSocket = new ServerSocket(11111);
        String confirmation = "Content received from ";
        String w = "";
        Socket connSocket = new Socket();

        while (true) {
            
            try {
                connSocket = welcomeSocket.accept();
            } catch (Exception e) {
                System.out.println("Socket is closed now!");
            }
            System.out.println("Client connected");

            BufferedReader infromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());

            clientString = infromClient.readLine();
            System.out.println(clientString);
            
            switch(clientString) {
                case "1": 
                    w = "https://www.ieee.org:443";
                    break;
                case "2":
                    w = "https://www.3gpp.org:443";
                    break;
                
                case "3":
                    w ="https://www.eecs.mit.edu:443";
                    break; 

            }

            URL obj = new URL(w);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            System.out.println("Request sent to " + w + "...");
            
            String inputLine = "";
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            outToClient.writeBytes(confirmation + w + "\n");
                welcomeSocket.close();
        }
    }
}
