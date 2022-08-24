package com.iferng09.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

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
                    s = new Socket("192.168.1.18", 6001);
                }

                /**InputStream in = s.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                int len = dis.readInt();
                byte[] data = new byte[len];
                if(len > 0){
                    dis.readFully(data, 0, data.length);
                }

                bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);*/
                InputStream inputStream = s.getInputStream();

                byte[] sizeAr = new byte[12000];
                inputStream.read(sizeAr);
                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
                System.out.println(size);
                byte[] imageAr = new byte[size];
                inputStream.read(imageAr);

                //Rect rect=new Rect();
                //rect.set(imageView.getLeft(),imageView.getTop(),imageView.getRight(),imageView.getBottom());

                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inSampleSize=1;

                Bitmap bmp=BitmapFactory.decodeByteArray(imageAr,0,imageAr.length,options);

                //imageView.setImageBitmap(bmp);
                bitmap = bmp;

                //ObjectInputStream ois = new ObjectInputStream(s.getInputStream());



                //DataInputStream dis = new DataInputStream(is);

                //int len = dis.read();
                /*while(true) {
                    byte[] data = new byte[345600];

                    //byte[] image = is.read(data);

                    /*try {
                        Object image = ois.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    InputStream is = s.getInputStream();

                    int n = is.read(data);

                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

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
                }*/

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

