// https://leetcode.com/problems/k-closest-points-to-origin/description/
class Solution {
    class Coordinate {
        int x;
        int y;
        double distanceFromOrigin;

        Coordinate(int x, int y, double distanceFromOrigin) {
            this.x = x;
            this.y = y;
            this.distanceFromOrigin = distanceFromOrigin;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> pq = new PriorityQueue<>((Coordinate x, Coordinate y)->{
            return (int)Double.compare(y.distanceFromOrigin, x.distanceFromOrigin);
        });

        for(int[] point: points) {
            double currentDistance = Math.pow(point[0],2) + Math.pow(point[1],2);
            if(pq.size() < k) {
                pq.add(new Coordinate(point[0], point[1], currentDistance));
            } else {
                Coordinate c = pq.remove();
                if(c.distanceFromOrigin > currentDistance) {
                    pq.add(new Coordinate(point[0], point[1], currentDistance));
                } else {
                    pq.add(c);
                }
            }
        }

        int[][] ans = new int[k][2];
        for(int index = k-1; index>=0; index--) {
            Coordinate c = pq.remove();
            ans[index][0] = c.x;
            ans[index][1] = c.y;
        }
        return ans;
    }
