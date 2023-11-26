package com.example.myusers;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDbAdapter {

    static class myDbHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "myDatabase";
        private static final String TABLE_NAME = "myTable";
        private static final int DATABASE_Version = 1;
        private static final String UID = "_id";
        private static final String NAME = "name";
        private static final String MyPASSWORD = "password";
        private static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME + " VARCHAR(255), " +
                        MyPASSWORD + " VARCHAR(255));";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context, "OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }
    }

    myDbHelper myhelper;

    public myDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
    }

    public String getData() {

        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.MyPASSWORD};

        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);

        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(cid + "  " + name + "  " + password + " \n");
        }
        return buffer.toString();
    }

    public long insertData(String name, String pass) {

        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);

        long id = db.insert(myDbHelper.TABLE_NAME, null, contentValues);
        return id;

    }

    public int updateName(String oldName, String newName) {

        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, newName);
        String[] whereArgs = {oldName};

        int count = db.update(myDbHelper.TABLE_NAME, contentValues, myDbHelper.NAME + " = ?", whereArgs);
        return count;
    }

    public int delete(String usrName) {

        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs = {usrName};

        int count = db.delete(myDbHelper.TABLE_NAME, myDbHelper.NAME + " = ?", whereArgs);
        return count;
    }
}
