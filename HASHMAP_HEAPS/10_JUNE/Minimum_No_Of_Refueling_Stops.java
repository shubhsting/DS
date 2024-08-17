// https://leetcode.com/problems/minimum-number-of-refueling-stops/

class Solution {
    class Station {
        int position;
        int fuel;

        Station(int position, int fuel) {
            this.fuel = fuel;
            this.position = position;
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int range = startFuel;
        int ans = 0;
        PriorityQueue<Station> pq = new PriorityQueue<>((Station a, Station b) -> {
            return b.fuel - a.fuel;
        });
        int index = 0;
        while (index < stations.length) {
            if (range >= stations[index][0]) {
                pq.add(new Station(stations[index][0], stations[index][1]));
                index++;
            } else {
                if (pq.size() == 0)
                    return -1;
                while (range < stations[index][0] && pq.size() > 0) {
                    Station s = pq.remove();
                    range += s.fuel;
                    ans++;
                }
            }
        }

        if (range >= target)
            return ans;
        while (pq.size() != 0) {
            Station s = pq.remove();
            range += s.fuel;
            ans++;
            if (range >= target)
                return ans;
        }
        return -1;
    }
}