package processing;

import net.vinograd.imageprocessingapi.processing.edgedetection.gradient.GradientCalculator;
import net.vinograd.imageprocessingapi.processing.edgedetection.gradient.GradientMagnitude;
import net.vinograd.imageprocessingapi.processing.edgedetection.gradient.SobelGradientCalculator;
import net.vinograd.imageprocessingapi.processing.filter.point.MonochromeGrayConverter;
import net.vinograd.imageprocessingapi.processing.filter.point.NegativeFilter;
import net.vinograd.imageprocessingapi.processing.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SobelOperator {

    private static final String pathToImage = "examples/Sobel.png";
    private static final String pathToSave = "examples/SobelConverted.jpg";

    public static void main(String[] args) throws IOException {
        Image image = new Image(ImageIO.read(new File(pathToImage)));

        Image converted;
        converted = new MonochromeGrayConverter(image).convert();
        GradientCalculator gradientCalculator = new SobelGradientCalculator(converted);
        converted = new GradientMagnitude(converted, gradientCalculator).apply();

        File file = new File(pathToSave);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(converted.getBytes("png"));

        fileOutputStream.close();

    }


}
