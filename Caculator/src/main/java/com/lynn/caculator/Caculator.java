/*
 * created by lynn
 * 
 * simple caculator
 */
package com.lynn.caculator;

public class Caculator {
	
	double caculatorAdd(double x, double y){
	    System.out.println(x+y);
		return (x+y);
	}

	double caculatorSub(double x, double y){
		return(x-y);
	}
	
	double caculatorMul(double x, double y){
		return(x*y);
	}
	
	double caculatorDev(double x, double y){
		return(x/y);
	}
//	
//	double caculatorToatol(List<Double>list){
////		double totalSum = 0.0d;
////		Iterator<Double> element = list.iterator();
//		Double double1 = 0.0D;
//		for (Iterator<Double> element = list.iterator(); element.hasNext();) {
//			double1 += (Double) element.next();			
//		}
////		for(int i=0; i<list.size();){
////			totalSum += list.get(i)'';
////		}
//		return double1;
//	}
}
