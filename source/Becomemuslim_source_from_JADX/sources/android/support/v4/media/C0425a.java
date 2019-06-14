package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* compiled from: MediaDescriptionCompatApi21 */
/* renamed from: android.support.v4.media.a */
class C0425a {

    /* compiled from: MediaDescriptionCompatApi21 */
    /* renamed from: android.support.v4.media.a$a */
    static class C0424a {
        /* renamed from: a */
        public static Object m1250a() {
            return new Builder();
        }

        /* renamed from: a */
        public static void m1256a(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        /* renamed from: a */
        public static void m1255a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        /* renamed from: b */
        public static void m1257b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        /* renamed from: c */
        public static void m1258c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }

        /* renamed from: a */
        public static void m1252a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        /* renamed from: a */
        public static void m1253a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        /* renamed from: a */
        public static void m1254a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        /* renamed from: a */
        public static Object m1251a(Object obj) {
            return ((Builder) obj).build();
        }
    }

    /* renamed from: a */
    public static String m1260a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    /* renamed from: b */
    public static CharSequence m1262b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    /* renamed from: c */
    public static CharSequence m1263c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    /* renamed from: d */
    public static CharSequence m1264d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    /* renamed from: e */
    public static Bitmap m1265e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    /* renamed from: f */
    public static Uri m1266f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    /* renamed from: g */
    public static Bundle m1267g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    /* renamed from: a */
    public static void m1261a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    /* renamed from: a */
    public static Object m1259a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
