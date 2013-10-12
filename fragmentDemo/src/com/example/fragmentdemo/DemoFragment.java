package com.example.fragmentdemo;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This is the DemoFragment. The DemoFragment is displayed on the SecondActivity and
 * calls its parent moveFragment function to move it self up or down when a user clicks
 * on the fragment (the green box).
 * @author Valentijn Harmers
 *
 */

public class DemoFragment extends Fragment 
{

	private boolean isOnTop;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.activity_fragment,
				container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		isOnTop = true;
		TextView clickMe = (TextView) getView().findViewById(R.id.clickView);
		
		clickMe.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				//Get the parent
				SecondActivity parent = (SecondActivity) getActivity();
				if(parent != null)
				{
					if(isOnTop)
					{
						
						//Use the moveFragment() function of the parent (SecondActivity)
						parent.moveFragment("down");
						isOnTop = false;
					}
					else
					{
						parent.moveFragment("up");
						isOnTop = true;
					}
				}
				
			}
		});
	}
	
	

	
}
