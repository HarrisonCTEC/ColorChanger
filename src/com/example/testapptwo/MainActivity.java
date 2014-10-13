package com.example.testapptwo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity
{
	
	private SeekBar redSeekBar;
	private SeekBar greenSeekBar;
	private SeekBar blueSeekBar;
	private TextView testTextView;
	private RelativeLayout background;
	
	private OnSeekBarChangeListener colorChangeListener;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		redSeekBar = (SeekBar) findViewById(R.id.redBar);
		greenSeekBar = (SeekBar) findViewById(R.id.greenBar);
		blueSeekBar = (SeekBar) findViewById(R.id.blueBar);
		
		background = (RelativeLayout) findViewById(R.id.RelativeLayout1);
		
		setupListeners();
		refreshScreen();
	}
	
	private void setupListeners()
	{
		
		colorChangeListener = new SeekBar.OnSeekBarChangeListener()
		{
		@Override
			public void onStopTrackingTouch(SeekBar seekBar)
		{
			// TODO Auto-generated method stub
			
		}
		@Override
			public void onStartTrackingTouch(SeekBar seekBar)
		{
			// TODO Auto-generated method stub
			
		}
		
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				refreshScreen();
			}
		};
		
		redSeekBar.setOnSeekBarChangeListener(colorChangeListener);
		greenSeekBar.setOnSeekBarChangeListener(colorChangeListener);
		blueSeekBar.setOnSeekBarChangeListener(colorChangeListener);
		
	}
	

	/**
	 * Refresh the background color with the slider values.
	 */
	private void refreshScreen()
	{
		int mixedColor = Color.rgb(normalColor(redSeekBar.getProgress()), normalColor(greenSeekBar.getProgress()), normalColor(blueSeekBar.getProgress()));
		background.setBackgroundColor(mixedColor);
	};
	
	/**
	 * Take a value from 0-100 and change it to a value 0-255
	 * @param color A value from 0-100
	 * @return A value from 0-255
	 */
	private int normalColor(int color)
	{
		return (int) (((double) color / 100.0) * 255.0);
	}
	
	private int oppositeColor(int color)
	{
		return 0xFFFFFF - color;
	}
}
