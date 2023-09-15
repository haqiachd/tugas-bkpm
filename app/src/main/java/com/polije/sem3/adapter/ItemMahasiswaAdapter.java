package com.polije.sem3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polije.sem3.R;
import com.polije.sem3.data.model.ItemMahasiswa;
import com.polije.sem3.data.model.ItemTugasModel;

import java.util.ArrayList;

public class ItemMahasiswaAdapter extends RecyclerView.Adapter<ItemMahasiswaAdapter.ViewHolder>{

    private ArrayList<ItemMahasiswa> models;

    public ItemMahasiswaAdapter(ArrayList<ItemMahasiswa> models){
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNama.setText(models.get(position).getNama());
        holder.txtNpm.setText(models.get(position).getNpm());
        holder.txtNoHp.setText(models.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNama, txtNpm, txtNoHp;

        ViewHolder(View view){
            super(view);
            txtNama = view.findViewById(R.id.im_nama);
            txtNpm = view.findViewById(R.id.im_npm);
            txtNoHp = view.findViewById(R.id.im_nohp);
        }

    }
}
