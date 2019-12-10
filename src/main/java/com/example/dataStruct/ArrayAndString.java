package com.example.dataStruct;

/**
 * 数组和字符串
 */
public class ArrayAndString {

	/**
	 * 选择数组中的中心索引
	 * 
	 * 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
	 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
	 */
	public int  findCenterIndex(int[] intArray) {
		int sum=0;
		for(int i=0;i<intArray.length;i++) {
			sum+=intArray[i];
		}
		if(sum==0)return 0;
		int leftSum=0;
		for(int i=1;i<intArray.length;i++) {
			leftSum+=intArray[i-1];
			if(leftSum==(sum-leftSum-intArray[i]))return i;
		}
		return -1;
	}
	/**
	 *  至少是其他数字两倍的最大数
	 *  
	 *  查找数组中的最大元素是否至少是数组中每个其他数字的两倍。如果是，则返回最大元素的索引，否则返回-1。
	 */
	public int isBiggestDoubleOthers(int[] intArray) {
		return 1;
	}
	
	/**
	 * 加1
	 * 
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
	 */
	public int[] plusOne(int[] intArray) {
		return null;
	}
	
	/**
	 * 对角线遍历
	 * 
	 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素
	 */
	public int[] diagonalTraversal(int[][] intArray) {
		return null;
	}
	/**
	 * 螺旋遍历
	 * 
	 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素
	 */
	public int[] spiralTraversal(int[][] intArray) {
		return null;
	}
	
	/**
	 * 杨辉三角
	 * 
	 * 输入: 5
	 * 输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 * 
	 */
	public int[][] YangHuiTriangle(int row) {
		return null;
	}
	/**
	 * 二进制求和
	 * 
	 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
	 * 输入为非空字符串且只包含数字 1 和 0。
	 */
	public String binarySum(String a,String b) {
		return null;
	}
	
	/**
	 * 存在位置
	 * 
	 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	 * 当 needle 是空字符串时我们应当返回 0 
	 */
	public int indexof(String haystack,String needle) {
		return 0;
	}
	/**
	 * 最长公共前缀
	 * 
	 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
	 * 所有输入只包含小写字母 a-z 。
	 */
	
	public String longestCommonPrefix(String[] strings) {
		return null;
	}
	
	/**
	 * 反转字符串
	 * 
	 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
	 */
	public String reverse(String string) {
		return null;
	}
	
	/**
	 * 数组拆分
	 * 
	 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
	 */
	public int[][] divideArray(int[] intArray){
		return null;
	}
	/**
	  *  两数之和
	 * 
	 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
	 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
	 * 
	 */
	public int[] addForTarget(int[] intArray,int target){
		return null;
	}
	
	/**
	 * 移除元素
	 * 
	 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	 */
	public int removeItemByValue(int[] intArray,int val) {
		
		return intArray.length;
	}
	/**
	  *  最大连续1的个数
	 *  
	  *  给定一个二进制数组， 计算其中最大连续1的个数。
	 */
	public int countOfContinuousOne(int[] intArray) {
		return 0;
	}
	/**
	  * 长度最小的子数组
	 * 
	  *  给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
	 */
	public int shortestArray(int[] intArray,int sum) {
		return 0;
	}
}
