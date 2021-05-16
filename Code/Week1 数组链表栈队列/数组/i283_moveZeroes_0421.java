package ArrayLinked;

import java.util.Arrays;

/*5
0 1 0 3 12*/
public class i283_moveZeroes_0421 {
    /*
     * @param: nums
     * @description: 方法1：双指针，前面的指针i，后面的指针j。
     * a[i]=a[j];
     * 但需要另起一个循环，来将最后i停着的位置之后的都赋值为0
     * @return: int[]
     */
    public int[] moveZeroes1(int[] nums) {
        if (nums == null) {
            return null;
        }
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while (i < nums.length){
            nums[i++] = 0;
        }
        return nums;
    }

    public int[] moveZeroes2(int[] nums) {
        if (nums == null) {
            return null;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                //将方法1的第二个循环合并到这里
                if (i != j) {
                    nums[j] = 0;
                }
                i++;
            }
        }
        return nums;
    }

    public int[] moveZeroes3(int[] nums) {
        if (nums == null) {
            return null;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //交换法，其实这里的temp都是0
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
//                System.out.print("temp:"+temp+" ");
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        i283_moveZeroes_0421 test = new i283_moveZeroes_0421();
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }*/
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(nums));
        nums = test.moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
