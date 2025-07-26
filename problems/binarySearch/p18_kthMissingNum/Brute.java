public class Brute {
    public static void main(String[] args) {
        int[] arr={1,2,3,6,7,9};
        System.out.println(findMis(arr, 3));

    }

    public static int findMis(int arr[],int k) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=k){
                k++;
            }else break;
        }

        return k;
        
    }
}
