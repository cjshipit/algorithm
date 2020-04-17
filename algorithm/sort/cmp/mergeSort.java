package sort.cmp;

public class mergeSort extends sort {
	/*
	 * �鲢�����˼��
	 *   ������������������˵ �ϲ���һ����������  ��˫ָ�������ƶ� ����һ���ط����
	 * 
	 * 
	 * 
	 * */
	private static int[] newArray = null;//�����Ԫ�ؿ����ĵط�
	public  static int[] sort(int[] array) {
		newArray = new int[array.length/2];
		//���м���� �������߷ֱ���й鲢���� ���������������
		mergeSorts(array,0,array.length/2);
		mergeSorts(array,array.length/2,array.length);
		//��һ��鲢
		merge(array,0,array.length,array.length/2);
		
		return array ;
	}
	//��Ҫ�ݹ���õĺ��� 
	private static void  mergeSorts(int[] array,int begin,int end) {
		//end��ʾ ���һ��Ԫ���±�+1    begin��ʾ��һ��Ԫ�ص��±�
		if(end-begin==1) {
			return ;
		}
		mergeSorts(array,begin,(end+begin)/2);
		mergeSorts(array,(end+begin)/2,end);
		merge(array,begin,end,(end+begin)/2); 
		return;
		
	}
	//���κ���һ��鲢  �鲢�������array����
	private static void merge(int[] array,int begin,int end,int mid) {
		//�����ߵ�Ԫ�ؿ���һ�� ��������
		for(int i=0;i<(mid-begin);i++) {
			newArray[i] = array[begin+i];
		}
		int li = 0 ;//���ߵ�ָ��
		int le = mid-begin;
		int ri = mid ;
		int re = end;
		int ro = begin;//���𿴹鲢����һ����
		//�������Ԫ�ر���ʱ�� ѭ�� ���û��ʱ�� �ұߴ��Ԫ�� ȫ�ڹ鲢������ұ�
		while(li<le) {
			//�ұ߹鲢���� ��Ҫ����ߵ�ȫ��ѹ�뵽�鲢������
			if(ri==re) {
				while(li<le) {
					array[ro] = newArray[li];
					li++;
					ro++;
					
					
					
				}
				
			}
			//���Ҷ���Ԫ��û�б���
			else if(li<le){
				//���Ԫ�ش� �����Ԫ��ѹ��鲢���� 
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
