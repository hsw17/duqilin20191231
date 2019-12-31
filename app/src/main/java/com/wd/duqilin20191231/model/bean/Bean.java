package com.wd.duqilin20191231.model.bean;

import java.util.List;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public class Bean {

    public List<RankingBean> ranking;

    public static class RankingBean {
        /**
         * avatar : http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg
         * name : Alice
         * rank : 1
         */

        public String avatar;
        public String name;
        public String rank;
    }
}
