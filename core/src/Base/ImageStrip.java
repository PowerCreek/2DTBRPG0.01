package Base;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageStrip {

	public BufferedImage getImage(String imagefile){
		
		BufferedImage image = null;
		
		try{
			image = ImageIO.read(new File("res/content/"+imagefile));
		//	System.out.println("Retrieved Image: "+imagefile);
			return image;
		}catch(Exception e){
			
		}
		if(image == null){
		System.out.println("load failed");
		}
		return image;
		
	}
	
}
