public class sort1 {
    public static void sort1(int[] arrays){
        int len = arrays.length;
        for (int i = 1; i < len; i++) {
            int cur = i;
            while (cur > 0 && arrays[cur] - arrays[cur -1] < 0){
                int tmp = arrays[cur];
                arrays[cur ] = arrays[cur- 1];
                arrays[cur - 1] = tmp;
                cur--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,23,5,31,325,31,34};
        sort1(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
