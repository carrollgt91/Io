package io;

public class AnimationManager {
	  private static AnimationManager instance = null;
	  public static Io sharedParent;
	   protected AnimationManager() {
	      // Exists only to defeat instantiation.
	   }
	   public static void setSharedParent(Io parent)
	   {
		   sharedParent = parent;
	   }
	   public static AnimationManager getInstance() {
	      if(instance == null) {
	         instance = new AnimationManager();
	      }
	      return instance;
	   }
	   public Io getSharedParent()
	   {
		   return sharedParent;
	   }
}


