package leetCode;


public class LeetCode_478 {

    private final double radius;
    private final double x_center;
    private final double y_center;

    public LeetCode_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double xLocation = Math.random() * radius * 2 - radius; // x自带正负号
        double yLocation = Math.random() * radius * 2 - radius; // y自带正负号
        if (Math.pow(xLocation, 2) + Math.pow(yLocation, 2) < Math.pow(radius, 2)) {
            return new double[]{xLocation + x_center, yLocation + y_center};
        } else {
            return randPoint();
        }
    }

    public static void main(String[] args) {
        double radius = 1.0;
        double x_center = 0.0;
        double y_center = 0.0;
        LeetCode_478 leetCode = new LeetCode_478(radius, x_center, y_center);
        for (int i = 0; i < 10000; i++) {
            double[] result = leetCode.randPoint();
            if (Math.pow(result[0] - x_center, 2) + Math.pow(result[1] - y_center, 2) >= Math.pow(radius, 2)) {
                System.out.println("超范围" + "x=" + result[0] + "  " + "y=" + result[1]);
                break;
            } else {
                System.out.println("没有超范围：" + i);
                System.out.println("x=" + result[0] + "  " + "y=" + result[1]);
            }
        }
    }
}
