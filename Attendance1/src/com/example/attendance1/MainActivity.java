package com.example.attendance1;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ListView listView = (ListView) findViewById(R.id.studentList);
		 String[] values = new String[] { "Pedro Rodriguez Vergara", "Jaime Esteban Perez Sedano", "Janeth Gomez Bunt",
			        "Jazmin Smith", "Joe Jones", "Oscar Frios", "Erika Carvajal" };
		 final ArrayList<String> list = new ArrayList<String>();
		    for (int i = 0; i < values.length; ++i) {
		      list.add(values[i]);
		    }
	
		    final studentAdapter adapter = new studentAdapter(this,values);
		    listView.setAdapter(adapter);
		    
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				
				//listView.getItemAtPosition(position);
				//adapter.clickImage();
				studentAdapter adapter = (studentAdapter)listView.getItemAtPosition(position);
				ImageView image = adapter.getImage();
			}
			
		});
       
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
