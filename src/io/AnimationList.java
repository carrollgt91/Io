package io;

import java.util.ArrayList;

public class AnimationList extends Animation implements AnimationInterface {

	ArrayList<Animation>list;
	int currentIndex;
	boolean isLooping;
	boolean isSimultaneous;
	AnimationList()
	{
		super();
		list = new ArrayList<Animation>();
		duration = 1000000;
		isLooping = true;
		isSimultaneous = false;
	}

	AnimationList(long duration) {
		super(duration);
		list = new ArrayList<Animation>();

	}
	
	@Override
	void startAnimation()
	{
		if(isSimultaneous)
		{
			for (int i = 0; i < list.size(); i++) {
				Animation animation = (Animation) list.get(i);
				animation.startAnimation();
				
			}
		}
		else
		{
			Animation animation = (Animation) list.get(0);
			animation.startAnimation();
		}
	}

	public void animationMethod() {
		System.out.println("animationMethod in AnimationList current index:" + currentIndex);		
	}

	public void drawMethod() {
		System.out.println("drawMethod in Animation");
	}

	@Override
	public void run() {
		this.animationMethod();
	}

	public void stopAnimation() {
		super.stopAnimation();
	}


	void add(Animation animation)
	{
		System.out.println("add method in List");
		animation.superList = this;
		list.add(animation);

	}

	public void queueNextAnimation()
	{
		//System.out.println("queuNextAnimation");
		
		if(currentIndex < list.size()-1)
		{
			currentIndex = currentIndex + 1;
		}
		else if(isLooping)
		{
			currentIndex = 0;
			this.clear();
		}
		else
		{
			if(this.superList !=null)
			{
				this.superList.queueNextAnimation();
			}
		}
		Animation nextAnimation = list.get(currentIndex);
		nextAnimation.clearTasks();
		nextAnimation.startAnimation();
		System.out.println("queuNextAnimationwithTag: " + nextAnimation.testTag);
	}
	
	public void clear()
	{
		if(this.superList !=null)
			this.superList.clear();
			else
			parent.rect(0,0, this.parent.getWidth(),this.parent.getHeight());
	}
}

