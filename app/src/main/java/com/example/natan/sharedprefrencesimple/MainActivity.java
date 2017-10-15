package com.example.natan.sharedprefrencesimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    EditText Name;
            EditText Email;
    Button Save;

    Button Retrive;
    Button Clear;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String NameKey = "nameKey";
    public static final String EmailKey = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);


        Name= (EditText) findViewById(R.id.name);
        Email= (EditText) findViewById(R.id.email);
        Save= (Button) findViewById(R.id.save);
        Retrive= (Button) findViewById(R.id.retrive);
        Clear= (Button) findViewById(R.id.clear);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(NameKey)) {
            Name.setText(sharedpreferences.getString(NameKey, ""));
        }
        if (sharedpreferences.contains(EmailKey)) {
            Email.setText(sharedpreferences.getString(EmailKey, ""));

        }

    }

    public void save(View view)
    {
        String n=Name.getText().toString();
        String e=Email.getText().toString();
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putString(NameKey,n);
        editor.putString(EmailKey,e);
        editor.commit();


    }
}
