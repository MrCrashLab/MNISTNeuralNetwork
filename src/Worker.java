import java.util.ArrayList;
import java.util.List;

public class Worker {
    private final String inputTutorialImagePath = "TutorialDataSet/train-images.idx3-ubyte";
    private final String inputTutorialLabelPath = "TutorialDataSet/train-labels.idx1-ubyte";
    private final String inputTestImagePath = "TestDataSet/t10k-images.idx3-ubyte";
    private final String inputTestLabelPath = "TestDataSet/t10k-labels.idx1-ubyte";
    private final NeuralNetwork neuralNetwork;
    private List<double[]> inputImageDataSet;
    private List<double[]> inputDoubleLabelDataSet = new ArrayList<>();
    private List<Integer> inputLabelDataSet;

    public Worker() {
        readAndConverting(inputTutorialImagePath,inputTutorialLabelPath);
        convertLabelToArray(inputLabelDataSet);
        neuralNetwork = new NeuralNetwork(0.0000001, 784, 10);
        neuralNetwork.gradientDescentTutorial(inputImageDataSet, inputDoubleLabelDataSet);
    }

    private void readAndConverting(String inputImagePath, String inputLabelPath) {
        inputImageDataSet = IdxReader.readInputImageDataSet(inputImagePath);
        inputLabelDataSet = IdxReader.readInputLabelDataSet(inputLabelPath);
    }

    private void convertLabelToArray(List<Integer> labels){
        for (int num : labels) {
            double[] tmp = new double[10];
            for (int i = 0; i < tmp.length; i++) {
                if (i == num) tmp[i] = 1;
                else tmp[i] = 0;
            }
            inputDoubleLabelDataSet.add(tmp);
        }
    }

    public void work(){
        int label = -1;
        readAndConverting(inputTestImagePath, inputTestLabelPath);
        for(int i = 0;i<inputImageDataSet.size();i++){
            label = neuralNetwork.test(inputImageDataSet.get(i));
            System.out.println(label == inputLabelDataSet.get(i));
        }
    }
}

