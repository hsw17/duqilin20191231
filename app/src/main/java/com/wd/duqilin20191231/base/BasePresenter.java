package com.wd.duqilin20191231.base;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }
}
