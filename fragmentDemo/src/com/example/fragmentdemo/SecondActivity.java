package com.example.fragmentdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This is het second Activity that houses the DemoFragement.
 * @author Valentijn Harmers
 *
 */

public class SecondActivity extends Activity 
{
	private Button hideButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		hideButton = (Button)findViewById(R.id.hideButton);
		//Set the onClickListener for het hideButton
		hideButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				//Show the fragment when it is hidden and hide the fragment when it is shown
				if(getFragmentManager().findFragmentById(R.id.myFragment).isHidden())
				{
					//Show the fragment
					moveFragment("fadeIn");
					hideButton.setText("hide Fragment");
				}
				else
				{
					//Hide the fragment
					moveFragment("fadeOut");
					hideButton.setText("show Fragment");
				}
								
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	/**
	 * This function hides, shows or moves the DemoFragment. 
	 * @param direction
	 */
	public void moveFragment(String direction)
	{
		FragmentManager fragManager = getFragmentManager();
		//Get the DemoFragment
		DemoFragment demoFrag= (DemoFragment)fragManager.findFragmentById(R.id.myFragment);
		
		if(direction.equals("fadeOut"))//Hide the fragment whit an fadeout animation
		{	
			FragmentTransaction fragTrans = fragManager.beginTransaction();
			fragTrans.setCustomAnimations(R.anim.fadeout, R.anim.fadeout);
			fragTrans.hide(demoFrag);
			fragTrans.commit();
		}
		else if(direction.equals("fadeIn"))//Show the fragment whit an fadein animation
		{
			FragmentTransaction fragTrans = fragManager.beginTransaction();
			fragTrans.setCustomAnimations(R.anim.fadein, R.anim.fadein);
			fragTrans.show(demoFrag);
			fragTrans.commit();
		}
		else if(direction.equals("up"))//Move the fragment up
		{
			demoFrag.getView().animate().translationY(0);
		}
		else if(direction.equals("down"))//Move the fragment down
		{
			demoFrag.getView().animate().translationY(200);
		}
	}

}
