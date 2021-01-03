import java.util.Arrays;
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
        double[][] weights_delta;
        double[] pred;
        for (int i = 0; i < inputImageDataSet.size(); i++) {
            pred = VectorCalculation.vectorMatrixMul(inputImageDataSet.get(i), weights);
            for (int j = 0; j < pred.length; j++) {
                errors[j] = Math.pow(pred[j] - inputLabelDataSet.get(i)[j], 2);
                deltas[j] = pred[j] - inputLabelDataSet.get(i)[j];
            }
            weights_delta = VectorCalculation.vectorVectorMul(deltas, inputImageDataSet.get(i));
            for (int j = 0; j < weights.length; j++)
                for (int k = 0; k < weights[j].length; k++)
                    weights[j][k] -= alpha * weights_delta[j][k];
        }
    }

    public int test(double[] inputImage){
        int num = -1;
        double[] pred;
        pred = VectorCalculation.vectorMatrixMul(inputImage, weights);
        double max = pred[0];
        for(int i = 0;i<pred.length;i++){
            if(pred[i]>max){
                max = pred[i];
                num = i;
            }
        }
        return num;
    }

    private void createRandomWeights() {
        weights = new double[outDot][inputDot];
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[i].length; j++)
                weights[i][j] = Math.random()/1000000000;
    }
}
