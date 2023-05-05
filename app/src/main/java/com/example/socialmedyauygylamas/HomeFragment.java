package com.example.socialmedyauygylamas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView myres;
    private ArrayList<GonderiDetay> paylasim;
    private MyreycAdaptor myreycAdaptor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        myres=view.findViewById(R.id.listem);
        paylasim=new ArrayList<>();
        myreycAdaptor=new MyreycAdaptor(paylasim);
        myres.setAdapter(myreycAdaptor);
        myres.setLayoutManager(new LinearLayoutManager(getActivity()));
        diziolustur();
        myreycAdaptor.notifyDataSetChanged();

        return view;
    }
    private void diziolustur() {
        paylasim.add(new GonderiDetay(R.drawable.togg,"TOGG"));
        paylasim.add(new GonderiDetay(R.drawable.fener,"FENERBAHÇE"));
        paylasim.add(new GonderiDetay(R.drawable.ww,"WOLKSVAGEN"));
        paylasim.add(new GonderiDetay(R.drawable.bjk,"BEŞİKTAŞ"));
        paylasim.add(new GonderiDetay(R.drawable.bmw,"BMW"));
        paylasim.add(new GonderiDetay(R.drawable.gs,"GALATASARAY"));
        paylasim.add(new GonderiDetay(R.drawable.togg2,"TOGG"));
    }
}