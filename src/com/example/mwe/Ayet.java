package com.example.mwe;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ayet extends Activity {
	
	
	private static String SAMPLE_TABLE_NAME = "ayetler";
	private SQLiteDatabase sampleDB;
	TextView t1;
	TextView t2;
	Button b1;
	
	
	private void createTable()
	{
	   sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + SAMPLE_TABLE_NAME +
               " (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, ayet VARCHAR," +
               " sayfa VARCHAR);");   
	}
	
	private void insertData()
	{
	    sampleDB.execSQL("INSERT INTO " +
                SAMPLE_TABLE_NAME +
                " Values (8,'aaaaa','bbbb');");
	}
	
	private void seedata(){
		t1 = (TextView)findViewById(R.id.ayet1);
		Cursor cursor = sampleDB.rawQuery("SELECT ayet FROM " + SAMPLE_TABLE_NAME, null);

		if (cursor != null)
		{
		   cursor.moveToFirst();
		
		
		       String personName = cursor.getString(cursor.getColumnIndex("ayet"));
		       t1.setText(personName);
		       
		       cursor.close();
			}
	}
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayet);
		
		
		t2 = (TextView)findViewById(R.id.sayfa2);
		
		sampleDB = openOrCreateDatabase("mwe.db", MODE_PRIVATE, null);
        createTable();
        seedata();
        
		
			
			
		
		
	}
	
	

}
