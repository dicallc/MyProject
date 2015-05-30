package com.xiaoxin.womenclass.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.xiaoxin.womenclass.R;
import com.xiaoxin.womenclass.adapter.DataShowAdapter;
import com.xiaoxin.womenclass.bean.DataShow;
import com.xiaoxin.womenclass.bean.SomeNews;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class DataShowFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private static List<SomeNews> list;
    private SwipeRefreshLayout mRefreshlayout;
    public static DataShowFragment newInstance() {
        return new DataShowFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data_show, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRefreshlayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout_grid);
        mRefreshlayout.setOnRefreshListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    private void InitData() {
        BmobQuery<DataShow> query = new BmobQuery<DataShow>();
        query.findObjects(getActivity(), new FindListener<DataShow>() {
            @Override
            public void onSuccess(List<DataShow> someNewses) {
                mAdapter = new RecyclerViewMaterialAdapter(new DataShowAdapter(someNewses,getActivity()));
                mRecyclerView.setAdapter(mAdapter);

                MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    @Override
    public void onRefresh() {
        InitData();
        //通知刷新完毕
        mRefreshlayout.setRefreshing(false);
        //滚动到列首部--->这是一个很方便的api，可以滑动到指定位置
        mRecyclerView.scrollToPosition(0);
    }
}
