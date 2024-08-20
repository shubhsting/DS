
// https://www.naukri.com/code360/problems/employee-free-time_1171181?leftPanelTabValue=PROBLEM
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    static class Edge {
        int sInterval;
        int eInterval;
        int empId;
        int index;

        Edge(int s, int e, int empId, int index) {
            this.sInterval = s;
            this.eInterval = e;
            this.empId = empId;
            this.index = index;
        }
    }

    public static ArrayList<Integer> findFreeIntervals(ArrayList<ArrayList<Integer>> schedules) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge a, Edge b) -> {
            return a.sInterval - b.sInterval;
        });
        for (int index = 0; index < schedules.size(); index++) {
            ArrayList<Integer> schedule = schedules.get(index);
            int nextIndex = schedule.size() > 2 ? 2 : -1;
            pq.add(new Edge(schedule.get(0), schedule.get(1), index, nextIndex));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int currentEnd = -1;
        while (pq.size() > 0) {
            Edge current = pq.remove();
            if (current.sInterval > currentEnd) {
                if (current.sInterval - 1 > currentEnd && currentEnd + 1 < current.sInterval) {
                    ans.add(currentEnd + 1);
                    ans.add(current.sInterval - 1);
                }
                currentEnd = current.eInterval;
            } else {
                currentEnd = Math.max(currentEnd, current.eInterval);
            }

            if (current.index != -1) {
                ArrayList<Integer> schedule = schedules.get(current.empId);
                int nextIndex = schedule.size() - 1 > current.index + 2 ? current.index + 2 : -1;
                pq.add(new Edge(schedule.get(current.index), schedule.get(current.index + 1), current.empId,
                        nextIndex));
            }
        }
        if (currentEnd != 100000000) {
            ans.add(currentEnd + 1);
            ans.add(100000000);
        }
        return ans;
    }

}