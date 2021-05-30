import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var s5 = "...@.\n" +
                ".####\n" +
                ".....\n" +
                "####.\n" +
                ".X...";

        var s4 = "..X..\n" +
                "#####\n" +
                ".....\n" +
                ".@...\n" +
                ".....\n";

        var s1 = "...@\n" +
                "#.##\n" +
                "....\n" +
                "...X\n" +
                "....";
        var s = "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                ".......@........\n" +
                ".###############\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "................\n" +
                "...............X";
        var finder = new MarsRouteFinder();
        var route = finder.findRoute(getMap(s));

        if (route == null) {
            System.out.println("A* Null. No way.");
        } else
            PrintMatrix(route);

    }

    public static void PrintMatrix(char[][] map) {
        for (var row : map) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static char[][] getMap(String s) {
        var rows = s.split("\n");
        var map = new char[rows.length][rows[0].length()];

        for (var x = 0; x < rows[0].length(); x++)
            for (var y = 0; y < rows.length; y++) {
                var r = rows[y];
                map[y][x] = r.charAt(x);
            }
        return map;
    }
}

