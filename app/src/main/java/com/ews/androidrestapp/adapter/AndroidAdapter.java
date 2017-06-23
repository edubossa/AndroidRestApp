package com.ews.androidrestapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ews.androidrestapp.R;
import com.ews.androidrestapp.model.Android;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wallace on 21/06/17.
 */
public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    private List<Android> androids;

    public AndroidAdapter(List<Android> list) {
        this.androids = list;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO parametro false significa que nao vou inflar meu layout nesse momento
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.android_row, parent, false);
        AndroidViewHolder viewHolder = new AndroidViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        Android android = androids.get(position);
        holder.tvTitulo.setText(android.getNome());
        holder.tvSubtitulo.setText(android.getVersao());

        //TODO http://square.github.io/picasso/
        Picasso.with(holder.itemView.getContext())
                .load(android.getUrlImagem())
                .placeholder(R.mipmap.ic_launcher) //TODO load enquanto carrega a imagem
                .error(R.mipmap.ic_launcher) //TODO caso a primeira imagem do logo der erro
                .into(holder.ivLogo);

    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    public static class AndroidViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogo;
        public TextView tvTitulo;
        public TextView tvSubtitulo;

        public AndroidViewHolder(View itemView) {
            super(itemView);
            ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tvSubtitulo);
        }
    }

}