package com.saff.sociallyawkwardfriendfinder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ImageButton cameraButton;
    ImageButton profileButton;
    Button findButton;
    String first_name, last_name, gender, Unique_ID;
    Bundle info = getIntent().getExtras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        cameraButton = (ImageButton) findViewById(R.id.camera_button);
        profileButton = (ImageButton) findViewById(R.id.profile_button);
        findButton = (Button) findViewById(R.id.find_button);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
                startActivity(intent);
            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        getProfile();
    }

    void UseCamera(){
        cameraPermission();

    }

    void cameraPermission(){
    }

    private void search(){
        if(first_name.isEmpty() || last_name.isEmpty() || gender.isEmpty()){
            createProfile();
        }
        Toast toast = Toast.makeText(getApplicationContext(), "Search Cant Be done",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    private void getProfile(){
        first_name = info.getString("First Name");
        last_name = info.getString("Last Name");
        gender = info.getString("Gender");
        Unique_ID = info.getString("UUID");

        {
            Log.i("First Name", first_name);
            Log.i("Last Name", last_name);
            Log.i("Gender", gender);
            Log.i("UUID", Unique_ID);
        }
    }

    private void createProfile(){
        JSONObject profile = new JSONObject();
        try{
            profile.put("UUID", Unique_ID);
            profile.put("First Name", first_name);
            profile.put("Last Name", last_name);
            profile.put("Gender", gender);
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
