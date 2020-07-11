package com.example.covidtracker;

import com.google.android.material.snackbar.Snackbar;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Delhi", "Tamil Nadu",
                               "Maharashtra", "Rajasthan",
                               "Goa", "Hyderabad",
                               "Bangalore", "Chennai","Kerala"};

    private String[] details = {"Item one details",
                                "Item two details", "Item three details",
                                "Item four details", "Item file details",
                                "Item six details", "Item seven details",
                                "Item eight details"};

    private int[] images = { R.drawable.android_image_1,
                             R.drawable.android_image_2,
                             R.drawable.android_image_3,
                             R.drawable.android_image_4,
                             R.drawable.android_image_5,
                             R.drawable.android_image_6,
                             R.drawable.android_image_7,
                             R.drawable.android_image_8 };



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mtextview;
        //public TextView mtextview2;
        public ImageView mimageview;

        public ViewHolder(final View itemView) {
            super(itemView);

            mtextview = itemView.findViewById(R.id.state);
           // mtextview2 = itemView.findViewById(R.id.);
            //mimageview = itemView.findViewById(R.id.item_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position= getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();


                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout,viewGroup,false);
        ViewHolder mviewholder= new ViewHolder(v);
        return mviewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        //viewHolder.mimageview.setImageResource(images[i]);
        viewHolder.mtextview.setText(titles[i]);
        //viewHolder.mtextview2.setText(details[i]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

 }
