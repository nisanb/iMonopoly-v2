package Controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Music {

	
	private static Music instance = null;
	private Map<URL, MediaPlayer> soundMap;
	
	private Music(){
	}
	
	public static Music getInstance(){
		
		if(instance == null){
			instance = new Music();
			instance.soundMap = new HashMap<>();
		}
		
		return instance;
	}
	
	
	public void play(String res){
		final URL resource = getResource(res);
		Logger.log("Getting resource: "+resource);
		try{
		if(!soundMap.containsKey(resource)){
			final Media media = new Media(resource.toString());
		    final MediaPlayer mediaPlayer = new MediaPlayer(media);
			soundMap.put(resource, mediaPlayer);
		}
	    
		soundMap.get(resource).seek(Duration.ZERO);
		soundMap.get(resource).play();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	public void stop(String res){
		final URL resource = getResource(res);
		if(soundMap.containsKey(resource)){
			MediaPlayer currentPlayer = soundMap.get(resource);
			
			if(currentPlayer.getStatus().equals(MediaPlayer.Status.PAUSED)){
				//Currently paused, play it
				currentPlayer.seek(currentPlayer.getCurrentTime());
				currentPlayer.play();
			}else{
				currentPlayer.pause();	
			}
			
			
		}
	}
		
	public void changeVolume(String res, Double vol){
		final URL resource = getResource(res);
		if(soundMap.containsKey(resource)){
			MediaPlayer currentPlayer = soundMap.get(resource);
			Logger.log("Changing volume to "+res+" - "+vol);
			currentPlayer.setVolume(vol/100);
			
		}
	}
	
	
	private URL getResource(String res){
		final URL resource = getClass().getResource("../Resources/"+res); 
		Logger.log("Aquired resource: "+resource);
		return resource;
	}
	
	
}
