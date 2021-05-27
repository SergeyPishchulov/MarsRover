import java.util.Comparator;

public class ShortestComparator implements Comparator<Tuple<Point, Integer>> {


    @Override
    public int compare(Tuple<Point, Integer> o1, Tuple<Point, Integer> o2) {
        return o1.Second-o2.Second;
    }
}
