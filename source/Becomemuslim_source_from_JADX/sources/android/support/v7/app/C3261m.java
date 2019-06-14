package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.C0517s;
import android.support.v7.app.C0608a.C0606b;
import android.support.v7.view.C0648i;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0736c;
import android.support.v7.widget.aj;
import android.support.v7.widget.br;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar */
/* renamed from: android.support.v7.app.m */
class C3261m extends C0608a {
    /* renamed from: a */
    aj f8361a;
    /* renamed from: b */
    boolean f8362b;
    /* renamed from: c */
    Callback f8363c;
    /* renamed from: d */
    private boolean f8364d;
    /* renamed from: e */
    private boolean f8365e;
    /* renamed from: f */
    private ArrayList<C0606b> f8366f = new ArrayList();
    /* renamed from: g */
    private final Runnable f8367g = new C06191(this);
    /* renamed from: h */
    private final C0736c f8368h = new C32572(this);

    /* compiled from: ToolbarActionBar */
    /* renamed from: android.support.v7.app.m$1 */
    class C06191 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3261m f1599a;

        C06191(C3261m c3261m) {
            this.f1599a = c3261m;
        }

        public void run() {
            this.f1599a.m9916i();
        }
    }

    /* compiled from: ToolbarActionBar */
    /* renamed from: android.support.v7.app.m$2 */
    class C32572 implements C0736c {
        /* renamed from: a */
        final /* synthetic */ C3261m f8356a;

        C32572(C3261m c3261m) {
            this.f8356a = c3261m;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f8356a.f8363c.onMenuItemSelected(0, menuItem);
        }
    }

    /* compiled from: ToolbarActionBar */
    /* renamed from: android.support.v7.app.m$a */
    private final class C3258a implements C0661a {
        /* renamed from: a */
        final /* synthetic */ C3261m f8357a;
        /* renamed from: b */
        private boolean f8358b;

        C3258a(C3261m c3261m) {
            this.f8357a = c3261m;
        }

        /* renamed from: a */
        public boolean mo379a(C3273h c3273h) {
            if (this.f8357a.f8363c == null) {
                return null;
            }
            this.f8357a.f8363c.onMenuOpened(108, c3273h);
            return true;
        }

        /* renamed from: a */
        public void mo378a(C3273h c3273h, boolean z) {
            if (!this.f8358b) {
                this.f8358b = true;
                this.f8357a.f8361a.mo696n();
                if (this.f8357a.f8363c) {
                    this.f8357a.f8363c.onPanelClosed(108, c3273h);
                }
                this.f8358b = null;
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    /* renamed from: android.support.v7.app.m$b */
    private final class C3259b implements C0657a {
        /* renamed from: a */
        final /* synthetic */ C3261m f8359a;

        /* renamed from: a */
        public boolean mo389a(C3273h c3273h, MenuItem menuItem) {
            return false;
        }

        C3259b(C3261m c3261m) {
            this.f8359a = c3261m;
        }

        /* renamed from: a */
        public void mo388a(C3273h c3273h) {
            if (this.f8359a.f8363c == null) {
                return;
            }
            if (this.f8359a.f8361a.mo691i()) {
                this.f8359a.f8363c.onPanelClosed(108, c3273h);
            } else if (this.f8359a.f8363c.onPreparePanel(0, null, c3273h)) {
                this.f8359a.f8363c.onMenuOpened(108, c3273h);
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    /* renamed from: android.support.v7.app.m$c */
    private class C3260c extends C0648i {
        /* renamed from: a */
        final /* synthetic */ C3261m f8360a;

        public C3260c(C3261m c3261m, Callback callback) {
            this.f8360a = c3261m;
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            i = super.onPreparePanel(i, view, menu);
            if (i != 0 && this.f8360a.f8362b == null) {
                this.f8360a.f8361a.mo695m();
                this.f8360a.f8362b = true;
            }
            return i;
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(this.f8360a.f8361a.mo679b());
            }
            return super.onCreatePanelView(i);
        }
    }

    /* renamed from: c */
    public void mo401c(boolean z) {
    }

    /* renamed from: e */
    public void mo404e(boolean z) {
    }

    /* renamed from: f */
    public void mo406f(boolean z) {
    }

    /* renamed from: i */
    void m9916i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002f in list [B:13:0x002c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.m9894j();
        r1 = r0 instanceof android.support.v7.view.menu.C3273h;
        r2 = 0;
        if (r1 == 0) goto L_0x000d;
    L_0x0009:
        r1 = r0;
        r1 = (android.support.v7.view.menu.C3273h) r1;
        goto L_0x000e;
    L_0x000d:
        r1 = r2;
    L_0x000e:
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        r1.m10088g();
    L_0x0013:
        r0.clear();	 Catch:{ all -> 0x0030 }
        r3 = r5.f8363c;	 Catch:{ all -> 0x0030 }
        r4 = 0;	 Catch:{ all -> 0x0030 }
        r3 = r3.onCreatePanelMenu(r4, r0);	 Catch:{ all -> 0x0030 }
        if (r3 == 0) goto L_0x0027;	 Catch:{ all -> 0x0030 }
    L_0x001f:
        r3 = r5.f8363c;	 Catch:{ all -> 0x0030 }
        r2 = r3.onPreparePanel(r4, r2, r0);	 Catch:{ all -> 0x0030 }
        if (r2 != 0) goto L_0x002a;	 Catch:{ all -> 0x0030 }
    L_0x0027:
        r0.clear();	 Catch:{ all -> 0x0030 }
    L_0x002a:
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.m10089h();
    L_0x002f:
        return;
    L_0x0030:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r1.m10089h();
    L_0x0036:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.m.i():void");
    }

    C3261m(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f8361a = new br(toolbar, false);
        this.f8363c = new C3260c(this, callback);
        this.f8361a.mo676a(this.f8363c);
        toolbar.setOnMenuItemClickListener(this.f8368h);
        this.f8361a.mo677a(charSequence);
    }

    /* renamed from: h */
    public Callback m9915h() {
        return this.f8363c;
    }

    /* renamed from: a */
    public void mo392a(float f) {
        C0517s.m1687a(this.f8361a.mo670a(), f);
    }

    /* renamed from: b */
    public Context mo398b() {
        return this.f8361a.mo679b();
    }

    /* renamed from: a */
    public void mo393a(Configuration configuration) {
        super.mo393a(configuration);
    }

    /* renamed from: a */
    public void mo394a(CharSequence charSequence) {
        this.f8361a.mo681b(charSequence);
    }

    /* renamed from: b */
    public void mo399b(CharSequence charSequence) {
        this.f8361a.mo677a(charSequence);
    }

    /* renamed from: a */
    public void m9897a(int i, int i2) {
        this.f8361a.mo683c((i & i2) | ((~i2) & this.f8361a.mo697o()));
    }

    /* renamed from: a */
    public void mo395a(boolean z) {
        m9897a(z ? true : false, 2);
    }

    /* renamed from: b */
    public void mo400b(boolean z) {
        m9897a(z ? true : false, 4);
    }

    /* renamed from: a */
    public int mo391a() {
        return this.f8361a.mo697o();
    }

    /* renamed from: c */
    public boolean mo402c() {
        return this.f8361a.mo693k();
    }

    /* renamed from: d */
    public boolean mo403d() {
        return this.f8361a.mo694l();
    }

    /* renamed from: e */
    public boolean mo405e() {
        this.f8361a.mo670a().removeCallbacks(this.f8367g);
        C0517s.m1697a(this.f8361a.mo670a(), this.f8367g);
        return true;
    }

    /* renamed from: f */
    public boolean mo407f() {
        if (!this.f8361a.mo684c()) {
            return false;
        }
        this.f8361a.mo685d();
        return true;
    }

    /* renamed from: a */
    public boolean mo397a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo402c();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo396a(int i, KeyEvent keyEvent) {
        Menu j = m9894j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: g */
    void mo408g() {
        this.f8361a.mo670a().removeCallbacks(this.f8367g);
    }

    /* renamed from: g */
    public void mo409g(boolean z) {
        if (z != this.f8365e) {
            this.f8365e = z;
            int size = this.f8366f.size();
            for (int i = 0; i < size; i++) {
                ((C0606b) this.f8366f.get(i)).m2013a(z);
            }
        }
    }

    /* renamed from: j */
    private Menu m9894j() {
        if (!this.f8364d) {
            this.f8361a.mo673a(new C3258a(this), new C3259b(this));
            this.f8364d = true;
        }
        return this.f8361a.mo699q();
    }
}
