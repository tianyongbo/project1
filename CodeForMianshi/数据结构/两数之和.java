/**
 * @author 9953
 * @date 2021/11/12 - 17:34
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        printarr(twosum(nums, target));



    }

    private static void printarr(int[] twosum) {
        System.out.print("[");

        for (int i = 0; i < twosum.length; i++) {
            if(i!=twosum.length-1) {
                System.out.print(twosum[i] + ",");
            }else{
                System.out.print(twosum[i]+"]");

            }

        }

    }

    public static int[] twosum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }

        }
        return arr;
    }
}
