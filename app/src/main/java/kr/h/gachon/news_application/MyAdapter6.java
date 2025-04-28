package kr.h.gachon.news_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter6 extends RecyclerView.Adapter<MyAdapter6.MyViewHolder> {
    private String[] mDataset;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_title;
        public TextView textView_content;


        public MyViewHolder(View v) {
            super(v);
            textView_title=v.findViewById(R.id.textview_title);
            textView_content=v.findViewById(R.id.textview_content);
        }
    }

    public MyAdapter6(String[] myDataset) {
        mDataset = new String[]{"11111", "22222","33333","44444","55555","66666","77777","88888"};
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter6.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        LinearLayout v =(LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rows_news6, parent, false);

        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.textView_content.setText(mDataset[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
