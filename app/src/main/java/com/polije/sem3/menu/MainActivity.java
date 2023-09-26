package com.polije.sem3.menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.polije.sem3.R;
import com.polije.sem3.util.FragmentUtil;


public class MainActivity extends AppCompatActivity {

    public static int MENU_HOME = 1, MENU_AKTIVITAS = 2, MENU_REFERENSI = 3, MENU_PROFILE = 4;

    private MeowBottomNavigation bottomNavigation;
    private TextView txtAppbar;

    private void initViews(){
        bottomNavigation = findViewById(R.id.bottomNav);
        txtAppbar = findViewById(R.id.txt_appbar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        bottomNavigation.add(new MeowBottomNavigation.Model(MENU_HOME, R.drawable.ic_bottom_nav_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(MENU_AKTIVITAS, R.drawable.ic_bottom_nav_activity));
        bottomNavigation.add(new MeowBottomNavigation.Model(MENU_REFERENSI, R.drawable.ic_bottom_nav_referensi));
        bottomNavigation.add(new MeowBottomNavigation.Model(MENU_PROFILE, R.drawable.ic_bottom_nav_profile));

        bottomNavigation.show(MENU_HOME, true);
        FragmentUtil.switchFragmentMain(getSupportFragmentManager(), new HomeFragment(), false);

        onClickGroups();
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

    private void onClickGroups(){

        bottomNavigation.setOnClickMenuListener(model -> {

            switch (model.getId()) {
                case 1: {
                    FragmentUtil.switchFragmentMain(MainActivity.this.getSupportFragmentManager(), new HomeFragment(), false);
                    txtAppbar.setText(R.string.menu_home);
                    break;
                }
                case 2: {
                    FragmentUtil.switchFragmentMain(MainActivity.this.getSupportFragmentManager(), new AktivitasFragment(), false);
                    txtAppbar.setText(R.string.menu_aktivitas);
                    break;
                }
                case 3: {
                    FragmentUtil.switchFragmentMain(MainActivity.this.getSupportFragmentManager(), new ReferensiFragment(), false);
                    txtAppbar.setText(R.string.menu_referensi);
                    break;
                }
                case 4: {
                    FragmentUtil.switchFragmentMain(MainActivity.this.getSupportFragmentManager(), new ProfileFragment(), false);
                    txtAppbar.setText(R.string.menu_profile);
                    break;
                }

            }

            return null;
        });
    }

}