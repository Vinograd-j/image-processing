package net.vinograd.imageprocessingapi.processing.edgedetection.gradient;

import net.vinograd.imageprocessingapi.processing.image.Image;
import net.vinograd.imageprocessingapi.processing.image.PixelColor;

import java.awt.*;
import java.util.function.BiFunction;

public class GradientMagnitude {

    private final Image image;
    private final GradientCalculator gradientCalculator;

    public GradientMagnitude(Image image, GradientCalculator gradientCalculator) {
        this.image = image;
        this.gradientCalculator = gradientCalculator;
    }

    public Image apply() {
        return image.mapToNew((x, y) -> {
            int gx = gradientCalculator.gradientX(x, y);
            int gy = gradientCalculator.gradientY(x, y);
            int magnitude = (int) Math.sqrt(gx * gx + gy * gy);

            int boundedValue = Math.max(0, Math.min(magnitude, 255));
            return new PixelColor(boundedValue, boundedValue, boundedValue);
        });
    }


}
