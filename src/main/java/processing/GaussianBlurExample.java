package processing;

import net.vinograd.imageprocessingapi.processing.filter.matrix.GaussianBlur;
import net.vinograd.imageprocessingapi.processing.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GaussianBlurExample {

    private static final String pathToImage = "examples/GaussianBlur.jpg";
    private static final String pathToSave = "examples/GaussianBlurConverted.jpg";

    public static void main(String[] args) throws IOException {
        Image convert = new GaussianBlur(new Image(ImageIO.read(new File(pathToImage))), 3, 7).convert();

        File file = new File(pathToSave);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(convert.getBytes("jpg"));

        fileOutputStream.close();

    }

}
