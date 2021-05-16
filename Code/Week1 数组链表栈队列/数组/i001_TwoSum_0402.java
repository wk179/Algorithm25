package ArrayLinked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class i001_TwoSum_0402 {
    //暴力查找，双层循环。时间复杂度O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    //利用哈希表，使时间复杂度变为O(1)
    public static int[] twoSum2(int[] nums, int target) {
        /*思路：
        * 1.算出当先数字i和target的差，target - nums[i]；
        * 2.检查哈希表中是否存在该差值，若存在，则输出i和哈希表中那个key的value；
        * 3.若不存在，则当前数字nums[i]作为key，该数字索引i作为value。*/
        int[] res = new int[2];
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                res[0] = hashmap.get(target - nums[i]);
                res[1] = i;
                //这里因为，本身哈希表为空，不存在了才填入值，所以应该先输出哈希表的value，后输出当前i
            }
            hashmap.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int[] a = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(a,target)));
    }

}
