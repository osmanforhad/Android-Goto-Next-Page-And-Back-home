package com.osmanforhad.timetable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.osmanforhad.timetable.Utils.LetterImageView;

public class WeekActivity extends AppCompatActivity {

    //Create object
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        //Call the method
        setupUIViews();
        initToolbar();

        setupListView();
    }
    //Cretae Method for setup ui
    private void setupUIViews(){
        //initial XML id from XML file
        toolbar = (Toolbar)findViewById(R.id.ToolbarWeek);
        listView = (ListView)findViewById(R.id.lvWeek);
    }
    //Create Method for initial toolbar
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Create Method for list view
    private void setupListView(){
        String[] week = getResources().getStringArray(R.array.Week);

    }
    //inner class
    public class WeekAdapter extends ArrayAdapter{

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week = new String[]{};

        public WeekAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvWeek = (TextView)convertView.findViewById(R.id.tvMain);
                convertView.setTag(holder);
            } else{
                holder = (ViewHolder)convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));
            holder.tvWeek.setText(week[position]);

            return convertView;

        }
        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvWeek;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
