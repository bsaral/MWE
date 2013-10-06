package com.example.mwe;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button ayet;
	Button hadis;
	Button sunnet;
	Button soz;
	Button isim;
	Button dua;
	DataBaseHelper myDbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		
	        myDbHelper = new DataBaseHelper(this);
	 
	        try {
	 
	        	myDbHelper.createDataBase();
	 
	 	} catch (IOException ioe) {
	 
	 		throw new Error("Unable to create database");
	 
	 	}
	 
	 	try {
	 
	 		myDbHelper.openDataBase();
	 
	 	}catch(SQLException sqle){
	 
	 		throw sqle;
	 
	 	}	 
		
		ayet = (Button)findViewById(R.id.ayet);
		ayet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.AYET"));
				
			}
		});
		
		hadis = (Button)findViewById(R.id.hadis);
		hadis.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.HADIS"));
				
			}
		});
		
		sunnet = (Button)findViewById(R.id.sunnet);
		sunnet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.SUNNET"));
				
			}
		});
		
		soz = (Button)findViewById(R.id.soz);
		soz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.SOZ"));
				
			}
		});
		
		isim = (Button)findViewById(R.id.isim);
		isim.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.ISIM"));
				
			}
		});
		
		dua = (Button)findViewById(R.id.dua);
		dua.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.DUA"));
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
