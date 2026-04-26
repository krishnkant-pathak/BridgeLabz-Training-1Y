public class Question6 {
    public static void main(String[] args) {
        int a[] = {10,20,30,40,50,60,70};
        int k = 3;
        int n = a.length;
        k = k % n;
        int t[] = new int[k];
        for (int i = 0; i < k; i++) t[i] = a[i];
        for (int i = k; i < n; i++) a[i - k] = a[i];
        for (int i = 0; i < k; i++) a[n - k + i] = t[i];
        for (int i : a) System.out.print(i + " ");
    }
}