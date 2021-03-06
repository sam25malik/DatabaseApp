package com.example.databaseassng;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sameer on 28/09/16.
 */

public class StoreActivity extends AppCompatActivity {

    private static final String TAG = "StoreActivity";

    EditText Name;
    EditText Email;
    TextView Print;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Name = (EditText) findViewById(R.id.edit_Name);
        Email = (EditText) findViewById(R.id.edit_con1);
        Print = (TextView)findViewById(R.id.textViewer);


       /* if (savedInstanceState != null) {
           // savedInstanceState.putString("Name", Name.getText().toString());
            //savedInstanceState.putString("Email", Email.getText().toString());

            savedInstanceState.putString("str3", Print.getText().toString());

        }*/

    }

    public void Save(View view)
    {
        SharedPreferences shared1 = getSharedPreferences("student", Context.MODE_PRIVATE);
        SharedPreferences.Editor editshared1 = shared1.edit();
        editshared1.putString("Name",Name.getText().toString());
        editshared1.putString("Email",Email.getText().toString());
        editshared1.apply();
        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show();

    }

    public void Display(View view)
    {
        SharedPreferences shared1 = getSharedPreferences("student", Context.MODE_PRIVATE);
        String str1 = shared1.getString("Name","");
        String str2 = shared1.getString("Email","");
        String str3 = "Name: " +str1+ "\nEmail: " + str2;
        Print.setText(str3);



    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putString("Name", Name.getText().toString());
        //savedInstanceState.putString("Email", Email.getText().toString());
        //savedInstanceState.putString("str1", str1.getText().toString());
        //savedInstanceState.putString("str2", str2.getText().toString());

        savedInstanceState.putString("str3", Print.getText().toString());
        }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        //Name.setText(savedInstanceState.getString("Name"));
        //Email.setText(savedInstanceState.getString("Email"));

        Print.setText(savedInstanceState.getString("str3"));
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
