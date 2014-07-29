package com.example.clothingstore.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ShirtDataSource {

	// Database fields
	private SQLiteDatabase database;
	private ShirtHelper dbHelper;
	private String[] allColumns = {
			                        ShirtHelper.COLUMN_ID,
			                        ShirtHelper.COLUMN_DESCRIPTION,
			                        ShirtHelper.COLUMN_PRICE,
			                        ShirtHelper.COLUMN_STOCK,
			                        ShirtHelper.COLUMN_COLOR
			                       };

	public ShirtDataSource(Context context) {
		dbHelper = new ShirtHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Shirt cursorToShirt(Cursor cursor) {
		Shirt shirt = new Shirt();
		shirt.setID(cursor.getLong(0));
		shirt.setDescription(cursor.getString(1));
		shirt.setPrice(cursor.getDouble(2));
		shirt.setQuantityInStock(cursor.getInt(3));
		shirt.setColorcode(cursor.getString(4).charAt(0));
		return shirt;
	}
	
	public Shirt createShirt(String description, double price, int stock, char colorCode) {
		String color = ""+ colorCode;
		ContentValues values = new ContentValues();
		values.put(ShirtHelper.COLUMN_DESCRIPTION, description);
		values.put(ShirtHelper.COLUMN_PRICE, price);
		values.put(ShirtHelper.COLUMN_STOCK, stock);
		values.put(ShirtHelper.COLUMN_COLOR, color);
		long insertId = database.insert(ShirtHelper.TABLE_SHIRTS, null,
				values);
		// To show how to query
		Cursor cursor = database.query(ShirtHelper.TABLE_SHIRTS,
				allColumns, ShirtHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		return cursorToShirt(cursor);
	}
	
	public void updateShirt(long id, String description, double price, int stock, char colorCode) {
		ContentValues values = new ContentValues();
		values.put(ShirtHelper.COLUMN_DESCRIPTION, description);
		values.put(ShirtHelper.COLUMN_PRICE, price);
		values.put(ShirtHelper.COLUMN_STOCK, stock);
		//String strFilter = "_id=" + id;
		String strFilter = ShirtHelper.COLUMN_ID+id;
		database.update(ShirtHelper.TABLE_SHIRTS, values, strFilter, null);
	}

	public void deleteShirt(long id) {
		//long id = shirt.getID();
		//System.out.println("Producto eliminado con el ID: " + id);
		database.delete(ShirtHelper.TABLE_SHIRTS, ShirtHelper.COLUMN_ID
				+ " = " + id, null);
	}
/**
 * Recupero todos los Shirts
 * @return
 */
	public List<Shirt> getAllShirt() {
		List<Shirt> shirts = new ArrayList<Shirt>();
		Cursor cursor = database.query(ShirtHelper.TABLE_SHIRTS,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Shirt shirt = cursorToShirt(cursor);
			shirts.add(shirt);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return shirts;
	}
	
	public Cursor getAllShirt2() {
		Cursor mCursor = database.query(ShirtHelper.TABLE_SHIRTS,
				allColumns, null, null, null, null, null);
		if (mCursor != null) {
			   mCursor.moveToFirst();
			  }
		return mCursor;
	}
	
	public Shirt getShirtsById(long id) {
		
		String strFilter = "_id= " + id + " ";
		Cursor cursor = database.query(ShirtHelper.TABLE_SHIRTS,
				allColumns, strFilter, null, null, null, null);
		cursor.moveToFirst();
	    
		Shirt shirt = cursorToShirt(cursor);

		// Make sure to close the cursor
		cursor.close();
		return shirt;
	}
}