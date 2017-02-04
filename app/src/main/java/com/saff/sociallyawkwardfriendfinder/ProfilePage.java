package com.saff.sociallyawkwardfriendfinder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by andrew on 2/4/17.
 */

public class ProfilePage extends Activity {

    EditText first_name;
    EditText last_name;
    RadioButton Gender;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);


    }


}
