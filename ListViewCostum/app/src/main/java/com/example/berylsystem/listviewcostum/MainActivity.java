package com.example.berylsystem.listviewcostum;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new ListAdapter(this));
    }
}

class SingleRow
{
    String title;
    String description;
    int image;
    SingleRow(String title,String description,int image)
    {
        this.title=title;
        this.description=description;
        this.image=image;
    }
}

class ListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<SingleRow> list;

    ListAdapter(Context c)
    {
        context =c;
        list=new ArrayList<SingleRow>();

        Resources res=c.getResources();
        String[] titles=res.getStringArray(R.array.titles);
        String[] descriptions=res.getStringArray(R.array.descriptions);
        int[] images={R.drawable.pc1,R.drawable.pc2,R.drawable.pc3,R.drawable.pc4,R.drawable.pc5};

        for (int i=0;i<5;i++)
        {
            list.add(new SingleRow(titles[i],descriptions[i],images[i]));

        }

    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int i) {

        return list.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,viewGroup,false);//contain a ref to the RelativeLayout

        TextView  title = (TextView) row.findViewById(R.id.textView);
        TextView  description = (TextView) row.findViewById(R.id.textView2);
        ImageView image= (ImageView) row.findViewById(R.id.imageView);

        SingleRow temp= list.get(i);
        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);


        return row;
    }
}