package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* compiled from: AppCompatDelegate */
/* renamed from: android.support.v7.app.e */
public abstract class C0611e {
    /* renamed from: a */
    private static int f1561a = -1;
    /* renamed from: b */
    private static boolean f1562b = false;

    /* renamed from: a */
    public abstract C0608a mo367a();

    /* renamed from: a */
    public abstract <T extends View> T mo2714a(int i);

    /* renamed from: a */
    public abstract void mo2716a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo2717a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo2718a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo2719a(View view);

    /* renamed from: a */
    public abstract void mo2720a(View view, LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo368a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo369b();

    /* renamed from: b */
    public abstract void mo2723b(int i);

    /* renamed from: b */
    public abstract void mo2724b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo2725b(View view, LayoutParams layoutParams);

    /* renamed from: c */
    public abstract void mo370c();

    /* renamed from: c */
    public abstract void mo371c(Bundle bundle);

    /* renamed from: c */
    public abstract boolean mo2728c(int i);

    /* renamed from: d */
    public abstract void mo372d();

    /* renamed from: e */
    public abstract void mo2729e();

    /* renamed from: f */
    public abstract void mo2730f();

    /* renamed from: g */
    public abstract void mo373g();

    /* renamed from: h */
    public abstract void mo2731h();

    /* renamed from: i */
    public abstract boolean mo374i();

    /* renamed from: a */
    public static C0611e m2056a(Activity activity, C0610d c0610d) {
        return C0611e.m2058a(activity, activity.getWindow(), c0610d);
    }

    /* renamed from: a */
    public static C0611e m2057a(Dialog dialog, C0610d c0610d) {
        return C0611e.m2058a(dialog.getContext(), dialog.getWindow(), c0610d);
    }

    /* renamed from: a */
    private static C0611e m2058a(Context context, Window window, C0610d c0610d) {
        if (VERSION.SDK_INT >= 24) {
            return new C4909g(context, window, c0610d);
        }
        if (VERSION.SDK_INT >= 23) {
            return new C4894i(context, window, c0610d);
        }
        return new C4831h(context, window, c0610d);
    }

    C0611e() {
    }

    /* renamed from: j */
    public static int m2059j() {
        return f1561a;
    }

    /* renamed from: k */
    public static boolean m2060k() {
        return f1562b;
    }
}
