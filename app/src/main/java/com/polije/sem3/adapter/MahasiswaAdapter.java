package com.polije.sem3.adapter;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polije.sem3.R;
import com.polije.sem3.data.model.MahasiswaModel;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>{

    private final ArrayList<MahasiswaModel> models;
    private final Listener listener;

    public MahasiswaAdapter(ArrayList<MahasiswaModel> models, Listener listener){
        this.models = models;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtNama.setText(models.get(position).getNama());
        holder.txtNpm.setText(models.get(position).getNpm());
        holder.txtNoHp.setText(models.get(position).getNohp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.getAdapterPosition() != RecyclerView.NO_POSITION){
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNama, txtNpm, txtNoHp;

        public ViewHolder(View view){
            super(view);
            txtNama = view.findViewById(R.id.im_nama);
            txtNpm = view.findViewById(R.id.im_npm);
            txtNoHp = view.findViewById(R.id.im_nohp);
        }

    }

    public interface Listener{
        void onItemClick(int position);
    }
}
