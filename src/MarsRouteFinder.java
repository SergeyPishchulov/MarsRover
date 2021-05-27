import java.util.*;


public class MarsRouteFinder implements RouteFinder {
    private Point[] getStartAndFinish(char[][] map) {
        var res = new Point[2];
        for (var x = 0; x < map[0].length; x++)
            for (var y = 0; y < map.length; y++) {
                if (map[y][x] == '@')
                    res[0] = new Point(x, y);
                if (map[y][x] == 'X')
                    res[1] = new Point(x, y);
            }
        return res;
    }

    @Override
    public char[][] findRoute(char[][] map) {
        var startAndFin = getStartAndFinish(map);
        var start = startAndFin[0];
        var fin = startAndFin[1];
        var frontier = new PriorityQueue<Tuple<Point, Integer>>(new ShortestComparator());
        frontier.add(new Tuple<Point, Integer>(start, 0));
        var camefrom = new HashMap<Point, Point>();
        var costSoFar = new HashMap<Point, Integer>();
        camefrom.put(start, null);
        costSoFar.put(start, 0);
        while (!frontier.isEmpty()) {
            var curTuple = frontier.peek();
            frontier.remove(curTuple);
            var cur = curTuple.First;

            if (cur == fin)
                break;

            for (var next : getValidNeighbors(cur, map)) {
                var newCost = costSoFar.get(cur) + 1;
                if (!costSoFar.containsKey(next) || newCost < costSoFar.get(next)) {
                    costSoFar.put(next, newCost);
                    var priority = newCost + manhattenDistance(next, fin);
                    frontier.add(new Tuple<>(next, priority));
                    camefrom.put(next, cur);
                }
            }
        }
        if (!costSoFar.containsKey(fin))
            return null;
        return RollBackRoute(camefrom, start, fin, map);
    }

    private char[][] RollBackRoute(HashMap<Point, Point> cameFrom, Point start, Point fin, char[][] map) {
        var width = map[0].length;
        var height = map.length;
        var cur = fin;
        while (cur != start) {
            map[cur.Y][cur.X] = '+';
            cur = cameFrom.get(cur);
        }
        map[fin.Y][fin.X] = 'X';
        return map;

    }

    private Integer manhattenDistance(Point a, Point b) {
        return Math.abs(a.X - b.X) + Math.abs(a.Y - b.Y);
    }

    private ArrayList<Point> getValidNeighbors(Point p, char[][] map) {//TODO recheck //, HashMap<Point, Integer> costSoFar
        var width = map[0].length;
        var height = map.length;
        var neighbors = new ArrayList<Point>();

        var right = new Point(p.X + 1, p.Y);
        if (right.X < width && map[right.Y][right.X] != '#')
            neighbors.add(right);

        var left = new Point(p.X - 1, p.Y);
        if (left.X >= 0 && map[left.Y][left.X] != '#')
            neighbors.add(left);

        var up = new Point(p.X, p.Y + 1);
        System.out.println(up);
        if (up.Y < height && map[up.Y][up.X] != '#')
            neighbors.add(up);

        var down = new Point(p.X, p.Y - 1);
        if (down.Y >= 0 && map[down.Y][down.X] != '#')
            neighbors.add(down);
        return neighbors;
    }
}
