public class Point {
    public int X;
    public int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public boolean equals(Point other) {
        return (this.X == other.X && this.Y == other.Y);
    }
}
