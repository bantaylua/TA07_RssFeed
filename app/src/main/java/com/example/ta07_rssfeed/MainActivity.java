package com.example.ta07_rssfeed;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    GridView gridView;
    TextView txtSoloMsg;
    ImageView imgSoloPhoto;
    Button btnSoloBack;
    Bundle myOriginalMemoryBundle;
    String[] items= {"Thanh Nien", "VnExpress", "Dan Tri", "Lao Dong", };
    Integer[] thumbnails = {R.drawable.logo_thanhnien, R.drawable.logo_vnexpress, R.drawable.logo_dantri,
    R.drawable.logo_laodong, };
    Integer[] largeImages = {R.drawable.logo_thanhnien, R.drawable.logo_vnexpress, R.drawable.logo_dantri,
            R.drawable.logo_laodong, };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOriginalMemoryBundle = savedInstanceState;

        gridView = (GridView) findViewById(R.id.gvNews);
        gridView.setAdapter(new MyImageAdapter(this, thumbnails));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               showBigScreen(position);
            }
        });
    }

    private void showBigScreen(int position){
        setContentView(R.layout.image_gridview);
        txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
        imgSoloPhoto = (ImageView) findViewById(R.id.imgSoloPhoto);

        txtSoloMsg.setText("Position= " + position + " " + items[position]);
        imgSoloPhoto.setImageResource(largeImages[position]);

        btnSoloBack = (Button) findViewById(R.id.btnSoloBack);
        btnSoloBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreate(myOriginalMemoryBundle);
            }
        });

    }
}
