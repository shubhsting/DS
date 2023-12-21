import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    // https://leetcode.com/problems/bus-routes/
    class EdgeMetadata {
        int busStopNo;
        int busCount;

        EdgeMetadata(int busStopNo, int busCount) {
            this.busStopNo = busStopNo;
            this.busCount = busCount;
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> busStopToBusNoMap = new HashMap<>();
        for (int busNo = 0; busNo < routes.length; busNo++) {
            int[] busStops = routes[busNo];
            for (int busStop : busStops) {
                busStopToBusNoMap.putIfAbsent(busStop, new ArrayList<>());
                busStopToBusNoMap.get(busStop).add(busNo);
            }
        }
        return BFS(routes, busStopToBusNoMap, new HashSet<>(), new HashSet<>(), source, target);
    }

    public int BFS(int[][] routes, HashMap<Integer, ArrayList<Integer>> busStopToBusNoMap, HashSet<Integer> visitedBus,
            HashSet<Integer> visitedBusStop, int source, int target) {
        if (!busStopToBusNoMap.containsKey(source) || !busStopToBusNoMap.containsKey(target)) {
            return -1;
        }
        LinkedList<EdgeMetadata> queue = new LinkedList<>();
        queue.addLast(new EdgeMetadata(source, 0));
        visitedBusStop.add(source);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                EdgeMetadata edge = queue.removeFirst();
                if (edge.busStopNo == target) {
                    return edge.busCount;
                }
                for (Integer bus : busStopToBusNoMap.get(edge.busStopNo)) {
                    if (!visitedBus.contains(bus)) {
                        visitedBus.add(bus);
                        for (int nextBusStop : routes[bus]) {
                            if (!visitedBusStop.contains(nextBusStop)) {
                                visitedBusStop.add(nextBusStop);
                                queue.addLast(new EdgeMetadata(nextBusStop, edge.busCount + 1));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}