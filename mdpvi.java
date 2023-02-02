package markovdecisionprocessvalueiterator;

import java.util.*;
import java.lang.*;
import java.math.*;




public class mdpvi {
	public static double gy = 0.9;
	public static void main(String []args) {
		
		double []v = new double[3];
		v[0] = 0; // value of s0
		v[1] = 0; // s1 
		v[2] = 0; // s2 
		//set all state values to zero
		
		double [][]sp0 = new double[2][3];//
		/* a = action, a0 = action0
		 * state 0 probability going to:
		 * 			s0		s1		s2
		 * s0,a0: 	0.5     0       0.5
		 * s0,a1: 	0       0       1
		 * */
		sp0[0][0] = 0.5;
		sp0[0][1] = 0;
		sp0[0][2] = 0.5;
		
		sp0[1][0] = 0;
		sp0[1][1] = 0;
		sp0[1][2] = 1;
		
		
		double [][]sr0 = new double[2][3];//
		/* a = action, a0 = action0
		 * state 0 reward going to:
		 * 			s0		s1		s2
		 * s0,a0: 	0       0       0
		 * s0,a1: 	0       0       0
		 * */
		sr0[0][0] = 0;
		sr0[0][1] = 0;
		sr0[0][2] = 0;
		
		sr0[1][0] = 0;
		sr0[1][1] = 0;
		sr0[1][2] = 0;
		
		double [][]sp1 = new double[2][3];//
		/* a = action, a0 = action0
		 * state 1 probability going to:
		 * 			s0		s1		s2
		 * s1,a0: 	0.7     0.1     0.2
		 * s1,a1: 	0       0.95    0.05
		 * */
		sp1[0][0] = 0.7;
		sp1[0][1] = 0.1;
		sp1[0][2] = 0.2;
		
		sp1[1][0] = 0;
		sp1[1][1] = 0.95;
		sp1[1][2] = 0.05;
		
		
		double [][]sr1 = new double[2][3];//
		/* a = action, a0 = action0
		 * state 1 reward going to:
		 * 			s0		s1		s2
		 * s1,a0: 	5       0       0
		 * s1,a1: 	0       0       0
		 * */
		sr1[0][0] = 5;
		sr1[0][1] = 0;
		sr1[0][2] = 0;
		
		sr1[1][0] = 0;
		sr1[1][1] = 0;
		sr1[1][2] = 0;
		
		double [][]sp2 = new double[2][3];//
		/* a = action, a0 = action0
		 * state 2 probability going to:
		 * 			s0		s1		s2
		 * s2,a0: 	0.4     0.6     0
		 * s2,a1: 	0.3     0.3     0.4
		 * */
		sp2[0][0] = 0.4;
		sp2[0][1] = 0.6;
		sp2[0][2] = 0.0;
		
		sp2[1][0] = 0.3;
		sp2[1][1] = 0.3;
		sp2[1][2] = 0.4;
		
		
		double [][]sr2 = new double[2][3];//
		/* a = action, a0 = action0
		 * state 1 reward going to:
		 * 			s0		s1		s2
		 * s1,a0: 	-1       0       0
		 * s1,a1: 	0       0       0
		 * */
		sr2[0][0] = 0;
		sr2[0][1] = 0;
		sr2[0][2] = 0;
		
		sr2[1][0] = -1;
		sr2[1][1] = 0;
		sr2[1][2] = 0;
		
		
		//int b = 0;
		/*
		for(int i = 0; i <2; i++) {
			for(int v = 0; v < 3; v++) {
				//sp0[i][v] = b;
				//b++;
			}
		}
		
		for(int i = 0; i <2; i++) {
			for(int v = 0; v < 3; v++) {
				System.out.println(sp0[i][v]);
			}
		}*/
		double max = 1000.0;
		int ctr = 0;
		
		double tmp1;
		double tmp2;
		double []tmpva = new double[3];
		while(ctr < 64) {
			
			tmp1 = sp0[0][0] * (sr0[0][0] + gy*v[0]) + sp0[0][1] * (sr0[0][1] + gy*v[1]) + sp0[0][2] * (sr0[0][2] + gy*v[2]);
			tmp2 = sp0[1][0] * (sr0[1][0] + gy*v[0]) + sp0[1][1] * (sr0[1][1] + gy*v[1]) + sp0[1][2] * (sr0[0][2] + gy*v[2]);
			
			if(tmp1 > tmp2) {
				tmpva[0] = tmp1;
			} else {
				tmpva[0] = tmp2;
			}
			//v[0] = tmpva[0]; activate for policy method
			
			tmp1 = sp1[0][0] * (sr1[0][0] + gy*v[0]) + sp1[0][1] * (sr1[0][1] + gy*v[1]) + sp1[0][2] * (sr1[0][2] + gy*v[2]);
			tmp2 = sp1[1][0] * (sr1[1][0] + gy*v[0]) + sp1[1][1] * (sr1[1][1] + gy*v[1]) + sp1[1][2] * (sr1[0][2] + gy*v[2]);
			
			if(tmp1 > tmp2) {
				tmpva[1] = tmp1;
			} else {
				tmpva[1] = tmp2;
			}
			//v[1] = tmpva[1];  activate for policy method
			tmp1 = sp2[0][0] * (sr2[0][0] + gy*v[0]) + sp2[0][1] * (sr2[0][1] + gy*v[1]) + sp2[0][2] * (sr2[0][2] + gy*v[2]);
			tmp2 = sp2[1][0] * (sr2[1][0] + gy*v[0]) + sp2[1][1] * (sr2[1][1] + gy*v[1]) + sp2[1][2] * (sr2[0][2] + gy*v[2]);
			
			if(tmp1 > tmp2) {
				tmpva[2] = tmp1;
			} else {
				tmpva[2] = tmp2;
			}
			//v[2] = tmpva[2]; activate for policy method
			
			v[0] = tmpva[0]; // disable for policy method
			v[1] = tmpva[1]; // disable for policy method
			v[2] = tmpva[2]; // disable for policy method
			
			// disable / activate = comment / uncomment
			
			
			ctr++;
		}
		for(int l = 0; l < 3; l++) {
			System.out.println(v[l]);
		}
	}

}
