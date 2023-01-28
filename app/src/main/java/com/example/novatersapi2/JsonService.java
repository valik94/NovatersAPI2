package com.example.novatersapi2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class  JsonService {
    //used for all json parsing
    static ArrayList<Print> fromJSONToList(String jsonString){
        ArrayList<Print> list = new ArrayList<>(0);
        //We know that our starting JSON structure is of type JSON Array
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
//            JSONObject jsonObject = new JSONObject((Map) jsonArray);

            for (int i =0 ; i<jsonArray.length(); i++){

               Log.d("Prints_App",jsonArray.getString(i));
                list.add(new Print(jsonArray.getString(i))); //add Print objects to the Print List full of print objects

               //now attempt to convert/parse to printObject not String data type.
//               Object JSONObject = jsonArray.getString(i);
//               Log.d("Inside object",JSONObject.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
