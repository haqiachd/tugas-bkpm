package com.polije.sem3.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.polije.sem3.R;
import com.polije.sem3.adapter.ItemTugasAdapter;
import com.polije.sem3.data.model.ItemTugasModel;
import com.polije.sem3.min3.M3Tugas2;
import com.polije.sem3.min4.M4ListView;
import com.polije.sem3.min5.Minggu15Activity;
import com.polije.sem3.min6.M6Intent1;
import com.polije.sem3.min6.M6Intent2;
import com.polije.sem3.min7.M7Storage;
import com.polije.sem3.min7.M7StorageSecond;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ArrayList<ItemTugasModel> tugasModels = new ArrayList<>();

    private ItemTugasAdapter itemTugasAdapter;
    private ListView listTugas;

    public HomeFragment() {
        // Required empty public constructor
    }

    private void initViews(View root){
        listTugas = root.findViewById(R.id.home_list);
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        tugasModels.add(
                new ItemTugasModel("Minggu 3", new ItemTugasModel.Listener() {
                    @Override
                    public void onItemClicked() {
                        startActivity(new Intent(HomeFragment.this.requireActivity(), M3Tugas2.class));
                    }
                })
        );
        tugasModels.add(
                new ItemTugasModel("Minggu 4", new ItemTugasModel.Listener() {
                    @Override
                    public void onItemClicked() {
                        startActivity(new Intent(HomeFragment.this.requireActivity(), M4ListView.class));
                    }
                })
        );
        tugasModels.add(
                new ItemTugasModel("Minggu 5", new ItemTugasModel.Listener() {
                    @Override
                    public void onItemClicked() {
                        startActivity(new Intent(HomeFragment.this.requireActivity(), Minggu15Activity.class));
                    }
                })
        );
        tugasModels.add(
                new ItemTugasModel("Minggu 6", new ItemTugasModel.Listener() {
                    @Override
                    public void onItemClicked() {
                        startActivity(new Intent(HomeFragment.this.requireActivity(), M6Intent1.class));
                    }
                })
        );
        tugasModels.add(
                new ItemTugasModel("Minggu 7", new ItemTugasModel.Listener() {
                    @Override
                    public void onItemClicked() {
                        startActivity(new Intent(HomeFragment.this.requireActivity(), M7Storage.class));
                    }
                })
        );

        itemTugasAdapter = new ItemTugasAdapter(requireContext(), R.layout.item_home_tugas, tugasModels);
        listTugas.setAdapter(itemTugasAdapter);
        listTugas.setDivider(null);

    }
}