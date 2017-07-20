package teerayut.dev.vlife.payment.summary;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.home.Item.CartItem;
import teerayut.dev.vlife.main.MainActivity;
import teerayut.dev.vlife.payment.detail.adapter.DetailAdapter;
import teerayut.dev.vlife.payment.pay.PayFragment;
import teerayut.dev.vlife.utils.Alert;
import teerayut.dev.vlife.utils.ExtactCartItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment implements SummaryInterface.View{


    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }

    private DetailAdapter adapter;
    private SweetAlertDialog sweetAlertDialog;
    private Cart cart = CartHelper.getCart();
    private List<CartItem> cartItemList = Collections.emptyList();
    public SummaryFragment() {
        // Required empty public constructor
    }

    private SummaryInterface.Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        bindView(view);
        return view;
    }

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.summary_payment) TextView payMent;
    @BindView(R.id.summary_delivery) TextView deliverYBy;
    @BindView(R.id.summary_address_delivery) TextView addressDelivery;
    @BindView(R.id.button_summary_apply) Button buttonApply;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        buttonApply.setOnClickListener( onApply() );
        setInstance();
        setListItem();
        setDetailSummary();
    }

    private void setInstance() {
        presenter = new SummaryPresenter(this);
    }

    private void setListItem() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        prepareItem();
    }

    private void prepareItem() {
        //StringBuilder sb2 = new StringBuilder();
        cartItemList = new ExtactCartItem().getCartItems(cart);
        if (cartItemList.size() > 0) {
            adapter = new DetailAdapter(getActivity(), cartItemList);
            recyclerView.setAdapter(adapter);
            /*for (CartItem item : cartItemList) {
                int quantity = item.getQuantity();
                int pv = Integer.parseInt(item.getProduct().getPv());
                int price = Integer.parseInt(item.getProduct().getPrice() + "");
                sumPV += (pv * quantity);
                sumPrice += (price * quantity);
            }
            sb2.append(String.valueOf(String.format("%,d", sumPV)) + "\n");
            sb2.append(String.valueOf(String.format("%,d", sumPrice)) + " " + getResources().getString(R.string.price_symbol) + "\n");
            sb2.append("0" + " " + getResources().getString(R.string.price_symbol) + "\n");
            sb2.append(String.valueOf(String.format("%,d", sumPrice))  + " " + getResources().getString(R.string.price_symbol));
            textViewSumValus.setText(sb2.toString());*/
        } else {
            /*sb2.append("0" + "\n");
            sb2.append("0" + " " + getResources().getString(R.string.price_symbol) + "\n");
            sb2.append("0" + " " +  getResources().getString(R.string.price_symbol) +  "\n");
            sb2.append("0" + " " +  getResources().getString(R.string.price_symbol));
            textViewSumValus.setText(sb2.toString());*/
        }
    }

    private void setDetailSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t" + getActivity().getResources().getString(R.string.address_name) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_phone) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_number) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_building) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_village) + ":" + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_soi) + ":" + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_road) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_sub_district) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_district) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_province) + ": " + "\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_zipcode) + ": ");
        addressDelivery.setText(sb.toString());
        payMent.setText(getActivity().getResources().getString(R.string.title_bank_tranfer));
        deliverYBy.setText(getActivity().getResources().getString(R.string.massenger));
    }

    private View.OnClickListener onApply() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sendOrder();
            }
        };
    }

    @Override
    public void onFail(String failed) {
        Alert.dialogError(getActivity(), R.string.dialog_msg_apply_error);
    }

    @Override
    public void onSuccess(String success) {
        cart.clear();
        cartItemList.clear();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        Alert.dialogSuccess(getActivity(), R.string.dialog_msg_apply_success, intent);
    }

    @Override
    public void onGoToHomePage() {
        cart.clear();
        cartItemList.clear();
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }
}
