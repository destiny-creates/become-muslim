package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.C0445e.C0444a;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C04341();
    /* renamed from: a */
    final int f1133a;
    /* renamed from: b */
    final long f1134b;
    /* renamed from: c */
    final long f1135c;
    /* renamed from: d */
    final float f1136d;
    /* renamed from: e */
    final long f1137e;
    /* renamed from: f */
    final int f1138f;
    /* renamed from: g */
    final CharSequence f1139g;
    /* renamed from: h */
    final long f1140h;
    /* renamed from: i */
    List<CustomAction> f1141i;
    /* renamed from: j */
    final long f1142j;
    /* renamed from: k */
    final Bundle f1143k;
    /* renamed from: l */
    private Object f1144l;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$1 */
    static class C04341 implements Creator<PlaybackStateCompat> {
        C04341() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1295a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1296a(i);
        }

        /* renamed from: a */
        public PlaybackStateCompat m1295a(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] m1296a(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C04351();
        /* renamed from: a */
        private final String f1128a;
        /* renamed from: b */
        private final CharSequence f1129b;
        /* renamed from: c */
        private final int f1130c;
        /* renamed from: d */
        private final Bundle f1131d;
        /* renamed from: e */
        private Object f1132e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1 */
        static class C04351 implements Creator<CustomAction> {
            C04351() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1297a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1298a(i);
            }

            /* renamed from: a */
            public CustomAction m1297a(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] m1298a(int i) {
                return new CustomAction[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f1128a = str;
            this.f1129b = charSequence;
            this.f1130c = i;
            this.f1131d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f1128a = parcel.readString();
            this.f1129b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1130c = parcel.readInt();
            this.f1131d = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1128a);
            TextUtils.writeToParcel(this.f1129b, parcel, i);
            parcel.writeInt(this.f1130c);
            parcel.writeBundle(this.f1131d);
        }

        /* renamed from: a */
        public static CustomAction m1299a(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    CustomAction customAction = new CustomAction(C0444a.m1377a(obj), C0444a.m1378b(obj), C0444a.m1379c(obj), C0444a.m1380d(obj));
                    customAction.f1132e = obj;
                    return customAction;
                }
            }
            return null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Action:mName='");
            stringBuilder.append(this.f1129b);
            stringBuilder.append(", mIcon=");
            stringBuilder.append(this.f1130c);
            stringBuilder.append(", mExtras=");
            stringBuilder.append(this.f1131d);
            return stringBuilder.toString();
        }
    }

    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f1133a = i;
        this.f1134b = j;
        this.f1135c = j2;
        this.f1136d = f;
        this.f1137e = j3;
        this.f1138f = i2;
        this.f1139g = charSequence;
        this.f1140h = j4;
        this.f1141i = new ArrayList(list);
        this.f1142j = j5;
        this.f1143k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f1133a = parcel.readInt();
        this.f1134b = parcel.readLong();
        this.f1136d = parcel.readFloat();
        this.f1140h = parcel.readLong();
        this.f1135c = parcel.readLong();
        this.f1137e = parcel.readLong();
        this.f1139g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1141i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f1142j = parcel.readLong();
        this.f1143k = parcel.readBundle();
        this.f1138f = parcel.readInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        stringBuilder.append(this.f1133a);
        stringBuilder.append(", position=");
        stringBuilder.append(this.f1134b);
        stringBuilder.append(", buffered position=");
        stringBuilder.append(this.f1135c);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.f1136d);
        stringBuilder.append(", updated=");
        stringBuilder.append(this.f1140h);
        stringBuilder.append(", actions=");
        stringBuilder.append(this.f1137e);
        stringBuilder.append(", error code=");
        stringBuilder.append(this.f1138f);
        stringBuilder.append(", error message=");
        stringBuilder.append(this.f1139g);
        stringBuilder.append(", custom actions=");
        stringBuilder.append(this.f1141i);
        stringBuilder.append(", active item id=");
        stringBuilder.append(this.f1142j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1133a);
        parcel.writeLong(this.f1134b);
        parcel.writeFloat(this.f1136d);
        parcel.writeLong(this.f1140h);
        parcel.writeLong(this.f1135c);
        parcel.writeLong(this.f1137e);
        TextUtils.writeToParcel(this.f1139g, parcel, i);
        parcel.writeTypedList(this.f1141i);
        parcel.writeLong(this.f1142j);
        parcel.writeBundle(this.f1143k);
        parcel.writeInt(this.f1138f);
    }

    /* renamed from: a */
    public static PlaybackStateCompat m1300a(Object obj) {
        Object obj2 = obj;
        PlaybackStateCompat playbackStateCompat = null;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List list;
        List<Object> h = C0445e.m1388h(obj);
        if (h != null) {
            List arrayList = new ArrayList(h.size());
            for (Object a : h) {
                arrayList.add(CustomAction.m1299a(a));
            }
            list = arrayList;
        } else {
            list = null;
        }
        if (VERSION.SDK_INT >= 22) {
            playbackStateCompat = C0446f.m1390a(obj);
        }
        PlaybackStateCompat playbackStateCompat2 = new PlaybackStateCompat(C0445e.m1381a(obj), C0445e.m1382b(obj), C0445e.m1383c(obj), C0445e.m1384d(obj), C0445e.m1385e(obj), 0, C0445e.m1386f(obj), C0445e.m1387g(obj), list, C0445e.m1389i(obj), playbackStateCompat);
        playbackStateCompat2.f1144l = obj2;
        return playbackStateCompat2;
    }
}
