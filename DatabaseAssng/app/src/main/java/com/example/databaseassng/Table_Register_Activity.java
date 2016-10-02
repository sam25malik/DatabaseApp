package com.example.databaseassng;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sameer on 29/09/16.
 */
public class Table_Register_Activity extends AppCompatActivity {
    private static final String TAG = "Table_Register_Activity";

    String reg_name;
    String reg_roll;
    String reg_sem;
    String reg_pass;
    String reg_pass_sure;

    EditText REG_NAME;
    EditText REG_ROLL;
    EditText REG_SEM;
    EditText REG_PASS;
    EditText REG_PASS_SURE;

    Context object= this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        REG_NAME = (EditText) findViewById(R.id.edit_name);
        REG_ROLL = (EditText) findViewById(R.id.edit_roll);
        REG_SEM = (EditText) findViewById(R.id.edit_sem);
        REG_PASS = (EditText) findViewById(R.id.edit_pass);
        REG_PASS_SURE = (EditText) findViewById(R.id.edit_pass_con);

    }

    public void register(View v)
    {
        reg_name = REG_NAME.getText().toString();
        reg_roll = REG_ROLL.getText().toString();
        reg_sem =  REG_SEM.getText().toString();
        reg_pass = REG_PASS.getText().toString();
        reg_pass_sure = REG_PASS_SURE.getText().toString();

        if(!(reg_pass.equals(reg_pass_sure)))
        {
            Toast.makeText(getBaseContext(),"Passwords Did not Match",Toast.LENGTH_SHORT).show();
            REG_PASS.setText("");
            REG_PASS_SURE.setText("");
        }
        else
        {
            SqliteTableDatabase obj =  new SqliteTableDatabase(object);
            obj.add_info(obj,reg_name,reg_roll,reg_sem,reg_pass);
            Toast.makeText(getBaseContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
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
