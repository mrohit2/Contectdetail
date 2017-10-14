package com.example.rohit.contectdetail;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rohit on 10/7/2017.
 */

public class NewContactActivity extends AppCompatActivity{
    EditText ContactName, ContactMob, ContactEmail;
    Button SaveContact;
    Context context =this;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);

        ContactName=(EditText) findViewById(R.id.name_edittext);
        ContactMob=(EditText) findViewById(R.id.mob_edittext);
        ContactEmail=(EditText) findViewById(R.id.email_editText);
        SaveContact=(Button)findViewById(R.id.Save_detail);


        SaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name =ContactName.getText().toString();
                String mob  =ContactMob.getText().toString();
                String email =ContactEmail.getText().toString();

                userDbHelper =new UserDbHelper(context);
                sqLiteDatabase= userDbHelper.getWritableDatabase();
                userDbHelper.addInformations(name,mob,email,sqLiteDatabase);

                Toast.makeText(getBaseContext(),"data saved ",Toast.LENGTH_LONG).show();
                userDbHelper.close();
                finish();


            }
        });




    }


}
