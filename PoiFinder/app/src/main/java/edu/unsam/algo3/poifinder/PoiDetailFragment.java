package edu.unsam.algo3.poifinder;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.unsam.algo3.poifinder.model.Poi;
import edu.unsam.algo3.poifinder.model.RepoPois;

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
        View rootView = inflater.inflate(R.layout.poi_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (poiSeleccionado != null) {
            ((TextView) rootView.findViewById(R.id.poi_direccion)).setText(poiSeleccionado.getDireccion());
            ((TextView) rootView.findViewById(R.id.poi_nro)).setText(String.valueOf(poiSeleccionado.getNumero()));


            //((TextView) rootView.findViewById(R.id.poi_nr)).setText(String.valueOf(poiSeleccionado.getCantParadas()));
        }

        return rootView;
    }

    // metodo alternativo

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState)
//
//    {
//        View rootViewColectivo = inflater.inflate(R.layout.poi_detailColectivo, container, false);
//        View rootViewCgp = inflater.inflate(R.layout.poi_detailCgp, container, false);
//        View rootViewLocal = inflater.inflate(R.layout.poi_detailLocal, container, false);
//        View rootViewBanco = inflater.inflate(R.layout.poi_detailBanco, container, false);
//
//        //Show the dummy content as text in a TextView.
//        if ((poiSeleccionado != null) && (poiSeleccionado.getTipo() == "Colectivo"))
//        {
//            ((TextView) rootViewColectivo.findViewById(R.id.poi_direccion)).setText(poiSeleccionado.getDireccion());
//            ((TextView) rootViewColectivo.findViewById(R.id.poi_nr)).setText(String.valueOf(poiSeleccionado.getCantParadas()))
//
//            //((TextView) rootViewColectivo.findViewById(R.id.poi_nro)).setText(String.valueOf(poiSeleccionado.getNumero()));
//
//            return rootViewColectivo;
//        }
//
//        else if ((poiSeleccionado != null) && (poiSeleccionado.getTipo() == "CGP"))
//        {
//            ((TextView) rootViewColectivo.findViewById(R.id.poi_direccion)).setText(poiSeleccionado.getDireccion());
//            return rootViewCgp;
//        }
//
//        else if ((poiSeleccionado != null) && (poiSeleccionado.getTipo() == "Local"))
//        {
//            ((TextView) rootViewColectivo.findViewById(R.id.poi_direccion)).setText(poiSeleccionado.getDireccion());
//            return rootViewLocal;
//        }
//
//            ((TextView) rootViewColectivo.findViewById(R.id.poi_direccion)).setText(poiSeleccionado.getDireccion());
//            return rootViewBanco;
//    }







}
