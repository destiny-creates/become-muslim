package com.imagepicker.p252c;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.v4.content.FileProvider;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;

/* compiled from: RealPathUtil */
/* renamed from: com.imagepicker.c.d */
public class C5420d {
    /* renamed from: a */
    public static Uri m22999a(Context context, File file) {
        if (VERSION.SDK_INT < 21) {
            return Uri.fromFile(file);
        }
        StringBuilder stringBuilder = new StringBuilder(context.getApplicationContext().getPackageName());
        stringBuilder.append(".provider");
        try {
            return FileProvider.a(context, stringBuilder.toString(), file);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static String m23000a(Context context, Uri uri) {
        Uri uri2 = null;
        if ((VERSION.SDK_INT >= 19 ? 1 : null) == null || !DocumentsContract.isDocumentUri(context, uri)) {
            if (UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                if (C5420d.m23007d(uri)) {
                    return uri.getLastPathSegment();
                }
                if (C5420d.m23003b(context, uri)) {
                    return C5420d.m23005c(context, uri);
                }
                return C5420d.m23001a(context, uri, null, null);
            } else if (UriUtil.LOCAL_FILE_SCHEME.equalsIgnoreCase(uri.getScheme()) != null) {
                return uri.getPath();
            }
        } else if (C5420d.m23002a(uri)) {
            context = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(context[0]) != null) {
                uri = new StringBuilder();
                uri.append(Environment.getExternalStorageDirectory());
                uri.append("/");
                uri.append(context[1]);
                return uri.toString();
            }
        } else if (C5420d.m23004b(uri)) {
            return C5420d.m23001a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (C5420d.m23006c(uri)) {
            Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
            if (MessengerShareContentUtility.MEDIA_IMAGE.equals(obj)) {
                uri2 = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(obj)) {
                uri2 = Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(obj)) {
                uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return C5420d.m23001a(context, uri2, "_id=?", new String[]{uri[1]});
        }
        return null;
    }

    /* renamed from: a */
    public static String m23001a(Context context, Uri uri, String str, String[] strArr) {
        try {
            context = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (context != null) {
                try {
                    if (context.moveToFirst() != null) {
                        uri = context.getString(context.getColumnIndexOrThrow("_data"));
                        if (context != null) {
                            context.close();
                        }
                        return uri;
                    }
                } catch (Throwable th) {
                    uri = th;
                    if (context != null) {
                        context.close();
                    }
                    throw uri;
                }
            }
            if (context != null) {
                context.close();
            }
            return null;
        } catch (Throwable th2) {
            uri = th2;
            context = null;
            if (context != null) {
                context.close();
            }
            throw uri;
        }
    }

    /* renamed from: a */
    public static boolean m23002a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* renamed from: b */
    public static boolean m23004b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static boolean m23006c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* renamed from: d */
    public static boolean m23007d(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* renamed from: b */
    public static boolean m23003b(Context context, Uri uri) {
        StringBuilder stringBuilder = new StringBuilder(context.getPackageName());
        stringBuilder.append(".provider");
        return stringBuilder.toString().equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static String m23005c(Context context, Uri uri) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), uri.getLastPathSegment());
        return file.exists() != null ? file.toString() : null;
    }
}
