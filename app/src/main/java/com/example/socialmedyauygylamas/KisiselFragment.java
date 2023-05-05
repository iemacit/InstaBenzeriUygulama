package com.example.socialmedyauygylamas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class KisiselFragment extends Fragment {
    TextView bilgim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_kisisel, container, false);
        bilgim=view.findViewById(R.id.kisim);
        bilgim.setText(MainActivity2.kullaniciAdi);

        return view;
    }
}