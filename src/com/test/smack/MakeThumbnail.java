package com.test.smack;

import net.coobird.thumbnailator.*;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class MakeThumbnail {

	public static void main(String[] args) throws Exception

	{
		 String outputImagePath1 = "/Users/ravindrarjpt9/Pictures/Single Photo/w12.jpg";
		BufferedImage originalImage = ImageIO.read(new File("/Users/ravindrarjpt9/Pictures/Single Photo/ww.jpg"));

		BufferedImage thumbnail = Thumbnails.of(originalImage)
		        .size(originalImage.getWidth(), originalImage.getHeight())
		        .asBufferedImage();
		String formatName = outputImagePath1.substring(outputImagePath1
                .lastIndexOf(".") + 1);
 
		ImageIO.write(thumbnail, formatName, new File(outputImagePath1));
	}
}
