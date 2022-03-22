package np.com.rishavchudal.test.presentation.dashboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.rishavchudal.domain.models.facts.Fact;
import np.com.rishavchudal.test.R;

/**
 * Created by Rishav Chudal on 21/03/2022.
 */
public class FactRecyclerAdapter extends RecyclerView.Adapter<FactRecyclerAdapter.FactsViewHolder> {
    private List<Fact> facts;

    public FactRecyclerAdapter(List<Fact> facts) {
        this.facts = facts;
    }

    @NonNull
    @Override
    public FactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_fact_item,
                parent,
                false
        );
        return new FactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactsViewHolder holder, int position) {
        Fact individualFact = facts.get(position);
        holder.itemTitleTv.setText(individualFact.getTitle());
        holder.itemDescriptionTv.setText(individualFact.getDescription());
        holder.itemBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

    }

    @Override
    public int getItemCount() {
        return facts.size();
    }

    public static class FactsViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView itemImageView;
        private AppCompatTextView itemTitleTv;
        private AppCompatTextView itemDescriptionTv;
        private AppCompatButton itemBtnEdit;

        public FactsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.item_iv);
            itemTitleTv = itemView.findViewById(R.id.item_title_tv);
            itemDescriptionTv = itemView.findViewById(R.id.item_description_tv);
            itemBtnEdit = itemView.findViewById(R.id.item_btn_edit);
        }

        public AppCompatImageView getItemImageView() {
            return itemImageView;
        }

        public AppCompatTextView getItemTitleTv() {
            return itemTitleTv;
        }

        public AppCompatTextView getItemDescriptionTv() {
            return itemDescriptionTv;
        }

        public AppCompatButton getItemBtnEdit() {
            return itemBtnEdit;
        }
    }
}
