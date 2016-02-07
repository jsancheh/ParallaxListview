package com.joseluis.parallaxlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joseluis.parallaxlistview.adapters.NewsAdapter;
import com.joseluis.parallaxlistview.model.News;
import com.joseluis.parallaxlistview.views.ParallaxListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * MainActivity Class
 *
 * Clase de tipo Activity
 *
 * Author: José Luis Sánchez
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Formato de fecha
     */
    private static final String FORMAT = "dd/MM/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //quitamos el status bar para poder poner la imagen hasta arriba
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //instanciamos el listview
        ParallaxListView parallaxListView = (ParallaxListView) findViewById(R.id.pListView);
        parallaxListView.addSourceToImage(R.mipmap.img_parallax);
        parallaxListView.setTitle(getString(R.string.app_name));

        //efecto fade in / fade out en le texto
        parallaxListView.setAlphaEnable(true);

        //efecto parallax en la imagen
        parallaxListView.setParallaxEnable(true);
        parallaxListView.setMode(ParallaxListView.MODE_ONE);

        //configuramos el adaptador para mostrar elementos en nuestra lista
        ArrayList<News> arrayList = new ArrayList<>();

        //obtenemos la fecha actual
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat(FORMAT);
        String today = formatter.format(date);

        //añadimos el modelo al array
        for(int i=0; i<20; i++){
            News news = new News();
            news.setIdNews(i);
            news.setTitle(getString(R.string.title_news) + (i + 1));
            news.setDesc(getString(R.string.desc_news));
            news.setDate(today);
            arrayList.add(news);
        }

        NewsAdapter adapter = new NewsAdapter(arrayList, this);
        parallaxListView.setAdapter(adapter);
    }

}
