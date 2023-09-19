package com.polije.sem3.min4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.polije.sem3.R;
import com.polije.sem3.adapter.MahasiswaAdapter;
import com.polije.sem3.data.model.MahasiswaModel;

import java.util.ArrayList;

public class M4RecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswa;
    private ArrayList<MahasiswaModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m4_recycler_view);

        recyclerView = findViewById(R.id.m4_recycler);

        models.add(
                new MahasiswaModel("Achmad Baihaqi", "5429843", "085690349034")
        );
        models.add(
                new MahasiswaModel("Afrizal Wahyu Alkausar", "0895342", "085690238923")
        );
        models.add(
                new MahasiswaModel("Syafrizal Wd Mahendra", "894234", "085790239023")
        );
        models.add(
                new MahasiswaModel("Ninik Yuniarsih", "9028922", "088309238923")
        );
        models.add(
                new MahasiswaModel("Widyasari Raisya Salsabila", "4238932", "081290239023")
        );

        mahasiswa = new MahasiswaAdapter(models, new MahasiswaAdapter.Listener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(M4RecyclerView.this, "Nama : " + models.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(mahasiswa);
    }
}