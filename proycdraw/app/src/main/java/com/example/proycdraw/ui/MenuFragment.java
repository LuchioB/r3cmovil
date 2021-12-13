package com.example.proycdraw.ui;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.example.proycdraw.R;
import com.google.android.material.snackbar.Snackbar;


public class MenuFragment extends Fragment {

private View v;
private ImageView foodimage1,foodimage2,foodimage3,foodimage4,foodimage5,foodimage6,foodimage7;
private ImageButton favfastpizza1,favfastpizza2,favfastpizza3,favfastpizza4,favfastpizza5,favfastpizza6,favfastpizza7;
private FrameLayout myframe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_menu, container, false);
        Drawable drawable;
        drawable = getResources().getDrawable(R.drawable.bigmac);
        foodimage1=(ImageView) v.findViewById(R.id.foodimage1);
        foodimage1.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.combo);
        foodimage2=(ImageView) v.findViewById(R.id.foodimage2);
        foodimage2.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.ic_taco);
        foodimage3=(ImageView) v.findViewById(R.id.foodimage3);
        foodimage3.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.pizzahit);
        foodimage4=(ImageView) v.findViewById(R.id.foodimage4);
        foodimage4.setImageDrawable(drawable);


        drawable = getResources().getDrawable(R.drawable.cotaco);
        foodimage5=(ImageView) v.findViewById(R.id.foodimage5);
        foodimage5.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.bigmac);
        foodimage6=(ImageView) v.findViewById(R.id.foodimage6);
        foodimage6.setImageDrawable(drawable);


        drawable = getResources().getDrawable(R.drawable.sushi);
        foodimage7=(ImageView) v.findViewById(R.id.foodimage7);
        foodimage7.setImageDrawable(drawable);


        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza1=(ImageButton) v.findViewById(R.id.favfastpizza1);
        favfastpizza1.setImageDrawable(drawable);


        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza2=(ImageButton) v.findViewById(R.id.favfastpizza2);
        favfastpizza2.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza3=(ImageButton) v.findViewById(R.id.favfastpizza3);
        favfastpizza3.setImageDrawable(drawable);

        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza4=(ImageButton) v.findViewById(R.id.favfastpizza4);
        favfastpizza4.setImageDrawable(drawable);
        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza5=(ImageButton) v.findViewById(R.id.favfastpizza5);
        favfastpizza5.setImageDrawable(drawable);
        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza6=(ImageButton) v.findViewById(R.id.favfastpizza6);
        favfastpizza6.setImageDrawable(drawable);
        drawable = getResources().getDrawable(R.drawable.ic_action_favorite_24);
        favfastpizza7=(ImageButton) v.findViewById(R.id.favfastpizza7);
        favfastpizza7.setImageDrawable(drawable);
        
        myframe = (FrameLayout)v.findViewById(R.id.myframe);

        favfastpizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        favfastpizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
                }
        });
        favfastpizza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        favfastpizza4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        favfastpizza5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        favfastpizza6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        favfastpizza7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myframe,"added to favorites",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });











        return v;


    }


}