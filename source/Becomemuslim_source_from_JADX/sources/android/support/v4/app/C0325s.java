package android.support.v4.app;

import android.arch.lifecycle.C0088p;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* compiled from: FragmentState */
/* renamed from: android.support.v4.app.s */
final class C0325s implements Parcelable {
    public static final Creator<C0325s> CREATOR = new C03241();
    /* renamed from: a */
    final String f853a;
    /* renamed from: b */
    final int f854b;
    /* renamed from: c */
    final boolean f855c;
    /* renamed from: d */
    final int f856d;
    /* renamed from: e */
    final int f857e;
    /* renamed from: f */
    final String f858f;
    /* renamed from: g */
    final boolean f859g;
    /* renamed from: h */
    final boolean f860h;
    /* renamed from: i */
    final Bundle f861i;
    /* renamed from: j */
    final boolean f862j;
    /* renamed from: k */
    Bundle f863k;
    /* renamed from: l */
    C3178i f864l;

    /* compiled from: FragmentState */
    /* renamed from: android.support.v4.app.s$1 */
    static class C03241 implements Creator<C0325s> {
        C03241() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m951a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m952a(i);
        }

        /* renamed from: a */
        public C0325s m951a(Parcel parcel) {
            return new C0325s(parcel);
        }

        /* renamed from: a */
        public C0325s[] m952a(int i) {
            return new C0325s[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    C0325s(C3178i c3178i) {
        this.f853a = c3178i.getClass().getName();
        this.f854b = c3178i.mIndex;
        this.f855c = c3178i.mFromLayout;
        this.f856d = c3178i.mFragmentId;
        this.f857e = c3178i.mContainerId;
        this.f858f = c3178i.mTag;
        this.f859g = c3178i.mRetainInstance;
        this.f860h = c3178i.mDetached;
        this.f861i = c3178i.mArguments;
        this.f862j = c3178i.mHidden;
    }

    C0325s(Parcel parcel) {
        this.f853a = parcel.readString();
        this.f854b = parcel.readInt();
        boolean z = false;
        this.f855c = parcel.readInt() != 0;
        this.f856d = parcel.readInt();
        this.f857e = parcel.readInt();
        this.f858f = parcel.readString();
        this.f859g = parcel.readInt() != 0;
        this.f860h = parcel.readInt() != 0;
        this.f861i = parcel.readBundle();
        if (parcel.readInt() != 0) {
            z = true;
        }
        this.f862j = z;
        this.f863k = parcel.readBundle();
    }

    /* renamed from: a */
    public C3178i m953a(C3179m c3179m, C0305k c0305k, C3178i c3178i, C0321p c0321p, C0088p c0088p) {
        if (this.f864l == null) {
            Context i = c3179m.m9498i();
            if (this.f861i != null) {
                this.f861i.setClassLoader(i.getClassLoader());
            }
            if (c0305k != null) {
                this.f864l = c0305k.mo194a(i, this.f853a, this.f861i);
            } else {
                this.f864l = C3178i.instantiate(i, this.f853a, this.f861i);
            }
            if (this.f863k != null) {
                this.f863k.setClassLoader(i.getClassLoader());
                this.f864l.mSavedFragmentState = this.f863k;
            }
            this.f864l.setIndex(this.f854b, c3178i);
            this.f864l.mFromLayout = this.f855c;
            this.f864l.mRestored = true;
            this.f864l.mFragmentId = this.f856d;
            this.f864l.mContainerId = this.f857e;
            this.f864l.mTag = this.f858f;
            this.f864l.mRetainInstance = this.f859g;
            this.f864l.mDetached = this.f860h;
            this.f864l.mHidden = this.f862j;
            this.f864l.mFragmentManager = c3179m.f8174d;
            if (C3184o.f8191a != null) {
                c0305k = new StringBuilder();
                c0305k.append("Instantiated fragment ");
                c0305k.append(this.f864l);
                Log.v("FragmentManager", c0305k.toString());
            }
        }
        this.f864l.mChildNonConfig = c0321p;
        this.f864l.mViewModelStore = c0088p;
        return this.f864l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f853a);
        parcel.writeInt(this.f854b);
        parcel.writeInt(this.f855c);
        parcel.writeInt(this.f856d);
        parcel.writeInt(this.f857e);
        parcel.writeString(this.f858f);
        parcel.writeInt(this.f859g);
        parcel.writeInt(this.f860h);
        parcel.writeBundle(this.f861i);
        parcel.writeInt(this.f862j);
        parcel.writeBundle(this.f863k);
    }
}
