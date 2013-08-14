package com.example.mwe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper{

	public static final String VERITABANI_ADI ="mwe.db";
	public static final int SURUM=1;
	public Veritabani(Context c){
		super(c,VERITABANI_ADI,null,SURUM);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE ayetler(id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, ayet TEXT,sayfa TEXT);");
		db.execSQL("INSERT INTO ayetler VALUES(2,'aaaaa','bbbb');");
		db.close();

	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
}
