package com.iferng09.myapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection{
    Socket s;
    PrintWriter writer;
    String mens;

    public Connection(){

    }

    public void sendMsg(String msg){
        this.mens = msg;
        BackGroundTask b1 = new BackGroundTask();
        b1.execute();
    }

    class BackGroundTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... voids) {
            try {

                if (s == null) {
                    //change it to your IP
                    s = new Socket("192.168.1.85", 6000);
                    writer = new PrintWriter(s.getOutputStream());
                    Log.d("javaClass", "CONNECTED");
                }

                if(mens.equals("arriba") || mens.equals("adelante")){
                    mens = "UP";
                } else if(mens.equals("abajo") || mens.equals("atrás")){
                    mens = "DOWN";
                } else if(mens.equals("derecha")){
                    mens = "RIGHT";
                } else if(mens.equals("izquierda")){
                    mens = "LEFT";
                } else if(mens.equals("stop")){
                    mens = "STOP";
                } else if(mens.equals("cocina")){
                    mens = "COCINA";
                } else if(mens.equals("salón")){
                    mens = "SALON";
                } else if(mens.equals("habitación")){
                    mens = "HABITACION";
                }

                if(mens.equals("UP") || mens.equals("DOWN") || mens.equals("LEFT") || mens.equals("RIGHT") || mens.equals("STOP")
                        || mens.equals("COCINA") || mens.equals("SALON") || mens.equals("HABITACION") || mens.equals("CAMARA")){
                    writer.write(mens);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
