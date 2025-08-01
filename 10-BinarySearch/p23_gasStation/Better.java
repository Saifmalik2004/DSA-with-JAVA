import java.util.*;

public class Better {
    public static class Pair{
        double first;
        int second;

        Pair(double first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public static double  gas(int arr[],int k) {

        int n=arr.length;
        int howMany[]=new int[n-1];

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> Double.compare(b.first, a.first));
        for (int i = 0; i < n-1; i++) {
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }

        for (int i = 1; i <= k; i++) {

            Pair tp=pq.poll();
            int secInd=tp.second;

            howMany[secInd]++;

            double inDiff=arr[secInd+1]-arr[secInd];
            double newSec=inDiff/(double)(howMany[secInd]+1);
            pq.add(new Pair(newSec,secInd));
            
            
        }

        return pq.peek().first;
    }
    public static void main(String[] args) {
         int arr[]={1,13,17,23};
        System.out.println(gasMin(arr, 5));
    }

    public static double gasMin(int arr[],int k){
        int n=arr.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> Double.compare(b.first,a.first));
        int[] howMany=new int[n-1];

        for (int i = 0; i < arr.length-1; i++) {
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }

       for (int i = 1; i <=k; i++) {
            Pair tp=pq.poll();
        int secInd=tp.second;

        howMany[secInd]++;

        double initDiff=arr[secInd+1]-arr[secInd];
        double secLen=initDiff/(double)(howMany[secInd]+1);
        pq.add(new Pair(secLen, secInd));
       }

       return pq.peek().first;

    }
}
