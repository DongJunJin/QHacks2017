package com.saff.sociallyawkwardfriendfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.UUID;

public class ProfilePage extends Activity {

    EditText first_name;
    EditText last_name;
    RadioGroup genderChoice;
    Button submit;
    int selectedID;
    RadioButton radioButton;
    Intent intent = new Intent(this,MainActivity.class);
    Bundle inform = new Bundle();
    UUID uniqueID;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        genderChoice = (RadioGroup) findViewById(R.id.radioButtons);
        submit = (Button) findViewById(R.id.submit_button);
        radioButton = (RadioButton) findViewById(selectedID);
        selectedID = genderChoice.getCheckedRadioButtonId();


        genderChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (String) radioButton.getText();
                Log.i("Radio Value", temp);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    if (isEmpty(first_name) || (isEmpty(last_name)) ||
                            genderChoice.getCheckedRadioButtonId() == -1) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Please Complete The Fields.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else{
                        startActivity(intent);
                        infoPass();
                    }
                }
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        infoPass();
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        //TODO WHEN ACTIVITY IS CALLED AGAIN RETURN THE FIELD VALUES
        infoStore();
    }

    private boolean isEmpty(EditText texty){
        return texty.getText().toString().trim().length() == 0;
    }

    private void infoPass(){
//        if(uniqueID.toString().length() == 0){
//            uniqueID = UUID.randomUUID();
//        }

        uniqueID = UUID.randomUUID();
        String ids = uniqueID.toString();
        String fn = first_name.toString();
        String ln = last_name.toString();
        String gen = "NULL";

        if(genderChoice.getCheckedRadioButtonId()!=-1){
            int id= genderChoice.getCheckedRadioButtonId();
            View radioButton = genderChoice.findViewById(id);
            int radioId = genderChoice.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) genderChoice.getChildAt(radioId);
            gen = (String) btn.getText();
        }

        inform.putString("UUID", ids);
        inform.putString("First Name", fn);
        inform.putString("Last Name", ln);
        Log.i("Gender", gen);
        inform.putString("Gender", gen);
        intent.putExtras(inform);
    }

    private void infoStore(){
        first_name.setText(first_name.toString());
        last_name.setText(first_name.toString());
        //TODO SET RADIO BUTTON TO GENDER TYPE
    }
}
