package com.example.labo.ingesup.series.list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.activities.DetailActivity;
import com.example.labo.ingesup.series.activities.SerieActivity;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Serie;

import java.util.List;

/**
 * Created by Come on 05/11/2014.
 */
public class SerieAdapter extends ArrayAdapter {

    private Context mContext;

    private int mResource;

    private List<Serie> mSeries;

    public SerieAdapter(Context context, int resource, List Serie) {
        super(context, resource, Serie);
        mContext = context;
        mResource = resource;
        mSeries = Serie;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Serie serieEnCours = mSeries.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(mResource, parent, false);

        TextView textViewTitre = (TextView) convertView.findViewById(R.id.tv_item_titre);
        textViewTitre.setText(serieEnCours.getTitre());
        ImageView imageViewFleche = (ImageView) convertView.findViewById(R.id.iv_item_fleche_serie);
        imageViewFleche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivityIntent = new Intent(mContext, DetailActivity.class);
                detailActivityIntent.putExtra(DetailActivity.SERIE_ID, serieEnCours.getId());
                mContext.startActivity(detailActivityIntent);
            }
        });
    return convertView;
    }

}
