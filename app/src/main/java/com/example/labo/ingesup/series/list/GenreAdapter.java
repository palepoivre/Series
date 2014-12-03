package com.example.labo.ingesup.series.list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.activities.DetailActivity;
import com.example.labo.ingesup.series.activities.GenreActivity;
import com.example.labo.ingesup.series.activities.SerieActivity;
import com.example.labo.ingesup.series.bean.Genre;

import java.util.List;

/**
 * Created by clément on 15/10/2014.
 */
public class GenreAdapter extends ArrayAdapter {

    private Context mContext;

    private int mResource;

    private List<Genre> mGenres;

    /**
     * Constructeur
     */
    public GenreAdapter(Context context, int resource, List<Genre> genres) {
        super(context, resource, genres);

        mContext = context;
        mResource = resource;
        mGenres = genres;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(mResource, parent, false);
        }

        final Genre genreEnCours = mGenres.get(position);

        TextView textViewTitre = (TextView) convertView.findViewById(R.id.tv_item_titre);
        textViewTitre.setText(genreEnCours.getNom());
        return convertView;
    }
}
