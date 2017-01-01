package com.listsofcardswithsectionssample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.listsofcardswithsectionssample.R;
import com.listsofcardswithsectionssample.models.TrainDetail;

import java.util.ArrayList;

/**
 * Created by Admin on 29-12-2016.
 */
public class ListOfTrains_RecyclerViewAdapter extends RecyclerView.Adapter<ListOfTrains_RecyclerViewAdapter.ViewHolder> {

    ArrayList<TrainDetail> trainDetails;

    public ListOfTrains_RecyclerViewAdapter(/*Context context, */ArrayList<TrainDetail> trainDetails/*, View.OnClickListener onClickListener*/) {
        this.trainDetails = trainDetails;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_trains_item_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.trainNumber_list_of_trains_item_recycler_view.setText(Integer.toString(trainDetails.get(position).getTrainNumber()));
        holder.fareAmount_list_of_trains_item_recycler_view.setText(Integer.toString(trainDetails.get(position).getFareAmount()));
    }

    @Override
    public int getItemCount() {
        if (trainDetails != null) {
            return trainDetails.size();
        } else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView trainNumber_list_of_trains_item_recycler_view;
        private TextView fareAmount_list_of_trains_item_recycler_view;

        ViewHolder(View itemView) {
            super(itemView);
            trainNumber_list_of_trains_item_recycler_view = (TextView) itemView.findViewById(R.id.trainNumber_list_of_trains_item_recycler_view);
            fareAmount_list_of_trains_item_recycler_view = (TextView) itemView.findViewById(R.id.fareAmount_list_of_trains_item_recycler_view);
        }
    }
}
