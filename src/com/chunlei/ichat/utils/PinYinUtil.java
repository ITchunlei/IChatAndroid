package com.chunlei.ichat.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinYinUtil {
	public static char getPinYinHeadChar(String str) {
        String convert = "";
        char word = str.charAt(0);
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
        if (pinyinArray != null) {
            convert += pinyinArray[0].charAt(0);
        } else {
            convert += word;
        }
        return convert.charAt(0);
    }
}
