package com.polije.sem3.min7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.polije.sem3.R;

import java.io.File;
import java.io.FileOutputStream;

public class M7Storage extends AppCompatActivity {

    private EditText editText;
    private Button btnPrivate, btnPublic, btnView;
    private int STORAGE_PERMISSION_CODE = 666;

    private void initViews(){
        editText = findViewById(R.id.m7_inpText);
        btnPrivate = findViewById(R.id.m7_save_private);
        btnPublic = findViewById(R.id.m7_save_public);
        btnView = findViewById(R.id.m7_btn_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7_storage);
        initViews();
        onClickGroups();
    }

    private void onClickGroups(){

        btnPrivate.setOnClickListener(v -> {
            savePrivate(null);
        });

        btnPublic.setOnClickListener(v -> {
            savePublic(null);
        });

        btnView.setOnClickListener(v -> {
            startActivity(new Intent(this, M7StorageSecond.class));
        });
    }

    public void savePublic(View view){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myData1.txt");
        writeData(myFile, info);
        editText.setText("");
    }

    public void savePrivate(View view){
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("samsul");
        File myFile = new File(folder, "myData2.txt");
        writeData(myFile, info);
        editText.setText("");
    }

    public void writeData(File myFile, String data){
        FileOutputStream fileOutputStream = null;
        try{
            System.out.println("TES WRITE DATA");
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}