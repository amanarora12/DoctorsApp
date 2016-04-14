package com.aman.appointments.utils;

/**
 * Created by aman on 14/4/16.
 */

import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;

import android.support.annotation.IntRange;

/**
 * Utility methods for working with colors.
 */
public class ColorUtils {

    private ColorUtils() { }

    /**
     * Set the alpha component of {@code color} to be {@code alpha}.
     */
    public static @CheckResult @ColorInt int modifyAlpha(@ColorInt int color,
                                                         @IntRange(from = 0, to = 255) int alpha) {
        return (color & 0x00ffffff) | (alpha << 24);
    }


}
