package com.polije.sem3.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.polije.sem3.R;
import com.polije.sem3.data.model.ItemTugasModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

@SuppressLint("ViewHolder")
public class ItemTugasAdapter extends ArrayAdapter<ItemTugasModel> {

    private final Context context;
    private final int resId;
    private final ArrayList<ItemTugasModel> models;

    public ItemTugasAdapter(Context context, int resId, ArrayList<ItemTugasModel> models){
        super(context, resId, models);
        this.context = context;
        this.resId = resId;
        this.models = models;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resId, null);

        TextView tugas = view.findViewById(R.id.iht_title);
        CardView cardView = view.findViewById(R.id.iht_card);

        tugas.setText(models.get(position).getNamaTugas());

        cardView.setBackgroundResource(R.drawable.sel_iht);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                models.get(position).getListener().onItemClicked();
            }
        });

        return view;
    }
}
