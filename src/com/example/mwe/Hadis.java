package com.example.mwe;

import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Hadis extends Activity {
	
	private static String SAMPLE_TABLE_NAME = "hadisler";
	private SQLiteDatabase sampleDB;
	public int i ;
	TextView t1;
	TextView t2;
	Button b1;
	
	
	private void createTable()
	{
	   sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + SAMPLE_TABLE_NAME +
               " (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, hadis VARCHAR," +
               " sayfa VARCHAR);");   
	}
	
	
	
	
	private void seedata( int i){
		t1 = (TextView)findViewById(R.id.textView1);
		t2 = (TextView)findViewById(R.id.textView2);
		Cursor cursor = sampleDB.rawQuery("SELECT * FROM " + SAMPLE_TABLE_NAME, null);
		
			if (cursor != null)
			{
			   cursor.moveToPosition(i);
			
			
			       String hadis = cursor.getString(cursor.getColumnIndex("hadis"));
			       String sayfa = cursor.getString(cursor.getColumnIndex("sayfa"));
			       
			      
			       t1.setText(hadis);
			       t2.setText(sayfa);
			       
			       cursor.close();
			}
	   
	}
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hadis);
		
		
		sampleDB = openOrCreateDatabase("mwe.db", MODE_PRIVATE, null);
        createTable();
        
        Date IlkGun=new GregorianCalendar(2013,6,27,00,00).getTime();
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



