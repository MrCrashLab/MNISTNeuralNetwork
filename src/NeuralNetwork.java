import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    int[] dot;
    ArrayList<double[][]> weights;

    public NeuralNetwork(int ... dot) {
        this.dot = dot;
        weights = new ArrayList<>();
        // TODO create multiThreads
        createRandomWeights();
    }

    public void tutorial(List<int[]> inputImageDataSet,List<Integer> inputLabelDataSet){

    }


    private void createRandomWeights(){
        for(int i = 0;i<dot.length-1;i++)
            weights.add(new double[dot[i]][dot[i+1]]);

        for (double[][] tmp: weights)
            for(int i = 0;i<tmp.length;i++)
                for (int j = 0; j < tmp[i].length; j++)
                    tmp[i][j] = Math.random();
    }
}
