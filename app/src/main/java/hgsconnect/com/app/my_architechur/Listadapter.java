package hgsconnect.com.app.my_architechur;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Networking.model.Project;

/**
 * Created by pratikb on 01-03-2018.
 */

public class Listadapter extends BaseAdapter {
    Context ct;
    List<Project> my;
    LayoutInflater inflater;

    Listadapter(Context ctx, List<Project>mylist) {
        this.ct = ctx;
        this.my = mylist;
    }

    @Override
    public int getCount() {
        return my.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater=(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.mylist_item,null);
        TextView tv=(TextView)view.findViewById(R.id.textView);
        tv.setText(my.get(i).getFull_name());
        return view;
    }
}
