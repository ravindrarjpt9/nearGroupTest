package com.test.smack;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;



public class Resizer {

    public static void main(String[] args) throws IOException {
        processPicture("/Users/ravindrarjpt9/Pictures/Single Photo/IMG_1272.jpg", new File("/Users/ravindrarjpt9/Pictures/Single Photo/output.jpg"), 300,200);
    }

      // load image from filename
    	static boolean processPicture(String source,File dest, int width, int height) throws IOException {
    		  BufferedImage sourceImage = ImageIO.read(new FileInputStream(source));
    		  double ratio = (double) sourceImage.getWidth()/sourceImage.getHeight();
    		  if (width < 1) {
    		    width = (int) (height * ratio + 0.4);
    		  } else if (height < 1) {
    		    height = (int) (width /ratio + 0.4);
    		  }

    		  Image scaled = sourceImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
    		  BufferedImage bufferedScaled = new BufferedImage(scaled.getWidth(null), scaled.getHeight(null), BufferedImage.TYPE_INT_RGB);
    		  Graphics2D g2d = bufferedScaled.createGraphics();
    		  g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    		  g2d.drawImage(scaled, 0, 0, width, height, null);
    		  dest.createNewFile();
    		  writeJpeg(bufferedScaled, dest.getCanonicalPath(), 1.0f);
    		  return true;
    		}

    	private static void writeJpeg(BufferedImage image, String destFile, float quality)
    		      throws IOException {
    		  ImageWriter writer = null;
    		  FileImageOutputStream output = null;
    		  try {
    		    writer = ImageIO.getImageWritersByFormatName("jpeg").next();
    		    ImageWriteParam param = writer.getDefaultWriteParam();
    		    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    		    param.setCompressionQuality(quality);
    		    output = new FileImageOutputStream(new File(destFile));
    		    writer.setOutput(output);
    		    IIOImage iioImage = new IIOImage(image, null, null);
    		    writer.write(null, iioImage, param);
    		  } catch (IOException ex) {
    		    throw ex;
    		  } finally {
    		    if (writer != null) {
    		      writer.dispose();
    		    }
    		    if (output != null) {
    		      output.close();
    		    }
    		  }
    	}
}
