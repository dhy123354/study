package 数据结构2;


import 数据结构2.Array.tools.Integers;

public class mian {
    protected static int[] array;

    public static void main(String[] args) {
        Integer[] array1 = {7, 3, 5, 8, 6, 7, 4, 5};
        sort(array1);
        Integers.println(array1);
    }

    private static void sort(Integer[] array) {
        sort(0,array.length);
    }

    private static void sort(int begin, int end){
        if (end - begin < 2) return;

        int mid = pivotIdex(begin,end);
        sort(begin,mid);
        sort(mid + 1,end);
    }

    protected static int cmp(int i1, int i2) {
        int cmpCount = 0;
        cmpCount++;
        return array[i1] - array[i2];
    }

    private static int pivotIdex(int begin, int end){
        int temp = array[begin];
        array[begin] = array[begin + (int) Math.random() * (end - begin)];
        array[begin + (int) Math.random() * (end - begin)] = temp;

        int pivot = array[begin];

        end--;
        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        //将轴点元素放入最终的位置
        array[begin] = pivot;

        // 返回轴点元素的位置
        return begin;
    }
}
