package com.polije.sem3.min7;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.polije.sem3.R;
import com.polije.sem3.data.local.DataHelper;

public class M7SqlLihatBiodata extends AppCompatActivity {

    protected Cursor cursor;

    private DataHelper dbHelper;

    private Button btnBack;

    private TextView txtNomor, txtNama, txtTgl, txtJenis, txtAlamat;

    private void initViews(){
        btnBack = findViewById(R.id.m7_btn_kembali);
        txtNomor = findViewById(R.id.m7_show_nomor);
        txtNama = findViewById(R.id.m7_show_nama);
        txtTgl = findViewById(R.id.m7_show_tgl);
        txtJenis = findViewById(R.id.m7_show_jk);
        txtAlamat = findViewById(R.id.m7_show_alamat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7_sql_lihat_biodata);
        initViews();

        dbHelper = new DataHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+getIntent().getStringExtra(M7SqlMain.EXTRA_KEY)+"'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            txtNomor.setText(cursor.getString(0));
            txtNama.setText(cursor.getString(1));
            txtTgl.setText(cursor.getString(2));
            txtJenis.setText(cursor.getString(3));
            txtAlamat.setText(cursor.getString(4));
        }

        btnBack.setOnClickListener(v -> {
            super.onBackPressed();
        });
    }
}