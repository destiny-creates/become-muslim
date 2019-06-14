package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.app.C4473b;
import android.support.v7.app.C4473b.C0609a;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.view.menu.C0662o.C0661a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* compiled from: MenuDialogHelper */
/* renamed from: android.support.v7.view.menu.i */
class C3274i implements OnClickListener, OnDismissListener, OnKeyListener, C0661a {
    /* renamed from: a */
    C3272f f8510a;
    /* renamed from: b */
    private C3273h f8511b;
    /* renamed from: c */
    private C4473b f8512c;
    /* renamed from: d */
    private C0661a f8513d;

    public C3274i(C3273h c3273h) {
        this.f8511b = c3273h;
    }

    /* renamed from: a */
    public void m10101a(IBinder iBinder) {
        C3273h c3273h = this.f8511b;
        C0609a c0609a = new C0609a(c3273h.m10085e());
        this.f8510a = new C3272f(c0609a.m2040a(), C0587g.abc_list_menu_item_layout);
        this.f8510a.mo465a((C0661a) this);
        this.f8511b.m10064a(this.f8510a);
        c0609a.m2045a(this.f8510a.m10036a(), (OnClickListener) this);
        View o = c3273h.m10096o();
        if (o != null) {
            c0609a.m2044a(o);
        } else {
            c0609a.m2043a(c3273h.m10095n()).m2046a(c3273h.m10094m());
        }
        c0609a.m2042a((OnKeyListener) this);
        this.f8512c = c0609a.m2051b();
        this.f8512c.setOnDismissListener(this);
        LayoutParams attributes = this.f8512c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f8512c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                dialogInterface = this.f8512c.getWindow();
                if (dialogInterface != null) {
                    dialogInterface = dialogInterface.getDecorView();
                    if (dialogInterface != null) {
                        dialogInterface = dialogInterface.getKeyDispatcherState();
                        if (dialogInterface != null) {
                            dialogInterface.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window = this.f8512c.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f8511b.m10068a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f8511b.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void m10100a() {
        if (this.f8512c != null) {
            this.f8512c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f8510a.mo464a(this.f8511b, true);
    }

    /* renamed from: a */
    public void mo378a(C3273h c3273h, boolean z) {
        if (z || c3273h == this.f8511b) {
            m10100a();
        }
        if (this.f8513d != null) {
            this.f8513d.mo378a(c3273h, z);
        }
    }

    /* renamed from: a */
    public boolean mo379a(C3273h c3273h) {
        return this.f8513d != null ? this.f8513d.mo379a(c3273h) : null;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8511b.m10070a((C3276j) this.f8510a.m10036a().getItem(i), 0);
    }
}
