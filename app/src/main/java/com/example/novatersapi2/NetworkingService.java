package com.example.novatersapi2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingService {
    //fetch all prints
    //fetch url in one print
    //because we don't know when the task (query & fetch) will be completed, we must use an interface
    interface NetworkingListener{
        void gettingJsonIsCompleted(String json);
    }
    NetworkingListener listener;
Handler handler = new Handler(Looper.getMainLooper());
//https
    //str1="https://api.data.gov/nih/3dprint/model/1.0/model_single.json?model_id"
    // str2="000914" //this varies
    // str3="&api_key=mtdhDKzNRYbGrmAltyeEuswijhID4qd8JahyJARF" //APIkey is fixed
    // printURLString =str1+str2+str3
    String str1 = "https://api.data.gov/nih/3dprint/model/1.0/model_single.json?model_id=";
    String printID = "000914"; //this print id varies at least 6 digits
    String APIKey = "&api_key=mtdhDKzNRYbGrmAltyeEuswijhID4qd8JahyJARF"; //API_KEY
    String printURLString = str1+printID+APIKey;

void getAllPrints(String printName){ //minimum length of characters search is 3
    String fullString = str1 + printName + APIKey;

    MyApp.executorService.execute(new Runnable() {
        @Override
        public void run() {
            try {
                int value = 0;
                URL url = new URL(fullString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                StringBuffer buffer = new StringBuffer();
                while ((value = in.read()) != -1){
                    buffer.append((char)value);
                }
                Log.d("Novaters App", buffer.toString());

                //the json content is ready to returned back
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //main thread
                        listener.gettingJsonIsCompleted(buffer.toString());

                    }
                });


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });



    }

}
