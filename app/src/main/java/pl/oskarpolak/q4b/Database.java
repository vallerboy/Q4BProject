package pl.oskarpolak.q4b;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by O on 2016-08-23.
 */
public class Database extends SQLiteOpenHelper{


    public Database(Context context) {
        super(context, "links.db", null, 1);

        //SharedPreferences for check if app is running for first time

        SharedPreferences settings = context.getSharedPreferences("firstRun", 0);
        if (settings.getBoolean("firstRun", true)) {
            settings.edit().putBoolean("firstRun", false).commit();
            loadFakeLinks();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE links(id integer primary key autoincrement, link text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addLink(String link) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues value =  new ContentValues();
        value.put("link", link);
        database.insertOrThrow("links", null, value);
    }

    public Cursor getAllLinks(){
        String[] colums =  {"id","link"};
        return getReadableDatabase().query("links", colums, null, null, null, null, null);
    }

    // debug function
    private void loadFakeLinks(){
        List<String> links =  new ArrayList<String>(20);
        links.add("http://i.imgur.com/DvpvklR.png");
        links.add("http://i.imgur.com/DvpvklR.png");
        links.add("http://i.imgur.com/DvpvklR.png");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");
        links.add("http://vader.joemonster.org/upload/rvc/l_15204943d3a7b0ddaily_picdump_2115_6.jpg");

        for(String s : links){
            addLink(s);
        }
    }
}
