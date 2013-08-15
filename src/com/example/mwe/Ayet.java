package com.example.mwe;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ayet extends Activity {
	
	
	private static String SAMPLE_TABLE_NAME = "ayetler";
	private SQLiteDatabase sampleDB;
	public int i ;
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
	
	
	
	private void seedata( int i){
		t1 = (TextView)findViewById(R.id.ayet1);
		t2 = (TextView)findViewById(R.id.sayfa2);
		Cursor cursor = sampleDB.rawQuery("SELECT * FROM " + SAMPLE_TABLE_NAME, null);
		
			if (cursor != null)
			{
			   cursor.moveToPosition(i);
			
			
			       String ayet = cursor.getString(cursor.getColumnIndex("ayet"));
			       String sayfa = cursor.getString(cursor.getColumnIndex("sayfa"));
			       
			      
			       t1.setText(ayet);
			       t2.setText(sayfa);
			       
			       cursor.close();
			}
	   
	}
	
	
	 public int daysBetween(Date d1, Date d2){
		 
		 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	 
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayet);
		
		
		sampleDB = openOrCreateDatabase("mwe.db", MODE_PRIVATE, null);
        createTable();
        
        TimeZone tzTarget = TimeZone.getTimeZone("Europe/Istanbul"); 
        Calendar cal1 = Calendar.getInstance(tzTarget);
		Calendar cal2 = Calendar.getInstance(tzTarget);
		cal1.setTimeInMillis(System.currentTimeMillis());
		cal1.set(Calendar.HOUR, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal2.setTimeInMillis(System.currentTimeMillis());
		cal2.set(Calendar.YEAR,2013);
		cal2.set(Calendar.MONTH, 9);
		cal2.set(Calendar.DAY_OF_MONTH, 15);
		cal2.set(Calendar.HOUR, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		
		
		int sonuc = daysBetween(cal1.getTime(),cal2.getTime());
		
		
		if(sonuc >= 60){
			
			int bol = sonuc / 60 ;
			int carp = 60 * bol ;
			int son = sonuc - carp ;
			seedata(son);
		}
		
		else {
			
			seedata(sonuc);
		}
			
		


        
        
        
		
			
			
		
		
	}
	
	

}
