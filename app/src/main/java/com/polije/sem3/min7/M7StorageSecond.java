package com.polije.sem3.min7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;

import com.polije.sem3.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class M7StorageSecond extends AppCompatActivity {

    private TextView showText;
    private Button btnPrivate, btnPublic, btnBack;

    private void initViews(){
        showText = findViewById(R.id.m7_txt_view);
        btnPrivate = findViewById(R.id.m7_show_private);
        btnPublic = findViewById(R.id.m7_show_public);
        btnBack = findViewById(R.id.m7_btn_back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7_storage_second);
        initViews();
        onClickGroups();
    }

    private void onClickGroups(){

        btnPrivate.setOnClickListener(v -> {
            getPrivate();
        });

        btnPublic.setOnClickListener(v -> {
            getPublic();
        });

        btnBack.setOnClickListener(v -> {
            super.onBackPressed();
        });

    }

    private void getPublic(){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myData1.txt");
        String text = getData(myFile);
        assert text != null;
        if (!text.isEmpty()){
            showText.setText(text);
        }else{
            showText.setText("No Data");
        }
    }

    private void getPrivate(){
        File folder = getExternalFilesDir("samsul");
        File myFile = new File(folder, "myData2.txt");
        String text = getData(myFile);
        assert text != null;
        if (!text.isEmpty()){
            showText.setText(text);
        }else{
            showText.setText("No Data");
        }
    }

    private String getData(File myFile){
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        try {
            fileInputStream = new FileInputStream(myFile);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            // read dan convert byte ke karakter
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            // close operasi file
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getDataBkpm(File myFile){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(myFile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1){
                buffer.append(i);
            }
            return buffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

}