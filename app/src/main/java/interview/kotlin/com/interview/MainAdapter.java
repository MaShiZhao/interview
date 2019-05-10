package interview.kotlin.com.interview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import interview.kotlin.com.interview.R;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>
{

    protected Context mContext;
    protected List<MainBean> mData;

    public MainAdapter(Context mContext, List<MainBean> mData)
    {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.recycler_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        holder.textView.setText(mData.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                mContext.startActivity(new Intent(mContext, mData.get(position).getNewClass()));

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }


    /**
     * 希望读者有良好的编码习惯，将ViewHolder类写成静态的.
     **/
    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        TextView textView;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            //重要
            this.itemView = itemView;
            this.textView = (TextView) itemView.findViewById(R.id.recycler_item);
        }


    }
}
