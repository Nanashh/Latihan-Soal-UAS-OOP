package no4;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public <T extends Comparable<T>> void sort(T[] data) {
		for(int i=0;i<data.length-1;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i].compareTo(data[j])>0) {
					T temp = data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
	}
	
	public <T> void print(T[]data) {
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	
	public Main() {
		String[] lalala = {"az","aa","abe"};
		String[] wow = {"1","boom","lalala"};
		Integer[] aws = {1,6,343124,13411,2,1231,231};
		sort(lalala);
		sort(wow);
		sort(aws);
		print(lalala);
		print(wow);
		print(aws);
	}
}
