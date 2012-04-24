package io;


public class Animation implements AnimationInterface {
    boolean isAnimating;
    boolean isDrawing;
    AnimationList list;

    void startAnimation()
    {
    	isAnimating = true;
    }
    void animate()
    {
    	if(isAnimating)
    	{
    		this.animationMethod();
    	}
    	else
    	{
    		this.draw();
    	}
    }
    void stopAnimation()
    {
    	isAnimating = false;
    }
    void draw()
    {
    	if(this.isDrawing)
    	{
    		this.drawMethod();
    	}
    }
	@Override
	public void animationMethod() {
	System.out.println("animationMethod in Animation");		
	}
	@Override
	public void drawMethod() {
		System.out.println("drawMethod in Animation");
	}
    
 
}