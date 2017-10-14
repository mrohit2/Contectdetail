package com.example.rohit.contectdetail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rohit on 10/6/2017.
 */

public class UserDbHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int VERSION=1;
    private static final String CREATE_QUERY="CREATE TABLE "+ UserContact.NewUserInfo.TABLE_NAME+"("+ UserContact.NewUserInfo.USER_NAME+" TEXT,"+
            UserContact.NewUserInfo.USER_MOB+" TEXT,"+ UserContact.NewUserInfo.USER_EMAIL+" TEXT);";


      public UserDbHelper(Context context){

          super(context,DATABASE_NAME,null,VERSION);
          Log.e("DATABASE OPERATIONS","database created/opened...");
      }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DATABASE OPERATIONS","inside top of oncreate in UderdbHandler...");

        db.execSQL(CREATE_QUERY);
          Log.e("DATABASE OPERATIONS","table created/opened...");


    }

    public void addInformations(String name , String mob , String email, SQLiteDatabase db){

        Log.e("DATABASE OPERATIONS","inside the addInformation funtion...");

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContact.NewUserInfo.USER_MOB,mob);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContact.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","one raw inserted...");




    }

    public Cursor getInformation(SQLiteDatabase db) {

        Cursor cursor;

        String[] projections = {UserContact.NewUserInfo.USER_NAME, UserContact.NewUserInfo.USER_MOB, UserContact.NewUserInfo.USER_EMAIL};
        cursor=db.query(UserContact.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);

        return cursor;
    }

    public Cursor getInformationContact(String user_name,SQLiteDatabase sqLiteDatabase){

        Cursor cursor;
        String[] projections = { UserContact.NewUserInfo.USER_MOB, UserContact.NewUserInfo.USER_EMAIL};
        String Selections =UserContact.NewUserInfo.USER_NAME+" LIKE ?";
        String[] Selection_args ={user_name};
        cursor=sqLiteDatabase.query(UserContact.NewUserInfo.TABLE_NAME,projections,Selections,Selection_args,null,null,null);

        return cursor;
    }

    public void  DeleteInformation(String user_name,SQLiteDatabase sqLiteDatabase)
      {
             String seclection = UserContact.NewUserInfo.USER_NAME+" LIKE ?";
          String[] Selection_args ={user_name};
            sqLiteDatabase.delete(UserContact.NewUserInfo.TABLE_NAME,seclection,Selection_args);

      }


      public int UpdateContact(String old_name,String new_name,String new_mobile,String new_email,SQLiteDatabase sqLiteDatabase)
        {
           ContentValues contentValues = new ContentValues();
            contentValues.put(UserContact.NewUserInfo.USER_NAME,new_name);
            contentValues.put(UserContact.NewUserInfo.USER_MOB,new_mobile);
            contentValues.put(UserContact.NewUserInfo.USER_EMAIL,new_email);
            String seclection = UserContact.NewUserInfo.USER_NAME+" LIKE ?";
            String[] Selection_args ={old_name};
           int count= sqLiteDatabase.update(UserContact.NewUserInfo.TABLE_NAME,contentValues,seclection,Selection_args);

         return count;
        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
