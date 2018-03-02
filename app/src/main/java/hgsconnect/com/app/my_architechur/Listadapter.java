package hgsconnect.com.app.my_architechur;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Networking.model.Project;
import hgsconnect.com.app.my_architechur.databinding.mydatabing;

/**
 * Created by pratikb on 01-03-2018.
 */

public class Listadapter extends BaseAdapter {
    private Context ct;
    private List<Project> my;
    private LayoutInflater inflater;
    private mydatabing binding;

    public Listadapter(Context ctx, List<Project> mylist) {
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
        inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater, R.layout.mylist_item, viewGroup, false);
        Project p = new Project();
        binding.setProject(my.get(i));
        binding.executePendingBindings();
        TextView tv = (TextView) binding.getRoot().findViewById(R.id.textview);
        return binding.getRoot();
    }
}
