package ArrayLinked;

public class i011_ContainerWithMostWater_0504 {
    /*
     * @param: a
     * @description: 暴力枚举法。双重循环a，一个个列举每一个情况，取最大的。
     * @return: int
     */
    public int maxArea1 (int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++){
//            System.out.print("i" + a[i] + ": ");
            for (int j = i + 1; j < a.length; j++) {
                int area = _getArea(a, i, j);
                int indexDiff = j - i;
                System.out.print("i(" + i + ")&j(" + j + ") = " + indexDiff + "*" + Math.min(a[j],a[i]) + " = " + area + "; ");
                System.out.println();
                max = Math.max(max, area);
            }
            System.out.println("---------");
        }
        return max;
    }
    private int _getArea(int[] a, int x, int y) {
        return (y - x) * Math.min(a[x], a[y]);
    }

    /*
     * @param: a
     * @description: 双指针夹逼
     * @return: int
     */
    public int maxArea2 (int[] a) {
        int i = 0, j = a.length - 1;
        int max = 0;
//        for (int i = 0, j = a.length - 1; i < j)
        while (i < j) {
//            int minHeight = a[i] < a[j] ? a[i++] : a[j--]; ->(j-i+1)*minHeight
            int area = _getArea(a, i, j);
            max = Math.max(max, area);
            if (a[i] < a[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }*/
        i011_ContainerWithMostWater_0504 test = new i011_ContainerWithMostWater_0504();
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int n = a.length;
        int res = test.maxArea2(a);
        System.out.println(res);
    }
}
