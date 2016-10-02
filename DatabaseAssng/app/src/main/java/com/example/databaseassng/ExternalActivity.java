package com.example.databaseassng;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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

public class ExternalActivity extends AppCompatActivity {
    private static final String TAG = "ExternalActivity";

    EditText Summary;
    TextView Output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        Summary = (EditText) findViewById(R.id.edit_summary);
        Output = (TextView)findViewById(R.id.textViewer_sum);

    }

    public void store_external_summary(View view)
    {
        String instace;
        instace = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(instace))
        {
            File exter_stor = Environment.getExternalStorageDirectory();
            File exter_d = new File(exter_stor.getAbsolutePath()+"/DatabaseFiles");
            if(!exter_d.exists()) {
                exter_d.mkdir();
            }

            File store = new File(exter_d,"databaseApp.txt");
            String string = Summary.getText().toString();

            try {
                FileOutputStream foStr = new FileOutputStream(store);
                foStr.write(string.getBytes());
                foStr.close();
                Summary.setText("");
                Toast.makeText(getApplicationContext(),"Saved to SD Card",Toast.LENGTH_SHORT).show();


            }

            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
        else
        {
            Toast.makeText(getApplicationContext(),"No SD Card Available",Toast.LENGTH_SHORT).show();

        }


    }

    public void read_external_summary(View view)
    {
        File exter_stor = Environment.getExternalStorageDirectory();
        File exter_d = new File(exter_stor.getAbsolutePath()+"/DatabaseFiles");
        File store = new File(exter_d,"databaseApp.txt");
        String string;
        try{
            FileInputStream fiStr = new FileInputStream(store);
            InputStreamReader isr = new InputStreamReader(fiStr);
            BufferedReader bR = new BufferedReader(isr);
            StringBuffer stringBuffer = new StringBuffer();

            while((string=bR.readLine())!=null)
            {
                stringBuffer.append(string +"\n");

            }
            Summary.setText(stringBuffer.toString());
            Summary.setVisibility(View.VISIBLE);

        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putString("Name", Name.getText().toString());
        //savedInstanceState.putString("Email", Email.getText().toString());
        //savedInstanceState.putString("str1", str1.getText().toString());
        //savedInstanceState.putString("str2", str2.getText().toString());

        savedInstanceState.putString("str3", Output.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        //Name.setText(savedInstanceState.getString("Name"));
        //Email.setText(savedInstanceState.getString("Email"));
        Output.setText(savedInstanceState.getString("str3"));
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this,"landscape",Toast.LENGTH_SHORT).show();

        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Toast.makeText(this,"portrait",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
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

