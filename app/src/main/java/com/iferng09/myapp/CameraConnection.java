package com.iferng09.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class CameraConnection{
    Bitmap bitmap;
    Socket s;

    public CameraConnection(){

    }

    public void receiveImg(){
        BackGroundTask b1 = new BackGroundTask();
        b1.execute();
    }

    class BackGroundTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... voids) {
            try {

                if (s == null) {
                    //change it to your IP
                    s = new Socket("192.168.1.85", 6001);
                }

                //ObjectInputStream ois = new ObjectInputStream(s.getInputStream());



                //DataInputStream dis = new DataInputStream(is);

                //int len = dis.read();
                while(true) {
                    byte[] data = new byte[345600];

                    //byte[] image = is.read(data);

                    /*try {
                        Object image = ois.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }*/
                    InputStream is = s.getInputStream();

                    int n = is.read(data);

                    //int size = ByteBuffer.wrap(data).asIntBuffer().get();

                    //byte[] img = new byte[size];
                    //is.read(img);

                    is = new BufferedInputStream(is);

                    System.out.println("IS:"+n);
                    System.out.println();

                    //bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    bitmap = BitmapFactory.decodeStream(is);

                    //is.reset();

                    //System.out.println(bitmap.getByteCount());
                }

                //is.close();
                //dis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public Bitmap getBitmap(){
        return this.bitmap;
    }



}

