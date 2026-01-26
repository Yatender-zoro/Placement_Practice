class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int j = 0;
        int m = passengers.length;
        int lastBusCount = 0;

        for (int bus : buses) {
            lastBusCount = 0;
            while (j < m && passengers[j] <= bus && lastBusCount < capacity) {
                j++;
                lastBusCount++;
            }
        }

        int ans;
        if (lastBusCount < capacity) {
            ans = buses[buses.length - 1];
        } else {
            ans = passengers[j - 1] - 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int p : passengers) set.add(p);
        while (set.contains(ans)) ans--;

        return ans;
               
    }
}