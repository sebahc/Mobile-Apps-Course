package com.example.clothingstore.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShirtHelper extends SQLiteOpenHelper {

	public static final String TABLE_SHIRTS = "shirts";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_PRICE = "price";
	public static final String COLUMN_STOCK = "stock";
	public static final String COLUMN_COLOR = "color";

	private static final String DATABASE_NAME = "Clothing";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_SHIRTS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, "
			+ COLUMN_DESCRIPTION + " text not null, "
			+ COLUMN_PRICE + "  real not null, "
			+ COLUMN_STOCK + " integer not null, "
			+ COLUMN_COLOR + " text not null "
			+ " );";

	public ShirtHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ShirtHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHIRTS);
		onCreate(db);
	}

}