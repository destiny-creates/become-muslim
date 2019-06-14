package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController.C0601a;
import android.support.v7.p035a.C0591a.C0581a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.facebook.imageutils.JfifUtil;

/* compiled from: AlertDialog */
/* renamed from: android.support.v7.app.b */
public class C4473b extends C3256k implements DialogInterface {
    /* renamed from: a */
    final AlertController f11947a = new AlertController(getContext(), this, getWindow());

    /* compiled from: AlertDialog */
    /* renamed from: android.support.v7.app.b$a */
    public static class C0609a {
        /* renamed from: a */
        private final C0601a f1559a;
        /* renamed from: b */
        private final int f1560b;

        public C0609a(Context context) {
            this(context, C4473b.m14987a(context, 0));
        }

        public C0609a(Context context, int i) {
            this.f1559a = new C0601a(new ContextThemeWrapper(context, C4473b.m14987a(context, i)));
            this.f1560b = i;
        }

        /* renamed from: a */
        public Context m2040a() {
            return this.f1559a.f1477a;
        }

        /* renamed from: a */
        public C0609a m2046a(CharSequence charSequence) {
            this.f1559a.f1482f = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0609a m2044a(View view) {
            this.f1559a.f1483g = view;
            return this;
        }

        /* renamed from: b */
        public C0609a m2049b(CharSequence charSequence) {
            this.f1559a.f1484h = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0609a m2043a(Drawable drawable) {
            this.f1559a.f1480d = drawable;
            return this;
        }

        /* renamed from: a */
        public C0609a m2041a(int i, OnClickListener onClickListener) {
            this.f1559a.f1485i = this.f1559a.f1477a.getText(i);
            this.f1559a.f1487k = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C0609a m2047a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1559a.f1485i = charSequence;
            this.f1559a.f1487k = onClickListener;
            return this;
        }

        /* renamed from: b */
        public C0609a m2050b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1559a.f1488l = charSequence;
            this.f1559a.f1490n = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C0609a m2048a(boolean z) {
            this.f1559a.f1494r = z;
            return this;
        }

        /* renamed from: a */
        public C0609a m2042a(OnKeyListener onKeyListener) {
            this.f1559a.f1497u = onKeyListener;
            return this;
        }

        /* renamed from: a */
        public C0609a m2045a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f1559a.f1499w = listAdapter;
            this.f1559a.f1500x = onClickListener;
            return this;
        }

        /* renamed from: b */
        public C4473b m2051b() {
            C4473b c4473b = new C4473b(this.f1559a.f1477a, this.f1560b);
            this.f1559a.m1966a(c4473b.f11947a);
            c4473b.setCancelable(this.f1559a.f1494r);
            if (this.f1559a.f1494r) {
                c4473b.setCanceledOnTouchOutside(true);
            }
            c4473b.setOnCancelListener(this.f1559a.f1495s);
            c4473b.setOnDismissListener(this.f1559a.f1496t);
            if (this.f1559a.f1497u != null) {
                c4473b.setOnKeyListener(this.f1559a.f1497u);
            }
            return c4473b;
        }

        /* renamed from: c */
        public C4473b m2052c() {
            C4473b b = m2051b();
            b.show();
            return b;
        }
    }

    protected C4473b(Context context, int i) {
        super(context, C4473b.m14987a(context, i));
    }

    /* renamed from: a */
    static int m14987a(Context context, int i) {
        if (((i >>> 24) & JfifUtil.MARKER_FIRST_BYTE) >= 1) {
            return i;
        }
        i = new TypedValue();
        context.getTheme().resolveAttribute(C0581a.alertDialogTheme, i, true);
        return i.resourceId;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f11947a.m1984a(charSequence);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11947a.m1979a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f11947a.m1985a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f11947a.m1989b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
