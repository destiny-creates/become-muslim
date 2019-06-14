package com.google.android.gms.p174b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.internal.C2854g;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.b.a */
public abstract class C2757a<T extends C2759c> {
    /* renamed from: a */
    private T f7049a;
    /* renamed from: b */
    private Bundle f7050b;
    /* renamed from: c */
    private LinkedList<C2756a> f7051c;
    /* renamed from: d */
    private final C2760e<T> f7052d = new C4326g(this);

    /* renamed from: com.google.android.gms.b.a$a */
    private interface C2756a {
        /* renamed from: a */
        int mo2370a();

        /* renamed from: a */
        void mo2371a(C2759c c2759c);
    }

    /* renamed from: a */
    protected abstract void m7858a(C2760e<T> c2760e);

    /* renamed from: a */
    public T m7856a() {
        return this.f7049a;
    }

    /* renamed from: a */
    private final void m7852a(int i) {
        while (!this.f7051c.isEmpty() && ((C2756a) this.f7051c.getLast()).mo2370a() >= i) {
            this.f7051c.removeLast();
        }
    }

    /* renamed from: a */
    private final void m7853a(Bundle bundle, C2756a c2756a) {
        if (this.f7049a != null) {
            c2756a.mo2371a(this.f7049a);
            return;
        }
        if (this.f7051c == null) {
            this.f7051c = new LinkedList();
        }
        this.f7051c.add(c2756a);
        if (bundle != null) {
            if (this.f7050b == null) {
                this.f7050b = (Bundle) bundle.clone();
            } else {
                this.f7050b.putAll(bundle);
            }
        }
        m7858a(this.f7052d);
    }

    /* renamed from: a */
    public void m7857a(Bundle bundle) {
        m7853a(bundle, new C4327h(this, bundle));
    }

    /* renamed from: a */
    public static void m7854a(FrameLayout frameLayout) {
        C4361e a = C4361e.m14332a();
        Context context = frameLayout.getContext();
        int a2 = a.mo2455a(context);
        CharSequence c = C2854g.m8335c(context, a2);
        CharSequence e = C2854g.m8337e(context, a2);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(c);
        linearLayout.addView(textView);
        frameLayout = a.mo2457a(context, a2, (String) null);
        if (frameLayout != null) {
            View button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new C2763i(context, frameLayout));
        }
    }

    /* renamed from: b */
    public void m7859b() {
        m7853a(null, new C4328j(this));
    }

    /* renamed from: c */
    public void m7861c() {
        m7853a(null, new C4329k(this));
    }

    /* renamed from: d */
    public void m7862d() {
        if (this.f7049a != null) {
            this.f7049a.m7870c();
        } else {
            m7852a(5);
        }
    }

    /* renamed from: e */
    public void m7863e() {
        if (this.f7049a != null) {
            this.f7049a.m7871d();
        } else {
            m7852a(4);
        }
    }

    /* renamed from: f */
    public void m7864f() {
        if (this.f7049a != null) {
            this.f7049a.m7872e();
        } else {
            m7852a(1);
        }
    }

    /* renamed from: b */
    public void m7860b(Bundle bundle) {
        if (this.f7049a != null) {
            this.f7049a.m7869b(bundle);
            return;
        }
        if (this.f7050b != null) {
            bundle.putAll(this.f7050b);
        }
    }

    /* renamed from: g */
    public void m7865g() {
        if (this.f7049a != null) {
            this.f7049a.m7873f();
        }
    }
}
