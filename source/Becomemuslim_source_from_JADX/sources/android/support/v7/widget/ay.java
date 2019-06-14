package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0702j;
import android.view.View;

/* compiled from: OrientationHelper */
public abstract class ay {
    /* renamed from: a */
    protected final C0701i f2052a;
    /* renamed from: b */
    final Rect f2053b;
    /* renamed from: c */
    private int f2054c;

    /* renamed from: a */
    public abstract int mo647a(View view);

    /* renamed from: a */
    public abstract void mo648a(int i);

    /* renamed from: b */
    public abstract int mo649b(View view);

    /* renamed from: c */
    public abstract int mo650c();

    /* renamed from: c */
    public abstract int mo651c(View view);

    /* renamed from: d */
    public abstract int mo652d();

    /* renamed from: d */
    public abstract int mo653d(View view);

    /* renamed from: e */
    public abstract int mo654e();

    /* renamed from: e */
    public abstract int mo655e(View view);

    /* renamed from: f */
    public abstract int mo656f();

    /* renamed from: f */
    public abstract int mo657f(View view);

    /* renamed from: g */
    public abstract int mo658g();

    /* renamed from: h */
    public abstract int mo659h();

    /* renamed from: i */
    public abstract int mo660i();

    private ay(C0701i c0701i) {
        this.f2054c = LinearLayoutManager.INVALID_OFFSET;
        this.f2053b = new Rect();
        this.f2052a = c0701i;
    }

    /* renamed from: a */
    public void m2691a() {
        this.f2054c = mo656f();
    }

    /* renamed from: b */
    public int m2693b() {
        return LinearLayoutManager.INVALID_OFFSET == this.f2054c ? 0 : mo656f() - this.f2054c;
    }

    /* renamed from: a */
    public static ay m2688a(C0701i c0701i, int i) {
        switch (i) {
            case 0:
                return m2687a(c0701i);
            case 1:
                return m2689b(c0701i);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* renamed from: a */
    public static ay m2687a(C0701i c0701i) {
        return new ay(c0701i) {
            /* renamed from: d */
            public int mo652d() {
                return this.a.getWidth() - this.a.getPaddingRight();
            }

            /* renamed from: e */
            public int mo654e() {
                return this.a.getWidth();
            }

            /* renamed from: a */
            public void mo648a(int i) {
                this.a.offsetChildrenHorizontal(i);
            }

            /* renamed from: c */
            public int mo650c() {
                return this.a.getPaddingLeft();
            }

            /* renamed from: e */
            public int mo655e(View view) {
                C0702j c0702j = (C0702j) view.getLayoutParams();
                return (this.a.getDecoratedMeasuredWidth(view) + c0702j.leftMargin) + c0702j.rightMargin;
            }

            /* renamed from: f */
            public int mo657f(View view) {
                C0702j c0702j = (C0702j) view.getLayoutParams();
                return (this.a.getDecoratedMeasuredHeight(view) + c0702j.topMargin) + c0702j.bottomMargin;
            }

            /* renamed from: b */
            public int mo649b(View view) {
                return this.a.getDecoratedRight(view) + ((C0702j) view.getLayoutParams()).rightMargin;
            }

            /* renamed from: a */
            public int mo647a(View view) {
                return this.a.getDecoratedLeft(view) - ((C0702j) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: c */
            public int mo651c(View view) {
                this.a.getTransformedBoundingBox(view, true, this.b);
                return this.b.right;
            }

            /* renamed from: d */
            public int mo653d(View view) {
                this.a.getTransformedBoundingBox(view, true, this.b);
                return this.b.left;
            }

            /* renamed from: f */
            public int mo656f() {
                return (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
            }

            /* renamed from: g */
            public int mo658g() {
                return this.a.getPaddingRight();
            }

            /* renamed from: h */
            public int mo659h() {
                return this.a.getWidthMode();
            }

            /* renamed from: i */
            public int mo660i() {
                return this.a.getHeightMode();
            }
        };
    }

    /* renamed from: b */
    public static ay m2689b(C0701i c0701i) {
        return new ay(c0701i) {
            /* renamed from: d */
            public int mo652d() {
                return this.a.getHeight() - this.a.getPaddingBottom();
            }

            /* renamed from: e */
            public int mo654e() {
                return this.a.getHeight();
            }

            /* renamed from: a */
            public void mo648a(int i) {
                this.a.offsetChildrenVertical(i);
            }

            /* renamed from: c */
            public int mo650c() {
                return this.a.getPaddingTop();
            }

            /* renamed from: e */
            public int mo655e(View view) {
                C0702j c0702j = (C0702j) view.getLayoutParams();
                return (this.a.getDecoratedMeasuredHeight(view) + c0702j.topMargin) + c0702j.bottomMargin;
            }

            /* renamed from: f */
            public int mo657f(View view) {
                C0702j c0702j = (C0702j) view.getLayoutParams();
                return (this.a.getDecoratedMeasuredWidth(view) + c0702j.leftMargin) + c0702j.rightMargin;
            }

            /* renamed from: b */
            public int mo649b(View view) {
                return this.a.getDecoratedBottom(view) + ((C0702j) view.getLayoutParams()).bottomMargin;
            }

            /* renamed from: a */
            public int mo647a(View view) {
                return this.a.getDecoratedTop(view) - ((C0702j) view.getLayoutParams()).topMargin;
            }

            /* renamed from: c */
            public int mo651c(View view) {
                this.a.getTransformedBoundingBox(view, true, this.b);
                return this.b.bottom;
            }

            /* renamed from: d */
            public int mo653d(View view) {
                this.a.getTransformedBoundingBox(view, true, this.b);
                return this.b.top;
            }

            /* renamed from: f */
            public int mo656f() {
                return (this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom();
            }

            /* renamed from: g */
            public int mo658g() {
                return this.a.getPaddingBottom();
            }

            /* renamed from: h */
            public int mo659h() {
                return this.a.getHeightMode();
            }

            /* renamed from: i */
            public int mo660i() {
                return this.a.getWidthMode();
            }
        };
    }
}
