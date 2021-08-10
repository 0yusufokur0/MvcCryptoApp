package com.example.myapplication.controller.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.constant.ApiMethod;
import com.example.myapplication.constant.FilterType;
import com.example.myapplication.controller.base.BaseFragment;
import com.example.myapplication.model.entity.CryptoStock;
import com.example.myapplication.model.request.GetCryptoStockRequest;
import com.example.myapplication.model.response.BaseResponse;
import com.example.myapplication.model.response.GetCryptoStockResponse;
import com.example.myapplication.view.adapter.CryptoInfoAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import butterknife.BindView;

public class MarketsFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.rvCryptoİnfo)
    RecyclerView recyclerView;

    private CryptoInfoAdapter mAdapter;
    private List<CryptoStock> mStockList;
    private int mCompaniesRequestInterval;
    private FilterType mFilterType;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_markets;
    }

    @Override
    public void assignObjects() {
        super.assignObjects();
        mStockList=new ArrayList<>();
        mAdapter=new CryptoInfoAdapter(context,mStockList);
        mFilterType=FilterType.ALL;
    }

    @Override
    public void onEventReceive(int event, Object... datas) {
        super.onEventReceive(event, datas);


           // sendStocksRequestByFilterType();
        }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void prepareUI() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onLayoutReady() {
        super.onLayoutReady();
        sendGetStocksRequest();
    }

    @Override
    public void onApiResponseReceive(ApiMethod method, BaseResponse baseResponse, boolean isSuccess) {
        if ((method == ApiMethod.GET_CRYPTO_STOCK)) {
            GetCryptoStockResponse response = (GetCryptoStockResponse) baseResponse;
            handleGetStocksResponse(response);
        }
    }

    private void sendStocksRequestByFilterType() {
        if (mFilterType == FilterType.ALL) {
            sendGetStocksRequest();
        }
    }

    private void sendGetStocksRequest() {
        GetCryptoStockRequest  request = new GetCryptoStockRequest();
        request.setKey("");
        sendRequest(request,true);
    }
    private void handleGetStocksResponse(GetCryptoStockResponse response) {
        List<CryptoStock> stocks = response.getStocks();
        if (stocks != null) {
            boolean isAllCompaniesFiltered = (mFilterType == FilterType.ALL);
            mStockList.clear();
            mStockList.addAll(stocks);
            mAdapter.notifyDataSetChanged();
        }

    }

   /* private Handler mSendGetStocksRequestHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            sendStocksRequestByFilterType();
            mSendGetStocksRequestHandler.sendEmptyMessageDelayed(0, mCompaniesRequestInterval);
        }
    };
*/



}
