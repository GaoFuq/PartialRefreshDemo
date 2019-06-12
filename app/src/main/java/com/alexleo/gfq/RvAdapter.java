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

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private Context context;
    private List<TestBean> list;
    private LayoutInflater layoutInflater;


    public RvAdapter(Context context, List<TestBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        final TestBean test = list.get(position);
        if (payloads.isEmpty()){
            holder.content.setText(list.get(position).getContent());
            holder.itemName.setText(test.getName());

            InnerAdapter innerAdapter = new InnerAdapter(context,list.get(position).getInnerList());
            holder.rvInner.setAdapter(innerAdapter);
            holder.itemDownBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    update(position);
                    // notifyItemChanged(position,"ll");
                }
            });
        }else {

            holder.content.setText(list.get(position).getContent());
            holder.rvInner.getAdapter().notifyItemChanged(0,"liked");
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public void update(RecyclerView.ViewHolder holder,int posi) {
        TestBean test = list.get(posi);
        test.setContent(System.currentTimeMillis()+"");
        //notifyItemChanged(posi);
        notifyItemChanged(posi,"ll");
       // holder.itemView.getAdapter().notifyItemChanged(0,"liked");
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        Button itemDownBtn;
        TextView content;
        ImageView itemImg;
        RecyclerView rvInner;

        MyViewHolder(View itemView) {
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


