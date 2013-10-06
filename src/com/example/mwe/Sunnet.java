package com.example.mwe;

import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Sunnet extends Activity {
	private static String SAMPLE_TABLE_NAME = "sunnetler";
	private SQLiteDatabase sampleDB;
	public int i ;
	TextView t1;
	
	Button b1;
	
	
	private void createTable()
	{
	   sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + SAMPLE_TABLE_NAME +
               " (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, sunnet VARCHAR);");   
	}
	
	
	
	
	private void seedata( int i){
		t1 = (TextView)findViewById(R.id.textView1);
		Typeface font_tV=Typeface.createFromAsset(getAssets(), "font/SANFW___.ttf");
		
		Cursor cursor = sampleDB.rawQuery("SELECT * FROM " + SAMPLE_TABLE_NAME, null);
		
			if (cursor != null)
			{
			   cursor.moveToPosition(i);
			
			
			       String sunnet = cursor.getString(cursor.getColumnIndex("sunnet"));
			      
			       
			      
			       t1.setText(sunnet);
			       t1.setTypeface(font_tV);
			      
			       
			       cursor.close();
			}
	   
	}
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sunnet);
		
		
		sampleDB = openOrCreateDatabase("mwe.db", MODE_PRIVATE, null);
        createTable();
        
        Date IlkGun=new GregorianCalendar(2013,7,9,00,00).getTime();
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
