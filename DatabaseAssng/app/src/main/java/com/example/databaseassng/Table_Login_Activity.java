package com.example.databaseassng;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Environment;
import android.os.Message;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by Sameer on 29/09/16.
 */
public class Table_Login_Activity extends AppCompatActivity {
    private static final String TAG = "Table_Login_Activity";

    EditText Name;
    EditText Pass;
    String Name_User;
    String Pass_User;
    Context l = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name = (EditText) findViewById(R.id.user_name);
        Pass= (EditText) findViewById(R.id.user_pass);

    }

    public void login(View view)
    {
        Toast.makeText(getBaseContext(),"Login in Progress Please Wait",Toast.LENGTH_SHORT).show();
        Name_User = Name.getText().toString();
        Pass_User = Pass.getText().toString();
        SqliteTableDatabase n = new SqliteTableDatabase(l);
        Cursor l2 = n.login_info(n);
        l2.moveToFirst();
        boolean stat = false;
        String N_Stat = "";
        do {
            if(Name_User.equals(l2.getString(0))&&(Pass_User.equals(l2.getString(3))))
            {
                stat = true;
                N_Stat = l2.getString(0);

            }
        }while (l2.moveToNext());
        if(stat)
        {
            Toast.makeText(getBaseContext(),"Successfully Logged in\n Welcome "+Name_User,Toast.LENGTH_SHORT).show();
            finish();

        }
        else
        {
            Toast.makeText(getBaseContext(),"Login Failed",Toast.LENGTH_SHORT).show();
            finish();
        }


    }


    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

}
