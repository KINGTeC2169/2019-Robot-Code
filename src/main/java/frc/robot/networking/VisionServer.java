package frc.robot.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class VisionServer extends Thread {

    private boolean connected = true;
    private ServerSocket server;

    //Constructor that creates the ServerSocket
    public VisionServer() throws IOException {
        server = new ServerSocket(2169);
    }

    private boolean getConnected() {
        return connected;
    }

    private void disconnect() {
        connected = false;
    }

    //Listener function that grabs new clients and hands them information.
    public void run() {

        // running infinite loop for getting
        // clientBase request
        while (System.currentTimeMillis() > 0) {
            Socket s = null;

            try {
                // socket object to receive incoming clientBase requests
                s = server.accept();
                connected = true;
                System.out.println("[INFO] A new client is connected : " + s);

                // obtaining input and out streams

                BufferedReader in;
                PrintWriter out;
                try {
                    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    out = new PrintWriter(s.getOutputStream(), true);
                    String data;

                    while (connected) {
                        long lastRecieved = System.currentTimeMillis();
                        //Check if we've got new data from our clientBase.
                        out.println(System.currentTimeMillis());
                        out.flush();
                        while (!in.ready()) {
                            long elapsedTime = System.currentTimeMillis() - lastRecieved;
                            if (elapsedTime > 3000) {
                                if (getConnected()) {
                                    System.out.println("Lost Client!");
                                    disconnect();
                                    break;
                                }
                            }
                        }
                        System.out.println("Client Says: " + System.currentTimeMillis()/1000.0f + "  " + Double.parseDouble(in.readLine()));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void spawnVisionThread(){
        VisionServer server = null;
        try {
            server = new VisionServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            server.run();
        }
    }

}
