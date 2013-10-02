package com.example.attendance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class MainActivity extends Activity {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    final ListView listview = (ListView) findViewById(R.id.studentList);
	    String[] values = new String[] { "Pedro Rodriguez Vergara", "Jaime Esteban Perez Sedano", "Janeth Gomez Bunt",
	        "Jazmin Smith", "Joe Jones", "Oscar Frios", "Erika Carvajal" };

	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    list.add("+");
	    /*final StableArrayAdapter adapter = new StableArrayAdapter(this,
	        android.R.layout.simple_list_item_1, list);*/
	    final myAdapter adapter = new myAdapter(this,values);
	    listview.setAdapter(adapter);

	   listview.setOnItemClickListener( new AdapterView.OnItemClickListener() {
		
	      @Override
	      public void onItemClick(AdapterView<?> parent, final View view,
	          int position, long id) {
	        final String item = (String) parent.getItemAtPosition(position);
	        view.animate().setDuration(2000).alpha(0)
	            .withEndAction(new Runnable() {
	              @Override
	              public void run() {
	                
	            	  list.remove(item);
	                adapter.notifyDataSetChanged();
	                view.setAlpha(1);
	              }
	            });
	      }
	   });
	}
}

	/*@Override
		public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
			final String item = (String) parent.getItemAtPosition(position);
			view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable(){
				@Override
	              public void run() {
	                list.remove(item);
	                //adapter.notifyDataSetChanged();
	                //view.setAlpha(1);
	              }
			});
			view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable(){
				@Override
	              public void run() {
	                //list.remove(item);
	                list.add("James Jeffries");
	                //list.add("+");
	                //adapter.notifyDataSetChanged();
	                //view.setAlpha(1);
	              }
			});
		}

	    });*/
	  

	  /*private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }*/
    

