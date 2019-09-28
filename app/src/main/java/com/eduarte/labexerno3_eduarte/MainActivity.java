package com.eduarte.labexerno3_eduarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText et, et2, et3, et4,
            et5, et6, et7, et8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("IT SUBJECTS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText18);
        et2 = findViewById(R.id.editText19);
        et3 = findViewById(R.id.editText20);
        et4 = findViewById(R.id.editText21);
        et5 = findViewById(R.id.editText22);
        et6 = findViewById(R.id.editText23);
        et7 = findViewById(R.id.editText24);
        et8 = findViewById(R.id.editText25);

    }
    public void writeData(View v){
        FileOutputStream writer = null;
        String input = et.getText().toString() + ",";
        String input2 = et2.getText().toString() + ",";
        String input3 = et3.getText().toString() + ",";
        String input4 = et4.getText().toString() + ",";
        String input5 = et5.getText().toString() + ",";
        String input6 = et6.getText().toString() + ",";
        String input7 = et7.getText().toString() + ",";
        String input8 = et8.getText().toString();
        try {
            writer = openFileOutput("data1.txt", MODE_APPEND);
            writer.write(input.getBytes());
            writer.write(input2.getBytes());
            writer.write(input3.getBytes());
            writer.write(input4.getBytes());
            writer.write(input5.getBytes());
            writer.write(input6.getBytes());
            writer.write(input7.getBytes());
            writer.write(input8.getBytes());
        }catch (IOException e){
            Log.d("error", "IOException");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found 2");
            }
        }
        Toast.makeText(this, "Courses Saved", Toast.LENGTH_LONG).show();
    }
    public void nextData(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}