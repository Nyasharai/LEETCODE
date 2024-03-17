class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Step 1: Convert array to list
        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        // Add new interval to the list
        intervalsList.add(newInterval);
        // Sort intervals based on start value
        Collections.sort(intervalsList, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Merge intervals
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervalsList) {
            if (ansList.size() == 0 || ansList.get(ansList.size() - 1)[1] < interval[0]) {
                ansList.add(interval);
            } else if (ansList.get(ansList.size() - 1)[1] >= interval[0]) {
                ansList.get(ansList.size() - 1)[1] = Math.max(ansList.get(ansList.size() - 1)[1], interval[1]);
            }
        }

        // Step 3: Convert list back to array
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}