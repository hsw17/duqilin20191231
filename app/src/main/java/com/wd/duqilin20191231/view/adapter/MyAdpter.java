package com.wd.duqilin20191231.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wd.duqilin20191231.R;
import com.wd.duqilin20191231.model.bean.Bean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/12/31
 * author:贺少伟(盗)
 * function:
 */
public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyViewHodel> {
    private List<Bean.RankingBean> ranking;

    public MyAdpter(List<Bean.RankingBean> ranking) {

        this.ranking = ranking;
    }

    @NonNull
    @Override
    public MyViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new MyViewHodel(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodel holder, int position) {
        Bean.RankingBean rankingBean = ranking.get(position);
        holder.tvRen.setText(rankingBean.name);
        holder.tvJia.setText(rankingBean.rank);
        Glide.with(holder.imageview).load(rankingBean.avatar)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new CenterCrop()))
                .into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return ranking.size();
    }

    class MyViewHodel extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview)
        ImageView imageview;
        @BindView(R.id.tv_ren)
        TextView tvRen;
        @BindView(R.id.tv_jia)
        TextView tvJia;
        public MyViewHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(String str);
    }
}
