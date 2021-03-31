package com.rebuild.project.controller.onlineCampus;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

public class Mp4Thumbnail {
	 private static final String IMAGE_PNG_FORMAT = "png";
	 
	 /**
	  * 
	  * 
	  * @param source mp4 file.
	  * @param thumbnail
	  * @return
	  * @throws IOException
	  * @throws JCodecException
	  */
	 public static byte[] getThumbnail(File source) throws IOException, JCodecException {
	 
	  int frameNumber = 0;
	  ByteArrayOutputStream thumbnail = new ByteArrayOutputStream();
	  Picture picture = FrameGrab.getFrameFromFile(source, frameNumber);
	 
	  BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
	  ImageIO.write(bufferedImage, IMAGE_PNG_FORMAT, thumbnail);

	  return thumbnail.toByteArray(); 
	 }
}
