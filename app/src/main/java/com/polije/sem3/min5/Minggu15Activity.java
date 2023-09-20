package com.polije.sem3.min5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.polije.sem3.R;

public class Minggu15Activity extends AppCompatActivity {

    private Button btnFragment1, btnFragment2;

    private void initViews(){
        btnFragment1 = findViewById(R.id.m15_btn_fragment1);
        btnFragment2 = findViewById(R.id.m15_btn_fragment2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minggu15);
        initViews();

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentFirst());
            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentSecond());
            }
        });

    }

    private void loadFragment(Fragment fragment){
        Minggu15Activity.this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.m15_frame_layout, fragment)
                .addToBackStack(null)
                .commit();
    }
}