package com.example.rohit.contectdetail;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;




public class DeleteActitvity extends AppCompatActivity {


    Button search_button,delete_bn;
    EditText Search_edtx,email_tx_view, mob_numer_tx_view,name_etx_view;
    LinearLayout update_form;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
        search_button = (Button) findViewById(R.id.search_button1);
        delete_bn = (Button) findViewById(R.id.delete_button);

        Search_edtx=(EditText)findViewById(R.id.search_edtx);
        name_etx_view=(EditText)findViewById(R.id.name_etx_view);
        email_tx_view = (EditText) findViewById(R.id.email_etx_view);
        mob_numer_tx_view = (EditText) findViewById(R.id.mob_etx_view);
        update_form=(LinearLayout)findViewById(R.id.update_form);

        update_form.setVisibility(View.INVISIBLE);



        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                search_name = Search_edtx.getText().toString();
                userDbHelper = new UserDbHelper(getApplicationContext());
                sqLiteDatabase = userDbHelper.getReadableDatabase();
                Cursor cursor = userDbHelper.getInformationContact(search_name, sqLiteDatabase);

                if (cursor.moveToFirst()) {
                    String NAME =search_name;
                    String MOBILE = cursor.getString(0);
                    String EMAIL = cursor.getString(1);
                    name_etx_view.setText(NAME);
                    mob_numer_tx_view.setText(MOBILE);
                    email_tx_view.setText(EMAIL);
                   update_form.setVisibility(View.VISIBLE);
                }


            }
        });


        delete_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDbHelper = new UserDbHelper(getApplicationContext());
                sqLiteDatabase = userDbHelper.getWritableDatabase();
                userDbHelper.DeleteInformation(search_name,sqLiteDatabase);
                Toast.makeText(getBaseContext(),"Contact deleted",Toast.LENGTH_LONG).show();

            }
        });





    }
}
