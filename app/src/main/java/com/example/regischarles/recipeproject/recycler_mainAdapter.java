package com.example.regischarles.recipeproject;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class recycler_mainAdapter extends RecyclerView.Adapter<recycler_mainAdapter.ViewHolders> {
    private Context context;


    recycler_mainAdapter(Context context) {
        this.context = context;

    }


    private String[] array_title = {"World Cuisine", "Diet and Health", "Seasonal","Meal Type","Dish Type","Cooking Style"};
    private int[] drawable_array = {R.drawable.worldcuisine, R.drawable.dietandhealth, R.drawable.seasonal, R.drawable.southindian,R.drawable.dishtype,R.drawable.cooking_style};


    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_cardview, parent, false);
        return new ViewHolders(v, context);


    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
        holder.title.setText(array_title[position]);
        Glide.with(context).load(drawable_array[position]).into(holder.cover_image);
    }

    @Override
    public int getItemCount() {
        return array_title.length;
    }

    static class ViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView cover_image;
        Context cont;
        Button explore;
        TextView title;
        Snackbar snackbar;

        ViewHolders(View view, Context cont) {
            super(view);
            this.cont = cont;
            cover_image = (ImageView) view.findViewById(R.id.medCover_adp);
            title = (TextView) view.findViewById(R.id.title_adp);
            explore = (Button) view.findViewById(R.id.explore);
            explore.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.explore:
                    if (title.getText().equals("Medicine")) {
                        cont.startActivity(new Intent(cont, HomePage.class));
                    } else if (title.getText().equals("Books")) {



                            cont.startActivity(new Intent(cont, HomePage.class));


                    } else if (title.getText().equals("R&D")) {
                        cont.startActivity(new Intent(cont, HomePage.class));
                    }

                    break;

            }
        }

    }
}
