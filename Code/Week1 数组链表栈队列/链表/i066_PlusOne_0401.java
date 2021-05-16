/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
输入：digits = [1,2,3]
输出：[1,2,4]
*/
import java.util.Arrays;
import java.util.Scanner;
public class i066_PlusOne_0401 {
    public static void main(String[] args) {
        /*分三种情况：
        * 1. 个位数为0~8，直接给个位数加一即可；
        * 2. 个位数为9，需要进位，个位数→0，十位+1；
        * 3. 999这样的，需要加一位，在数组头加一位1。*/
//        Scanner sc = new Scanner(System.in);
//        String digits = sc.nextLine();
        int[] num = {1,2,3};
        System.out.println(Arrays.toString(plusOne(num)));
        System.out.println("ms");
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


}
