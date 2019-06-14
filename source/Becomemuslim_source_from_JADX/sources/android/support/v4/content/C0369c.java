package android.support.v4.content;

import android.content.Context;
import android.support.v4.util.C0450d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader */
/* renamed from: android.support.v4.content.c */
public class C0369c<D> {
    /* renamed from: f */
    int f965f;
    /* renamed from: g */
    C0368b<D> f966g;
    /* renamed from: h */
    C0367a<D> f967h;
    /* renamed from: i */
    Context f968i;
    /* renamed from: j */
    boolean f969j = false;
    /* renamed from: k */
    boolean f970k = false;
    /* renamed from: l */
    boolean f971l = true;
    /* renamed from: m */
    boolean f972m = false;
    /* renamed from: n */
    boolean f973n = false;

    /* compiled from: Loader */
    /* renamed from: android.support.v4.content.c$a */
    public interface C0367a<D> {
        /* renamed from: a */
        void m1114a(C0369c<D> c0369c);
    }

    /* compiled from: Loader */
    /* renamed from: android.support.v4.content.c$b */
    public interface C0368b<D> {
        /* renamed from: a */
        void mo2657a(C0369c<D> c0369c, D d);
    }

    /* renamed from: a */
    protected void mo223a() {
    }

    /* renamed from: b */
    protected boolean mo225b() {
        return false;
    }

    /* renamed from: j */
    protected void mo3269j() {
    }

    /* renamed from: n */
    protected void m1130n() {
    }

    /* renamed from: p */
    protected void m1132p() {
    }

    /* renamed from: r */
    protected void m1134r() {
    }

    public C0369c(Context context) {
        this.f968i = context.getApplicationContext();
    }

    /* renamed from: b */
    public void m1120b(D d) {
        if (this.f966g != null) {
            this.f966g.mo2657a(this, d);
        }
    }

    /* renamed from: g */
    public void m1123g() {
        if (this.f967h != null) {
            this.f967h.m1114a(this);
        }
    }

    /* renamed from: a */
    public void m1117a(int i, C0368b<D> c0368b) {
        if (this.f966g == null) {
            this.f966g = c0368b;
            this.f965f = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    /* renamed from: a */
    public void m1118a(C0368b<D> c0368b) {
        if (this.f966g == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f966g == c0368b) {
            this.f966g = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    /* renamed from: h */
    public boolean m1124h() {
        return this.f970k;
    }

    /* renamed from: i */
    public final void m1125i() {
        this.f969j = true;
        this.f971l = false;
        this.f970k = false;
        mo3269j();
    }

    /* renamed from: k */
    public boolean m1127k() {
        return mo225b();
    }

    /* renamed from: l */
    public void m1128l() {
        mo223a();
    }

    /* renamed from: m */
    public void m1129m() {
        this.f969j = false;
        m1130n();
    }

    /* renamed from: o */
    public void m1131o() {
        this.f970k = true;
        m1132p();
    }

    /* renamed from: q */
    public void m1133q() {
        m1134r();
        this.f971l = true;
        this.f969j = false;
        this.f970k = false;
        this.f972m = false;
        this.f973n = false;
    }

    /* renamed from: s */
    public void m1135s() {
        this.f973n = false;
    }

    /* renamed from: t */
    public void m1136t() {
        if (this.f973n) {
            m1137u();
        }
    }

    /* renamed from: u */
    public void m1137u() {
        if (this.f969j) {
            m1128l();
        } else {
            this.f972m = true;
        }
    }

    /* renamed from: c */
    public String m1122c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0450d.m1408a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0450d.m1408a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f965f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo224a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f965f);
        printWriter.print(" mListener=");
        printWriter.println(this.f966g);
        if (!(this.f969j == null && this.f972m == null && this.f973n == null)) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f969j);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f972m);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f973n);
        }
        if (this.f970k != null || this.f971l != null) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f970k);
            printWriter.print(" mReset=");
            printWriter.println(this.f971l);
        }
    }
}
