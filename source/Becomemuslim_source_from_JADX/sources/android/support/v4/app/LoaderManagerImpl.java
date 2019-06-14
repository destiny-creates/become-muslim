package android.support.v4.app;

import android.arch.lifecycle.C0076e;
import android.arch.lifecycle.C0081k;
import android.arch.lifecycle.C0085n;
import android.arch.lifecycle.C0087o;
import android.arch.lifecycle.C0087o.C0086a;
import android.arch.lifecycle.C0088p;
import android.arch.lifecycle.C3109j;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.C0344z.C0343a;
import android.support.v4.content.C0369c;
import android.support.v4.content.C0369c.C0368b;
import android.support.v4.util.C0450d;
import android.support.v4.util.C0464m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends C0344z {
    /* renamed from: a */
    static boolean f8121a = false;
    /* renamed from: b */
    private final C0076e f8122b;
    /* renamed from: c */
    private final LoaderViewModel f8123c;
    /* renamed from: d */
    private boolean f8124d;

    static class LoaderViewModel extends C0085n {
        /* renamed from: a */
        private static final C0086a f8116a = new C31651();
        /* renamed from: b */
        private C0464m<C4455a> f8117b = new C0464m();

        /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderViewModel$1 */
        static class C31651 implements C0086a {
            C31651() {
            }

            /* renamed from: a */
            public <T extends C0085n> T mo172a(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        LoaderViewModel() {
        }

        /* renamed from: a */
        static LoaderViewModel m9409a(C0088p c0088p) {
            return (LoaderViewModel) new C0087o(c0088p, f8116a).m202a(LoaderViewModel.class);
        }

        /* renamed from: a */
        void m9412a(int i, C4455a c4455a) {
            this.f8117b.m1471b(i, c4455a);
        }

        /* renamed from: a */
        <D> C4455a<D> m9410a(int i) {
            return (C4455a) this.f8117b.m1467a(i);
        }

        /* renamed from: b */
        void m9414b() {
            int b = this.f8117b.m1469b();
            for (int i = 0; i < b; i++) {
                ((C4455a) this.f8117b.m1476e(i)).m14884g();
            }
        }

        /* renamed from: a */
        protected void mo173a() {
            super.mo173a();
            int b = this.f8117b.m1469b();
            for (int i = 0; i < b; i++) {
                ((C4455a) this.f8117b.m1476e(i)).m14876a(true);
            }
            this.f8117b.m1472c();
        }

        /* renamed from: a */
        public void m9413a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f8117b.m1469b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("    ");
                String stringBuilder2 = stringBuilder.toString();
                for (int i = 0; i < this.f8117b.m1469b(); i++) {
                    C4455a c4455a = (C4455a) this.f8117b.m1476e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f8117b.m1475d(i));
                    printWriter.print(": ");
                    printWriter.println(c4455a.toString());
                    c4455a.m14879a(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.LoaderManagerImpl$b */
    static class C3166b<D> implements C0081k<D> {
        /* renamed from: a */
        private final C0369c<D> f8118a;
        /* renamed from: b */
        private final C0343a<D> f8119b;
        /* renamed from: c */
        private boolean f8120c = false;

        C3166b(C0369c<D> c0369c, C0343a<D> c0343a) {
            this.f8118a = c0369c;
            this.f8119b = c0343a;
        }

        /* renamed from: a */
        public void mo174a(D d) {
            if (LoaderManagerImpl.f8121a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  onLoadFinished in ");
                stringBuilder.append(this.f8118a);
                stringBuilder.append(": ");
                stringBuilder.append(this.f8118a.m1122c(d));
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.f8119b.mo2363a(this.f8118a, (Object) d);
            this.f8120c = true;
        }

        /* renamed from: a */
        boolean m9417a() {
            return this.f8120c;
        }

        /* renamed from: b */
        void m9418b() {
            if (this.f8120c) {
                if (LoaderManagerImpl.f8121a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Resetting: ");
                    stringBuilder.append(this.f8118a);
                    Log.v("LoaderManager", stringBuilder.toString());
                }
                this.f8119b.mo2362a(this.f8118a);
            }
        }

        public String toString() {
            return this.f8119b.toString();
        }

        /* renamed from: a */
        public void m9416a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f8120c);
        }
    }

    /* renamed from: android.support.v4.app.LoaderManagerImpl$a */
    public static class C4455a<D> extends C3109j<D> implements C0368b<D> {
        /* renamed from: a */
        private final int f11903a;
        /* renamed from: b */
        private final Bundle f11904b;
        /* renamed from: c */
        private final C0369c<D> f11905c;
        /* renamed from: d */
        private C0076e f11906d;
        /* renamed from: e */
        private C3166b<D> f11907e;
        /* renamed from: f */
        private C0369c<D> f11908f;

        C4455a(int i, Bundle bundle, C0369c<D> c0369c, C0369c<D> c0369c2) {
            this.f11903a = i;
            this.f11904b = bundle;
            this.f11905c = c0369c;
            this.f11908f = c0369c2;
            this.f11905c.m1117a(i, this);
        }

        /* renamed from: f */
        C0369c<D> m14883f() {
            return this.f11905c;
        }

        /* renamed from: b */
        protected void mo2658b() {
            if (LoaderManagerImpl.f8121a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Starting: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.f11905c.m1125i();
        }

        /* renamed from: c */
        protected void mo2659c() {
            if (LoaderManagerImpl.f8121a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Stopping: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.f11905c.m1129m();
        }

        /* renamed from: a */
        C0369c<D> m14875a(C0076e c0076e, C0343a<D> c0343a) {
            Object c3166b = new C3166b(this.f11905c, c0343a);
            m162a(c0076e, (C0081k) c3166b);
            if (this.f11907e != null) {
                mo2656a(this.f11907e);
            }
            this.f11906d = c0076e;
            this.f11907e = c3166b;
            return this.f11905c;
        }

        /* renamed from: g */
        void m14884g() {
            C0076e c0076e = this.f11906d;
            C0081k c0081k = this.f11907e;
            if (c0076e != null && c0081k != null) {
                super.mo2656a(c0081k);
                m162a(c0076e, c0081k);
            }
        }

        /* renamed from: a */
        public void mo2656a(C0081k<D> c0081k) {
            super.mo2656a((C0081k) c0081k);
            this.f11906d = null;
            this.f11907e = null;
        }

        /* renamed from: a */
        C0369c<D> m14876a(boolean z) {
            if (LoaderManagerImpl.f8121a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Destroying: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.f11905c.m1127k();
            this.f11905c.m1131o();
            C0081k c0081k = this.f11907e;
            if (c0081k != null) {
                mo2656a(c0081k);
                if (z) {
                    c0081k.m9418b();
                }
            }
            this.f11905c.m1118a(this);
            if ((c0081k == null || c0081k.m9417a()) && !z) {
                return this.f11905c;
            }
            this.f11905c.m1133q();
            return this.f11908f;
        }

        /* renamed from: a */
        public void mo2657a(C0369c<D> c0369c, D d) {
            if (LoaderManagerImpl.f8121a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onLoadComplete: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo26b(d);
                return;
            }
            if (LoaderManagerImpl.f8121a != null) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            mo25a(d);
        }

        /* renamed from: b */
        public void mo26b(D d) {
            super.mo26b(d);
            if (this.f11908f != null) {
                this.f11908f.m1133q();
                this.f11908f = null;
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f11903a);
            stringBuilder.append(" : ");
            C0450d.m1408a(this.f11905c, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public void m14879a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f11903a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f11904b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f11905c);
            C0369c c0369c = this.f11905c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            c0369c.mo224a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
            if (this.f11907e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f11907e);
                fileDescriptor = this.f11907e;
                strArr = new StringBuilder();
                strArr.append(str);
                strArr.append("  ");
                fileDescriptor.m9416a(strArr.toString(), printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m14883f().m1122c(m161a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(m168d());
        }
    }

    LoaderManagerImpl(C0076e c0076e, C0088p c0088p) {
        this.f8122b = c0076e;
        this.f8123c = LoaderViewModel.m9409a(c0088p);
    }

    /* renamed from: a */
    private <D> C0369c<D> m9419a(int i, Bundle bundle, C0343a<D> c0343a, C0369c<D> c0369c) {
        try {
            this.f8124d = true;
            C0369c a = c0343a.mo2361a(i, bundle);
            if (a.getClass().isMemberClass()) {
                if (!Modifier.isStatic(a.getClass().getModifiers())) {
                    bundle = new StringBuilder();
                    bundle.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                    bundle.append(a);
                    throw new IllegalArgumentException(bundle.toString());
                }
            }
            C4455a c4455a = new C4455a(i, bundle, a, c0369c);
            if (f8121a != null) {
                c0369c = new StringBuilder();
                c0369c.append("  Created new loader ");
                c0369c.append(c4455a);
                Log.v("LoaderManager", c0369c.toString());
            }
            this.f8123c.m9412a(i, c4455a);
            return c4455a.m14875a(this.f8122b, (C0343a) c0343a);
        } finally {
            this.f8124d = false;
        }
    }

    /* renamed from: a */
    public <D> C0369c<D> mo175a(int i, Bundle bundle, C0343a<D> c0343a) {
        if (this.f8124d) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            C4455a a = this.f8123c.m9410a(i);
            if (f8121a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("initLoader in ");
                stringBuilder.append(this);
                stringBuilder.append(": args=");
                stringBuilder.append(bundle);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            if (a == null) {
                return m9419a(i, bundle, (C0343a) c0343a, null);
            }
            if (f8121a != 0) {
                bundle = new StringBuilder();
                bundle.append("  Re-using existing loader ");
                bundle.append(a);
                Log.v("LoaderManager", bundle.toString());
            }
            return a.m14875a(this.f8122b, (C0343a) c0343a);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    /* renamed from: a */
    void m9421a() {
        this.f8123c.m9414b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0450d.m1408a(this.f8122b, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo176a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f8123c.m9413a(str, fileDescriptor, printWriter, strArr);
    }
}
