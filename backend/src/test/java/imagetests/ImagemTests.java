package imagetests;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class ImagemTests {

    @Test
    public void deveCarregarImagenEmJPEG() throws IOException {


        InputStream jpgIS = Thread.currentThread().getContextClassLoader().getResourceAsStream("jacu.jpg");
        BufferedImage jpgData = ImageIO.read(jpgIS);

        assertNotNull(jpgData);
    }

    @Test
    public void deveCarregarImagenEmPNG() throws IOException {


        InputStream pngIS = Thread.currentThread().getContextClassLoader().getResourceAsStream("jacu.png");
        BufferedImage pngData = ImageIO.read(pngIS);

        assertNotNull(pngData);
    }
}
