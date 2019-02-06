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

public class MealtypeAdapter extends RecyclerView.Adapter<MealtypeAdapter.ViewHolders> {
    private Context context;


    MealtypeAdapter(Context context) {
        this.context = context;

    }


    private String[] array_title = {"Breakfast","brunch","lunch","Dinner"};
    private int[] drawable_array = {R.drawable.breakfast, R.drawable.brunch, R.drawable.lunch, R.drawable.dinner};


    @Override
    public MealtypeAdapter.ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_cardview, parent, false);
        return new MealtypeAdapter.ViewHolders(v, context);


    }

    @Override
    public void onBindViewHolder(MealtypeAdapter.ViewHolders holder, int position) {
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
            cover_image =  view.findViewById(R.id.medCover_adp);
            title =  view.findViewById(R.id.title_adp);
            explore =  view.findViewById(R.id.explore);
            explore.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.explore:
                    if (title.getText().equals("Breakfast")) {
                        cont.startActivity(new Intent(cont, HomePage.class));
                    } else if (title.getText().equals("brunch")) {



                        cont.startActivity(new Intent(cont, HomePage.class));


                    } else if (title.getText().equals("lunch")) {
                        cont.startActivity(new Intent(cont, HomePage.class));
                    }
                    else if (title.getText().equals("Dinner")) {
                        cont.startActivity(new Intent(cont, HomePage.class));
                    }

                    break;

            }
        }

    }
}
