package com.example.kbc;

import com.example.kbc.util.SystemUiHider;




import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class GameActivity extends Activity {

	BackgroundSound mBackgroundSound = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game);
		mBackgroundSound = new BackgroundSound();
		mBackgroundSound.execute(null,null,null);
		
	}
	
	
	public class BackgroundSound extends AsyncTask<Void, Void, Void> {
		MediaPlayer player = MediaPlayer.create(GameActivity.this, R.raw.test); 
		@Override
		protected Void doInBackground(Void... params) {
		   // MediaPlayer player = MediaPlayer.create(GameActivity.this, R.raw.test); 
		    player.setLooping(true); // Set looping 
		    player.setVolume(100,100); 
		    player.start(); 
		    return null;
		 }
		
		
		public void stopMusic()
		{
			player.stop();
			player.release();
		}
		   }
	
	/*public void onResume() {
		super.onResume();
		mBackgroundSound.execute(null,null,null);
		}*/
	
	 public void onPause() {
		 super.onPause();
		 mBackgroundSound.cancel(true);
		 }
	 
	 public void onDestroy()
	 {
		 mBackgroundSound.stopMusic();
		
		 if(!mBackgroundSound.isCancelled())
		 {
			 mBackgroundSound.cancel(true);
		 }
		 super.onDestroy();
	 }
	
}

	