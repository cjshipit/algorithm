package sort.util;
import java.lang.Math;
//����һ������������ڲ��������㷨
public class randArray {
	//��һ�� ��������ֵ ����(0 max] �������
	 public static int[] produceArray(int max,int size) {
		 int[] array = new int[size];
		 for(int i=0;i<array.length;i++) {
			 array[i] =(int)(Math.random()*max+1);		 
		 }
		 
		 
		 return array ;
		 
	 }

}
