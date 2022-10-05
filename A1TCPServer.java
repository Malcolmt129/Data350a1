import java.io.*;
import java.net.*;
import java.time.*;
import java.util.concurrent.TimeUnit;

public class A1TCPServer {
    
    public static String getPage(URL url) throws IOException, InterruptedException{
        URL site = url;
        HttpURLConnection con = (HttpURLConnection) site.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        System.out.println("Request sent to " + site + "...");

        TimeUnit.SECONDS.sleep(3);
        
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        
        BufferedReader out = new BufferedReader(new InputStreamReader(con.getInputStream())); 
        while ((inputLine = out.readLine()) != null) 
            outToClient.writeBytes(inputLine); 

        return "Content received from " + site;
    }
    
    
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
    
        String clientString;
        ServerSocket welcomeSocket = new ServerSocket(11111);

        while (true) {
            Socket connSocket = welcomeSocket.accept();

            BufferedReader infromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());

            clientString = infromClient.readLine();
            
            switch(clientString) {
                case "1": 
                    URL url = new URL("https://ieee.org");
                    getPage(url);

                    
                    break;
                case "2":
                    URL url2 = new URL("https://3gpp.org");
                    outToClient.writeBytes(getPage(url2));
                    
                    break;
                
                case "3":
                    URL url3 = new URL("https://eecs.mit.edu");
                    outToClient.writeBytes(getPage(url3));
                    
                    break; 

            }



        }
    }
    
}
