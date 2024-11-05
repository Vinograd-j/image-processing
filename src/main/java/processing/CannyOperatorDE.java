package processing;

import net.vinograd.imageprocessingapi.processing.edgedetection.CannyOperator;
import net.vinograd.imageprocessingapi.processing.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CannyOperatorDE {

    private static final String pathToImage = "examples/Canny.png";
    private static final String pathToSave = "examples/CannyConverted.png";

    public static void main(String[] args) throws IOException {
        Image image = new CannyOperator().detectEdges(new Image(ImageIO.read(new File(pathToImage))));

        File file = new File(pathToSave);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(image.getBytes("png"));

        fileOutputStream.close();

    }

}
