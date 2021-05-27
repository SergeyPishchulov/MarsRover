import java.util.Objects;

public class Point {
    public int X;
    public int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return X == point.X && Y == point.Y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.X;
        hash = 71 * hash + this.Y;
        return hash;
    }

}
