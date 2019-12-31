package com.wd.duqilin20191231.model;

import com.google.gson.Gson;
import com.wd.duqilin20191231.ceniten.IMainCeniten;
import com.wd.duqilin20191231.model.bean.Bean;
import com.wd.duqilin20191231.util.NetUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public class MainModel implements IMainCeniten.IModel {

    @Override
    public void getMainData(IModelCallBack iModelCallBack) {
        String httpUrl = "http://blog.zhaoliang5156.cn/api/news/ranking.json";
        try {
            String encode = URLEncoder.encode(httpUrl, "UTF-8");
//            NetUtil.getInstance().getJson(encode, new NetUtil.MyCallBack() {
//                @Override
//                public void onGetJson(String json) {
//                    Bean bean = new Gson().fromJson(json, Bean.class);
//                    iModelCallBack.onMainSeccess(bean);
//                }
//
//                @Override
//                public void onError(Throwable throwable) {
//                    iModelCallBack.onMainFrese(throwable);
//                }
//            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
