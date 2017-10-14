package com.example.rohit.contectdetail;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText search_edtx,name_etx_view,mob_etx_view,email_etx_view;
    Button search_button,update_button;
    String search_name;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    LinearLayout update_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);
        search_edtx=(EditText)findViewById(R.id.search_edtx);
        name_etx_view=(EditText)findViewById(R.id.name_etx_view);
        mob_etx_view=(EditText)findViewById(R.id.mob_etx_view);
        email_etx_view=(EditText)findViewById(R.id.email_etx_view);

        search_button=(Button)findViewById(R.id.search_button);

        update_button=(Button)findViewById(R.id.update_button);
       update_form=(LinearLayout)findViewById(R.id.update_form);
        update_form.setVisibility(View.GONE);




        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                search_name=search_edtx.getText().toString();
                userDbHelper =new UserDbHelper(getApplicationContext());
                sqLiteDatabase=userDbHelper.getReadableDatabase();
                Cursor cursor=userDbHelper.getInformationContact(search_name,sqLiteDatabase);

                if(cursor.moveToFirst())
                {   String NAME=search_name;
                    String MOBILE =cursor.getString(0);
                    String EMAIL=cursor.getString(1);
                    name_etx_view.setText(NAME);
                    mob_etx_view.setText(MOBILE);
                    email_etx_view.setText(EMAIL);
                    update_form.setVisibility(View.VISIBLE);

                }




            }
        });


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDbHelper =new UserDbHelper(getApplicationContext());
                sqLiteDatabase=userDbHelper.getWritableDatabase();
                String name1,mobile,email;

                name1=name_etx_view.getText().toString();
                mobile=mob_etx_view.getText().toString();
                email=email_etx_view.getText().toString();
               int count= userDbHelper.UpdateContact(search_edtx.getText().toString(),name1,mobile,email,sqLiteDatabase);

                Toast.makeText(getApplicationContext(),count+"Contact updated", Toast.LENGTH_LONG).show();
                finish();

            }
        });

    }
}
