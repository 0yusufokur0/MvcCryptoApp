package com.example.myapplication.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.entity.CryptoStock;
import com.example.myapplication.view.layout.CryptoInfoListItemLayout;

import java.util.List;

public class CryptoInfoAdapter extends RecyclerView.Adapter<CryptoInfoAdapter.ViewHolder> {

    private final Context mContext;
    private final List<CryptoStock> mCryptoStock;

    public CryptoInfoAdapter(Context context, List<CryptoStock> cryptoStocks) {
        mContext = context;
        mCryptoStock = cryptoStocks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CryptoInfoListItemLayout layout = new CryptoInfoListItemLayout(mContext);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CryptoStock stock = mCryptoStock.get(position);
        holder.layout.fillContent(stock, position);
    }

    @Override
    public int getItemCount() {
        return mCryptoStock.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final CryptoInfoListItemLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (CryptoInfoListItemLayout) itemView;
        }
    }
}
