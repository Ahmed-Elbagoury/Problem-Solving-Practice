//https://leetcode.com/problems/product-of-array-except-self/
//http://www.geeksforgeeks.org/a-product-array-puzzle/
public class ProductExceptSelf{
	public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        int n = nums.length;    
        int [] left = new int [n];    
        left[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            left[i] = left[i+1] * nums[i+1];
        }
        int [] right = new int [n];
        right[0] = 1;
        for(int i = 1; i < n; i ++){
            right[i] = right[i-1] * nums[i-1];
        }
        int [] sol = new int [n];
        for(int i = 0; i < n; i++){
            sol[i] = left[i] * right[i];
        }
        return sol;
    }
    //O(1) space
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int [0];
        }
        int n = nums.length;
        int [] solution = new int [n];
        solution[0] = 1;
        for(int i = 1; i < n; i++){
            solution[i] = nums[i-1] * solution[i-1];
        }
        int curProduct = 1;
        for(int i = n-2; i >= 0; i--){
            curProduct *= nums[i+1];
            solution[i] *= curProduct;
        }
        return solution;
    }

}
