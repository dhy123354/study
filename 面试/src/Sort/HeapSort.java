public class HeapSort {
    static int[] array = {1,92,13,45,9,76,4};;
    int heapSize;

    public void HeapSort(int[] array){
        // 原地建堆
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            int temp = array[0];
            array[0] = array[--heapSize];
            array[heapSize] = temp;
            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        int element = array[index];
        int half = heapSize >> 1;
        while (index < half) { // index必须是非叶子节点
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            int child = array[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if (rightIndex < heapSize &&
                    array[rightIndex] > child) {
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (element >= child) break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.HeapSort(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
