package com.example.novatersapi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class PrintActivity extends AppCompatActivity
implements NetworkingService.NetworkingListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        if(getIntent().hasExtra("print")){
          Print p =   getIntent().getParcelableExtra("print");
            ((MyApp) getApplication()).networkingService.listener = this;
            //converting the print class from the parcelable returned into a String
            ((MyApp) getApplication()).networkingService.getAllPrints(p.toString()); }

    }

    @Override
    public void gettingJsonIsCompleted(String json) {
        Log.d("print-app", json);
    }
}