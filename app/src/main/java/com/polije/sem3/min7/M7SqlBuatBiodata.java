package com.polije.sem3.min7;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.polije.sem3.R;
import com.polije.sem3.data.local.DataHelper;

public class M7SqlBuatBiodata extends AppCompatActivity {

    private DataHelper dbHelper;

    private Button btnSave, btnBack;

    private EditText inpNomor, inpNama, inpTgl, inpJk, inpAlamat;

    private void initViews(){
        btnSave = findViewById(R.id.m7_bio_save);
        btnBack = findViewById(R.id.m7_bio_back);
        inpNomor = findViewById(R.id.m7_inp_nomor);
        inpNama = findViewById(R.id.m7_inp_nama);
        inpTgl = findViewById(R.id.m7_inp_tgl);
        inpJk = findViewById(R.id.m7_inp_jk);
        inpAlamat = findViewById(R.id.m7_inp_alamat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7_sql_buat_biodata);

        dbHelper = new DataHelper(this);

        initViews();
        onClickGroups();
    }


    private void onClickGroups(){
        btnSave.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL(
                    "INSERT INTO biodata VALUES ("
                            + inpNomor.getText().toString() + ", '"
                            + inpNama.getText().toString() + "', '"
                            + inpTgl.getText().toString() + "','"
                            + inpJk.getText().toString() + "','"
                            + inpAlamat.getText().toString() +
                            "')"
            );
            Toast.makeText(M7SqlBuatBiodata.this, "Berhasil", Toast.LENGTH_SHORT).show();
            M7SqlMain.ma.refreshList();
            finish();
        });

        btnBack.setOnClickListener(v -> {
            super.onBackPressed();
        });
    }

}