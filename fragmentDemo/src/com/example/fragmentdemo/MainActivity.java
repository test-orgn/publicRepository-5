package com.example.fragmentdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This is an application that show how to use fragments and Activities
 * in Android.   
 * 
 * @author Valentijn Harmers
 *
 */

public class MainActivity extends Activity 
{
	private Button nextButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nextButton = (Button) findViewById(R.id.nextButton);
		//Set a onClickListener for the "nextButton"
		nextButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				//Start the second activity when the nextButton is pressed
				Intent secondIntent = new Intent(getApplicationContext(), SecondActivity.class);
				startActivity(secondIntent);
			}
		});
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
