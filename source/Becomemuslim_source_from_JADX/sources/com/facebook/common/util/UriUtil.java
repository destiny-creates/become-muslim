package com.facebook.common.util;

import android.content.ContentResolver;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.net.URL;

public class UriUtil {
    public static final String DATA_SCHEME = "data";
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    public static final String LOCAL_ASSET_SCHEME = "asset";
    private static final Uri LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
    public static final String LOCAL_CONTENT_SCHEME = "content";
    public static final String LOCAL_FILE_SCHEME = "file";
    public static final String LOCAL_RESOURCE_SCHEME = "res";
    public static final String QUALIFIED_RESOURCE_SCHEME = "android.resource";

    public static URL uriToUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (Uri uri2) {
            throw new RuntimeException(uri2);
        }
    }

    public static boolean isNetworkUri(Uri uri) {
        uri = getSchemeOrNull(uri);
        if (!HTTPS_SCHEME.equals(uri)) {
            if (HTTP_SCHEME.equals(uri) == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean isLocalFileUri(Uri uri) {
        return LOCAL_FILE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContentUri(Uri uri) {
        return LOCAL_CONTENT_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContactUri(Uri uri) {
        return (isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && uri.getPath().startsWith(LOCAL_CONTACT_IMAGE_URI.getPath()) == null) ? true : null;
    }

    public static boolean isLocalCameraUri(Uri uri) {
        uri = uri.toString();
        if (!uri.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            if (uri.startsWith(Media.INTERNAL_CONTENT_URI.toString()) == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean isLocalAssetUri(Uri uri) {
        return LOCAL_ASSET_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalResourceUri(Uri uri) {
        return LOCAL_RESOURCE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isQualifiedResourceUri(Uri uri) {
        return QUALIFIED_RESOURCE_SCHEME.equals(getSchemeOrNull(uri));
    }

    public static boolean isDataUri(Uri uri) {
        return "data".equals(getSchemeOrNull(uri));
    }

    public static String getSchemeOrNull(Uri uri) {
        return uri == null ? null : uri.getScheme();
    }

    public static Uri parseUriOrNull(String str) {
        return str != null ? Uri.parse(str) : null;
    }

    public static String getRealPathFromUri(ContentResolver contentResolver, Uri uri) {
        String str = null;
        if (isLocalContentUri(uri)) {
            try {
                contentResolver = contentResolver.query(uri, null, null, null, null);
                if (contentResolver != null) {
                    try {
                        if (contentResolver.moveToFirst() != null) {
                            uri = contentResolver.getColumnIndex("_data");
                            if (uri != -1) {
                                str = contentResolver.getString(uri);
                            }
                        }
                    } catch (Throwable th) {
                        uri = th;
                        if (contentResolver != null) {
                            contentResolver.close();
                        }
                        throw uri;
                    }
                }
                if (contentResolver == null) {
                    return str;
                }
                contentResolver.close();
                return str;
            } catch (Throwable th2) {
                uri = th2;
                contentResolver = null;
                if (contentResolver != null) {
                    contentResolver.close();
                }
                throw uri;
            }
        } else if (isLocalFileUri(uri) != null) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static Uri getUriForFile(File file) {
        return Uri.fromFile(file);
    }

    public static Uri getUriForResourceId(int i) {
        return new Builder().scheme(LOCAL_RESOURCE_SCHEME).path(String.valueOf(i)).build();
    }

    public static Uri getUriForQualifiedResource(String str, int i) {
        return new Builder().scheme(QUALIFIED_RESOURCE_SCHEME).authority(str).path(String.valueOf(i)).build();
    }
}
