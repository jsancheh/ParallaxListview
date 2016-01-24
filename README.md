# ParallaxListview
Proyecto que implementa un Listview custom con efecto Parallax sin tener que implementar nada en tu proyecto.

Ejemplo: 
<code><pre>
  ParallaxListView parallaxListView = (ParallaxListView) findViewById(R.id.pListView);<br />
  parallaxListView.addSourceToImage(R.mipmap.img_parallax);<br />
  parallaxListView.setTitle("Nuestro Título");<br />
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
