public class task1 {
    private static double start_degree;
    private static double increase_degree;
    private static double end_degree;
    private static final double DEFAULT_DEGREE = 0.0;
    private static final int DEFAULT_INCREASE = 5;
    private static final double DEFAULT_END = 360.0;

    public task1(double start_degree, double increase_degree, double end_degree) {
        this.start_degree = start_degree;
        this.increase_degree = increase_degree;
        this.end_degree = end_degree;
    }

    public task1(double start_degree) {
        new task1(start_degree, DEFAULT_INCREASE, DEFAULT_END);
    }

    public task1() {
        new task1(DEFAULT_DEGREE);
    }

    public double getStartDegree() {
        return start_degree;
    }

    public double getIncreaseDegree() {
        return increase_degree;
    }

    public double getEndDegree() {
        return end_degree;
    }

    public static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }


    public static void main(String[] args) {
        task1 taskTest = new task1();
        double currentDegree = taskTest.getStartDegree();
        while (currentDegree<taskTest.getEndDegree()){
            double error = taskTest.programResults(currentDegree) - taskTest.programTaylor(10, currentDegree);
            System.out.println("For degree " + currentDegree + "; program value is " + taskTest.programResults(currentDegree)
                    + "; Taylor result is " + taskTest.programTaylor(10, currentDegree) + "; error " + error);
            currentDegree +=taskTest.getIncreaseDegree();
        }
    }

    public double programResults(double degree) {
        double result = Math.sin(Math.toRadians(degree));
        return result;
    }

    public double programTaylor(int n, double degree) {
        double result = 0;
        //taylor works well for sin peroid (-Pi/2; Pi/2) so we need to refactor our angles
        //i mean that for other values it goes out of allowed [-1; 1]
        if (degree%360 > 90 || degree%360 <= 180){
            degree = 180 - degree;
        }
        if (degree%360 > 180  ||degree%360 <= 270){
            degree = (180 - degree);
        }
        if (degree%360 > 270  ||degree%360 <= 360){
            degree = degree -360;
        }

        for (int i = 0; i < n; i++) {
            result += Math.pow(-1, i) * (Math.pow(Math.toRadians(degree), 2 * i + 1) / getFactorial(2 * i + 1));
        }
        return result;
    }

}
