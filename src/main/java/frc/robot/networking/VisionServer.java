package frc.robot.networking;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class VisionServer extends Thread {

    private boolean connected = true;
    private ServerSocket server;

    //Constructor that creates the ServerSocket
    private VisionServer() throws IOException {
        server = new ServerSocket(5803);
    }

    // Return connection status
    private boolean getConnected() {
        SmartDashboard.putBoolean("Connected", connected);
        return connected;
    }

    // Disconnect from the server
    private void disconnect() {
        SmartDashboard.putBoolean("Connected", false);
        connected = false;
        System.out.println("Disconnect Method Complete");
    }

    //Listener function that grabs new clients and hands them information.
    @Override
    public void run() {

        SmartDashboard.putBoolean("Connected", false);

        while (System.currentTimeMillis() > 0) {

            try {

                // Accept requests and connect
                Socket s = server.accept();
                connected = true;

                SmartDashboard.putBoolean("Connected", true);
                DriverStation.reportWarning("[INFO] A new client is connected : " + s, false);


                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),
                            StandardCharsets.UTF_8));
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true, StandardCharsets.UTF_8);

                    while (connected) {

                        // Save the time for later comparison
                        long lastReceived = System.currentTimeMillis();

                        //Send back our current time
                        out.println(System.currentTimeMillis());
                        out.flush();

                        while (!in.ready()) {
                            // Calculate current time, if more than 3 seconds have passed, abandon connection and
                            // search again
                            long elapsedTime = System.currentTimeMillis() - lastReceived;
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

        // Set server as null
        VisionServer server = null;
        try {
            System.out.println("Creating New Vision Server!");
            server = new VisionServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (System.currentTimeMillis() > 0) {
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
