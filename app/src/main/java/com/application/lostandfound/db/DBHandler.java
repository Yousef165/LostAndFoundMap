package com.application.lostandfound.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.application.lostandfound.MainActivity;
import com.application.lostandfound.model.Location;
import com.application.lostandfound.model.LostAndFound;
import com.application.lostandfound.service.Delete;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "LostAndFoundDB";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "lostandfound";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our data name column
    private static final String NAME_COL = "name";

    // below variable id for our data duration column.
    private static final String PHONE_COL = "phone";

    // below variable for our data description column.
    private static final String DESCRIPTION_COL = "description";

    // below variable is for our data tracks column.
    private static final String DATE_COL = "date";
    // below variable is for our data name column
    private static final String  LOCATION_COL = "location";

    // below variable id for our data latitude column.
    private static final String LATITUDE_COL = "latitude";

    // below variable id for our data longitude column.
    private static final String LONGITUDE_COL = "longitude";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + LOCATION_COL + " TEXT,"
                + LATITUDE_COL + " TEXT,"
                + LONGITUDE_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new data to our sqlite database.
    public void addData(String Name, String Phone, String Description, String Date, String Location, String Latitude, String Longitude) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

            values.put(NAME_COL, Name);
            values.put(PHONE_COL, Phone);
            values.put(DESCRIPTION_COL, Description);
            values.put(DATE_COL, Date);
            values.put(LOCATION_COL, Location);
            values.put(LATITUDE_COL, Latitude);
            values.put(LONGITUDE_COL, Longitude);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the datas.
    public ArrayList<LostAndFound> readDatas() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorDatas = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<LostAndFound> LostAndFoundArrayList = new ArrayList<>();

        // printing a cursor count on logcat.
        System.out.println("Cursor Count " + cursorDatas.getCount());
        System.out.println("Cursor Count " + cursorDatas);

        // moving our cursor to first position.
        if (cursorDatas.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                LostAndFoundArrayList.add(new LostAndFound(
                        cursorDatas.getString(0),
                        cursorDatas.getString(1),
                        cursorDatas.getString(2),
                        cursorDatas.getString(3),
                        cursorDatas.getString(4),
                        cursorDatas.getString(5),
                        cursorDatas.getString(6),
                        cursorDatas.getString(7)));

            } while (cursorDatas.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorDatas.close();
        return LostAndFoundArrayList;
    }


    public List<LatLng> getLocations() {
        List<LatLng> locations = new ArrayList<>();

        // Retrieve data from SQLite using appropriate queries
        // Assuming you have a "locations" table with "latitude" and "longitude" columns
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, new String[]{LATITUDE_COL, LONGITUDE_COL}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                double latitude = Double.parseDouble(cursor.getString(0));
                double longitude = Double.parseDouble(cursor.getString(1));
                LatLng location = new LatLng(latitude, longitude);
                locations.add(location);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();

        return locations;
    }


    // delete data from database by id
    public void deleteData(String id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID_COL + " = ?", new String[]{id});
        db.close();

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
