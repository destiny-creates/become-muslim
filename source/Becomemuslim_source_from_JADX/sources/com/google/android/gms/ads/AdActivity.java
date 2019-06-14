package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.ads.C4936r;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.p174b.C4757d;

public class AdActivity extends Activity {
    /* renamed from: a */
    private C4936r f6639a;

    /* renamed from: a */
    private final void m7336a() {
        if (this.f6639a != null) {
            try {
                this.f6639a.l();
            } catch (Throwable e) {
                mt.d("#007 Could not call remote method.", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f6639a.a(i, i2, intent);
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f6639a != null) {
                z = this.f6639a.e();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f6639a.a(C4757d.m16684a((Object) configuration));
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6639a = aph.b().a(this);
        if (this.f6639a == null) {
            mt.d("#007 Could not call remote method.", null);
        } else {
            try {
                this.f6639a.a(bundle);
                return;
            } catch (Throwable e) {
                mt.d("#007 Could not call remote method.", e);
            }
        }
        finish();
    }

    protected void onDestroy() {
        try {
            if (this.f6639a != null) {
                this.f6639a.k();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f6639a != null) {
                this.f6639a.i();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f6639a != null) {
                this.f6639a.f();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f6639a != null) {
                this.f6639a.h();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f6639a != null) {
                this.f6639a.b(bundle);
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f6639a != null) {
                this.f6639a.g();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f6639a != null) {
                this.f6639a.j();
            }
        } catch (Throwable e) {
            mt.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m7336a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m7336a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m7336a();
    }
}
