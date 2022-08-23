package com.ammar.shoot.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

 
public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean isLeftPressed;
	private boolean isRightPressed;
	private int moveX;
	private int moveY;
	 
	public boolean isLeftPressed()
	{
		return isLeftPressed;
	}
	public boolean isRightPressed()
	{
		return isRightPressed;
	}
	
	public int getX()
	{
		return moveX;
	}
	public int getY()
	{
		return moveY;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			isLeftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			isRightPressed = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			isLeftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			isRightPressed = false;
 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		moveX = e.getX();
		moveY = e.getY();
		
	}
	public void setLeftPressed() {
		isLeftPressed=false;
		// TODO Auto-generated method stub
		
	}

}
