package com.rebuild.project.controller.onlineCampus;

import java.io.IOException;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

/*
	1. https://ffmpeg.zeranoe.com/builds/에서 다운로드 한다.
	다운받은 zip파일을 C드라이브에 압축 해제한다.
	
	2. 환경 변수 설정을 한다.
 	   C:\ffmpeg-20191109-0f89a22-win64-static\bin 이다.

*/

public class Videoffmpeg {
	
	//private static final String FFPROBE_PATH = "C:/ffmpeg-20200721-b5f1e05-win64-static/bin/ffprobe.exe";
	private static final String FFPROBE_PATH = "/var/packages/ffmpeg/target/bin/ffprobe";
	
	public static int media_player_time(String mediaPath) {
		//System.out.println("@@ media_player_time start @@");
		int returnData = 0;

		try {
			FFprobe ffprobe = new FFprobe(FFPROBE_PATH); // window에 설치된  ffprobe.exe 경로
			FFmpegProbeResult probeResult = ffprobe.probe(mediaPath); // 동영상 경로
			FFmpegFormat format = probeResult.getFormat();
			double second = format.duration; // 초단위

			returnData = (int) Math.floor(second);
			//System.out.println("second==" + second);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//System.out.println("@@ media_player_time end @@");
		}

		return returnData;
	}
	
	

}
