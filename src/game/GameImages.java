package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// This class is used to get different images for the game
public class GameImages {
    final static String _base = "../pics/";
    
    public static BufferedImage GetImage(String imageName) {
        try {
            return 
                ImageIO.read(
                    GameImages.class.getResourceAsStream(
                        _base + imageName)
                    );
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public static BufferedImage GetSaab95Image() {
        return GetImage("Saab95.jpg");
    }

    public static BufferedImage GetVolvo240Image() {
        return GetImage("Volvo240.jpg");
    }

    public static BufferedImage GetScaniaImage() {
        return GetImage("Scania.jpg");
    }
}
