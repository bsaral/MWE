package com.example.mwe;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
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
               " (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, ayet VARCHAR," +
               " sayfa VARCHAR);");   
	}
	
	
	
	private void seedata( int i){
		Typeface font_tV=Typeface.createFromAsset(getAssets(), "font/SANFW___.ttf");
		t1 = (TextView)findViewById(R.id.ayet1);
		t2 = (TextView)findViewById(R.id.sayfa2);
		Cursor cursor = sampleDB.rawQuery("SELECT * FROM " + SAMPLE_TABLE_NAME, null);
		
			if (cursor != null)
			{
			   cursor.moveToPosition(i);
			
			
			       String ayet = cursor.getString(cursor.getColumnIndex("ayet"));
			       String sayfa = cursor.getString(cursor.getColumnIndex("sayfa"));
			       
			      
			       t1.setText(ayet);
			       t1.setTypeface(font_tV);
			       t2.setText(sayfa);
			       t2.setTypeface(font_tV);
			       
			       cursor.close();
			}
	   
	}
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayet);
		
		
		sampleDB = openOrCreateDatabase("mwe.db", MODE_PRIVATE, null);
        createTable();
        
        Date IlkGun=new GregorianCalendar(2013,7,21,00,00).getTime();
        Date SonGun=new Date();
        long Fark=SonGun.getTime()-IlkGun.getTime();
		
		int sonuc = (int) (Fark/(1000*60*60*24));
		
		
		 if(sonuc >= 60){
			
			int son = sonuc % 60;
			seedata(son);
		}
		
		else {
			
			seedata(sonuc);
		} 
			
	}
	
}
