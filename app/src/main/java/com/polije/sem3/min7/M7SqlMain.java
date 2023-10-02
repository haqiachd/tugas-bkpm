package com.polije.sem3.min7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.polije.sem3.R;
import com.polije.sem3.data.local.DataHelper;

public class M7SqlMain extends AppCompatActivity {

    String[] daftar;
    ListView listView1;
    Menu menu;
    DataHelper dbCenter;
    protected Cursor cursor;
    public static M7SqlMain ma;
    public static final String EXTRA_KEY = "nama";
    private Button btnBuat;

    private void initViews(){
        btnBuat = findViewById(R.id.m7_button_list);
        listView1 = findViewById(R.id.m7_listview1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m7_sql_main);
        initViews();

        ma = this;
        dbCenter = new DataHelper(this);
        refreshList();

        btnBuat.setOnClickListener(v -> {
            startActivity(new Intent(this, M7SqlBuatBiodata.class));
        });
    }

    public void refreshList(){

        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1);
        }

        listView1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView1.setSelected(true);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = daftar[position];
                CharSequence[] dialogItem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(M7SqlMain.this)
                        .setTitle("Pilihan")
                        .setItems(dialogItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0 : {
                                        startActivity(
                                                new Intent(M7SqlMain.this, M7SqlLihatBiodata.class)
                                                        .putExtra(EXTRA_KEY, selection)
                                        );
                                        break;
                                    }
                                    case 1 : {
                                        startActivity(
                                                new Intent(M7SqlMain.this, M7SqlUpdateBiodata.class)
                                                        .putExtra(EXTRA_KEY, selection)
                                        );
                                        break;
                                    }
                                    case 2 : {
                                        SQLiteDatabase db = dbCenter.getWritableDatabase();
                                        db.execSQL("DELETE FROM biodata WHERE nama = '"+selection+"'");
                                        refreshList();
                                        Toast.makeText(M7SqlMain.this, "Berhasil", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                }
                            }
                        });
                builder.create().show();
            }
        });
    }
}