package org.kasapbasi.week20190602;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


     class DownloadTask extends AsyncTask<String,Void,String>{

         @Override
         protected void onCancelled() {
             super.onCancelled();
         }

         @Override
         protected void onCancelled(String s) {
             super.onCancelled(s);
         }

         @Override
         protected void onProgressUpdate(Void... values) {
             super.onProgressUpdate(values);
         }

         @Override
         protected void onPostExecute(String s) {
             super.onPostExecute(s);
         }

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
         }

         @Override
         protected String doInBackground(String... strings) {


             StringBuilder sb= new StringBuilder("");
             String str="";
             HttpURLConnection con;
             URL url ;
int data;
             for(String s:strings) {
                 try {
                     url= new URL(s);
                     con=(HttpURLConnection)url.openConnection();
                     str+="**************************************\n";

                     InputStream is= con.getInputStream();
                     InputStreamReader reader=  new InputStreamReader(is);

                     data=reader.read();
                     while(data!=-1){
                            char c= (char)data;
                           str+=c;
                          data= reader.read();
                     }



                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             //    Log.i("URL", s);

             }
             return  str;
         }


     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask dt= new DownloadTask();
        String result=null;
        try {
          result= dt.execute("https://www.ticaret.edu.tr/").get();


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("Result", result);
    }
}
