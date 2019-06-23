package com.example.ssl.grid_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by ssl on 2019/6/23.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> datalist;

    public MyAdapter(Context context,List<Map<String,Object>> datalist) {
        this.context=context;
        this.datalist=datalist;
    }


    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.grid_item,null);
            viewHolder.images=(ImageView)convertView.findViewById(R.id.Images);
            viewHolder.prices=(TextView)convertView.findViewById(R.id.Price);
            viewHolder.content=(TextView)convertView.findViewById(R.id.Content);
            convertView.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.images.setImageResource((int)datalist.get(position).get("imgs"));
        viewHolder.prices.setText((String)datalist.get(position).get("price"));
        viewHolder.content.setText((String)datalist.get(position).get("content"));
        return convertView;
    }

    private class ViewHolder {
        public ImageView images;
        public TextView prices;
        public TextView content;
    }
}
