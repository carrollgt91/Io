package io;

import java.util.Timer;

public class AnimationManager {
	  private static AnimationManager instance = null;
	  public static Io sharedParent;
	  public static Timer sharedManager;
	   protected AnimationManager() {
	      // Exists only to defeat instantiation.
	   }
	  
	   public static AnimationManager getInstance() {
	      if(instance == null) {
	         instance = new AnimationManager();
	      }
	      return instance;
	   }
	   
	   public static void setSharedParent(Io parent)
	   {
		   sharedParent = parent;
	   }
	   public Io getSharedParent()
	   {
		   return sharedParent;
	   }
	   public static void setSharedmanager(Timer manager)
	   {
		   sharedManager = manager;
	   }
	   public Timer getSharedManager()
	   {
		   return sharedManager;
	   }
}


