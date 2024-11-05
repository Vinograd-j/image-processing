package processing;

import net.vinograd.imageprocessingapi.processing.filter.point.MonochromeGrayConverter;
import net.vinograd.imageprocessingapi.processing.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Monochrome {

    private static final String pathToImage = "examples/Monochrome.jpg";
    private static final String pathToSave = "examples/MonochromeConverted.jpg";

    public static void main(String[] args) throws IOException {
        Image convert = new MonochromeGrayConverter(new Image(ImageIO.read(new File(pathToImage)))).convert();

        File file = new File(pathToSave);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(convert.getBytes("png"));

        fileOutputStream.close();
    }
}
