package com.xiaoxin.womenclass.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaoxin.womenclass.R;
import com.xiaoxin.womenclass.WebViewActivity;
import com.xiaoxin.womenclass.bean.DataShow;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class DataShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<DataShow> list;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private  Context ct;
    public DataShowAdapter(List<DataShow> list, Context ct) {
        this.list=list;
        this.ct=ct;
    }

    @Override
    public int getItemViewType(int position) {
                return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = null;

                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                TextView title= (TextView) view.findViewById(R.id.title);
                title.setText(list.get(viewType).getTitle());
                ImageView logo= (ImageView) view.findViewById(R.id.logo);
                 view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(ct, WebViewActivity.class);
                        intent.putExtra("content",list.get(viewType).getContent());
                        intent.putExtra("title",list.get(viewType).getTitle());
                        ct.startActivity(intent);
                    }
                });
                Picasso.with(ct).load(list.get(viewType).getLogo()).into(logo);
                return new RecyclerView.ViewHolder(view) {
                };
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }

    //点击事件
    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }
    public interface OnItemClickListener
    {
        public void OnItemClick(View view, String data);
    }
}