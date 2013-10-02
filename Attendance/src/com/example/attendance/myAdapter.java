package com.example.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends ArrayAdapter<String>{
	private final Context context;
	private final String[] values;
	
	public myAdapter(Context context, String[] values) {
		super(context, R.layout.rowview, values);
		this.context = context;
		this.values = values;
	}
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.rowview, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.name);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    textView.setText(values[position]);
	    // Change the icon for Windows and iPhone
	    String s = values[position];
	    if (s.startsWith("J")) {
	      imageView.setImageResource(R.drawable.no);
	    }
	    else if (s.startsWith("E")){
	      imageView.setImageResource(R.drawable.tardy);
	    }else {
	    	imageView.setImageResource(R.drawable.yes);
	    }

	    return rowView;
	  }
	
	
}
