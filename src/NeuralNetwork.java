import java.util.List;

public class NeuralNetwork {
    int inputDot;
    int outDot;
    double alpha;
    double[][] weights;

    public NeuralNetwork(double alpha, int inputDot, int outDot) {
        this.alpha = alpha;
        this.inputDot = inputDot;
        this.outDot = outDot;
        // TODO create multiThreads
        createRandomWeights();
    }

    public void gradientDescentTutorial(List<double[]> inputImageDataSet, List<double[]> inputLabelDataSet) {
        double[] deltas = new double[outDot];
        double[] errors = new double[outDot];
        double[] pred;
        for(int i = 0;i<inputImageDataSet.size();i++){
            pred = VectorCalculation.vectorMatrixMul(inputImageDataSet.get(i),weights);
            for(int j = 0;j<pred.length;j++){
                System.out.println(pred[j]);
            }
            System.out.println("\n");
        }
    }


    private void createRandomWeights() {
        weights = new double[outDot][inputDot];
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[i].length; j++)
                weights[i][j] = Math.random();
    }
}
