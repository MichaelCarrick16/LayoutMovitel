package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.callback.OnActionCallback;
import com.example.myapplication.model.FirstModel;
import com.example.myapplication.model.SecondModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<FirstModel> mList;
    private Context mContext;
    private OnActionCallback onCallback;
    private int i = 0;

    public RecyclerViewAdapter(List<FirstModel> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public void setNewData(List<FirstModel> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void setOnCallback(OnActionCallback onCallback) {
        this.onCallback = onCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_recycler_view,parent,false);
        return new ViewHolder(view);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            FirstModel firstModel = mList.get(position);
            if(i == position){
            holder.tvLineRecyclerView.setBackgroundColor(mContext.getResources().getColor(android.R.color.black));
            }
            else{
            holder.tvLineRecyclerView.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            holder.textView.setText(firstModel.getName());
            }

            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    i = position;
                    onCallback.onCallback((ArrayList<SecondModel>) firstModel.getListSecondModel());
                    notifyDataSetChanged();
                }
            }
            );

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView , tvLineRecyclerView;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_name_recycler_view);
            tvLineRecyclerView = itemView.findViewById(R.id.tv_line_recycler_view);
            constraintLayout = itemView.findViewById(R.id.constraint_layout_recycler_view);
        }
    }
}
