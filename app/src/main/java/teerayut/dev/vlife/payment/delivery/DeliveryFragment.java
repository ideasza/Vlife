package teerayut.dev.vlife.payment.delivery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends Fragment {


    public DeliveryFragment() {
        // Required empty public constructor
    }

    public static DeliveryFragment newInstance() {
        return new DeliveryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery, container, false);
    }

}
