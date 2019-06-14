package android.support.v4.p030f;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p030f.C0389c.C3197a;

/* compiled from: ResultReceiver */
/* renamed from: android.support.v4.f.g */
public class C0396g implements Parcelable {
    public static final Creator<C0396g> CREATOR = new C03941();
    /* renamed from: a */
    final boolean f1018a = false;
    /* renamed from: b */
    final Handler f1019b = null;
    /* renamed from: c */
    C0389c f1020c;

    /* compiled from: ResultReceiver */
    /* renamed from: android.support.v4.f.g$1 */
    static class C03941 implements Creator<C0396g> {
        C03941() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1173a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1174a(i);
        }

        /* renamed from: a */
        public C0396g m1173a(Parcel parcel) {
            return new C0396g(parcel);
        }

        /* renamed from: a */
        public C0396g[] m1174a(int i) {
            return new C0396g[i];
        }
    }

    /* compiled from: ResultReceiver */
    /* renamed from: android.support.v4.f.g$b */
    class C0395b implements Runnable {
        /* renamed from: a */
        final int f1015a;
        /* renamed from: b */
        final Bundle f1016b;
        /* renamed from: c */
        final /* synthetic */ C0396g f1017c;

        C0395b(C0396g c0396g, int i, Bundle bundle) {
            this.f1017c = c0396g;
            this.f1015a = i;
            this.f1016b = bundle;
        }

        public void run() {
            this.f1017c.mo230a(this.f1015a, this.f1016b);
        }
    }

    /* compiled from: ResultReceiver */
    /* renamed from: android.support.v4.f.g$a */
    class C4459a extends C3197a {
        /* renamed from: a */
        final /* synthetic */ C0396g f11910a;

        C4459a(C0396g c0396g) {
            this.f11910a = c0396g;
        }

        /* renamed from: a */
        public void mo226a(int i, Bundle bundle) {
            if (this.f11910a.f1019b != null) {
                this.f11910a.f1019b.post(new C0395b(this.f11910a, i, bundle));
            } else {
                this.f11910a.mo230a(i, bundle);
            }
        }
    }

    /* renamed from: a */
    protected void mo230a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f1020c == 0) {
                this.f1020c = new C4459a(this);
            }
            parcel.writeStrongBinder(this.f1020c.asBinder());
        }
    }

    C0396g(Parcel parcel) {
        this.f1020c = C3197a.m9670a(parcel.readStrongBinder());
    }
}
