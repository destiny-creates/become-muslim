package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.C0656g;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow */
public class aw extends au implements av {
    /* renamed from: a */
    private static Method f12069a;
    /* renamed from: b */
    private av f12070b;

    /* compiled from: MenuPopupWindow */
    /* renamed from: android.support.v7.widget.aw$a */
    public static class C3308a extends am {
        /* renamed from: a */
        final int f8790a;
        /* renamed from: b */
        final int f8791b;
        /* renamed from: c */
        private av f8792c;
        /* renamed from: d */
        private MenuItem f8793d;

        /* renamed from: a */
        public /* bridge */ /* synthetic */ int mo638a(int i, int i2, int i3, int i4, int i5) {
            return super.mo638a(i, i2, i3, i4, i5);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo639a(MotionEvent motionEvent, int i) {
            return super.mo639a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public C3308a(Context context, boolean z) {
            super(context, z);
            context = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < true || true != context.getLayoutDirection()) {
                this.f8790a = 22;
                this.f8791b = 21;
                return;
            }
            this.f8790a = 21;
            this.f8791b = 22;
        }

        public void setHoverListener(av avVar) {
            this.f8792c = avVar;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f8790a) {
                if (!(listMenuItemView.isEnabled() == 0 || listMenuItemView.getItemData().hasSubMenu() == 0)) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f8791b) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0656g) getAdapter()).m2180a().m10068a((boolean) null);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.f8792c != null) {
                int headersCount;
                C0656g c0656g;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0656g = (C0656g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c0656g = (C0656g) adapter;
                }
                MenuItem menuItem = null;
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        pointToPosition -= headersCount;
                        if (pointToPosition >= 0 && pointToPosition < c0656g.getCount()) {
                            menuItem = c0656g.m2181a(pointToPosition);
                        }
                    }
                }
                MenuItem menuItem2 = this.f8793d;
                if (menuItem2 != menuItem) {
                    C3273h a = c0656g.m2180a();
                    if (menuItem2 != null) {
                        this.f8792c.mo471a(a, menuItem2);
                    }
                    this.f8793d = menuItem;
                    if (menuItem != null) {
                        this.f8792c.mo472b(a, menuItem);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r1 = "setTouchModal";	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0013 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r4 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0013 }
        f12069a = r0;	 Catch:{ NoSuchMethodException -> 0x0013 }
        goto L_0x001a;
    L_0x0013:
        r0 = "MenuPopupWindow";
        r1 = "Could not find method setTouchModal() on PopupWindow. Oh well.";
        android.util.Log.i(r0, r1);
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aw.<clinit>():void");
    }

    public aw(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    am mo2772a(Context context, boolean z) {
        am c3308a = new C3308a(context, z);
        c3308a.setHoverListener(this);
        return c3308a;
    }

    /* renamed from: a */
    public void m15170a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void m15172b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: a */
    public void m15169a(av avVar) {
        this.f12070b = avVar;
    }

    /* renamed from: c */
    public void mo2773c(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = f12069a;
        if (r0 == 0) goto L_0x001d;
    L_0x0004:
        r0 = f12069a;	 Catch:{ Exception -> 0x0016 }
        r1 = r4.g;	 Catch:{ Exception -> 0x0016 }
        r2 = 1;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0016 }
        r3 = 0;	 Catch:{ Exception -> 0x0016 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0016 }
        r2[r3] = r5;	 Catch:{ Exception -> 0x0016 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0016 }
        goto L_0x001d;
    L_0x0016:
        r5 = "MenuPopupWindow";
        r0 = "Could not invoke setTouchModal() on PopupWindow. Oh well.";
        android.util.Log.i(r5, r0);
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aw.c(boolean):void");
    }

    /* renamed from: b */
    public void mo472b(C3273h c3273h, MenuItem menuItem) {
        if (this.f12070b != null) {
            this.f12070b.mo472b(c3273h, menuItem);
        }
    }

    /* renamed from: a */
    public void mo471a(C3273h c3273h, MenuItem menuItem) {
        if (this.f12070b != null) {
            this.f12070b.mo471a(c3273h, menuItem);
        }
    }
}
