package com.listsofcardswithsectionssample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.listsofcardswithsectionssample.R;

/**
 * Created by Admin on 29-12-2016.
 */
public class SectionOfDays_RecyclerViewAdapter extends RecyclerView.Adapter<SectionOfDays_RecyclerViewAdapter.ViewHolder> {

    /**
     * member variables
     */
    private Context context;
    private String[] daysArray;
    private final View.OnClickListener onDaySectionItemClicked;

    public SectionOfDays_RecyclerViewAdapter(Context context, String[] daysArray, View.OnClickListener onDaySectionItemClicked) {
        this.context = context;
        this.daysArray = daysArray;
        this.onDaySectionItemClicked = onDaySectionItemClicked;
    }

    @Override
    public SectionOfDays_RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_item_recycler_view_horizontal, parent, false));
    }

    @Override
    public void onBindViewHolder(SectionOfDays_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.sectionTitle_section_item_recycler_view_horizontal.setText(daysArray[position]);
        holder.sectionTitle_section_item_recycler_view_horizontal.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (daysArray != null) {
            return daysArray.length;
        } else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView sectionTitle_section_item_recycler_view_horizontal;

        ViewHolder(View itemView) {
            super(itemView);
            sectionTitle_section_item_recycler_view_horizontal = (TextView) itemView.findViewById(R.id.sectionTitle_section_item_recycler_view_horizontal);
            sectionTitle_section_item_recycler_view_horizontal.setOnClickListener(onDaySectionItemClicked);
        }
    }
}
