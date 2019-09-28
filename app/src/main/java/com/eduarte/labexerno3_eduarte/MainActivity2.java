package com.eduarte.labexerno3_eduarte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    String data = "";
    String[] dataArray;
    CheckBox[] checkBox = new CheckBox[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("SUBJECTS TAKEN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        checkBox[0] = findViewById(R.id.checkBox);
        checkBox[1] = findViewById(R.id.checkBox2);
        checkBox[2]= findViewById(R.id.checkBox3);
        checkBox[3] = findViewById(R.id.checkBox4);
        checkBox[4] = findViewById(R.id.checkBox5);
        checkBox[5] = findViewById(R.id.checkBox6);
        checkBox[6] = findViewById(R.id.checkBox7);
        checkBox[7] = findViewById(R.id.checkBox8);
    }
    @Override
    public void onStart() {
        super.onStart();
        try {
            FileInputStream reader = openFileInput("data1.txt");
            int token;
            while ((token = reader.read()) != -1) {
                data = data + (char) token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IOException");
        }
        dataArray = data.split(",");
        for(int i = 0; i < 8; i++){
            checkBox[i].setText(dataArray[i]);
        }
    }
    public void confirm(View v){
        String checkedBoxes = "";
        for(int i = 0; i < 8; i++){
            if(checkBox[i].isChecked()){
                if(data.contains(checkBox[i].getText()))
                    checkedBoxes += checkBox[i].getText() + " ";
            }
        }
        if(checkedBoxes != ""){
            Toast.makeText(this, checkedBoxes + "are enrolled", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this, checkedBoxes + "Please select a subject", Toast.LENGTH_LONG).show();

    }
}