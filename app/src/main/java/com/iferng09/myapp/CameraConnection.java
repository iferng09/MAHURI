package com.iferng09.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CameraConnection implements Runnable{
    Bitmap bitmap;

    public CameraConnection(){

    }

    @Override
    public void run(){
        try{
            ServerSocket s = new ServerSocket(6001);

            Socket socket = s.accept();

            InputStream is = socket.getInputStream();

            DataInputStream dis = new DataInputStream(is);

            int len = dis.readInt();

            byte[] data = new byte[len];

            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

            dis.close();

            is.close();

        } catch (Exception e){
            System.out.println("Error recibiendo imagen: " + e);
        }
    }

    public Bitmap getBitmap(){
        return this.bitmap;
    }



}

