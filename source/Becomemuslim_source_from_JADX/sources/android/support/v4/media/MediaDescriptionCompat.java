package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.C0425a.C0424a;
import android.support.v4.media.C3204b.C3203a;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C04201();
    /* renamed from: a */
    private final String f1086a;
    /* renamed from: b */
    private final CharSequence f1087b;
    /* renamed from: c */
    private final CharSequence f1088c;
    /* renamed from: d */
    private final CharSequence f1089d;
    /* renamed from: e */
    private final Bitmap f1090e;
    /* renamed from: f */
    private final Uri f1091f;
    /* renamed from: g */
    private final Bundle f1092g;
    /* renamed from: h */
    private final Uri f1093h;
    /* renamed from: i */
    private Object f1094i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$1 */
    static class C04201 implements Creator<MediaDescriptionCompat> {
        C04201() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1232a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1233a(i);
        }

        /* renamed from: a */
        public MediaDescriptionCompat m1232a(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m1243a(C0425a.m1259a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] m1233a(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    public static final class C0421a {
        /* renamed from: a */
        private String f1078a;
        /* renamed from: b */
        private CharSequence f1079b;
        /* renamed from: c */
        private CharSequence f1080c;
        /* renamed from: d */
        private CharSequence f1081d;
        /* renamed from: e */
        private Bitmap f1082e;
        /* renamed from: f */
        private Uri f1083f;
        /* renamed from: g */
        private Bundle f1084g;
        /* renamed from: h */
        private Uri f1085h;

        /* renamed from: a */
        public C0421a m1238a(String str) {
            this.f1078a = str;
            return this;
        }

        /* renamed from: a */
        public C0421a m1237a(CharSequence charSequence) {
            this.f1079b = charSequence;
            return this;
        }

        /* renamed from: b */
        public C0421a m1241b(CharSequence charSequence) {
            this.f1080c = charSequence;
            return this;
        }

        /* renamed from: c */
        public C0421a m1242c(CharSequence charSequence) {
            this.f1081d = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0421a m1234a(Bitmap bitmap) {
            this.f1082e = bitmap;
            return this;
        }

        /* renamed from: a */
        public C0421a m1235a(Uri uri) {
            this.f1083f = uri;
            return this;
        }

        /* renamed from: a */
        public C0421a m1236a(Bundle bundle) {
            this.f1084g = bundle;
            return this;
        }

        /* renamed from: b */
        public C0421a m1240b(Uri uri) {
            this.f1085h = uri;
            return this;
        }

        /* renamed from: a */
        public MediaDescriptionCompat m1239a() {
            return new MediaDescriptionCompat(this.f1078a, this.f1079b, this.f1080c, this.f1081d, this.f1082e, this.f1083f, this.f1084g, this.f1085h);
        }
    }

    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f1086a = str;
        this.f1087b = charSequence;
        this.f1088c = charSequence2;
        this.f1089d = charSequence3;
        this.f1090e = bitmap;
        this.f1091f = uri;
        this.f1092g = bundle;
        this.f1093h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f1086a = parcel.readString();
        this.f1087b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1088c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1089d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1090e = (Bitmap) parcel.readParcelable(null);
        this.f1091f = (Uri) parcel.readParcelable(null);
        this.f1092g = parcel.readBundle();
        this.f1093h = (Uri) parcel.readParcelable(null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f1086a);
            TextUtils.writeToParcel(this.f1087b, parcel, i);
            TextUtils.writeToParcel(this.f1088c, parcel, i);
            TextUtils.writeToParcel(this.f1089d, parcel, i);
            parcel.writeParcelable(this.f1090e, i);
            parcel.writeParcelable(this.f1091f, i);
            parcel.writeBundle(this.f1092g);
            parcel.writeParcelable(this.f1093h, i);
            return;
        }
        C0425a.m1261a(m1244a(), parcel, i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1087b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f1088c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f1089d);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public Object m1244a() {
        if (this.f1094i == null) {
            if (VERSION.SDK_INT >= 21) {
                Object a = C0424a.m1250a();
                C0424a.m1256a(a, this.f1086a);
                C0424a.m1255a(a, this.f1087b);
                C0424a.m1257b(a, this.f1088c);
                C0424a.m1258c(a, this.f1089d);
                C0424a.m1252a(a, this.f1090e);
                C0424a.m1253a(a, this.f1091f);
                Bundle bundle = this.f1092g;
                if (VERSION.SDK_INT < 23 && this.f1093h != null) {
                    if (bundle == null) {
                        bundle = new Bundle();
                        bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                    }
                    bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f1093h);
                }
                C0424a.m1254a(a, bundle);
                if (VERSION.SDK_INT >= 23) {
                    C3203a.m9683b(a, this.f1093h);
                }
                this.f1094i = C0424a.m1251a(a);
                return this.f1094i;
            }
        }
        return this.f1094i;
    }

    /* renamed from: a */
    public static MediaDescriptionCompat m1243a(Object obj) {
        Bundle bundle = null;
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        MediaDescriptionCompat a;
        C0421a c0421a = new C0421a();
        c0421a.m1238a(C0425a.m1260a(obj));
        c0421a.m1237a(C0425a.m1262b(obj));
        c0421a.m1241b(C0425a.m1263c(obj));
        c0421a.m1242c(C0425a.m1264d(obj));
        c0421a.m1234a(C0425a.m1265e(obj));
        c0421a.m1235a(C0425a.m1266f(obj));
        Bundle g = C0425a.m1267g(obj);
        if (g == null) {
            uri = null;
        } else {
            uri = (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                c0421a.m1236a(bundle);
                if (uri != null) {
                    c0421a.m1240b(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c0421a.m1240b(C3204b.m9684h(obj));
                }
                a = c0421a.m1239a();
                a.f1094i = obj;
                return a;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        c0421a.m1236a(bundle);
        if (uri != null) {
            c0421a.m1240b(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c0421a.m1240b(C3204b.m9684h(obj));
        }
        a = c0421a.m1239a();
        a.f1094i = obj;
        return a;
    }
}
