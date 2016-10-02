package com.example.databaseassng;


import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SqliteActivity extends AppCompatActivity {
    private static final String TAG = "SqliteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        Button b1 = (Button)findViewById(R.id.login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(SqliteActivity.this,Table_Login_Activity.class);
                startActivity(intent1);
            }
        });


        Button b2 = (Button)findViewById(R.id.register);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(SqliteActivity.this,Table_Register_Activity.class);
                startActivity(intent2);
            }
        });


        Button b3 = (Button)findViewById(R.id.update);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(SqliteActivity.this,Table_Update_Activity.class);
                startActivity(intent3);
            }
        });


        Button b4 = (Button)findViewById(R.id.delete);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(SqliteActivity.this,Table_Delete_Activity.class);
                startActivity(intent4);
            }
        });
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

