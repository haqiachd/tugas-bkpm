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

public class M7SqlUpdateBiodata extends AppCompatActivity {

    private Cursor cursor;

    private DataHelper dbHelper;

    private Button btnUpdate, btnBack;

    private EditText inpNomor, inpNama, inpTgl, inpJk, inpAlamat;

    private void initViews(){
        btnUpdate = findViewById(R.id.m7_bio_update);
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
        setContentView(R.layout.activity_m7_sql_update_biodata);
        initViews();
        dbHelper = new DataHelper(this);

        showData();
        onClickGroups();
    }

    private void showData(){
        dbHelper = new DataHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+getIntent().getStringExtra(M7SqlMain.EXTRA_KEY)+"'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            inpNomor.setText(cursor.getString(0));
            inpNama.setText(cursor.getString(1));
            inpTgl.setText(cursor.getString(2));
            inpJk.setText(cursor.getString(3));
            inpAlamat.setText(cursor.getString(4));
        }
    }

    private void onClickGroups(){

        btnUpdate.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL(
                    "UPDATE biodata SET nama = '"
                            + inpNama.getText().toString() + "', tgl = '"
                            + inpTgl.getText().toString() + "', jk = '"
                            + inpJk.getText().toString() + "', alamat = '"
                            + inpAlamat.getText().toString() +
                            "' WHERE no = '" + inpNomor.getText().toString() + "'"
            );
            Toast.makeText(M7SqlUpdateBiodata.this, "Berhasil", Toast.LENGTH_SHORT).show();
            M7SqlMain.ma.refreshList();
            finish();
        });

        btnBack.setOnClickListener(v -> {
            super.onBackPressed();
        });

    }
}