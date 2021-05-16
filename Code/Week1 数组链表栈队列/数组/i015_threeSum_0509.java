package ArrayLinked;
import java.util.*;

public class i015_threeSum_0509 {
    /*
     * @param: nums
     * @description: 双指针夹逼，已加速
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || n < 3) {
            return res;
        }
        for (int i = 0; i < n - 2; i++) {
            //加速
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int L = i + 1, R = n - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //加速
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    //加速
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                }else if(sum>0) {
                    R--;
                }
            }
        }
        return res;
    }
    /*
     * @param: nums
     * @description: 哈希表解法，set去重
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(nums == null || n < 3) {
            return res;
        }
        Set<List<Integer>> sortedRes = new LinkedHashSet<>();

        for (int i = 0; i < n - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(n - 1);
            for (int j = i + 1; j < n; j++) {
                int over = target - nums[j];
                Integer exist = hashMap.get(over);
                if (exist != null) {  //存
                    List<Integer> list = Arrays.asList(nums[i], nums[j], exist);
                    list.sort(Comparator.naturalOrder());
                    res.add(list);
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        i015_threeSum_0509 test = new i015_threeSum_0509();
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));*/
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum1(a));
    }
}
