package com.example.myapplication.adapter;

import static com.example.myapplication.R.drawable.custom_background_item_child_click;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.callback.OnActionCallBackChild;
import com.example.myapplication.model.SecondModel;

import java.util.List;

public class RecyclerViewChildAdapter extends RecyclerView.Adapter<RecyclerViewChildAdapter.ViewHolder> {
    private List<SecondModel> listSecondModel;
    private Context mContext;
    private OnActionCallBackChild onActionCallBackChild;
    private int defaultIndex = 0 ;

    public RecyclerViewChildAdapter(List<SecondModel> listSecondModel, Context mContext) {
        this.listSecondModel = listSecondModel;
        this.mContext = mContext;
    }

    public void setOnActionCallBackChild(OnActionCallBackChild onActionCallBackChild) {
        this.onActionCallBackChild = onActionCallBackChild;
    }

    public void resetPosition(int position){
        defaultIndex = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_recycler_view_child,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SecondModel secondModel = listSecondModel.get(position);

        holder.tvNameRecyclerViewChild.setText(secondModel.getNameSecond());

        if(defaultIndex == position){
            holder.tvNameRecyclerViewChild.setTextColor(mContext.getResources().getColor(android.R.color.white));
            holder.tvNameRecyclerViewChild.setBackgroundResource(custom_background_item_child_click);
        }else{
            holder.tvNameRecyclerViewChild.setTextColor(mContext.getResources().getColor(android.R.color.black));
            holder.tvNameRecyclerViewChild.setBackgroundResource(R.drawable.custom_background_item_child);
        }


        holder.constraintLayoutRecyclerViewChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultIndex = position;
                onActionCallBackChild.onCallbackChild(listSecondModel , position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSecondModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameRecyclerViewChild ;
        ConstraintLayout constraintLayoutRecyclerViewChild;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameRecyclerViewChild = itemView.findViewById(R.id.tv_name_recycler_view_child);
            constraintLayoutRecyclerViewChild = itemView.findViewById(R.id.constraint_layout_recycler_view_child);
        }
    }
}
