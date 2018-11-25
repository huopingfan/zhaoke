package com.fh.util;

import java.util.Random;

public class Random2 {

	public static final String SEEDS = "23456789ABCDEFGHJKMNPQRSTUVWXYZ";//去除0 1 I L等易混淆的字母数字
    public static final int NORMAL_SIZE = 4;
    private static Random random = new Random();

    public static String getVerificationCode(){
        return getVerificationCode(NORMAL_SIZE);
    }

    public static String getVerificationCode(int verificationSize){
        return getVerificationCode(verificationSize, SEEDS);
    }

    public static String getVerificationCode(int verificationSize,String seeds){
        seeds = seedsIsNullOrEmpty(seeds);
        int maxIndex = seeds.length();
        StringBuffer verificationCode = new StringBuffer(verificationSize);
        for(int i=0;i<verificationSize;i++){
            int randomIndex = random.nextInt(maxIndex);
            char seed = seeds.charAt(randomIndex);
            verificationCode.append(seed);
        }
        return verificationCode.toString();
    }

    public static String seedsIsNullOrEmpty(String seeds){
        if (seeds == null || "".equals(seeds)) {
            seeds = SEEDS;
        }
        return seeds;
    }
}
