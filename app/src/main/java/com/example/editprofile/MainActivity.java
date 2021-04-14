package com.example.editprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_main_viewWebsite=findViewById(R.id.id_button_main_ViewWebsit);
        button_main_viewWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("http://7learn.ac"));
                startActivity(intent);
            }
        });

        CheckBox checkBox_main_Android=findViewById(R.id.id_checkBox_main_Android);
        CheckBox checkBox_main_Ui=findViewById(R.id.id_checkBox_main_Ui);
        CheckBox checkBox_main_dep=findViewById(R.id.id_checkBox_main_deep);
        checkBox_main_Android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Android is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox_main_Ui.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Ui is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox_main_dep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Deep is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup radioGroup = findViewById(R.id.id_radioGroup_main);
        RadioButton radioButton_main_tehran=findViewById(R.id.id_radioButton_main_Tehran);
        RadioButton radioButton_main_gilan=findViewById(R.id.id_radioButton_main_Gilan);
        RadioButton radioButton_main_alborz=findViewById(R.id.id_radioButton_main_Alborz);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.id_radioButton_main_Tehran:
                        Toast.makeText(MainActivity.this, "Tehran is checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_radioButton_main_Gilan:
                        Toast.makeText(MainActivity.this, "Gilan is checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_radioButton_main_Alborz:
                        Toast.makeText(MainActivity.this, "Alborz is checked", Toast.LENGTH_SHORT).show();
                        break;

                }



        Button btn_EditProfile = findViewById(R.id.id_button_main_EditProfile);
        btn_EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv_main_fullname=findViewById(R.id.id_textView_main_fullname);
                String name = tv_main_fullname.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Activity_EditProfile.class);
                intent.putExtra("name" , name);
                startActivityForResult(intent , 1000);

            }
        });
    }



});

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1000 && resultCode== Activity.RESULT_OK && data!=null){

            String fullname = data.getStringExtra("fullname");
            TextView tv_main_fullname=findViewById(R.id.id_textView_main_fullname);

            tv_main_fullname.setText(fullname);


        }

    }
}
