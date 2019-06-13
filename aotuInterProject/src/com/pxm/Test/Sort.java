package com.pxm.Test;

import java.util.Arrays;

public class Sort {
	
	public Sort() {
		// TODO Auto-generated constructor stub
	}
	
	//BubbleSort 冒泡排序  O(n^2)
	public static void BubbleSort(int [] arr) {
		//外层循环负责循环多少趟
		for(int i=0;i<arr.length-1;i++) {
			//内层循环负责比较次数
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	
	//快排
	public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
 
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
         arr[low] = arr[i];
         arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
	
	 public static void main(String[] args){
	        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
	        quickSort(arr, 0, arr.length-1);
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i]+" ");
	        }
	    }
	
	

	/*public static void main(String[] args) {
		int [] arr= {6,2,5,8,9,1};
		BubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}*/

}