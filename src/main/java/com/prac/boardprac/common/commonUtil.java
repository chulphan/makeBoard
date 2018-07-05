package com.prac.boardprac.common;

import java.io.UnsupportedEncodingException;

public class commonUtil {
	
	public static String getShortString(String str, Integer len) {
		try {
			if(str.getBytes("UTF-8").length > len) {
				str = strCut(str, len) + "...";
			}
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	public static String strCut(String szText, int nlength) {
		String rval = szText;
		int oooF = 0;
		int oooL = 0;
		int rrrF = 0;
		int rrrL = 0;
		int nlengthPrev = 0;
		
		try {
			byte[] bytes = rval.getBytes("UTF-8");
			
			int jcount = 0;
			if(nlengthPrev > 0) {
				while(jcount < bytes.length) {
					if ((bytes[jcount] & 0x80) != 0) {
						oooF += 2;
						rrrF += 3;
						
						if(oooF + 2 > nlengthPrev) {
							break;
						}
						
						jcount += 3;
					} else {
						if (oooF + 1 > nlengthPrev) {
							break;
						}
						++oooF;
						++rrrF;
						++jcount;
					}
				}
			}
			
			jcount = rrrF;
			
			while(jcount < bytes.length) {
				if((bytes[jcount] & 0x80) != 0) {
					if (oooL + 2 > nlength) {
						break;
					}
					
					oooL += 2;
					rrrL += 3;
					jcount += 3;
				} else {
					if(oooL + 1 > nlength) {
						break;
					}
					++oooL;
					++rrrL;
					++jcount;
				}
			}
			
			rval = new String(bytes, rrrF, rrrL, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rval;
	}
}
