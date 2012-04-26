package io;

import java.util.TimerTask;

public class StartDrawTask extends TimerTask {
	Animation animation;
	StartDrawTask(Animation animation)
	{
		this.animation = animation;
	}

	@Override
	public void run() {
		System.out.println("StartDrawTask");
		this.animation.drawMethod();
	}
	


}
