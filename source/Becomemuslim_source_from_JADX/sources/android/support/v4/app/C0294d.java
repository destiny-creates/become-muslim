package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C3176c.C0292a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
/* renamed from: android.support.v4.app.d */
final class C0294d implements Parcelable {
    public static final Creator<C0294d> CREATOR = new C02931();
    /* renamed from: a */
    final int[] f783a;
    /* renamed from: b */
    final int f784b;
    /* renamed from: c */
    final int f785c;
    /* renamed from: d */
    final String f786d;
    /* renamed from: e */
    final int f787e;
    /* renamed from: f */
    final int f788f;
    /* renamed from: g */
    final CharSequence f789g;
    /* renamed from: h */
    final int f790h;
    /* renamed from: i */
    final CharSequence f791i;
    /* renamed from: j */
    final ArrayList<String> f792j;
    /* renamed from: k */
    final ArrayList<String> f793k;
    /* renamed from: l */
    final boolean f794l;

    /* compiled from: BackStackRecord */
    /* renamed from: android.support.v4.app.d$1 */
    static class C02931 implements Creator<C0294d> {
        C02931() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m866a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m867a(i);
        }

        /* renamed from: a */
        public C0294d m866a(Parcel parcel) {
            return new C0294d(parcel);
        }

        /* renamed from: a */
        public C0294d[] m867a(int i) {
            return new C0294d[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C0294d(C3176c c3176c) {
        int size = c3176c.f8150b.size();
        this.f783a = new int[(size * 6)];
        if (c3176c.f8157i) {
            int i = 0;
            int i2 = 0;
            while (i < size) {
                C0292a c0292a = (C0292a) c3176c.f8150b.get(i);
                int i3 = i2 + 1;
                this.f783a[i2] = c0292a.f777a;
                int i4 = i3 + 1;
                this.f783a[i3] = c0292a.f778b != null ? c0292a.f778b.mIndex : -1;
                i3 = i4 + 1;
                this.f783a[i4] = c0292a.f779c;
                i4 = i3 + 1;
                this.f783a[i3] = c0292a.f780d;
                i3 = i4 + 1;
                this.f783a[i4] = c0292a.f781e;
                i4 = i3 + 1;
                this.f783a[i3] = c0292a.f782f;
                i++;
                i2 = i4;
            }
            this.f784b = c3176c.f8155g;
            this.f785c = c3176c.f8156h;
            this.f786d = c3176c.f8159k;
            this.f787e = c3176c.f8161m;
            this.f788f = c3176c.f8162n;
            this.f789g = c3176c.f8163o;
            this.f790h = c3176c.f8164p;
            this.f791i = c3176c.f8165q;
            this.f792j = c3176c.f8166r;
            this.f793k = c3176c.f8167s;
            this.f794l = c3176c.f8168t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0294d(Parcel parcel) {
        this.f783a = parcel.createIntArray();
        this.f784b = parcel.readInt();
        this.f785c = parcel.readInt();
        this.f786d = parcel.readString();
        this.f787e = parcel.readInt();
        this.f788f = parcel.readInt();
        this.f789g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f790h = parcel.readInt();
        this.f791i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f792j = parcel.createStringArrayList();
        this.f793k = parcel.createStringArrayList();
        this.f794l = parcel.readInt() != null ? true : null;
    }

    /* renamed from: a */
    public C3176c m868a(C3184o c3184o) {
        C3176c c3176c = new C3176c(c3184o);
        int i = 0;
        int i2 = 0;
        while (i < this.f783a.length) {
            C0292a c0292a = new C0292a();
            int i3 = i + 1;
            c0292a.f777a = this.f783a[i];
            if (C3184o.f8191a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Instantiate ");
                stringBuilder.append(c3176c);
                stringBuilder.append(" op #");
                stringBuilder.append(i2);
                stringBuilder.append(" base fragment #");
                stringBuilder.append(this.f783a[i3]);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            int i4 = i3 + 1;
            i = this.f783a[i3];
            if (i >= 0) {
                c0292a.f778b = (C3178i) c3184o.f8203f.get(i);
            } else {
                c0292a.f778b = null;
            }
            i3 = i4 + 1;
            c0292a.f779c = this.f783a[i4];
            i4 = i3 + 1;
            c0292a.f780d = this.f783a[i3];
            i3 = i4 + 1;
            c0292a.f781e = this.f783a[i4];
            i4 = i3 + 1;
            c0292a.f782f = this.f783a[i3];
            c3176c.f8151c = c0292a.f779c;
            c3176c.f8152d = c0292a.f780d;
            c3176c.f8153e = c0292a.f781e;
            c3176c.f8154f = c0292a.f782f;
            c3176c.m9460a(c0292a);
            i2++;
            i = i4;
        }
        c3176c.f8155g = this.f784b;
        c3176c.f8156h = this.f785c;
        c3176c.f8159k = this.f786d;
        c3176c.f8161m = this.f787e;
        c3176c.f8157i = true;
        c3176c.f8162n = this.f788f;
        c3176c.f8163o = this.f789g;
        c3176c.f8164p = this.f790h;
        c3176c.f8165q = this.f791i;
        c3176c.f8166r = this.f792j;
        c3176c.f8167s = this.f793k;
        c3176c.f8168t = this.f794l;
        c3176c.m9459a(1);
        return c3176c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f783a);
        parcel.writeInt(this.f784b);
        parcel.writeInt(this.f785c);
        parcel.writeString(this.f786d);
        parcel.writeInt(this.f787e);
        parcel.writeInt(this.f788f);
        TextUtils.writeToParcel(this.f789g, parcel, 0);
        parcel.writeInt(this.f790h);
        TextUtils.writeToParcel(this.f791i, parcel, 0);
        parcel.writeStringList(this.f792j);
        parcel.writeStringList(this.f793k);
        parcel.writeInt(this.f794l);
    }
}
