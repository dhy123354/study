public class sort {
    public static void sort(int[] arrays){
        for (int end = arrays.length - 1; end > 0; end--) {
            int max= 0;
            for (int begin = 1; begin <= end; begin++) {
                if (arrays[max] - arrays[begin] < 0)
                    max = begin;
            }
            int tmp = arrays[end];
            arrays[end] = arrays[max];
            arrays[max] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{12,10,8,4,7,34};
        sort(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
