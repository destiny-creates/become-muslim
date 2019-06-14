package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.arch.lifecycle.C0074c.C0072a;
import android.os.Bundle;

/* compiled from: ReportFragment */
/* renamed from: android.arch.lifecycle.m */
public class C0084m extends Fragment {
    /* renamed from: a */
    private C0083a f213a;

    /* compiled from: ReportFragment */
    /* renamed from: android.arch.lifecycle.m$a */
    interface C0083a {
        /* renamed from: a */
        void m192a();

        /* renamed from: b */
        void m193b();

        /* renamed from: c */
        void m194c();
    }

    /* renamed from: a */
    public static void m195a(Activity activity) {
        activity = activity.getFragmentManager();
        if (activity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            activity.beginTransaction().add(new C0084m(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            activity.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m197a(C0083a c0083a) {
        if (c0083a != null) {
            c0083a.m192a();
        }
    }

    /* renamed from: b */
    private void m198b(C0083a c0083a) {
        if (c0083a != null) {
            c0083a.m193b();
        }
    }

    /* renamed from: c */
    private void m199c(C0083a c0083a) {
        if (c0083a != null) {
            c0083a.m194c();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m197a(this.f213a);
        m196a(C0072a.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        m198b(this.f213a);
        m196a(C0072a.ON_START);
    }

    public void onResume() {
        super.onResume();
        m199c(this.f213a);
        m196a(C0072a.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        m196a(C0072a.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        m196a(C0072a.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        m196a(C0072a.ON_DESTROY);
        this.f213a = null;
    }

    /* renamed from: a */
    private void m196a(C0072a c0072a) {
        Activity activity = getActivity();
        if (activity instanceof C3108g) {
            ((C3108g) activity).m9137a().m9133a(c0072a);
            return;
        }
        if (activity instanceof C0076e) {
            C0074c lifecycle = ((C0076e) activity).getLifecycle();
            if (lifecycle instanceof C3107f) {
                ((C3107f) lifecycle).m9133a(c0072a);
            }
        }
    }
}
