package mau.train.com.list.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mau.train.com.list.R;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    List<String> names;

    public MyAdapter(Context context, int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() { return this.names.size(); }

    @Override
    public Object getItem(int position) { return names.get(position); }

    @Override
    public long getItemId(int id) { return id; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //implementar View Holder pattern
        ViewHolder holder;

        if(convertView == null){

            //inflamos la vista que nos ha llegado con nuestro layout
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);

            holder = new ViewHolder();

            holder.nameTextView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        //tomamos el valor actual
        String currrentName = names.get(position);

        //devolvemos la vista inflada y modificada con nuestros datos
        holder.nameTextView.setText(currrentName);

        return convertView;
    }

    static class ViewHolder{
        private  TextView nameTextView;
    }
}
