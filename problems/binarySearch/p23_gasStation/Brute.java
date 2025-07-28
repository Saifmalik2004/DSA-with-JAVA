
public class Brute {
    public static double  minMaxDis(int arr[],int k) {
        int n=arr.length;
        int howmany[]=new int[n-1];
        for (int gas = 1; gas <=k; gas++) {
            double maxVal=-1;
            int maxIdx=-1;

            for (int i = 0; i < n-1; i++) {
                double diff=arr[i+1]-arr[i];
                double secLen=diff/(double)(howmany[i]+1);

                if(secLen>maxVal){
                    maxVal=secLen;
                    maxIdx=i;
                }
                
            }
            howmany[maxIdx]++;
            
        }
        double maxVal=-1;
        for (int i = 0; i < n-1; i++) {
            double diff=arr[i+1]-arr[i];
            double secLen=diff/(double)(howmany[i]+1);
            maxVal=Math.max(maxVal,secLen);
            
        }
         return maxVal;
        
    }
    public static void main(String[] args) {
        int arr[]={1,2};
        System.out.println(minMaxDis(arr, 5));
    }
}
