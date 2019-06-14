package com.RNFetchBlob.p049b;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.RNFetchBlob.C0877h;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: PathResolver */
/* renamed from: com.RNFetchBlob.b.a */
public class C0861a {
    /* renamed from: a */
    public static String m3063a(Context context, Uri uri) {
        Uri uri2 = null;
        if ((VERSION.SDK_INT >= 19 ? 1 : null) == null || !DocumentsContract.isDocumentUri(context, uri)) {
            if (UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                if (C0861a.m3068d(uri)) {
                    return uri.getLastPathSegment();
                }
                return C0861a.m3064a(context, uri, null, null);
            } else if (UriUtil.LOCAL_FILE_SCHEME.equalsIgnoreCase(uri.getScheme()) != null) {
                return uri.getPath();
            }
        } else if (C0861a.m3065a(uri)) {
            context = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(context[0]) != null) {
                uri = new StringBuilder();
                uri.append(Environment.getExternalStorageDirectory());
                uri.append("/");
                uri.append(context[1]);
                return uri.toString();
            }
        } else if (C0861a.m3066b(uri)) {
            return C0861a.m3064a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (C0861a.m3067c(uri)) {
            Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
            if (MessengerShareContentUtility.MEDIA_IMAGE.equals(obj)) {
                uri2 = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(obj)) {
                uri2 = Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(obj)) {
                uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return C0861a.m3064a(context, uri2, "_id=?", new String[]{uri[1]});
        } else if (!UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    uri = C0861a.m3062a(context.getContentResolver(), uri);
                    if (uri != null) {
                        File file = new File(context.getCacheDir(), uri);
                        context = new FileOutputStream(file);
                        uri = new byte[1024];
                        while (openInputStream.read(uri) > 0) {
                            context.write(uri);
                        }
                        context.close();
                        openInputStream.close();
                        return file.getAbsolutePath();
                    }
                }
            } catch (Context context2) {
                C0877h.m3120b(context2.toString());
                return null;
            }
        } else if (C0861a.m3068d(uri)) {
            return uri.getLastPathSegment();
        } else {
            return C0861a.m3064a(context2, uri, null, null);
        }
        return null;
    }

    /* renamed from: a */
    private static String m3062a(ContentResolver contentResolver, Uri uri) {
        contentResolver = contentResolver.query(uri, null, null, null, null);
        contentResolver.moveToFirst();
        uri = contentResolver.getColumnIndex("_display_name");
        if (uri < null) {
            return null;
        }
        uri = contentResolver.getString(uri);
        contentResolver.close();
        return uri;
    }

    /* renamed from: a */
    public static String m3064a(Context context, Uri uri, String str, String[] strArr) {
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
                } catch (Exception e) {
                    uri = e;
                    try {
                        uri.printStackTrace();
                        if (context != null) {
                            context.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        uri = th;
                        if (context != null) {
                            context.close();
                        }
                        throw uri;
                    }
                }
            }
            uri = null;
            if (context != null) {
                context.close();
            }
            return uri;
        } catch (Exception e2) {
            uri = e2;
            context = null;
            uri.printStackTrace();
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
    public static boolean m3065a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* renamed from: b */
    public static boolean m3066b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static boolean m3067c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* renamed from: d */
    public static boolean m3068d(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
