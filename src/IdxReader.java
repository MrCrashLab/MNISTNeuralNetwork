import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IdxReader {
    public static List<int[]> readInputImageDataSet(String inputImagePath) {
        try (FileInputStream inImage = new FileInputStream(inputImagePath)) {
            int magicNumberImages = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfImages = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfRows = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfColumns = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfPixels = numberOfRows * numberOfColumns;
            int[] imgPixels = new int[numberOfPixels];
            List<int[]> inputData = new ArrayList<>();

            for (int i = 0; i < numberOfImages; i++) {
                if (i % 100 == 0) {
                    System.out.println("Number of images extracted: " + i);
                }
                for (int p = 0; p < numberOfPixels; p++) {
                    int gray = 255 - inImage.read();
                    imgPixels[p] = 0xFF000000 | (gray << 16) | (gray << 8) | gray;
                }
                inputData.add(imgPixels);
            }
            return inputData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> readInputLabelDataSet(String inputLabelPath) {
        try (FileInputStream inLabel = new FileInputStream(inputLabelPath)) {
            int magicNumberLabels = (inLabel.read() << 24) | (inLabel.read() << 16) | (inLabel.read() << 8) | (inLabel.read());
            int numberOfLabels = (inLabel.read() << 24) | (inLabel.read() << 16) | (inLabel.read() << 8) | (inLabel.read());
            List<Integer> inputData = new ArrayList<>();
            int label = inLabel.read();
            while (label != -1) {
                inputData.add(label);
                label = inLabel.read();
            }
            return inputData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
