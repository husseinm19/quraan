package husseinm19.github.com.quraan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by hussein on 14/04/2020.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>
        implements Filterable
         {

    //private ArrayList<ExampleItem> mExampleList;

    private List<ExampleItem> mExampleList;
    private List<ExampleItem> exampleListFull;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void SetOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView , final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdapter(List<ExampleItem> exampleList) {

        mExampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

//        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public Filter getFilter() {
        return exampleFilter;
    }
             private Filter exampleFilter = new Filter() {
                 @Override
                 protected FilterResults performFiltering(CharSequence constraint) {
                     List<ExampleItem> filteredList = new ArrayList<>();
                     if (constraint == null || constraint.length() == 0) {
                         filteredList.addAll(exampleListFull);
                     } else {
                         String filterPattern = constraint.toString().toLowerCase().trim();
                         for (ExampleItem item : exampleListFull) {
                             if (item.getText1().toLowerCase().contains(filterPattern)) {
                                 filteredList.add(item);
                             }
                         }
                     }
                     FilterResults results = new FilterResults();
                     results.values = filteredList;
                     return results;
                 }
                 @Override
                 protected void publishResults(CharSequence constraint, FilterResults results) {
                     mExampleList.clear();
                     mExampleList.addAll((List) results.values);
                     notifyDataSetChanged();
                 }
    };




}