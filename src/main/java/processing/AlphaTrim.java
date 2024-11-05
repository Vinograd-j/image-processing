package processing;

import net.vinograd.imageprocessingapi.processing.filter.noisesuppression.AlphaTrimFilter;
import net.vinograd.imageprocessingapi.processing.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AlphaTrim {

    private static final String pathToImage = "examples/AlphaTrim.jpg";
    private static final String pathToSave = "examples/AlphaTrimConverted.jpg";

    public static void main(String[] args) throws IOException {

        Image convert = new AlphaTrimFilter(new Image(ImageIO.read(new File(pathToImage))), 5, 5, 25).convert();
        File file = new File(pathToSave);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(convert.getBytes("png"));

        fileOutputStream.close();

    }

}
