package com.easydeliver.ink.app.ui.mefragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.utils.ScreenUtils;

import me.drakeet.multitype.ItemViewBinder;

public class MeTextItemViewBinder extends ItemViewBinder<MeText, MeTextItemViewBinder.MeTextViewHolder> {
    @NonNull
    @Override
    protected MeTextItemViewBinder.MeTextViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_me_text,parent,false);

        return new MeTextViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull MeTextItemViewBinder.MeTextViewHolder holder, final @NonNull MeText item) {
        holder.img.setImageResource(item.getImg());
        holder.tv_text.setText(item.getInt_text());
        holder.rllayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // ScreenUtils.adaptScreen4VerticalSlide(this.getActivity(), 750);
                ScreenUtils.cancelAdaptScreen();
                Toast.makeText(view.getContext(),
                        view.getContext().getResources().getText(item.getInt_text()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class MeTextViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv_text;
        private RelativeLayout rllayout;
        public MeTextViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.me_item_img);
            tv_text =itemView.findViewById(R.id.me_item_text);
            rllayout = itemView.findViewById(R.id.rllayout);
        }
    }
}
