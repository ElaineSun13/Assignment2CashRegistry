package com.example.assignment2cashregistry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreItemRecyclerAdapter extends RecyclerView.Adapter<StoreItemRecyclerAdapter.ItemViewHolder> {
    Context a_context;
    ArrayList<StoreItemManager.PurchaseItem> storeItems;

    public interface StoreItemClickListener{
        public void onToDoSelected(StoreItemManager.PurchaseItem selectedToDo);
    }

    StoreItemRecyclerAdapter(Context context, ArrayList<StoreItemManager.PurchaseItem> listOfToDos){
        a_context = context;
        storeItems = listOfToDos;
    }

    public StoreItemClickListener listener;

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private final TextView listName;
        private final TextView listPrice;
        private final TextView listQuantity;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            listName=itemView.findViewById(R.id.productName_in_row);
            listPrice=itemView.findViewById(R.id.productPrice_in_row);
            listQuantity=itemView.findViewById(R.id.productQuanity_in_row);
        }
        public TextView getNameView() {
            return listName;
        }

        public TextView getPriceView() {
            return listPrice;
        }
        public TextView getQuantityView() {
            return listQuantity;
        }
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(a_context).inflate(R.layout.list_history_view,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.getNameView().setText(storeItems.get(position).getProductName()+ "");
        holder.getPriceView().setText(storeItems.get(position).getTotal()+"");
        holder.getQuantityView().setText(storeItems.get(position).getQuantity()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onToDoSelected(storeItems.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return storeItems.size();
    }

}
