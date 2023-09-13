package com.polije.sem3.min4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.polije.sem3.R;
import com.polije.sem3.adapter.LapanganAdapter;
import com.polije.sem3.data.model.ItemLapangan;

import java.util.ArrayList;

public class LapanganTest extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LapanganAdapter lapanganAdapter;
    private ArrayList<ItemLapangan> lapangans = new ArrayList<>();

    private void initViews(){
        recyclerView = findViewById(R.id.recycler_lapangan);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapangan_test);

        initViews();

        lapangans.add(
                new ItemLapangan("Lapangan Badminton", R.drawable.img_venue_1)
        );

        lapangans.add(
                new ItemLapangan("Blessing Futsal", R.drawable.img_venue_2)
        );

        lapanganAdapter = new LapanganAdapter(lapangans, new LapanganAdapter.Listener() {
            @Override
            public void onItemClicked(int position) {
                Toast.makeText(LapanganTest.this, lapangans.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(lapanganAdapter);

    }
}