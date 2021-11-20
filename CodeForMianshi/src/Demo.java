/**
 * @author 9953
 * @date 2021/11/8 - 16:32
 */
public class Demo {
    public static void main(String[] args) {
        /*
        打印图案
        *
        **
        ***
        ****
        *****
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        /*
        打印图案
        * * * * *
        * * * *
        * * *
        * * 
        *
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();

        }
        /*
        打印图案
        * * * * *
         * * * *
          * * *
           * *
            *
         */
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 5; k > i; k--) {
                System.out.print("* ");

            }
            System.out.println();


        }
        int[] arr = {1, 54, 48, 354, 84, 23, 6,55};
        System.out.println("---------选择排序--------");
        select_sort(arr);
        printarr(arr);
        System.out.println("---------冒泡排序--------");
        bubblesort(arr);
        printarr(arr);
        System.out.println("---------二分查找--------");
        System.out.println(halfsearch(arr,354));

    }

    private static int halfsearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) / 2;
        while(arr[mid]!=key){
            if(arr[mid]<key){
                min=mid+1;
            }else if(arr[mid]>key){
                max=mid-1;
            }
            else{
                return mid;
            }
            if(min>max){
                return -1;
            }
            mid = (max+min)/2;
        }
        return mid;
    }

    private static void bubblesort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     */
    public static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
