package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;

public class MediaUtils {
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");

    public static boolean isPhoto(String str) {
        return (str == null || str.startsWith("image/") == null) ? null : true;
    }

    public static boolean isVideo(String str) {
        return (str == null || str.startsWith("video/") == null) ? null : true;
    }

    public static boolean isThreeD(String str) {
        return (str == null || str.equals("model/gltf-binary") == null) ? null : true;
    }

    public static String extractMime(String str) {
        str = extractExtension(str);
        if (str == null) {
            return null;
        }
        str = str.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = (String) ADDITIONAL_ALLOWED_MIME_TYPES.get(str);
        }
        return mimeTypeFromExtension;
    }

    private static String extractExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            if (lastIndexOf != str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return null;
    }

    public static boolean isNonNativeSupportedMimeType(String str) {
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(str);
    }
}
