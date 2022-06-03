package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample2 {
	
	public void shallowCopy() {
		
		int[] arr = {1,2,3,4,5};
		
		int[] copyArr = arr;
		
		System.out.println("�ּҰ� : arr = "+arr);
		System.out.println("�ּҰ� : copyArr = "+copyArr);
		
		
		System.out.println("���� ��");
		System.out.println("arr : "+Arrays.toString(arr));
		System.out.println("copyArr : "+Arrays.toString(copyArr));
		
		copyArr[2]=999;
		
		System.out.println("���� ��");
		System.out.println("arr : "+Arrays.toString(arr));
		System.out.println("copyArr : "+Arrays.toString(copyArr));
		
		//�ּҰ��� �����߱� ������
		
	}

	public void deepCopy() {
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = new int[arr1.length];
		
		//for�� ����
		for(int i=0;i<arr1.length;i++) {
			arr2[i] = arr1[i];
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		//arraycopy ����
		// 2. System.arraycopy
		//(�����迭, ���� ���� ���� �ε���, ����迭, ����迭�� ���� ���� �ε���, �������);
		
		int[]arr3 = {6,7,8,9,10};
		int[]arr4 = new int[arr3.length];
		
		System.arraycopy(arr3,0,arr4,0,arr3.length);
		
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
		
		//arr2 = arrays.copyOf(arr1,arr1.length);
		
		int[]arr5 = {1,3,5,7,9};
		int[]arr6 = new int[arr5.length];
		
		arr6 = Arrays.copyOf(arr5, arr5.length);
		
		System.out.println(Arrays.toString(arr5));
		System.out.println(Arrays.toString(arr6));
		
		//clone (risky)
		// arr8=arr.7clone();
		
	}
	
	public void createLottoNumber() {
		
		//1~45 6
		//���� ��������
		int[] arr = new int[6];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(1+Math.random()*45+1);			
			for(int x=0;x<i;x++) {
				if(arr[x]==arr[i]) {
					i--;
					break;
				}
			}	
		}
		
		Arrays.sort(arr);//�������� �޼ҵ�
		//arrays.sort(arr,collections.reverseorder()); ��������
		
		System.out.println(Arrays.toString(arr));
	}
	
}
