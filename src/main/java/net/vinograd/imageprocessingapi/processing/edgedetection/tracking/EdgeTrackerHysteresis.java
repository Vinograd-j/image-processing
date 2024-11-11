package net.vinograd.imageprocessingapi.processing.edgedetection.tracking;


import net.vinograd.imageprocessingapi.processing.image.Image;
import net.vinograd.imageprocessingapi.processing.image.PixelColor;

import java.awt.image.BufferedImage;

public class EdgeTrackerHysteresis implements EdgeTracker {

    private final Image image;
    private final int width;
    private final int height;

    private final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {0, -1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public EdgeTrackerHysteresis(Image image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    @Override
    public Image track() {
        BufferedImage resultImage = new BufferedImage(width, height, image.getType());

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = image.getRGB(x, y);

                if (color != PixelColor.fromGrayscale(255)) {
                    resultImage.setRGB(x, y, PixelColor.fromGrayscale(0));
                    continue;
                }

                resultImage.setRGB(x, y, PixelColor.fromGrayscale(255));

                for (int[] direction : directions) {
                    int dx = direction[0];
                    int dy = direction[1];
                    int offsetX = x;
                    int offsetY = y;

                    while (true) {
                        offsetX += dx;
                        offsetY += dy;

                        if (offsetX < 0 || offsetX >= width || offsetY < 0 || offsetY >= height) {
                            break;
                        }

                        int colorByDirection = image.getRGB(offsetX, offsetY);

                        if (colorByDirection == PixelColor.fromGrayscale(255) || colorByDirection == PixelColor.fromGrayscale(0)) {
                            break;
                        }

                        resultImage.setRGB(x, y, PixelColor.fromGrayscale(255));
                    }
                }
            }
        }

        return new Image(resultImage);
    }
}
