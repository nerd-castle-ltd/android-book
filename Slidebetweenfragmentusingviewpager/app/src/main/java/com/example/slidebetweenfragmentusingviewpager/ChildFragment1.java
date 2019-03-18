package com.example.slidebetweenfragmentusingviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ChildFragment1 extends Fragment {

    private Button buttonForChildFragment1;

    public ChildFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_child_fragment1, container, false);
        buttonForChildFragment1 = view.findViewById(R.id.buttonForChildFragment1);
        buttonForChildFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "button in fragment 1", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
