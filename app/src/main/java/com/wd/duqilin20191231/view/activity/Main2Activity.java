package com.wd.duqilin20191231.view.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.wd.duqilin20191231.R;
import com.wd.duqilin20191231.base.BaseActivity;
import com.wd.duqilin20191231.presenter.MainPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {


    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.bt_01)
    Button bt01;
    @BindView(R.id.bt_02)
    Button bt02;

    @Override
    protected MainPresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        Bitmap image = CodeUtils.createImage("杜其林", 400, 400, null);
        img.setImageBitmap(image);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CodeUtils.analyzeByImageView(img, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this,"成功"+result,Toast.LENGTH_LONG).cancel();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this,"失败",Toast.LENGTH_LONG).cancel();
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_2main;
    }

    @OnClick({R.id.bt_01, R.id.bt_02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_01:
                EventBus.getDefault().post("微信");
                break;
            case R.id.bt_02:
                EventBus.getDefault().post("QQ");
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void aaa(String string) {
        Toast.makeText(Main2Activity.this,string,Toast.LENGTH_LONG).cancel();
    }
}
