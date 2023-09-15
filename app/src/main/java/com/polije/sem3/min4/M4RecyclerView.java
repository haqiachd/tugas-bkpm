package com.polije.sem3.min4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.polije.sem3.R;
import com.polije.sem3.adapter.ItemMahasiswaAdapter;
import com.polije.sem3.data.model.ItemMahasiswa;

import java.util.ArrayList;

public class M4RecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemMahasiswaAdapter mahasiswa;
    private ArrayList<ItemMahasiswa> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m4_recycler_view);

        recyclerView = findViewById(R.id.m4_recycler);

        models.add(
                new ItemMahasiswa("Pramudya", "145", "95345534")
        );
        models.add(
                new ItemMahasiswa("Syamdani", "123", "9r45353")
        );
        models.add(
                new ItemMahasiswa("Mahen", "153", "6345534")
        );

        mahasiswa = new ItemMahasiswaAdapter(models);
        recyclerView.setAdapter(mahasiswa);
    }
}