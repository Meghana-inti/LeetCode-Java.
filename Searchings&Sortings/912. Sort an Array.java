class Solution {
    public static void merge(int nums[],int lb ,int ub,int mid){
        int i=lb,j=mid+1,k=0;
        int b[] = new int[ub-lb +1];
        while(i<=mid && j<=ub){
            if(nums[i]<nums[j]){
                b[k++] = nums[i++];
            }
            else{
                b[k++] = nums[j++];
            }
        }
        while(i<=mid){
            b[k++] = nums[i++];
        }
        while(j<=ub){
            b[k++] = nums[j++];
        }
        int s=0;
        for( k=lb;k<=ub;k++){
            nums[k] = b[s++];
        }
    }
    public static void mergeSort(int nums[],int lb, int ub){
        if(lb>=ub){
            return;
        }
        int mid = (lb+ub)/2;
        mergeSort(nums,lb,mid);
        mergeSort(nums,mid+1,ub);
        merge(nums,lb,ub,mid);
    }
    public int[] sortArray(int[] nums) {

        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}
