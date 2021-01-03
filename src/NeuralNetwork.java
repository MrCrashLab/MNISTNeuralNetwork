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

    public void gradientDescentTutorial(List<int[]> inputImageDataSet, List<double[]> inputLabelDataSet) {

    }


    private void createRandomWeights() {
        weights = new double[inputDot][outDot];
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[i].length; j++)
                weights[i][j] = Math.random();
    }
}
