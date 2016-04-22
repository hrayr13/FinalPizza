package com.hrayr.pizza;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private List<Pizza> pizzas;
    private Context context;

    public RecycleAdapter(Context context, List<Pizza> pizzas){
        this.pizzas = pizzas;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView cardView;
        TextView textView;
        ImageView imageView;
        private int position;

        public ViewHolder(CardView view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            textView = (TextView) cardView.findViewById(R.id.info_text);
            imageView = (ImageView) cardView.findViewById(R.id.info_image);
            cardView.setOnClickListener(this);
//            textView.setOnClickListener(this);
//            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Pizza p = pizzas.get(position);
            context.startActivity(new Intent(context, ActivityDetail.class)
                    .putExtra(Constants.KEY_TITLE, p.getName())
                    .putExtra(Constants.KEY_IMAGE_ID, p.getImageId())
                    .putExtra(Constants.KEY_DESCRIPTION, p.getDescription()));

        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new RecycleAdapter.ViewHolder (cardView);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        Pizza piza = pizzas.get(position);
        holder.setPosition(position);
        holder.imageView.setImageResource(piza.getImageId());
        holder.textView.setText(piza.getName());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount(){
        return pizzas.size();
    }
}
