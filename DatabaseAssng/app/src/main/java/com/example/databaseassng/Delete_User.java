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
public class Delete_User extends AppCompatActivity {


    String Name_User;
    EditText password;
    Bundle data_l;
    String PASSWORD;
    SqliteTableDatabase x_y;
    Context con_l=this;




 @Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_delete);
    password = (EditText) findViewById(R.id.del_pass);
    data_l = getIntent().getExtras();
    Name_User = data_l.getString("name_user");


}

    public void Delete_User(View v)
    {
        PASSWORD = password.getText().toString();
        x_y = new SqliteTableDatabase(con_l);
        Cursor con_l = x_y.login_pass(x_y,Name_User);
        con_l.moveToFirst();
        boolean status =  false;

        do{
            if(PASSWORD.equals(con_l.getString(0)))
            {
                status = true;

            }

        }while (con_l.moveToNext());
        if(status) {
            x_y.user_delete(x_y,Name_User,PASSWORD);
            Toast.makeText(getBaseContext(),"User Has Been Removed Successfully",Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(getBaseContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
            finish();
        }
    }



}
