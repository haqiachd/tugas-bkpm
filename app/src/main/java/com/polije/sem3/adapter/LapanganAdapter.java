package com.polije.sem3.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.polije.sem3.R;
import com.polije.sem3.data.model.ItemLapangan;

import java.util.ArrayList;

public class LapanganAdapter extends RecyclerView.Adapter<LapanganAdapter.ViewHolder>{

    private final ArrayList<ItemLapangan> lapangan;
    private final Listener listener;

    public LapanganAdapter(ArrayList<ItemLapangan> lapangan, Listener listener){
        this.lapangan = lapangan;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_lapangan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaLapangan.setText(lapangan.get(position).getNama());
        holder.imgLapangan.setImageURI(Uri.parse(""+lapangan.get(position).getImgLapangan()));

        Glide.with(holder.itemView)
                .load(lapangan.get(position).getImgLapangan())
                .centerCrop()
                .into(holder.imgLapangan);

        if(holder.getAdapterPosition() != RecyclerView.NO_POSITION){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lapangan.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView namaLapangan;
        private final ImageView imgLapangan;

        ViewHolder(View view){
            super(view);

            namaLapangan = view.findViewById(R.id.il_text);
            imgLapangan = view.findViewById(R.id.il_img);

        }
    }

    public interface Listener{
        void onItemClicked(int position);
    }
}
