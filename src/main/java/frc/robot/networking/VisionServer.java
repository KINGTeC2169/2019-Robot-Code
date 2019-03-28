package frc.robot.networking;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.Driver;

public class VisionServer extends Thread {

    private boolean connected = true;
    private ServerSocket server;

    //Constructor that creates the ServerSocket
    public VisionServer() throws IOException {
        server = new ServerSocket(5803);
    }

    private boolean getConnected() {
        SmartDashboard.putBoolean("Connected", connected);
        return connected;
    }

    private void disconnect() {
        SmartDashboard.putBoolean("Connected", false);
        connected = false;
        System.out.println("Disconnect Method Complete");
    }

    //Listener function that grabs new clients and hands them information.
    @Override
    public void run() {

        // running infinite loop for getting
        // clientBase request


        SmartDashboard.putBoolean("Connected", false);

        while (true) {

            try {
                // socket object to receive incoming clientBase requests
                Socket s = server.accept();
                connected = true;

                SmartDashboard.putBoolean("Connected", true);
                DriverStation.reportWarning("[INFO] A new client is connected : " + s, false);

                // obtaining input and out streams

                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true, StandardCharsets.UTF_8);

                    while (connected) {
                        long lastRecieved = System.currentTimeMillis();
                        //Check if we've got new data from our clientBase.
                        out.println(System.currentTimeMillis());
                        out.flush();
                        while (!in.ready()) {
                            long elapsedTime = System.currentTimeMillis() - lastRecieved;
                            if (elapsedTime > 3000) {
                                if (getConnected()) {
                                    DriverStation.reportError("Lost Client!", false);
                                    disconnect();
                                    break;
                                }
                            }
                        }
                        if(!connected){
                            System.out.println("Breaking!");
                            break;
                        }
                        Main.visionData = Double.parseDouble(in.readLine());
                        SmartDashboard.putNumber("Yee-Haw", Main.visionData);
                    }

                } catch (IOException e) {
                    System.out.println("Inner Network Loop");
                    e.printStackTrace();
                }


            } catch (IOException e) {
                System.out.println("Outer Network Loop");
                e.printStackTrace();
            }

        }
    }

    public static void spawnVisionThread(){
        VisionServer server = null;
        try {
            System.out.println("Creating New Vision Server!");
            server = new VisionServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            if (server != null) {
                server.run();
                System.out.println("Died! Trying Again!");
            }
            else{
                System.out.println("Restarting SpawnVisionThread Method!");
                spawnVisionThread();
            }
        }
    }

}
