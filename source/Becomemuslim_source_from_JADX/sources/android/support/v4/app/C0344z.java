package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.C0369c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager */
/* renamed from: android.support.v4.app.z */
public abstract class C0344z {

    /* compiled from: LoaderManager */
    /* renamed from: android.support.v4.app.z$a */
    public interface C0343a<D> {
        /* renamed from: a */
        C0369c<D> mo2361a(int i, Bundle bundle);

        /* renamed from: a */
        void mo2362a(C0369c<D> c0369c);

        /* renamed from: a */
        void mo2363a(C0369c<D> c0369c, D d);
    }

    /* renamed from: a */
    public abstract <D> C0369c<D> mo175a(int i, Bundle bundle, C0343a<D> c0343a);

    /* renamed from: a */
    public abstract void mo176a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
