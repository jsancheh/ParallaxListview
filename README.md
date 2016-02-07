# ParallaxListview
Proyecto que implementa un Listview custom con efecto Parallax de una forma muy sencilla. Sólo necesitas importar a tu proyecto la clase ParallaxListView.java y el recurso lay_parallax_img.xml.

Ejemplo: 
<code><pre>
  ParallaxListView parallaxListView = (ParallaxListView) findViewById(R.id.pListView);<br />
  parallaxListView.addSourceToImage(R.mipmap.img_parallax);<br />
  parallaxListView.setTitle("Título");<br />
</pre></code>

Si no queremos mostrar título dentro de la Imagen
<code><pre>
  parallaxListView.setVisibleTitle(false);
</pre></code>

Si queremos deshabilitar los efectos de Parallax (ImageView) y Alpha (TextView)
<code><pre>
  parallaxListView.setAlphaEnable(false);
  parallaxListView.setParallaxEnable(false);
</pre></code>

MainActivity.xml

```xml
  <com.joseluis.parallaxlistview.views.ParallaxListView
    android:id="@+id/pListView"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
  </com.joseluis.parallaxlistview.views.ParallaxListView>
```

lay_parallax_img.xml (Parallax)

```xml
  <?xml version="1.0" encoding="utf-8"?>
  <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="@dimen/header_height"
    android:orientation="vertical">

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/imgParallax"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:scaleType="centerCrop"
            android:src="@null" />

        <TextView
            android:id="@+id/tvParallax"
            android:gravity="center"
            android:layout_gravity="center"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            style="@style/headerText"
            android:text="@null" />

    </FrameLayout>
</FrameLayout>
```

![alt tag](https://github.com/jsancheh/ParallaxListview/blob/master/captura1.png)

![alt tag](https://github.com/jsancheh/ParallaxListview/blob/master/captura2.png)
