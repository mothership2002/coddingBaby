package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {

	public void ex1() {
		
		int [][] arr = {{1,2,3,4},{5,6,7,8}};
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=0;j<arr[i].length;j++) {
			
				if(i==0){
					System.out.printf("%d ",arr[i][j]);
				}else {
					System.out.printf("%d ",arr[i][j]);
				}
				
			}
			System.out.println();
		}
		
	}
	
	public void ex2() {
		
		int[][] secondDimensionArrayStudy = new int[2][3];
		
		for(int i=0; i<secondDimensionArrayStudy.length;i++) {
			
			for(int j=0;j<secondDimensionArrayStudy[i].length;j++) {
				
				secondDimensionArrayStudy[i][j] = 10 * (i+1) * (j+1);
				
				System.out.print(secondDimensionArrayStudy[i][j]+" ");
			
			}
			
			System.out.println();
			
		}
		System.out.println(Arrays.deepToString(secondDimensionArrayStudy));
		System.out.println("===========================================");
		
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j=0;j<arr[i].length;j++) {
				sum += arr[i][j];
			}
			System.out.printf("%d행의 합계 : %d\n",i+1,sum);
			
		}
		
		System.out.println("=========================================");
		
		for(int i=0;i<arr[i].length;i++) {
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				sum+=arr[j][i];
			}
			System.out.printf("%d열의 합계 : %d\n",i+1,sum);
		}
		
		System.out.println("====================================");
		
	}
	
	public void ex3() {
		//가변배열
		//-2차원 배열 생성 시 마지막 배열차수를 지정하지 않고
		
		char[][] arr = new char[4][];
		
		arr[0] = new char[3];
		arr[1] = new char[4];
		arr[2] = new char[5];
		arr[3] = new char[2];
		
		//각 배열 요소에 a~부터 대입
		char a = 'a';
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = a++;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(Arrays.deepToString(arr));
		
	}
	
	
}
