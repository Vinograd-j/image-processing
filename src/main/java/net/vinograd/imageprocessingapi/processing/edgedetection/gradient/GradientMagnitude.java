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

    public Image apply(){
        return image.mapToNew((x, y) -> {
            Color bounded = new Color(Math.max(0, Math.min(gradientCalculator.calculateIntensity(x, y), 255)));
            return new PixelColor(bounded.getRed(), bounded.getGreen(), bounded.getBlue());
        });
    }

}
