class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length, num = -1, deno = -1, fractionPosCovered = 0;
            double s = 0, e = 1;
            while(fractionPosCovered != k) {
                fractionPosCovered = 0;
                double mid = s + (e - s) /2.0, maxFracValue = 0.0;
                for(int numIndx = 0, denoIndx = 1; numIndx < n; numIndx++) {
                    while(denoIndx < n && arr[numIndx] > mid * arr[denoIndx])
                        denoIndx++;
                    int currFracPos = n - denoIndx;    
                    if (denoIndx == n || (fractionPosCovered += currFracPos) > k)
                        break;
                    if (arr[numIndx] > maxFracValue * arr[denoIndx]) {
                        maxFracValue = arr[numIndx] * 1.0 / arr[denoIndx] ;
                        num = arr[numIndx];
                        deno = arr[denoIndx];
                    }
                }
                if (fractionPosCovered > k)
                    e = mid;
                else 
                    s = mid;
            }
            return new int[] {num, deno};
        }
}