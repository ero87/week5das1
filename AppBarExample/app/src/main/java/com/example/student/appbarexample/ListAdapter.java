package com.example.student.appbarexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyVievHolder> implements Filterable {

    private Context context;
    private List<ModelList> list;
    private List<ModelList> listFiltered;


    public ListAdapter(Context context, List<ModelList> list) {
        this.context = context;
        this.list = list;
        listFiltered = list;
    }

    @Override
    public MyVievHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyVievHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyVievHolder holder, int position) {
        final ModelList modelList = listFiltered.get(position);
        holder.title.setText(modelList.getTitle());
        holder.description.setText(modelList.getDescription());
        holder.image.setImageResource(R.drawable.ic_face);
    }


    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    listFiltered = list;
                } else {
                    List<ModelList> filteredList = new ArrayList<>();
                    for (ModelList row : list) {
                        if (row.getTitle().contains(charString)) {
                            filteredList.add(row);
                        }
                    }
                    listFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;
                filterResults.count = listFiltered.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listFiltered = (ArrayList<ModelList>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyVievHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final ImageView image;

        public MyVievHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.userTitle);
            description = (TextView) itemView.findViewById(R.id.userDescription);
            image = (ImageView) itemView.findViewById(R.id.userImage);

        }
    }
}
