package exam;

public class Test {

    public static int findIndex(int[] sortArr, int target) {
        //代码编辑区 start
        int begin = 0;
        int end = sortArr.length;
        while (begin < end){
            int mid = (begin + end) >> 1;
            if (target < sortArr[mid]){
                end = mid;
            }else if (target > sortArr[mid]){
                begin = mid + 1;
            }else {
                return mid;
            }
        }
        return end;
        //代码编辑区 end
    }
    public static void main(String[] args) {
        int [] sortArr ={1};
        int target = 1 ;
        System.out.println(findIndex(sortArr, target));
    }
}
