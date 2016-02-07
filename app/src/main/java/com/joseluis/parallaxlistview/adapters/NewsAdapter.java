package com.joseluis.parallaxlistview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.joseluis.parallaxlistview.R;
import com.joseluis.parallaxlistview.model.News;

import java.util.List;

/**
 * NewsAdapter Class
 *
 * Clase que implementa un Adaptador que dará vida a un ListView.
 *
 * Author: José Luis Sánchez
 */
public class NewsAdapter extends BaseAdapter {

    /**
     * Listado de objetos (model)
     */
    private List<News> arrAdapter;

    /**
     * objeto con el que traeremos la vista a la clase
     */
    private LayoutInflater inflater;


    /**
     * Constructor del adaptador
     * @param arrAdapter
     */
    public NewsAdapter(List<News> arrAdapter, Context context){
        super();
        this.arrAdapter = arrAdapter;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrAdapter.size();
    }

    @Override
    public Object getItem(int i) {
        return arrAdapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //get model
        News news = arrAdapter.get(i);

        //get view
        View rowView = view;

        //if null, inflate
        if(rowView == null) {
            rowView = inflater.inflate(R.layout.lay_news_row, viewGroup, false);
        }

        //configuramos el titulo
        TextView tvTitleNews = (TextView) rowView.findViewById(R.id.tvTitle);
        tvTitleNews.setText(news.getTitle());

        //configuramos la fecha
        TextView tvSubTitleNews = (TextView) rowView.findViewById(R.id.tvDesc);
        tvSubTitleNews.setText(news.getDesc());

        TextView tvFecha = (TextView) rowView.findViewById(R.id.tvFecha);
        tvFecha.setText(news.getDate());

        //seteamos el objeto
        rowView.setTag(news);

        return rowView;
    }
}
