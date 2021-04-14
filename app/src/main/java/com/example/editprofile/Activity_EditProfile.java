package com.example.editprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__edit_profile);

        Button btn_Done=findViewById(R.id.id_button_ActivityEdit_Done);
        btn_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_fullname=findViewById(R.id.id_editT_ActivityEdit_fullname);

                Intent intent = new Intent();
                String fullname=et_fullname.getText().toString();
                intent.putExtra("fullname",fullname);
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

        EditText et_fullname=findViewById(R.id.id_editT_ActivityEdit_fullname);
        String name = getIntent().getStringExtra("name");
        et_fullname.setText(name);


    }
}