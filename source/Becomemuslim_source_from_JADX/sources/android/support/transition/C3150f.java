package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.transition.C0254u.C0253c;
import android.support.v4.view.C0517s;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;

/* compiled from: ChangeBounds */
/* renamed from: android.support.transition.f */
public class C3150f extends C0254u {
    /* renamed from: g */
    private static final String[] f8092g = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    /* renamed from: h */
    private static final Property<Drawable, PointF> f8093h = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        /* renamed from: a */
        private Rect f569a = new Rect();

        public /* synthetic */ Object get(Object obj) {
            return m597a((Drawable) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m598a((Drawable) obj, (PointF) obj2);
        }

        /* renamed from: a */
        public void m598a(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f569a);
            this.f569a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f569a);
        }

        /* renamed from: a */
        public PointF m597a(Drawable drawable) {
            drawable.copyBounds(this.f569a);
            return new PointF((float) this.f569a.left, (float) this.f569a.top);
        }
    };
    /* renamed from: i */
    private static final Property<C0237a, PointF> f8094i = new Property<C0237a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF m599a(C0237a c0237a) {
            return null;
        }

        public /* synthetic */ Object get(Object obj) {
            return m599a((C0237a) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m600a((C0237a) obj, (PointF) obj2);
        }

        /* renamed from: a */
        public void m600a(C0237a c0237a, PointF pointF) {
            c0237a.m610a(pointF);
        }
    };
    /* renamed from: j */
    private static final Property<C0237a, PointF> f8095j = new Property<C0237a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF m601a(C0237a c0237a) {
            return null;
        }

        public /* synthetic */ Object get(Object obj) {
            return m601a((C0237a) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m602a((C0237a) obj, (PointF) obj2);
        }

        /* renamed from: a */
        public void m602a(C0237a c0237a, PointF pointF) {
            c0237a.m611b(pointF);
        }
    };
    /* renamed from: k */
    private static final Property<View, PointF> f8096k = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF m603a(View view) {
            return null;
        }

        public /* synthetic */ Object get(Object obj) {
            return m603a((View) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m604a((View) obj, (PointF) obj2);
        }

        /* renamed from: a */
        public void m604a(View view, PointF pointF) {
            am.m578a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    /* renamed from: l */
    private static final Property<View, PointF> f8097l = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF m605a(View view) {
            return null;
        }

        public /* synthetic */ Object get(Object obj) {
            return m605a((View) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m606a((View) obj, (PointF) obj2);
        }

        /* renamed from: a */
        public void m606a(View view, PointF pointF) {
            am.m578a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    /* renamed from: m */
    private static final Property<View, PointF> f8098m = new Property<View, PointF>(PointF.class, ViewProps.POSITION) {
        /* renamed from: a */
        public PointF m607a(View view) {
            return null;
        }

        public /* synthetic */ Object get(Object obj) {
            return m607a((View) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m608a((View) obj, (PointF) obj2);
        }

        /* renamed from: a */
        public void m608a(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            pointF = Math.round(pointF.y);
            am.m578a(view, round, pointF, view.getWidth() + round, view.getHeight() + pointF);
        }
    };
    /* renamed from: q */
    private static C0247s f8099q = new C0247s();
    /* renamed from: n */
    private int[] f8100n = new int[2];
    /* renamed from: o */
    private boolean f8101o = false;
    /* renamed from: p */
    private boolean f8102p = false;

    /* compiled from: ChangeBounds */
    /* renamed from: android.support.transition.f$a */
    private static class C0237a {
        /* renamed from: a */
        private int f585a;
        /* renamed from: b */
        private int f586b;
        /* renamed from: c */
        private int f587c;
        /* renamed from: d */
        private int f588d;
        /* renamed from: e */
        private View f589e;
        /* renamed from: f */
        private int f590f;
        /* renamed from: g */
        private int f591g;

        C0237a(View view) {
            this.f589e = view;
        }

        /* renamed from: a */
        void m610a(PointF pointF) {
            this.f585a = Math.round(pointF.x);
            this.f586b = Math.round(pointF.y);
            this.f590f++;
            if (this.f590f == this.f591g) {
                m609a();
            }
        }

        /* renamed from: b */
        void m611b(PointF pointF) {
            this.f587c = Math.round(pointF.x);
            this.f588d = Math.round(pointF.y);
            this.f591g++;
            if (this.f590f == this.f591g) {
                m609a();
            }
        }

        /* renamed from: a */
        private void m609a() {
            am.m578a(this.f589e, this.f585a, this.f586b, this.f587c, this.f588d);
            this.f590f = 0;
            this.f591g = 0;
        }
    }

    /* renamed from: a */
    public String[] mo137a() {
        return f8092g;
    }

    /* renamed from: d */
    private void m9342d(aa aaVar) {
        View view = aaVar.f542b;
        if (C0517s.m1730x(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            aaVar.f541a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            aaVar.f541a.put("android:changeBounds:parent", aaVar.f542b.getParent());
            if (this.f8102p) {
                aaVar.f542b.getLocationInWindow(this.f8100n);
                aaVar.f541a.put("android:changeBounds:windowX", Integer.valueOf(this.f8100n[0]));
                aaVar.f541a.put("android:changeBounds:windowY", Integer.valueOf(this.f8100n[1]));
            }
            if (this.f8101o) {
                aaVar.f541a.put("android:changeBounds:clip", C0517s.m1732z(view));
            }
        }
    }

    /* renamed from: a */
    public void mo135a(aa aaVar) {
        m9342d(aaVar);
    }

    /* renamed from: b */
    public void mo138b(aa aaVar) {
        m9342d(aaVar);
    }

    /* renamed from: a */
    private boolean m9341a(View view, View view2) {
        if (!this.f8102p) {
            return true;
        }
        aa b = m655b(view, true);
        if (b == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == b.f542b) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public Animator mo134a(ViewGroup viewGroup, aa aaVar, aa aaVar2) {
        C3150f c3150f = this;
        aa aaVar3 = aaVar;
        aa aaVar4 = aaVar2;
        if (aaVar3 != null) {
            if (aaVar4 != null) {
                ViewGroup viewGroup2 = (ViewGroup) aaVar3.f541a.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) aaVar4.f541a.get("android:changeBounds:parent");
                if (viewGroup2 != null) {
                    if (viewGroup3 != null) {
                        View view = aaVar4.f542b;
                        int i;
                        int i2;
                        int i3;
                        Animator ofObject;
                        if (m9341a(viewGroup2, viewGroup3)) {
                            Rect rect = (Rect) aaVar3.f541a.get("android:changeBounds:bounds");
                            Rect rect2 = (Rect) aaVar4.f541a.get("android:changeBounds:bounds");
                            int i4 = rect.left;
                            int i5 = rect2.left;
                            int i6 = rect.top;
                            int i7 = rect2.top;
                            int i8 = rect.right;
                            int i9 = rect2.right;
                            i = rect.bottom;
                            int i10 = rect2.bottom;
                            int i11 = i8 - i4;
                            i2 = i - i6;
                            int i12 = i9 - i5;
                            int i13 = i10 - i7;
                            View view2 = view;
                            Rect rect3 = (Rect) aaVar3.f541a.get("android:changeBounds:clip");
                            Rect rect4 = (Rect) aaVar4.f541a.get("android:changeBounds:clip");
                            if ((i11 == 0 || i2 == 0) && (i12 == 0 || i13 == 0)) {
                                i3 = 0;
                            } else {
                                if (i4 == i5) {
                                    if (i6 == i7) {
                                        i3 = 0;
                                        if (!(i8 == i9 && i == i10)) {
                                            i3++;
                                        }
                                    }
                                }
                                i3 = 1;
                                i3++;
                            }
                            if (!(rect3 == null || rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                                i3++;
                            }
                            if (i3 > 0) {
                                Animator a;
                                Rect rect5 = rect4;
                                Rect rect6 = rect3;
                                if (c3150f.f8101o) {
                                    Animator animator;
                                    Rect rect7;
                                    final View view3;
                                    view = view2;
                                    am.m578a(view, i4, i6, Math.max(i11, i12) + i4, Math.max(i2, i13) + i6);
                                    if (i4 == i5) {
                                        if (i6 == i7) {
                                            animator = null;
                                            if (rect6 != null) {
                                                i = 0;
                                                rect7 = new Rect(0, 0, i11, i2);
                                            } else {
                                                i = 0;
                                                rect7 = rect6;
                                            }
                                            if (rect7.equals(rect5 != null ? new Rect(i, i, i12, i13) : rect5)) {
                                                C0517s.m1693a(view, rect7);
                                                ofObject = ObjectAnimator.ofObject(view, "clipBounds", f8099q, new Object[]{rect7, r2});
                                                view3 = view;
                                                rect = rect5;
                                                i13 = i5;
                                                i11 = i7;
                                                i4 = i9;
                                                i5 = i10;
                                                ofObject.addListener(new AnimatorListenerAdapter(this) {
                                                    /* renamed from: g */
                                                    final /* synthetic */ C3150f f583g;
                                                    /* renamed from: h */
                                                    private boolean f584h;

                                                    public void onAnimationCancel(Animator animator) {
                                                        this.f584h = true;
                                                    }

                                                    public void onAnimationEnd(Animator animator) {
                                                        if (this.f584h == null) {
                                                            C0517s.m1693a(view3, rect);
                                                            am.m578a(view3, i13, i11, i4, i5);
                                                        }
                                                    }
                                                });
                                            } else {
                                                ofObject = null;
                                            }
                                            a = C0258z.m685a(animator, ofObject);
                                        }
                                    }
                                    animator = C0239h.m612a(view, f8098m, m673l().mo144a((float) i4, (float) i6, (float) i5, (float) i7));
                                    if (rect6 != null) {
                                        i = 0;
                                        rect7 = rect6;
                                    } else {
                                        i = 0;
                                        rect7 = new Rect(0, 0, i11, i2);
                                    }
                                    if (rect5 != null) {
                                    }
                                    if (rect7.equals(rect5 != null ? new Rect(i, i, i12, i13) : rect5)) {
                                        ofObject = null;
                                    } else {
                                        C0517s.m1693a(view, rect7);
                                        ofObject = ObjectAnimator.ofObject(view, "clipBounds", f8099q, new Object[]{rect7, r2});
                                        view3 = view;
                                        rect = rect5;
                                        i13 = i5;
                                        i11 = i7;
                                        i4 = i9;
                                        i5 = i10;
                                        ofObject.addListener(/* anonymous class already generated */);
                                    }
                                    a = C0258z.m685a(animator, ofObject);
                                } else {
                                    view = view2;
                                    am.m578a(view, i4, i6, i8, i);
                                    if (i3 != 2) {
                                        if (i4 == i5) {
                                            if (i6 == i7) {
                                                a = C0239h.m612a(view, f8096k, m673l().mo144a((float) i8, (float) i, (float) i9, (float) i10));
                                            }
                                        }
                                        a = C0239h.m612a(view, f8097l, m673l().mo144a((float) i4, (float) i6, (float) i5, (float) i7));
                                    } else if (i11 == i12 && i2 == i13) {
                                        a = C0239h.m612a(view, f8098m, m673l().mo144a((float) i4, (float) i6, (float) i5, (float) i7));
                                    } else {
                                        final C0237a c0237a = new C0237a(view);
                                        ObjectAnimator a2 = C0239h.m612a(c0237a, f8094i, m673l().mo144a((float) i4, (float) i6, (float) i5, (float) i7));
                                        ObjectAnimator a3 = C0239h.m612a(c0237a, f8095j, m673l().mo144a((float) i8, (float) i, (float) i9, (float) i10));
                                        Animator animatorSet = new AnimatorSet();
                                        animatorSet.playTogether(new Animator[]{a2, a3});
                                        animatorSet.addListener(new AnimatorListenerAdapter(c3150f) {
                                            /* renamed from: b */
                                            final /* synthetic */ C3150f f576b;
                                            private C0237a mViewBounds = c0237a;
                                        });
                                        a = animatorSet;
                                    }
                                }
                                if (view.getParent() instanceof ViewGroup) {
                                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                                    af.m559a(viewGroup4, true);
                                    mo146a(new C3156v(c3150f) {
                                        /* renamed from: a */
                                        boolean f11889a = null;
                                        /* renamed from: c */
                                        final /* synthetic */ C3150f f11891c;

                                        /* renamed from: a */
                                        public void mo99a(C0254u c0254u) {
                                            if (!this.f11889a) {
                                                af.m559a(viewGroup4, false);
                                            }
                                            c0254u.mo151b((C0253c) this);
                                        }

                                        /* renamed from: b */
                                        public void mo100b(C0254u c0254u) {
                                            af.m559a(viewGroup4, false);
                                        }

                                        /* renamed from: c */
                                        public void mo101c(C0254u c0254u) {
                                            af.m559a(viewGroup4, true);
                                        }
                                    });
                                }
                                return a;
                            }
                        }
                        i2 = ((Integer) aaVar3.f541a.get("android:changeBounds:windowX")).intValue();
                        int intValue = ((Integer) aaVar3.f541a.get("android:changeBounds:windowY")).intValue();
                        i = ((Integer) aaVar4.f541a.get("android:changeBounds:windowX")).intValue();
                        i3 = ((Integer) aaVar4.f541a.get("android:changeBounds:windowY")).intValue();
                        if (i2 == i) {
                            if (intValue != i3) {
                            }
                        }
                        viewGroup.getLocationInWindow(c3150f.f8100n);
                        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
                        view.draw(new Canvas(createBitmap));
                        Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
                        float c = am.m582c(view);
                        am.m576a(view, 0.0f);
                        am.m574a(viewGroup).mo121a(bitmapDrawable);
                        PropertyValuesHolder a4 = C0243n.m617a(f8093h, m673l().mo144a((float) (i2 - c3150f.f8100n[0]), (float) (intValue - c3150f.f8100n[1]), (float) (i - c3150f.f8100n[0]), (float) (i3 - c3150f.f8100n[1])));
                        ofObject = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{a4});
                        final ViewGroup viewGroup5 = viewGroup;
                        final Drawable drawable = bitmapDrawable;
                        final View view4 = view;
                        final float f = c;
                        ofObject.addListener(new AnimatorListenerAdapter(this) {
                            /* renamed from: e */
                            final /* synthetic */ C3150f f574e;

                            public void onAnimationEnd(Animator animator) {
                                am.m574a(viewGroup5).mo122b(drawable);
                                am.m576a(view4, f);
                            }
                        });
                        return ofObject;
                        return null;
                    }
                }
                return null;
            }
        }
        return null;
    }
}
