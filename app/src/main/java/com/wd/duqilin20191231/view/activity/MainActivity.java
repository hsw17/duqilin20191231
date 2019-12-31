package com.wd.duqilin20191231.view.activity;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.duqilin20191231.R;
import com.wd.duqilin20191231.base.BaseActivity;
import com.wd.duqilin20191231.ceniten.IMainCeniten;
import com.wd.duqilin20191231.model.bean.Bean;
import com.wd.duqilin20191231.presenter.MainPresenter;
import com.wd.duqilin20191231.util.NetUtil;
import com.wd.duqilin20191231.view.adapter.MyAdpter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainCeniten.IView {

    @BindView(R.id.tv_name)
    TextView tv_Name;
    @BindView(R.id.rv)
    RecyclerView recyclerView;

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        if (NetUtil.getInstance().haxNet(this)){
            mPresenter.getMainData();
        }else {
            Toast.makeText(MainActivity.this,"没有网络",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onMainSeccess(Bean bean) {
        List<Bean.RankingBean> ranking = bean.ranking;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdpter myAdpter = new MyAdpter(ranking);
        recyclerView.setAdapter(myAdpter);
    }

    @Override
    public void onMainFrese(Throwable throwable) {
        Toast.makeText(MainActivity.this,"失败"+throwable,Toast.LENGTH_LONG).cancel();
    }

    @OnClick(R.id.tv_name)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
