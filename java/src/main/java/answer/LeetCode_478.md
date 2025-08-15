[题目传送门](https://leetcode.cn/problems/generate-random-point-in-a-circle/)




解题思路：  
      
  
这个题目是为数不多的根据内容完成结构设计的题目  
核心问题是如何生成合理的圆内随机点  


错误结果：  
*这个结果不是随机的*  
比如在x=0和x=1都是10次，但是y出现的频率不一样，这样就会认为在远的地方更密集，不是随机的。

先假定圆心恒定为(0,0)，半径为r=1  
那么优先在x轴上进行随机化，在[-1,1]区间内随机取一个值，比如x=0.3
那么其最大的y值为 Max_y = pow(r*r-x*x,1/2)
随机在[-y,y]中取一个值即可


```
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
        double maxY = Math.pow(radius * radius - xLocation * xLocation, 0.5);
        double yLocation = Math.random() * maxY * 2 - maxY;     // y自带正负号
        return new double[]{xLocation + x_center, yLocation + y_center};
    }

    public static void main(String[] args) {
        double radius = 0.01;
        double x_center = -73839.1;
        double y_center = -3289891.3;
        LeetCode_478 leetCode = new LeetCode_478(radius, x_center, y_center);
        for (int i = 0; i < 10000; i++) {
            double[] result = leetCode.randPoint();
            if (Math.pow(result[0] - x_center, 2) + Math.pow(result[1] - y_center, 2) >= Math.pow(radius, 2)) {
                System.out.println("超范围" + "x=" + result[0] + "  " + "y=" + result[1]);
                break;
            } else {
                System.out.println("没有超范围：" + i);
            }
        }
    }
}

```
  
  
    
第二种思路：  
在圆外侧生成一个正方形，x和y都可以任意取值，如果在圆内，则返回，不在圆内则重新调用。












