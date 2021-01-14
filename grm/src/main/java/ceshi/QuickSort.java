package ceshi;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] arr){
	    qsort(arr, 0, arr.length-1);
	}
	private static void qsort(int[] arr, int low, int high){
	    if (low >= high)
	        return;
	    int pivot = partition(arr, low, high);        //将数组分为两部分
	    qsort(arr, low, pivot-1);                   //递归排序左子数组
	    qsort(arr, pivot+1, high);                  //递归排序右子数组
	}
	private static int partition(int[] arr, int low, int high){
	    int pivot = arr[low];     //基准
	    while (low < high){
	        while (low < high && arr[high] >= pivot) --high;
	        arr[low]=arr[high];             //交换比基准大的记录到左端
	        while (low < high && arr[low] <= pivot) ++low;
	        arr[high] = arr[low];           //交换比基准小的记录到右端
	    }
	    //扫描完成，基准到位
	    arr[low] = pivot;
	    //返回的是基准的位置
	    return low;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr=new int[] {9,8,8,7,5,4,3,2,1};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	
}
