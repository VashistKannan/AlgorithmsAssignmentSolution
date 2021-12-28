package com.greatlearning.stocker.service;

public class Operations {
	
	public void order(double arr[],int left, int right, boolean set) {
		// TODO Auto-generated method stub
		if(left<right) {
			int mid = left+(right-left)/2;
			order(arr,left,mid,set);
			order(arr,mid+1,right,set);
			
			merge(arr,left,mid,right,set);
		}	
	}
	
	public void merge(double arr[], int left, int mid, int right, boolean set) {
		int n1 = mid-left+1;
		int n2 = right-mid;
		double[] L=new double[n1];
		double[] R=new double[n2];
		
		for(int i=0;i<n1;i++) {
			L[i]=arr[left+i];
		}
		for(int j=0;j<n2;j++) {
			R[j]=arr[mid+1+j];
		}
		int i=0,j=0;
		int k=left;
		while(i<n1&&j<n2) {
			if(set==true) {
		//This will perform the Ascending part
				if(L[i]<=R[j]) {
				arr[k]=L[i];
				i++;
			}
			else {
				arr[k]=R[j];
				j++;
			}
				k++;
			}
			else{
		//This will perform the Descending part
				if(L[i]>=R[j]) {
					arr[k]=L[i];
					i++;
			}
				else {
				arr[k]=R[j];
				j++;
			}
			k++;
		}
	}
		while(i<n1) {
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k]=R[j];
			j++;
			k++;
		}
	}
	
	public void rise(boolean[] flag, int N) {
		// TODO Auto-generated method stub
		int rise=0;
		for(int i=0;i<N;i++) {
			if(flag[i]==true) {
				rise++;
			}
		}
		System.out.println("Total no of companies whose stock price rose today: "+rise);
	}

	public void fall(boolean[] flag, int N) {
		// TODO Auto-generated method stub
		int fall=0;
		for(int i=0;i<N;i++) {
			if(flag[i]==false) {
				fall++;
			}
		}
		System.out.println("Total no of companies whose stock price rose today: "+fall);
	}

	public void search(double[] arr,int first,int last, double key) {
		// TODO Auto-generated method stub
		int mid = (first+last)/2;
		while(first<=last) {
			if(arr[mid]==key) {
				System.out.println("Stock of value "+ arr[mid] +" is present");
				break;
			}
			else if(arr[mid]<key) {
				first = mid+1;
			}
			else {
				last = mid-1;
			}mid = (first+last)/2;
		}
		if(first>last) {
			System.out.println("Value not found!");
		}
	}

	public void priceOrder(double[] price, int N) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			System.out.print(price[i]+" ");
		}
		
	}

}
