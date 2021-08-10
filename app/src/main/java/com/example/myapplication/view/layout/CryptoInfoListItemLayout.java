package com.example.myapplication.view.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.example.myapplication.constant.ApiMethod;
import com.example.myapplication.controller.base.BaseActivity;
import com.example.myapplication.controller.base.BaseApiActivity;
import com.example.myapplication.manager.api.ApiListener;
import com.example.myapplication.model.entity.CryptoStock;
import com.example.myapplication.model.response.BaseResponse;

import javax.security.auth.callback.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CryptoInfoListItemLayout extends FrameLayout implements View.OnClickListener, ApiListener {

    public static final int EVENT_STOCK_DROPPED = BaseActivity.getNewEventId();

    private static final int RESOURCE = R.layout.layout_crypto_info_list_item;

    @BindView(R.id.tvCurrency)
    TextView tvCurrency;
    @BindView(R.id.tvPrice)
    TextView tvPrice;

    private BaseApiActivity mActivity;
    private Context mContext;
    private CryptoStock mStock;
    private Callback mCallback;

    public CryptoInfoListItemLayout(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(RESOURCE, this,true);
        ButterKnife.bind(this);
        mActivity = (BaseApiActivity) getContext();
        mContext = context;

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActivity.addApiListener(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mActivity.removeApiListener(this);
    }


    @Override
    public void onApiResponseReceive(ApiMethod method, BaseResponse response, boolean isSuccess) {

    }


    public void fillContent(CryptoStock stock,int position){
        mStock=stock;
        tvCurrency.setText(stock.getCurrency());
        tvPrice.setText(String.valueOf(stock.getPrice()));
    }
}
