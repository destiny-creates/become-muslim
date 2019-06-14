package com.facebook.drawee.backends.pipeline.info;

import com.facebook.GraphResponse;

public class ImagePerfUtils {
    public static String toString(int i) {
        switch (i) {
            case 0:
                return "requested";
            case 1:
                return "origin_available";
            case 2:
                return "intermediate_available";
            case 3:
                return GraphResponse.SUCCESS_KEY;
            case 4:
                return "canceled";
            case 5:
                return "error";
            default:
                return "unknown";
        }
    }

    private ImagePerfUtils() {
    }
}
