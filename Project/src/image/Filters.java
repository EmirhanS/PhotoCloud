package image;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Filters {

	public static BufferedImage blurFilter(BufferedImage bufferImage, int kernel) {
		ImageMatrix image = new ImageMatrix(bufferImage);
		ImageMatrix writer = new ImageMatrix(bufferImage.getWidth(), bufferImage.getHeight());

		for (int i = kernel; i < image.getWidth() - kernel; i++) {
			for (int j = kernel; j < image.getHeight() - kernel; j++) {
				try {
					int red = 0;
					int green = 0;
					int blue = 0;

					for (int i2 = i - kernel; i2 < i + kernel + 1; i2++) {
						for (int j2 = j - kernel; j2 < j + kernel + 1; j2++) {
							red += image.getRed(i2, j2);
							green += image.getGreen(i2, j2);
							blue += image.getBlue(i2, j2);
						}
					}
					red /= ((2 * kernel) + 1) * ((2 * kernel) + 1);
					green /= ((2 * kernel) + 1) * ((2 * kernel) + 1);
					blue /= ((2 * kernel) + 1) * ((2 * kernel) + 1);
					writer.setRGB(i, j, ImageMatrix.convertRGB(red, green, blue));
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		}

		BufferedImage output = writer.getBufferedImage();
		return output;
	}

	public static BufferedImage sharpenFilter(BufferedImage bufferImage, int kernel) {
		ImageMatrix image = new ImageMatrix(bufferImage);
		ImageMatrix write = new ImageMatrix(bufferImage.getWidth(), bufferImage.getHeight());

		for (int i = kernel; i < image.getWidth() - kernel; i++) {
			for (int j = kernel; j < image.getHeight() - kernel; j++) {
				try {
					int red = 0;
					int green = 0;
					int blue = 0;

					for (int i2 = i - kernel; i2 < i + kernel + 1; i2++) {
						for (int j2 = j - kernel; j2 < j + kernel + 1; j2++) {
							red += image.getRed(i2, j2);
							green += image.getGreen(i2, j2);
							blue += image.getBlue(i2, j2);
						}
					}
					red /= ((2 * kernel) + 1) * ((2 * kernel) + 1);
					green /= ((2 * kernel) + 1) * ((2 * kernel) + 1);
					blue /= ((2 * kernel) + 1) * ((2 * kernel) + 1);
					write.setRGB(i, j,
							ImageMatrix.convertRGB(isBetween0and255(Math.abs(2 * image.getRed(i, j) - red)),
									isBetween0and255(Math.abs(2 * image.getGreen(i, j) - green)),
									isBetween0and255(Math.abs(2 * image.getBlue(i, j) - blue))));
				} catch (IndexOutOfBoundsException e) {
					write.setRGB(i, j, image.getRGB(i, j));
				}
			}
		}

		BufferedImage output = write.getBufferedImage();
		return output;
	}

	public static BufferedImage grayscaleFilter(BufferedImage bufferImage, double change) {
		ImageMatrix image = new ImageMatrix(bufferImage);
		ImageMatrix write = new ImageMatrix(bufferImage.getWidth(), bufferImage.getHeight());

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				double average = (image.getRed(i, j) + image.getGreen(i, j) + image.getBlue(i, j)) / 3;
				write.setRGB(i, j, ImageMatrix.convertRGB((int) Math.floor(average * change),
						(int) Math.floor(average * change), (int) Math.floor(average * change)));
			}
		}

		BufferedImage output = write.getBufferedImage();
		return output;
	}

	public static BufferedImage edgeDetectionFilter(BufferedImage bufferImage, int kernel) {
		ImageMatrix image = new ImageMatrix(bufferImage);
		ImageMatrix write = new ImageMatrix(image.getWidth(), image.getHeight());

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				try {
					int red = 0;
					int green = 0;
					int blue = 0;

					for (int i2 = i - kernel; i2 < i + kernel + 1; i2++) {
						red -= image.getRed(i2, j);
						green -= image.getGreen(i2, j);
						blue -= image.getBlue(i2, j);
					}

					for (int j2 = j - kernel; j2 < j + kernel + 1; j2++) {
						red -= image.getRed(i, j2);
						green -= image.getGreen(i, j2);
						blue -= image.getBlue(i, j2);
					}

					red = red + (4 * kernel + 2) * image.getRed(i, j);
					green = green + (4 * kernel + 2) * image.getGreen(i, j);
					blue = blue + (4 * kernel + 2) * image.getBlue(i, j);
					write.setRGB(i, j, ImageMatrix.convertRGB(isBetween0and255(red), isBetween0and255(green),
							isBetween0and255(blue)));
				} catch (IndexOutOfBoundsException e) {
					write.setRGB(i, j, image.getRGB(i, j));
				}
			}
		}

		BufferedImage output = write.getBufferedImage();
		return output;
	}

	public static BufferedImage brightnessFilter(BufferedImage bufferImage, int chg) {
		ImageMatrix image = new ImageMatrix(bufferImage);
		ImageMatrix write = new ImageMatrix(bufferImage.getWidth(), bufferImage.getHeight());

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				write.setRGB(i, j,
						ImageMatrix.convertRGB(isBetween0and255(image.getRed(i, j) + chg),
								isBetween0and255(image.getGreen(i, j) + chg),
								isBetween0and255(image.getBlue(i, j) + chg)));
			}
		}

		BufferedImage output = write.getBufferedImage();
		return output;
	}

	public static BufferedImage contrastFilter(BufferedImage bufferImage, double chg) {
		int width = bufferImage.getWidth();
		int height = bufferImage.getHeight();

		BufferedImage filteredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Apply contrast filter to each pixel
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color originalColor = new Color(bufferImage.getRGB(x, y));
				int red = originalColor.getRed();
				int green = originalColor.getGreen();
				int blue = originalColor.getBlue();

				// Apply contrast change
				red = applyContrast(red, chg);
				green = applyContrast(green, chg);
				blue = applyContrast(blue, chg);

				// Create new color with adjusted contrast
				Color newColor = new Color(red, green, blue);
				filteredImage.setRGB(x, y, newColor.getRGB());
			}
		}

		return filteredImage;
	}

	private static int applyContrast(int value, double chg) {
		// Apply contrast formula
		double newValue = value / 255.0;
		newValue -= 0.5;
		newValue *= chg;
		newValue += 0.5;
		newValue *= 255;

		// Ensure the value is within valid range
		newValue = Math.max(0, Math.min(255, newValue));

		return (int) newValue;
	}
	
	public static int isBetween0and255(int number) {
		if (number >= 255) {
			return 255;
		} else if (number <= 0) {
			return 0;
		} else {
			return number;

		}
	}
}
