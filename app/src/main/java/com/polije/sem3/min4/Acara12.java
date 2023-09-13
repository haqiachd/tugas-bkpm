package com.polije.sem3.min4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.polije.sem3.R;

public class Acara12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara12);

        String[] data = new String[]{
                "Item 1", "Item 2", "Item 3"
        };

        Spinner spinner = findViewById(R.id.spiner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (data[position]){
                    case "Item 1" : {
                        Toast.makeText(Acara12.this, "Item 1", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case "Item 2" : {
                        Toast.makeText(Acara12.this, "Item 2", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case "Item 3" : {
                        Toast.makeText(Acara12.this, "Item 3", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });

        String[] autoWord = {"Mouse", "Keyboard", "Handphone"};

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autocomp);
        ArrayAdapter<String> auto = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, autoWord);
        autoCompleteTextView.setAdapter(auto);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = (String) parent.getItemAtPosition(position);
            }
        });
    }
}