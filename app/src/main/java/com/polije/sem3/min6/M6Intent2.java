package com.polije.sem3.min6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.polije.sem3.R;

public class M6Intent2 extends AppCompatActivity {

    EditText name;
    Button btnSend;
    private final String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m6_intent2);

        name = (EditText) findViewById(R.id.edt_nama);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nama = name.getText().toString();
                    if (nama != ""){
                        Intent i = new Intent(M6Intent2.this, M6IntentSecond.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}