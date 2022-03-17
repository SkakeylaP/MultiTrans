package com.skakeylapearson.multitrans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private Context context;
    private List<RetroTranslation> translations;

    public RecyclerAdapter(Context context, List<RetroTranslation> translations) {
        this.context = context;
        this.translations = translations;
    }
    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView titleView;
        TextView translationView;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            titleView = mView.findViewById(R.id.languageTitle);
            translationView = mView.findViewById(R.id.translatedText);
        }
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row, parent, false);
        return new RecyclerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) { holder.titleView.setText(translations.get(position).getTranslatedText()); }
    @Override
    public int getItemCount() { return translations.size(); }

}

