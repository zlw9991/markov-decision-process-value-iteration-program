package mdpviuserinput;
import java.util.*;
import java.io.*;

public class mdpviusi {
	public static double gy = 0.9;
	public static void main(String []args) {
		int states = 0;
		int actions = 0;
		int itr = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of states: ");
		states = sc.nextInt();
		System.out.println("Enter number of actions: ");
		actions = sc.nextInt();
		System.out.println("Enter number of iterations: ");
		itr = sc.nextInt();
		double [][][]probarray = new double[states][actions][states];
		double [][][]rewardarray = new double[states][actions][states];
		
		double []values = new double[states];
		double []tempvalues = new double[states];
		
		for(int vr = 0; vr < states; vr++) {
			values[vr] = 0;
			tempvalues[vr] = 0;
		}
		
		threedarrayfiller(actions, states, probarray,0);
		//threedarrayprinter(actions, states, probarray,0);
		
		threedarrayfiller(actions, states, rewardarray,1);
		//threedarrayprinter(actions, states, rewardarray,1);
		
		bellmaneqiterationlimited(itr,actions,states,probarray,rewardarray,values);
		
		for(int vr = 0; vr < states; vr++) {
			System.out.println(values[vr]);
		}
	}
	
	public static void bellmaneqiterationlimited(int iterations, int actions, int states, double [][][]probar, double [][][]rewardar, double []vals) {
		
		double []tempvalues = new double[states];
		for(int vr = 0; vr < states; vr++) {
			tempvalues[vr] = 0;
		}
		
		int counter = 0;
		double max = -10000;
		double tmp = 0;
		while(counter < iterations) {
			for(int a = 0; a < states; a++) {
				for(int b = 0; b < actions; b++) {
					tmp = 0;
					for(int c = 0; c < states; c++) {
						tmp += probar[a][b][c] * (rewardar[a][b][c] + gy*vals[c]);
					}
					if(tmp > max) {
						max = tmp;
					
					}
					//tmp = 0;
				}
				tempvalues[a] = max;
				max = -10000;
			}
			
			for(int vr = 0; vr < states; vr++) {
				vals[vr] = tempvalues[vr];
			}
			
			counter++;
		}
		
		
	}
	
	public static void threedarrayfiller(int actions, int states, double [][][]tdar, int type) {
		Scanner ns = new Scanner(System.in);
		String ts =  null;
		if(type == 0) {
			ts = "probability";
		} else {
			ts = "reward";
		}
		for(int a= 0; a < states; a++) {
			for(int b = 0; b < actions; b++) {
				for(int c = 0; c < states; c++) {
					System.out.println("Enter The "+ ts +" of state " + Integer.toString(a) + " taking action " + Integer.toString(b)
					+ " reaching state " + Integer.toString(c));
					tdar[a][b][c] = ns.nextDouble();
				}
			}
		}
	}
	
	public static void threedarrayprinter(int actions, int states, double [][][]tdar, int type) {
		String ts =  null;
		if(type == 0) {
			ts = "probability";
		} else {
			ts = "reward";
		}
		for(int a= 0; a < states; a++) {
			for(int b = 0; b < actions; b++) {
				for(int c = 0; c < states; c++) {
					System.out.println("The "+ ts +" of state " + Integer.toString(a) + " taking action " + Integer.toString(b)
					+ " reaching state " + Integer.toString(c) + " is: " + Double.toString(tdar[a][b][c]));
					
				}
			}
		}
	}
}
