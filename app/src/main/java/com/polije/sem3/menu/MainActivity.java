package com.polije.sem3.menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.polije.sem3.R;
import com.polije.sem3.util.FragmentUtil;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_bottom_nav_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_bottom_nav_activity));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_bottom_nav_referensi));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_bottom_nav_profile));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 1 : {
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    }
                    case 2 : {
                        Toast.makeText(MainActivity.this, "Activity", Toast.LENGTH_SHORT).show();
                    }
                    case 3 : {
                        Toast.makeText(MainActivity.this, "Referensi", Toast.LENGTH_SHORT).show();
                    }
                    case 4 : {
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    }

                }

                return null;
            }
        });

        FragmentUtil.switchFragmentMain(getSupportFragmentManager(), new HomeFragment(), false);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Information")
                .setMessage("Apakah Anda ingin keluar")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
    }
}