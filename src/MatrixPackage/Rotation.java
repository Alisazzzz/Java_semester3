package MatrixPackage;

public class Rotation extends Matrix22{

    int alpha;

    Rotation(int alpha) {
        super(Math.sin(alpha), Math.cos(alpha), -Math.cos(alpha), Math.sin(alpha));
        this.alpha = alpha;
    }

    public int getAngle() {
        return alpha;
    }
}
