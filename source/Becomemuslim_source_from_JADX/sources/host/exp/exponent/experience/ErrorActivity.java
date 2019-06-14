package host.exp.exponent.experience;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0309n;
import android.support.v4.app.C3178i;
import android.support.v4.app.C3185r;
import android.support.v4.app.C4890j;
import android.support.v4.view.C0513q;
import android.support.v4.view.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import host.exp.exponent.C6301d;
import host.exp.exponent.LauncherActivity;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6332e;
import host.exp.exponent.p339f.C7560j;
import host.exp.p333a.C6279c.C6275d;
import java.util.LinkedList;
import javax.inject.C6562a;

public class ErrorActivity extends C4890j {
    /* renamed from: b */
    private static ErrorActivity f32892b;
    /* renamed from: c */
    private static LinkedList<C6332e> f32893c = new LinkedList();
    /* renamed from: e */
    private static ErrorConsoleFragment f32894e;
    @C6562a
    /* renamed from: a */
    C7560j f32895a;
    /* renamed from: d */
    private C0513q f32896d;
    /* renamed from: f */
    private String f32897f;
    @BindView(2131493015)
    ViewPager mPager;

    /* renamed from: host.exp.exponent.experience.ErrorActivity$1 */
    static class C63051 implements Runnable {
        C63051() {
        }

        public void run() {
            if (ErrorActivity.f32894e.f30362a != null) {
                ErrorActivity.f32894e.f30362a.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: host.exp.exponent.experience.ErrorActivity$a */
    private class C8175a extends C3185r {
        /* renamed from: a */
        final /* synthetic */ ErrorActivity f30361a;

        public int getCount() {
            return 2;
        }

        public C8175a(ErrorActivity errorActivity, C0309n c0309n) {
            this.f30361a = errorActivity;
            super(c0309n);
        }

        /* renamed from: a */
        public C3178i m39706a(int i) {
            Bundle extras = this.f30361a.getIntent().getExtras();
            extras.putString("manifestUrl", this.f30361a.f32897f);
            if (i != 1) {
                i = new ErrorFragment();
                i.setArguments(extras);
                return i;
            }
            ErrorActivity.f32894e = new ErrorConsoleFragment();
            ErrorActivity.f32894e.setArguments(extras);
            return ErrorActivity.f32894e;
        }
    }

    /* renamed from: a */
    public static ErrorActivity m44447a() {
        return f32892b;
    }

    /* renamed from: a */
    public static void m44450a(C6332e c6332e) {
        synchronized (f32893c) {
            f32893c.addFirst(c6332e);
        }
        if (f32892b != null && f32894e != null) {
            f32892b.runOnUiThread(new C63051());
        }
    }

    /* renamed from: b */
    public static void m44451b() {
        synchronized (f32893c) {
            f32893c.clear();
        }
    }

    /* renamed from: c */
    public static LinkedList<C6332e> m44452c() {
        return f32893c;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6275d.error_activity_new);
        ButterKnife.bind(this);
        C6294a.m25957a().m25961b(ErrorActivity.class, this);
        ExperienceActivity.m44574a((Context) this);
        this.f32897f = getIntent().getExtras().getString("manifestUrl");
        if (this.f32897f == null && C6301d.f20496b != null) {
            this.f32897f = C6301d.f20496b;
        }
        this.f32896d = new C8175a(this, getSupportFragmentManager());
        this.mPager.setAdapter(this.f32896d);
    }

    protected void onResume() {
        super.onResume();
        f32892b = this;
        C6288a.m25943a("ERROR_APPEARED", this.f32897f);
    }

    protected void onPause() {
        super.onPause();
        if (f32892b == this) {
            f32892b = null;
        }
    }

    public void onBackPressed() {
        if (this.mPager.getCurrentItem() == 0) {
            this.f32895a.m34251b((Activity) this);
        } else {
            this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
        }
    }

    /* renamed from: d */
    public void m44454d() {
        m44451b();
        startActivity(new Intent(this, LauncherActivity.class));
        if (f32892b == this) {
            f32892b = null;
        }
        this.f32895a.m34251b((Activity) this);
    }

    /* renamed from: e */
    public void m44455e() {
        if (this.f32897f != null) {
            m44451b();
            if (f32892b == this) {
                f32892b = null;
            }
            this.f32895a.m34251b((Activity) this);
            this.f32895a.m26070i(this.f32897f);
            return;
        }
        if (f32892b == this) {
            f32892b = null;
        }
        finish();
    }

    /* renamed from: f */
    public void m44456f() {
        if (this.mPager != null && this.mPager.getCurrentItem() == 0) {
            this.mPager.setCurrentItem(1);
        }
    }
}
