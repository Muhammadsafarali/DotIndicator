package com.dublick.dotindicator;

import android.content.Context;

/**
 * Created by 3dium on 14.08.2017.
 */

public class Locale {
    private static Locale instance;
    private static DescriptionModel[] array;

    public static Locale getInstance(Context context) {
        if (instance == null) {
            synchronized (Locale.class) {
                if (instance == null) {
                    instance = new Locale(context);
                }
            }
        }
        return instance;
    }

    Locale(Context context) {
        array = new DescriptionModel[3];

        array[0] = new DescriptionModel(R.drawable.kubic, context.getString(R.string.demo_page1_title), context.getString(R.string.demo_page1_body));
        array[1] = new DescriptionModel(R.drawable.kubic_color, context.getString(R.string.demo_page2_title), context.getString(R.string.demo_page2_body));
        array[2] = new DescriptionModel(R.drawable.printer_clean_transparent, context.getString(R.string.demo_page3_title), context.getString(R.string.demo_page3_body));
    }

    public DescriptionModel[] getDemoPageLocale() {
        return array;
    }
}
