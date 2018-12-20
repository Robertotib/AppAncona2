package com.example.test.appancona.Database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyDBHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static File DB_PATH;

    private static String DB_NAME = "ancona.sql";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public MyDBHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = myContext.getDatabasePath(DB_NAME);
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        return DB_PATH.exists();
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{
        AssetManager assetManager = myContext.getAssets();
        BufferedReader reader = null;
        StringBuilder stringB = new StringBuilder();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(myContext.getAssets().open(DB_NAME), "UTF-8"));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                stringB.append(mLine);
            }
        } catch (IOException e) {
            new Error("IMPOSSIBILE APRIRE IL FILE");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    new Error("IMPOSSIBILE CHIUDERE IL FILEREADER");
                }
            }
        }
        String sql = stringB.toString();
        String [] comandi = sql.split(";");
        SQLiteDatabase db = getReadableDatabase();
        for (int i=0;i < comandi.length;i++)
        {
            db.execSQL(comandi[i]);

        }


    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH.getPath();
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.

}