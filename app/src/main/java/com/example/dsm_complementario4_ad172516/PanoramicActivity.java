package com.example.dsm_complementario4_ad172516;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.dsm_complementario4_ad172516.Models.Image;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class PanoramicActivity extends AppCompatActivity {

    private VrPanoramaView panoramaView;
    private VrPanoramaView.Options panoOptions = new VrPanoramaView.Options();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panoramic);

        initPanoramaActivity();

    }

    @Override
    protected void onPause() {
        panoramaView.pauseRendering();
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        panoramaView.resumeRendering();

    }

    @Override
    protected void onDestroy() {
        panoramaView.shutdown();
        super.onDestroy();

    }

    private void initPanoramaActivity() {
        //get panoramic view
        panoramaView = findViewById(R.id.pano_view);

        //get intent
        Image panoramicImage = (Image) getIntent().getSerializableExtra("image");

        //temporal image view
        final ImageView tmpImageView = new ImageView(this);

        //set image to panorama view
        tmpImageView.setImageResource(panoramicImage.getImage());
        Bitmap b = ((BitmapDrawable)tmpImageView.getDrawable()).getBitmap();
        panoramaView.loadImageFromBitmap(b, panoOptions);
        panoOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        //if this device has or hasn't gyroscope
        PackageManager packageManager = getPackageManager();
        boolean gyroExist = packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);

        if (!gyroExist) {
            panoramaView.setPureTouchTracking(true);
        }


    }
}
