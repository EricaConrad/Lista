package com.example.attendance1;



import android.content.Context;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class studentAdapter extends ArrayAdapter<String>{
	private final Context context;
	private final String[] values;
	private ImageView image;
	public studentAdapter(Context context, String[] values) {
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
	    image = (ImageView) rowView.findViewById(R.id.icon);
	    textView.setText(values[position]);
	    // Change the icon for Windows and iPhone
	    String s = values[position];
	    
	    image.setImageResource(R.drawable.yes);

	    return rowView;
	  }
	public ImageView getImage(){
		
		return image;
	}
	public void clickImage(){
		if(image.getResources().equals(R.drawable.no)){
			image.setImageResource(R.drawable.yes);
		}else{
			image.setImageResource(R.drawable.no);
		}
	}
	
}
