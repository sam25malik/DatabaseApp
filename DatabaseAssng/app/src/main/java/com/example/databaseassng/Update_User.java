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
 * Created by Sameer on 30/09/16.
 */
public class Update_User extends AppCompatActivity{

    String name_user;
    String name_pass;
    String new_name_user;
    EditText newusername;
    Button on_update;
    Context t_x=this;

    SqliteTableDatabase p_x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Bundle l_n = getIntent().getExtras();
        name_user = l_n.getString("name_user");
        name_pass = l_n.getString("pass_user");
        on_update = (Button) findViewById(R.id.update_button);
        newusername = (EditText) findViewById(R.id.update_user);

        on_update.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick (View v)
        {
            new_name_user = newusername.getText().toString();
            p_x = new SqliteTableDatabase(t_x);
            p_x.user_update(p_x,name_user, name_pass, new_name_user);
            Toast.makeText(getBaseContext(), "Username Updated Successfully", Toast.LENGTH_SHORT).show();
            finish();

        }
    });


    }

    /*public Update_User(View view)
    {
        new_name_user = newusername.getText().toString();
        p_x = new SqliteTableDatabase(t_x);
        p_x.user_update(p_x,name_user,name_pass,new_name_user);
        Toast.makeText(getBaseContext(),"Username Updated Successfully",Toast.LENGTH_SHORT).show();
        finish();

    }*/

}
