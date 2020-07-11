package com.example.covidtracker;

import com.google.android.material.snackbar.Snackbar;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Covidresult> mArraylist;
    Context mcontext;

    public RecyclerAdapter(ArrayList<Covidresult> mArraylist, Context mcontext) {
        this.mArraylist = mArraylist;
        this.mcontext = mcontext;


    }




    /*private String[] titles = {"Delhi", "Tamil Nadu",
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
                             R.drawable.android_image_8 };*/


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mstatetext;
        public TextView mtotaltext;
        public TextView mdeathtext;
        public TextView mrecovertext;

        public ViewHolder(final View itemView) {
            super(itemView);

            mstatetext = itemView.findViewById(R.id.state);
            mtotaltext = itemView.findViewById(R.id.total_no);
            mdeathtext = itemView.findViewById(R.id.death_no);
            mrecovertext = itemView.findViewById(R.id.recovered_no);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();

                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlayout, viewGroup, false);
        ViewHolder mviewholder = new ViewHolder(v);
        return mviewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Covidresult mCovidresult= mArraylist.get(i);

        String State= mCovidresult.getStatename();
        int totalcases=mCovidresult.getTotalcases();
        int totaldeaths=mCovidresult.getTotaldeaths();
        int totalrecovered=mCovidresult.getTotalrecovered();

        viewHolder.mtotaltext.setText("" + totalcases);
        viewHolder.mstatetext.setText(State);
        viewHolder.mdeathtext.setText(""+totaldeaths);
        viewHolder.mrecovertext.setText(""+totalrecovered);



    }

    @Override
    public int getItemCount() {
        return mArraylist.size();
    }

}
