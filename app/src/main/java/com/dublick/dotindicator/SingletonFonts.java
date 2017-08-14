package com.dublick.dotindicator;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by 3dium on 14.08.2017.
 */

public class SingletonFonts {

    private static volatile SingletonFonts instance;

    private static Typeface font1;
    private static Typeface font2;
    private static Typeface font3;

    private SingletonFonts() {}

    public static SingletonFonts getInstance(Context context) {
        SingletonFonts localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonFonts.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonFonts();
                }
            }
            setFont1(Typeface.createFromAsset(context.getAssets(), "fonts/VarelaRound-Regular.otf"));
//            setFont2(Typeface.createFromAsset(context.getAssets(), "DroidSerif-Bold.ttf"));
//            setFont3(Typeface.createFromAsset(context.getAssets(), "DroidSerif-Italic.ttf"));
        }
        return localInstance;
    }

    public Typeface getFont1() {
        return font1;
    }

    public Typeface getFont2() {
        return font2;
    }

    public Typeface getFont3() {
        return font3;
    }

    public static void setFont1(Typeface font1) {
        SingletonFonts.font1 = font1;
    }

    public static void setFont2(Typeface font2) {
        SingletonFonts.font2 = font2;
    }

    public static void setFont3(Typeface font3) {
        SingletonFonts.font3 = font3;
    }

}
