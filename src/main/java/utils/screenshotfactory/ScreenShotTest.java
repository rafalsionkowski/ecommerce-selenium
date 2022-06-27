package utils.screenshotfactory;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import ru.yandex.qatools.ashot.AShot;
import tests.BaseTest;


public class ScreenShotTest extends BasePage {


    //Current Directory
    private String currentDir = System.getProperty("user.dir");

    //GetScreenShot Method Directory and Image File
    private File getSreenShotMethodImageFile = new File (currentDir +
            "\\screenShotTests\\amazonscreenshot.png");

    //Element Screenshot Directory and Image File
    private File webElementImageFile = new File(currentDir +
            "\\screenShotTests\\logo.png" );

    //Entirepage ScreenShot Directory and Image File
    private File entirePageImageFile = new File(currentDir +
            "\\screenShotTests\\entirepage.png" );

    public ScreenShotTest(WebDriver driver) {
        super(driver);
    }

    public void screenshotEntirePageAshot() throws IOException {
        //Take Screenshot of entire page by AShot
        Screenshot entirePageScreenShot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(this.driver);
        ImageIO.write(entirePageScreenShot.getImage(),"PNG", entirePageImageFile);
    }


}
