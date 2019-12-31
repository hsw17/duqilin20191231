package com.wd.duqilin20191231.ceniten;

import com.wd.duqilin20191231.model.bean.Bean;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public interface IMainCeniten {

    interface IView{
        void onMainSeccess(Bean bean);
        void onMainFrese(Throwable throwable);
    }

    interface IPresenter{
        void getMainData();
    }

    interface IModel{
        void getMainData(IModelCallBack iModelCallBack);

        interface IModelCallBack{
            void onMainSeccess(Bean bean);
            void onMainFrese(Throwable throwable);
        }
    }
}
