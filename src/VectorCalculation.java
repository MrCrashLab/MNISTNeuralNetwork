public class VectorCalculation {
    public static double vectorMul(double[] vec1, double[] vec2){
        double output = 0;
        if(vec1.length!= vec2.length) return 0;
        for(int i = 0;i < vec1.length;i++) {
            output += (vec1[i] * vec2[i]);
        }
        return output;
    }

    public static double[][] vectorVectorMul(double[] vec1, double[] vec2){
        double[][] output = new double[vec1.length][vec2.length];
        for(int i = 0;i<vec1.length;i++)
            for(int j = 0;j<vec2.length;j++)
                output[i][j] = vec1[i]*vec2[j];
        return output;
    }

    public static double[] vectorMatrixMul(double[] vector, double[][]matrix){
        double[] output = new double[matrix.length];
        for(int i = 0; i<matrix.length;i++)
            output[i] = vectorMul(vector, matrix[i]);
        return output;
    }
}
