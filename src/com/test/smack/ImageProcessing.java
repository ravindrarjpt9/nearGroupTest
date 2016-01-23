package com.test.smack;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ImageProcessing {

	public static void main(String[] args) throws IOException {
		
		OutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/ravindrarjpt9/Desktop/hi.jpg"));
	  
		byte[] arr=  resize(new File("/Users/ravindrarjpt9/Desktop/ravindra.jpg"),"jpeg");
		out.write(arr);
		out.close();

	}
	public static byte[] resize(File icon,String formate) {
        try {
           BufferedImage originalImage = ImageIO.read(icon);

           originalImage= Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, 250, 300);
            //To save with original ratio uncomment next line and comment the above.
            //originalImage= Scalr.resize(originalImage, 153, 128);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, formate, baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (Exception e) {
            return null;
        }


    }
}
