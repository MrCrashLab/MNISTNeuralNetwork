import java.util.ArrayList;
import java.util.List;

public class Worker {
    private final String inputImagePath = "DataSets/train-images.idx3-ubyte";
    private final String inputLabelPath = "DataSets/train-labels.idx1-ubyte";
    private final NeuralNetwork neuralNetwork;
    private List<int[]> inputImageDataSet;
    private List<double[]> inputLabelDataSet;

    public Worker() {
        readAndConverting();
        neuralNetwork = new NeuralNetwork(0.01, 784, 10);
        neuralNetwork.gradientDescentTutorial(inputImageDataSet, inputLabelDataSet);
    }

    private void readAndConverting() {
        List<Integer> tmpList = IdxReader.readInputLabelDataSet(inputLabelPath);
        inputImageDataSet = IdxReader.readInputImageDataSet(inputImagePath);
        inputLabelDataSet = new ArrayList<>();
        for (int num : tmpList) {
            double[] tmp = new double[10];
            System.out.println(num);
            for (int i = 0; i < tmp.length; i++) {
                if (i == num) tmp[i] = 1;
                else tmp[i] = 0;
            }
            inputLabelDataSet.add(tmp);
        }
    }
}

