package com.example.labo.ingesup.series.list;

import android.content.Context;
import android.widget.ArrayAdapter;

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

    public SerieAdapter(Context context, int resource, List objects, List<Serie> mSeries) {
        super(context, resource, objects);
        this.mSeries = mSeries;
    }
}
