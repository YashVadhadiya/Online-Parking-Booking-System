package com.example.dell.sampleregistration;
/**
 * Created by DELL on 3/5/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class MainDataBaseAdapter {
    static final String DATABASE_NAME = "parking.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database

    int valid=0;
    static final String DATABASE_CREATE = "create table "+"PARKING"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,EMAILID text,PHONENO text,VALIDID text); ";
    // Variable to hold the database instance
    public  SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper1 dbHelper;
    public  MainDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper1(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  MainDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userName,String phoneno,String email)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME",userName);
        newValues.put("PHONENO",phoneno);
        newValues.put("EMAILID",email);
        valid++;
        String ss=Integer.toString(valid);
         newValues.put("VALIDID",ss);
        // Insert the row into your table
        db.insert("PARKING", null, newValues);
        Toast.makeText(context, "The Data inserted in PARKING TABLE", Toast.LENGTH_LONG).show();
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public void printdata(String userName)
    {
        Cursor cursor = db.query("PARKING", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            Toast.makeText(context, "NOT EXIST EMAIL ID", Toast.LENGTH_LONG).show();
        }
        cursor.moveToFirst();
        String Email = cursor.getString(cursor.getColumnIndex("EMAILID"));
        String Phoneno=cursor.getString(cursor.getColumnIndex("PHONENO"));
        String ValidId=cursor.getString(cursor.getColumnIndex("VALIDID"));

        Toast.makeText(context, "EMAIL ID is"+Email, Toast.LENGTH_LONG).show();
        Toast.makeText(context, "PHONE NO IS"+Phoneno, Toast.LENGTH_LONG).show();
        Toast.makeText(context, "Valid id is"+ValidId, Toast.LENGTH_LONG).show();
        cursor.close();
    }
    public int deleteEntry(String UserName)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("PARKING", where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getEmail(String userName)
    {
        try {

            Cursor cursor = db.query("PARKING", null, " USERNAME=?", new String[]{userName}, null, null, null);
            if (cursor.getCount() < 1) // UserName Not Exist
            {
                cursor.close();
                return "NOT EXIST";
            }
            cursor.moveToFirst();
            String email = cursor.getString(cursor.getColumnIndex("EMAILID"));
            cursor.close();
            return email;
        }
        catch(Exception ex)
        {
            return "ERROR OCCURED";
        }
    }
    public String getPhoneno(String userName)
    {
        Cursor cursor=db.query("PARKING", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String email= cursor.getString(cursor.getColumnIndex("PHONENO"));
        cursor.close();
        return email;
    }
    public String getValidid(String userName)
    {
        Cursor cursor=db.query("PARKING", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String email= cursor.getString(cursor.getColumnIndex("VALIDID"));
        cursor.close();
        return email;
    }
    public void  updateEntry(String userName,String phoneno,String email)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PHONENO",phoneno);
        updatedValues.put("EMAILID",email);
        String where="USERNAME = ?";
        db.update("PARKING",updatedValues, where, new String[]{userName});
    }
}