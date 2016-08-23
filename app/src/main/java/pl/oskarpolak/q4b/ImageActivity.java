package pl.oskarpolak.q4b;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends Activity implements View.OnClickListener {

    private ImageView bigImage;
    private ImageView  closeBigImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        bigImage = (ImageView) findViewById(R.id.bigImage);
        closeBigImage = (ImageView) findViewById(R.id.closeBigImage);
        closeBigImage.setOnClickListener(this);

        Picasso.with(this).load(getIntent().getExtras().getString("url")).into(bigImage);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

    }
}
