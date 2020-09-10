package com.socio_infonavit_android.socio_infonavit_android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.socio_infonavit_android.socio_infonavit_android.model.BenevitWallets;

import java.util.ArrayList;

public class AdapterCustom extends BaseAdapter {

    static class ViewHolder
    {
        TextView tvFecha_pub;
        TextView tvtitulo_post;

    }

    private static final String TAG = "CustomAdapter";
    private static int convertViewCounter = 0;

    private ArrayList<BenevitWallets> data;
    private LayoutInflater inflater = null;

    public AdapterCustom(Context c, ArrayList<BenevitWallets> d)
    {
        Log.v(TAG, "Constructing CustomAdapter");

        this.data = d;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount()
    {
        Log.v(TAG, "in getCount()");
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        Log.v(TAG, "in getItem() for position " + position);
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        Log.v(TAG, "in getItemId() for position " + position);
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        Log.v(TAG, "in getViewTypeCount()");
        return 1;
    }

    @Override
    public int getItemViewType(int position)
    {
        Log.v(TAG, "in getItemViewType() for position " + position);
        return 0;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder holder;

        Log.v(TAG, "in getView for position " + position + ", convertView is "
                + ((convertView == null) ? "null" : "being recycled"));

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.template_griew, null);

            convertViewCounter++;
            Log.v(TAG, convertViewCounter + " convertViews have been created");

            holder = new ViewHolder();

     holder.tvtitulo_post = (TextView) convertView.findViewById(R.id.titulo);
          /*  holder.tvtitulo_post = (TextView) convertView.findViewById(R.id.tvTitulo);
            holder.cb = (CheckBox) convertView.findViewById(R.id.leido);
            holder.cb.setOnClickListener(checkListener);*/

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        // Para porde hacer click en el checkbox
        BenevitWallets d = (BenevitWallets) getItem(position);
        holder.tvtitulo_post.setText(data.get(position).getName());
        // Setting all values in listview
  //      holder.tvFecha_pub.setText(data.get(position).getFecha());
    //    holder.tvtitulo_post.setText(data.get(position).getEquipos());
      //  holder.cb.setChecked(data.get(position).getChecked());

        return convertView;
    }


}
