package sort.cmp;

public class mergeSort extends sort {
	/*
	 * 归并排序的思想
	 *   对于两个有序数组来说 合并成一个有序数组  用双指针往后移动 来往一个地方填充
	 * 
	 * 
	 * 
	 * */
	private static int[] newArray = null;//将左边元素拷贝的地方
	public  static int[] sort(int[] array) {
		newArray = new int[array.length/2];
		//从中间分治 左右两边分别进行归并排序 获得两个有序数组
		mergeSorts(array,0,array.length/2);
		mergeSorts(array,array.length/2,array.length);
		//往一起归并
		merge(array,0,array.length,array.length/2);
		
		return array ;
	}
	//需要递归调用的函数 
	private static void  mergeSorts(int[] array,int begin,int end) {
		//end表示 最后一个元素下标+1    begin表示第一个元素的下标
		if(end-begin==1) {
			return ;
		}
		mergeSorts(array,begin,(end+begin)/2);
		mergeSorts(array,(end+begin)/2,end);
		merge(array,begin,end,(end+begin)/2); 
		return;
		
	}
	//分治后往一起归并  归并数组就用array数组
	private static void merge(int[] array,int begin,int end,int mid) {
		//将左半边的元素拷贝一份 给新数组
		for(int i=0;i<(mid-begin);i++) {
			newArray[i] = array[begin+i];
		}
		int li = 0 ;//左半边的指针
		int le = mid-begin;
		int ri = mid ;
		int re = end;
		int ro = begin;//负责看归并到那一块了
		//当左边有元素被归时候 循环 左边没有时候 右边大的元素 全在归并数组的右边
		while(li<le) {
			//右边归并完了 需要把左边的全都压入到归并数组中
			if(ri==re) {
				while(li<le) {
					array[ro] = newArray[li];
					li++;
					ro++;
					
					
					
				}
				
			}
			//左右都有元素没有被归
			else if(li<le){
				//左边元素大 把左边元素压入归并数组 
				if(newArray[li]<=array[ri]) {
					array[ro] = newArray[li];
					li++;
					ro++;										
				}
				else {
					array[ro] = array[ri];
					ri++;
					ro++;		
				}
				
			}
			
			
			
		}
	}

}
