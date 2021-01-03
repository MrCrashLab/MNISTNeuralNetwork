public class VectorCalculation {
    public static double vectorMul(double[] vec1, double[] vec2){
        double output = 0;
        if(vec1.length!= vec2.length) return 0;
        for(int i = 0;i < vec1.length;i++)
            output += (vec1[i]*vec2[i]);
        return output;
    }

    public static double[] vectorMatrixMul(double[] vector, double[][]matrix){
        double[] output = new double[matrix.length];
        for(int i = 0; i<matrix.length;i++){
            output[i] = vectorMul(vector, matrix[i]);
        }
        return output;
    }
}
