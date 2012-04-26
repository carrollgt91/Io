package io;

import java.util.ArrayList;

public class AnimationList extends Animation implements AnimationInterface {

	ArrayList<Animation>list;
	int currentIndex;
	boolean isLooping;
	AnimationList()
	{
		super();
		list = new ArrayList<Animation>();
	}

	AnimationList(long duration) {
		super(duration);
		list = new ArrayList<Animation>();

	}

	void startAnimation()
	{
		super.startAnimation();
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
		
		animation.superList = this;
		list.add(animation);

	}

	public void queueNextAnimation()
	{
		if(currentIndex < list.size()-1)
		{
			currentIndex = currentIndex + 1;
		}
		else if(isLooping)
		{
			currentIndex = 0;
		}
		else
		{
			if(this.superList !=null)
			{
				this.superList.queueNextAnimation();
			}
		}
		Animation nextAnimation = list.get(currentIndex);
		nextAnimation.startAnimation();
	}
}

