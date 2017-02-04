package com.saff.sociallyawkwardfriendfinder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton cameraButton = (ImageButton) findViewById(R.id.camera_button);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profile_button);
        Button findButton = (Button) findViewById(R.id.find_button);

        if (cameraButton.callOnClick()) {
            UseCamera();
        }

        if(profileButton.callOnClick()){
            Intent intent = new Intent(this, ProfilePage.class);
            startActivity(intent);
        }

        if(findButton.callOnClick()){
            //TODO CONDITION IF PROFILE AND IMG EXISTS
            search();
        }
    }

    void UseCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

//        ImageButton imageButton = (ImageButton) findViewById(R.id.camera_button);
//      if (ContextCompat.checkSelfPermission(this,
//        Manifest.permission.CAMERA)
//        != PackageManager.PERMISSION_GRANTED) {
//
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.CAMERA)) {
//
//                // Show an explanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//
//            } else {
//
//                // No explanation needed, we can request the permission.
//
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.CAMERA}, );
//
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                // app-defined int constant. The callback method gets the
//                // result of the request.
//            }
//        }
    }

    void search(){

    }
}
