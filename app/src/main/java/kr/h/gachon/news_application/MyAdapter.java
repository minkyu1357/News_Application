package kr.h.gachon.news_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter {
    private String[] mDataset;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_title;
        public TextView textView_content;


        public MyViewHolder(TextView v) {
            super(v);
            textView_title=v.findViewById(R.id.textview_title);
            textView_title=v.findViewById(R.id.textview_content);
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        LinearLayout v =(LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rows_news, parent, false);

        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView().setText(myDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mydataSet.length;
    }
}
