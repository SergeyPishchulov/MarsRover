import java.lang.reflect.Array;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.PriorityQueue;


public class MarsRouteFinder implements RouteFinder {
    private Point[] getStartAndFinish(char[][] map) {
        var res = new Point[2];
        for (var x = 0; x < map[0].length; x++)
            for (var y = 0; y < map.length; y++) {
                if (map[x][y] == '@')
                    res[0] = new Point(x, y);
                if (map[x][y] == 'X')
                    res[1] = new Point(x, y);
            }
        return res;
    }

    @Override
    public char[][] findRoute(char[][] map) {
        var startAndFin = getStartAndFinish(map);
        var start = startAndFin[0];
        var fin = startAndFin[1];
        var frontier = new PriorityQueue<Tuple<Point, Integer>>(0, new ShortestComparator());
        frontier.add(new Tuple<Point, Integer>(start, 0));
        var camefrom=new HashMap<Point, Point>();
        var costSoFar=new HashMap<Point, Integer>();
        camefrom.put(start, null);
        costSoFar.put(start, 0);

        while (!frontier.isEmpty())
        {
            var curTuple=frontier.peek();
            frontier.remove(curTuple);
            var cur=curTuple.First;

            if (cur==fin)
                break;

            for (var next in neighbours)
        }


        return new char[0][];
    }
}
