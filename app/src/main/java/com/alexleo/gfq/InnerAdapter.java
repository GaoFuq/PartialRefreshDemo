package com.alexleo.gfq;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexleo.partialrefreshdemo.R;

import java.util.List;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder> {

    private Context context;
    private List<InnerBean> list;
    private LayoutInflater layoutInflater;


    public InnerAdapter(Context context, List<InnerBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.item,parent,false);
        return new InnerHolder(rootView);
    }

    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(InnerHolder holder, final int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        final InnerBean test = list.get(position);
        if (payloads.isEmpty()){
            holder.content.setText(list.get(position).getLikeName());
        }else {

            holder.content.setText(list.get(position).getLikeName());

        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public void update(int posi) {
        InnerBean test = list.get(posi);
        test.setLikeName("LikeName**"+posi);
        //notifyItemChanged(posi);
        notifyItemChanged(posi,"ll");
    }

    class InnerHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        Button itemDownBtn;
        TextView content;
        ImageView itemImg;
        RecyclerView rvInner;

        InnerHolder(View itemView) {
            super(itemView);
            itemImg = (ImageView) itemView.findViewById(R.id.itemImg);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            //itemSize = (TextView) itemView.findViewById(R.id.itemSize);
            itemDownBtn = (Button) itemView.findViewById(R.id.itemDownBtn);
            content = (TextView)itemView.findViewById(R.id.content);
            rvInner = (RecyclerView)itemView.findViewById(R.id.rv_inner);
        }
    }

}

