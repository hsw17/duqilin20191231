package com.wd.duqilin20191231.presenter;

import com.wd.duqilin20191231.base.BasePresenter;
import com.wd.duqilin20191231.ceniten.IMainCeniten;
import com.wd.duqilin20191231.model.MainModel;
import com.wd.duqilin20191231.model.bean.Bean;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public class MainPresenter extends BasePresenter<IMainCeniten.IView> implements IMainCeniten.IPresenter {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
    }

    @Override
    public void getMainData() {
        mainModel.getMainData(new IMainCeniten.IModel.IModelCallBack() {
            @Override
            public void onMainSeccess(Bean bean) {
                view.onMainSeccess(bean);
            }

            @Override
            public void onMainFrese(Throwable throwable) {
                view.onMainFrese(throwable);
            }
        });
    }
}
