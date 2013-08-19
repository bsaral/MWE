package com.example.mwe;

import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Isim extends Activity {
	private static String SAMPLE_TABLE_NAME = "isimler";
	private SQLiteDatabase sampleDB;
	public int i ;
	TextView t1;
	TextView t2;
	TextView t3;
	TextView t4;
	Button b1;
	
	
	private void createTable()
	{
	   sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + SAMPLE_TABLE_NAME +
               " (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, girl VARCHAR," +
               " g_mean VARCHAR, boy VARCHAR, b_mean VARCHAR);");   
	}
	
	
	
	
	private void seedata( int i){
		t1 = (TextView)findViewById(R.id.textView1);
		t2 = (TextView)findViewById(R.id.textView2);
		t3 = (TextView)findViewById(R.id.textView3);
		t4 = (TextView)findViewById(R.id.textView4);
		Cursor cursor = sampleDB.rawQuery("SELECT * FROM " + SAMPLE_TABLE_NAME, null);
		
			if (cursor != null)
			{
			   cursor.moveToPosition(i);
			
			
			       String girl = cursor.getString(cursor.getColumnIndex("girl"));
			       String g_mean = cursor.getString(cursor.getColumnIndex("g_mean"));
			       String boy = cursor.getString(cursor.getColumnIndex("boy"));
			       String b_mean = cursor.getString(cursor.getColumnIndex("b_mean"));
			       
			      
			       t1.setText(girl);
			       t2.setText(g_mean);
			       t3.setText(boy);
			       t4.setText(b_mean);
			       
			       cursor.close();
			}
	   
	}
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.isim);
		
		
		sampleDB = openOrCreateDatabase("mwe.db", MODE_PRIVATE, null);
        createTable();
        
        Date IlkGun=new GregorianCalendar(2013,7,19,00,00).getTime();
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


