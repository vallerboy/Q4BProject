package pl.oskarpolak.q4b;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.squareup.picasso.Picasso;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ScrollView scrollView;
    private LinearLayout columnFirst;
    private LinearLayout columnSecond;



    private Database database;

    private LinkedHashMap<Integer, String> images = new LinkedHashMap<Integer, String>(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        columnFirst = (LinearLayout) findViewById(R.id.firstColumn);
        columnSecond = (LinearLayout) findViewById(R.id.secondColumn);

        database = new Database(this);
        loadPicturesIntoViews();

    }



    private void loadPicturesIntoViews(){

         Cursor cursor = database.getAllLinks();

         while(cursor.moveToNext()) {
             images.put(cursor.getInt(0), cursor.getString(1));
             ImageView image = new ImageView(this);
             image.setOnClickListener(this);
             image.setTag(cursor.getInt(0));
             image.setPadding(20, 25, 20, 0);

             LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 600);

             if(cursor.getInt(0) > 10) {
                 columnSecond.addView(image,0,params);
             }else {
                 columnFirst.addView(image,0,params);
             }
             Picasso.with(this).load(cursor.getString(1)).fit().into(image);
         }
    }


    @Override
    public void onClick(View v) {
         Intent i = new Intent(this, ImageActivity.class);
         i.putExtra("url", images.get(v.getTag()));
         startActivity(i);
    }
}
