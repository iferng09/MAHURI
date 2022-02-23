package com.iferng09.myapp;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection{
    Socket s;
    PrintWriter writer;
    String mens;
    int contador;

    public Connection(){

    }

    public void connect(int contador){
        this.contador = contador;
        this.mens = String.valueOf(contador);
        BackGroundTask b1 = new BackGroundTask();
        b1.execute();
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
                writer.write(mens);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
