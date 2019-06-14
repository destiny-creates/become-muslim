package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.C3211a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C04221();
    /* renamed from: a */
    static final C3211a<String, Integer> f1095a = new C3211a();
    /* renamed from: c */
    private static final String[] f1096c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    /* renamed from: d */
    private static final String[] f1097d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    /* renamed from: e */
    private static final String[] f1098e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    /* renamed from: b */
    final Bundle f1099b;
    /* renamed from: f */
    private Object f1100f;

    /* renamed from: android.support.v4.media.MediaMetadataCompat$1 */
    static class C04221 implements Creator<MediaMetadataCompat> {
        C04221() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1245a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1246a(i);
        }

        /* renamed from: a */
        public MediaMetadataCompat m1245a(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: a */
        public MediaMetadataCompat[] m1246a(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    static {
        f1095a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f1095a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f1095a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f1095a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f1095a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f1095a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f1095a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f1095a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f1095a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f1095a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f1095a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f1095a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f1095a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f1095a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f1095a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f1095a.put("android.media.metadata.ART", Integer.valueOf(2));
        f1095a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f1095a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f1095a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f1095a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f1095a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f1095a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f1095a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f1095a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f1095a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f1095a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f1095a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f1095a.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        f1095a.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        f1095a.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        f1095a.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f1099b = parcel.readBundle();
        this.f1099b.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1099b);
    }

    /* renamed from: a */
    public static MediaMetadataCompat m1247a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        C0426c.m1268a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.f1100f = obj;
        return mediaMetadataCompat;
    }
}
