package com.app.dynamicslidingtabs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.dynamicslidingtabs.R;
import com.app.dynamicslidingtabs.model.WorldpopulationItem;
import com.app.dynamicslidingtabs.utils.ImageLoadedCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Pratik Surela on 02-09-2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<WorldpopulationItem> arrayList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<WorldpopulationItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recyclerview, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    //Replace the content of the view
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        viewHolder.txtName.setText(arrayList.get(position).getCountry());
        //get data from the item data
        Picasso.with(context)
                .load(arrayList.get(position).getFlag())
                .into(viewHolder.imgPerson, new ImageLoadedCallback(viewHolder.progressBar) {
                    @Override
                    public void onSuccess() {
                        if (viewHolder.progressBar != null) {
                            viewHolder.progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }

    //Inner class to hold a reference to each item of RecylcerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public ImageView imgPerson;
        public ProgressBar progressBar = null;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            txtName = (TextView) itemLayoutView.findViewById(R.id.txtName);

            imgPerson = (ImageView) itemLayoutView.findViewById(R.id.imgPerson);

            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}