package com.example.dsm_complementario4_ad172516;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;

import com.example.dsm_complementario4_ad172516.Adapters.ImagesAdapter;
import com.example.dsm_complementario4_ad172516.Models.Image;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarSetUp();

        initRecyclerVew();

    }

    private void initRecyclerVew() {

        //arraylist of images
        List<Image> images = new ArrayList<>();
        images.add(new Image(1, R.drawable.image1));
        images.add(new Image(2, R.drawable.image2));
        images.add(new Image(3, R.drawable.image3));

        RecyclerView mRecyclerView = findViewById(R.id.imageRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(new ImagesAdapter(images, this));

    }

    private void toolBarSetUp() {
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        toolbar.setElevation(4);
    }
}
