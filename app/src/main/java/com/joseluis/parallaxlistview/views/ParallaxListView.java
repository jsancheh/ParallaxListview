package com.joseluis.parallaxlistview.views;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.joseluis.parallaxlistview.R;


/**
 * Parallax Class
 *
 * Esta clase implementa los métodos necesarios para configurar una lista de elementos en la que su vista inicial o HeaderView
 * realiza un efecto parallax según se va realizando el scroll
 *
 * Author: José Luis Sánchez
 */
public class ParallaxListView extends ListView implements AbsListView.OnScrollListener {

    /**
     * Contexto de la app
     */
    private Context mContext;

    /**
     * Imagen que realizará el efecto parallax
     */
    private ImageView mParallaxImage;

    /**
     * Texto que realizará el efecto fade in / fade out
     */
    private TextView mParallaxTitle;

    /**
     * Variable que hace de contador para realizar el efecto parallax
     */
    private int lastTopValueAssigned = 0;

    /**
     * Variable que configura si se quiere o no el efecto alpha del titulo
     */
    private boolean alphaEnable = true;

    /**
     * Variable que configura si se quiere o no el efecto parallax
     */
    private boolean parallaxEnable = true;

    /**
     * Valor inicial de la vista (alpha)
     */
    private static final float ALPHA_INICIAL = 1.0f;

    /**
     * valor Alpha inicial
     */
    private float alpha = ALPHA_INICIAL;

    /**
     * Variable que configura si debe mostrarse el titulo o no
     */
    private boolean visibleTitle = true;

    /**
     * Velocidad del efecto 1
     */
    public static final double MODE_ONE = 2.0;

    /**
     * Velocidad del efecto 2
     */
    public static final double MODE_TWO = 4.0;

    /**
     * Velocidad del efecto 3
     */
    public static final double MODE_THREE = 6.0;

    /**
     * Variable que contiene el modo
     */
    private double parallaxMode = MODE_ONE;

    /**
     * Campo para identificar la primera posición
     */
    private static final int FIRST_POS = 1;

    /**
     * Campo para dividir y obtener el valor incremental del alpha
     */
    private static final float DIV = 1F;

    /**

     * Constructor por defecto
     * @param context - conexto de la aplicación
     */
    public ParallaxListView(Context context) {
        super(context);
        setmContext(context);
        initViews();
        setOnScrollListener(this);
    }

    /**
     * Constructor con atributos
     * @param context - contexto de la aplicación
     * @param attrs - atributos
     */
    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setmContext(context);
        initViews();
        setOnScrollListener(this);
    }

    /**
     *
     * @param context - contexto de la aplicacion
     * @param attrs - atributos
     * @param defStyleAttr - estilos
     */
    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setmContext(context);
        initViews();
        setOnScrollListener(this);
    }

    /**
     * Inicializa las vistas
     */
    private void initViews(){

        //inflamos la vista
        LayoutInflater inflater = (LayoutInflater) getmContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup headerParallax = (ViewGroup) inflater.inflate(R.layout.lay_parallax_img, this, false);

        //obtenemos el titulo y la imagen
        mParallaxImage = (ImageView) headerParallax.findViewById(R.id.imgParallax);
        mParallaxTitle = (TextView) headerParallax.findViewById(R.id.tvParallax);
        mParallaxTitle.setVisibility(isVisibleTitle() ? VISIBLE : GONE);

        //añadimos la vista al header
        addHeaderView(headerParallax);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {}


    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

        //si la primera posiciones, la siguiente despues del header no esta disponible, nos salimos
        if(getChildAt(FIRST_POS) == null){
            return;
        }

        //obtenemos el incremento unitario para el alpha
        float alphaDiff = DIV / mParallaxImage.getHeight();

        //multiplcamos ese incremento por la posicion
        float alpha = getChildAt(FIRST_POS).getTop() * alphaDiff;

        //aplicamos el efecto
        parallaxEffect(alpha);
    }


    /**
     * Configura los efectos en tiempo de ejecución
     * @param alpha - valor del alpha
     */
    private void parallaxEffect(float alpha) {

        //si el efecto está activo
        if(isParallaxEnable()) {
            Rect rect = new Rect();
            mParallaxImage.getLocalVisibleRect(rect);
            if (lastTopValueAssigned != rect.top) {
                lastTopValueAssigned = rect.top;
                mParallaxImage.setY((int) (rect.top / parallaxMode));
            }
        }

        //si el efecto está activo
        if(isAlphaEnable()) {
            mParallaxTitle.setAlpha(alpha);
        }
    }


    /**
     * Añade una imagen a la vista desde un recurso de la aplicación
     * @param resource - recurso de la aplicación
     */
    public void addSourceToImage(int resource){
        mParallaxImage.setImageResource(resource);
    }

    /**
     * Añade una imagen a la vista Imageview desde un archivo externo
     * @param path - uri o path de la imagen
     */
    public void addSourceToImage(Uri path){
        mParallaxImage.setImageURI(path);
    }

    /**
     * Establece un titulo en el Textview
     * @param title - titulo
     */
    public void setTitle(String title){
        mParallaxTitle.setText(title);
    }

    /**
     * Establece la velocidad del efecto al hacer scroll en la lista
     * @param mode - velocidad del effecto parallax
     */
    public void setMode(double mode){
        parallaxMode = mode;
    }

    /**
     * Devuelve el estado del efecto parallax
     * @return - estado del efecto
     */
    public boolean isParallaxEnable() {
        return parallaxEnable;
    }

    /**
     * Establece el efecto parallax
     * @param parallaxEnable - estado del efecto
     */
    public void setParallaxEnable(boolean parallaxEnable) {
        this.parallaxEnable = parallaxEnable;
    }

    /**
     * Devuelve el estado del efecto
     * @return - estado del efecto
     */
    public boolean isAlphaEnable() {
        return alphaEnable;
    }

    /**
     * Estable si el efecto alfa está activo o no
     * @param alphaEnable - estado del efecto
     */
    public void setAlphaEnable(boolean alphaEnable) {
        this.alphaEnable = alphaEnable;
    }

    /**
     * Devuelve el estado de la variable
     * @return - estado del titulo
     */
    public boolean isVisibleTitle() {
        return visibleTitle;
    }

    /**
     * Setea el estado de la variable
     * @param visibleTitle - estado del titulo
     */
    public void setVisibleTitle(boolean visibleTitle) {
        this.visibleTitle = visibleTitle;
    }

    /**
     * Devuelve el contexto de la aplicacion
     * @return - contexto de la aplicación
     */
    public Context getmContext() {
        return mContext;
    }

    /**
     * Establece el contexto de la aplicacion en la calse
     * @param mContext - contexto de la aplicacion
     */
    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

}
