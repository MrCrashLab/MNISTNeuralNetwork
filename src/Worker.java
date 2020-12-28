import java.util.List;

public class Worker {
    private final String inputImagePath = "DataSets/train-images.idx3-ubyte";
    private final String inputLabelPath = "DataSets/train-labels.idx1-ubyte";
    private NeuralNetwork neuralNetwork;
    private List<int[]> inputImageDataSet;
    private List<Integer> inputLabelDataSet;

    public Worker() {
        inputImageDataSet = IdxReader.readInputImageDataSet(inputImagePath);
        inputLabelDataSet = IdxReader.readInputLabelDataSet(inputLabelPath);
        neuralNetwork = new NeuralNetwork(784, 10);
        neuralNetwork.tutorial(inputImageDataSet, inputLabelDataSet);
    }
}

