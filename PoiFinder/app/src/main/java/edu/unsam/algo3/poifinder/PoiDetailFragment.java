package edu.unsam.algo3.poifinder;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.unsam.algo3.poifinder.model.Colectivo;
import edu.unsam.algo3.poifinder.model.Poi;
import edu.unsam.algo3.poifinder.model.RepoPois;
import edu.unsam.algo3.poifinder.util.CustomPoiDeserializer;

/**
 * A fragment representing a single Poi detail screen.
 * This fragment is either contained in a {@link PoiListActivity}
 * in two-pane mode (on tablets) or a {@link PoiDetailActivity}
 * on handsets.
 */
public class PoiDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */

    //private Poi mItem;
    private Poi poiSeleccionado;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PoiDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            poiSeleccionado = RepoPois.findById(getArguments().getInt(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(poiSeleccionado.getNombre());
            }
        }
    }

    //metodo original

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;
        if (poiSeleccionado != null) {
            rootView = getView(inflater, container, savedInstanceState);
            ((TextView) rootView.findViewById(R.id.poi_direccion)).setText(poiSeleccionado.getDireccion());
            ((TextView) rootView.findViewById(R.id.poi_nro)).setText(String.valueOf(poiSeleccionado.getNumero()));
        }
        return rootView;
    }

    public View getView(LayoutInflater inflater, ViewGroup container,
                        Bundle savedInstanceState){
        try {
            String type = poiSeleccionado.getTipo();
            Class<?>[] paramTypes = {LayoutInflater.class, ViewGroup.class, Bundle.class};
            Method createViewMethod = this.getClass().getMethod("createView"+type, paramTypes);
            return (View) createViewMethod.invoke(this, inflater, container, savedInstanceState);
        } catch (SecurityException e) {  }
        catch (NoSuchMethodException e) {  }
        catch (IllegalArgumentException e) {  }
        catch (IllegalAccessException e) {  }
        catch (InvocationTargetException e) {  }

        return null;
    }

    public View createViewColectivo(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_detail_colectivo, container, false);
        String paradas = String.valueOf( ((Colectivo) poiSeleccionado).getCantParadas());
        ((TextView) rootView.findViewById(R.id.txtCantParadas)).setText( paradas);
        return rootView;
    }

    public View createViewBanco(LayoutInflater inflater, ViewGroup container,
                                    Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_detail_banco, container, false);
        return rootView;
    }

    public View createViewLocal(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_detail_local, container, false);
        return rootView;
    }
    public View createViewCGP(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_detail_cgp, container, false);
        return rootView;
    }




}
