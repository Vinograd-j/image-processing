package processing;

import net.vinograd.imageprocessingapi.processing.filter.matrix.Emboss;
import net.vinograd.imageprocessingapi.processing.filter.point.MonochromeGrayConverter;
import net.vinograd.imageprocessingapi.processing.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EmbossVertical {

    private static final String pathToImage = "examples/EmbossVertical.png";
    private static final String pathToSave = "examples/EmbossVerticalConverted.png";

    public static void main(String[] args) throws IOException {
        Image monochrome = new MonochromeGrayConverter(new Image(ImageIO.read(new File(pathToImage)))).convert();
        Image convert = new Emboss(monochrome, Emboss.Type.VERTICAL).convert();

        File file = new File(pathToSave);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(convert.getBytes("png"));

        fileOutputStream.close();

    }

}
