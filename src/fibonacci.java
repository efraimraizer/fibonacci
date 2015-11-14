import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;


public class fibonacci {
	
	public static int SCALE = 4;

	
	public static void main(String args[]) throws InterruptedException{
		
		//adding comments because need to make changes
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter number upto which Fibonacci series to print: ");
		int number = keyboard.nextInt() + 1;
		System.out.print("Enter the scale you would like to use: ");
		SCALE = keyboard.nextInt();
		System.out.println();
		System.out.println();
		//System.out.print("Fibonacci series upto " + number +" numbers : ");
		int[] fibNums = getNumbers(number);
		
		
		drawSpiral(fibNums);
		
	}
	
	public static int[] getNumbers(int num){
		
		int[] nums = new int[num];
		
		for (int i = 1; i<=num; i++){
			int currentNum = fibonacciRecursion(i);
			//System.out.print(currentNum + " ");
			nums[i-1] = currentNum;
		}
		
		return nums;
	}
	
	public static int fibonacciRecursion(int num){
		if(num == 1 || num == 2)
			return 1;
		
		else 
			return fibonacciRecursion(num-1)+ fibonacciRecursion(num-2);
		
	}
	
	public static void drawSpiral(int[] nums) throws InterruptedException{

		DrawingPanel panel = new DrawingPanel(1300, 700);
		Graphics g = panel.getGraphics();
		
		int xPos = panel.width/2-200;
		int yPos = panel.height/2+150;

		for(int i = 0; i<nums.length-1; i++){
			int seqNum = (i+1)%4;

			drawFromCorner(xPos,yPos,nums[i],seqNum,g);
			g.drawString(nums[i] + "", 100 , 100 + 15*i);
			
			try {
			    Thread.sleep(500);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			if(i!=nums.length-1){
			if(seqNum == 1)
				xPos-=nums[i]*SCALE + nums[i+1]*SCALE;
			else if (seqNum == 2)
				yPos-=nums[i]*SCALE + nums[i+1]*SCALE;
			else if (seqNum == 3)
				xPos+=nums[i]*SCALE + nums[i+1]*SCALE;
			else if (seqNum == 0)
				yPos+=nums[i]*SCALE + nums[i+1]*SCALE;
		}
		}
		
	}
	
	public static void drawFromCorner(int xPos, int yPos,int size, int corner, Graphics g){
		Color c = new Color(228,228,35);
		c= Color.BLACK;
		
		if(corner == 3){
			g.drawRect(xPos, yPos, size*SCALE, size*SCALE);
			g.setColor(c);
			g.drawArc(xPos, yPos, size*SCALE*2, size*SCALE*2, -180, -90);
		}
		else if (corner == 0){
			xPos-=size*SCALE;
			g.drawRect(xPos, yPos, size*SCALE, size*SCALE);
			g.setColor(c);
			g.drawArc(xPos-size*SCALE, yPos, size*SCALE*2, size*SCALE*2, -270, -90);
		}
		else if (corner == 1){
			xPos-=size*SCALE;
			yPos-=size*SCALE;
			g.drawRect(xPos, yPos, size*SCALE, size*SCALE);
			g.setColor(c);
			g.drawArc(xPos-size*SCALE, yPos-size*SCALE, size*SCALE*2, size*SCALE*2, 0, -90);
			
		}
		else if (corner == 2){
			yPos-=size*SCALE;
			g.drawRect(xPos, yPos, size*SCALE, size*SCALE);
			g.setColor(c);
			g.drawArc(xPos, yPos-size*SCALE, size*SCALE*2, size*SCALE*2, -90, -90);
		}
		
		g.setColor(Color.BLACK);
	}
	
	
}