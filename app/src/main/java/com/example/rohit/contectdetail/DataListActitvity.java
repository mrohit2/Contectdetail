package com.example.rohit.contectdetail;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActitvity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    DataProvider dataProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        listView=(ListView)findViewById(R.id.data_list_view);
        listDataAdapter =new ListDataAdapter(getApplicationContext(),R.layout.rawlayout);
        listView.setAdapter(listDataAdapter);

        userDbHelper= new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        cursor=userDbHelper.getInformation(sqLiteDatabase);

        if(cursor.moveToFirst())
        {

            do
             { String name,mob,email;
                 name=cursor.getString(0);
                 mob=cursor.getString(1);
                 email=cursor.getString(2);
                 dataProvider = new DataProvider(name,mob,email);
                 listDataAdapter.add(dataProvider);


              } while (cursor.moveToNext());
        }
    }
}
