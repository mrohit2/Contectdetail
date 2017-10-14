package com.example.rohit.contectdetail;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addContact_bn,viewContact_bn,search_contact_bn,delete_contact_bn,update_contact_bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addContact_bn=(Button)findViewById(R.id.add_contact_bn);
        viewContact_bn=(Button)findViewById(R.id.View_contact_bn);
        search_contact_bn=(Button)findViewById(R.id.search_contact_bn);
        delete_contact_bn=(Button)findViewById(R.id.delete_contact_bn);
        update_contact_bn=(Button)findViewById(R.id.update_contact_bn);

        addContact_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getApplicationContext(),NewContactActivity.class);
                startActivity(intent);

            }
        });

        viewContact_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getApplicationContext(),DataListActitvity.class);
                startActivity(intent);

            }
        });

        search_contact_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getApplicationContext(),Search_Activity.class);
                startActivity(intent);

            }
        });

        delete_contact_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),DeleteActitvity.class);
                startActivity(intent);

            }
        });


        update_contact_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getApplicationContext(),UpdateActivity.class);
                startActivity(intent);

            }
        });

    }






}
