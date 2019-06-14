package android.support.v4.app;

import android.support.v4.app.C3178i.C0300c;
import android.support.v4.app.C3184o.C0320g;
import android.support.v4.util.C0451e;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
/* renamed from: android.support.v4.app.c */
final class C3176c extends C0326t implements C0320g {
    /* renamed from: a */
    final C3184o f8149a;
    /* renamed from: b */
    ArrayList<C0292a> f8150b = new ArrayList();
    /* renamed from: c */
    int f8151c;
    /* renamed from: d */
    int f8152d;
    /* renamed from: e */
    int f8153e;
    /* renamed from: f */
    int f8154f;
    /* renamed from: g */
    int f8155g;
    /* renamed from: h */
    int f8156h;
    /* renamed from: i */
    boolean f8157i;
    /* renamed from: j */
    boolean f8158j = true;
    /* renamed from: k */
    String f8159k;
    /* renamed from: l */
    boolean f8160l;
    /* renamed from: m */
    int f8161m = -1;
    /* renamed from: n */
    int f8162n;
    /* renamed from: o */
    CharSequence f8163o;
    /* renamed from: p */
    int f8164p;
    /* renamed from: q */
    CharSequence f8165q;
    /* renamed from: r */
    ArrayList<String> f8166r;
    /* renamed from: s */
    ArrayList<String> f8167s;
    /* renamed from: t */
    boolean f8168t = false;
    /* renamed from: u */
    ArrayList<Runnable> f8169u;

    /* compiled from: BackStackRecord */
    /* renamed from: android.support.v4.app.c$a */
    static final class C0292a {
        /* renamed from: a */
        int f777a;
        /* renamed from: b */
        C3178i f778b;
        /* renamed from: c */
        int f779c;
        /* renamed from: d */
        int f780d;
        /* renamed from: e */
        int f781e;
        /* renamed from: f */
        int f782f;

        C0292a() {
        }

        C0292a(int i, C3178i c3178i) {
            this.f777a = i;
            this.f778b = c3178i;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f8161m >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f8161m);
        }
        if (this.f8159k != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f8159k);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void m9462a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m9463a(str, printWriter, true);
    }

    /* renamed from: a */
    public void m9463a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f8159k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f8161m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f8160l);
            if (this.f8155g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f8155g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f8156h));
            }
            if (!(this.f8151c == 0 && this.f8152d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8151c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8152d));
            }
            if (!(this.f8153e == 0 && this.f8154f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8153e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8154f));
            }
            if (!(this.f8162n == 0 && this.f8163o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8162n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f8163o);
            }
            if (!(this.f8164p == 0 && this.f8165q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8164p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f8165q);
            }
        }
        if (!this.f8150b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            stringBuilder.toString();
            int size = this.f8150b.size();
            for (int i = 0; i < size; i++) {
                String str2;
                C0292a c0292a = (C0292a) this.f8150b.get(i);
                switch (c0292a.f777a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("cmd=");
                        stringBuilder2.append(c0292a.f777a);
                        str2 = stringBuilder2.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0292a.f778b);
                if (z) {
                    if (!(c0292a.f779c == 0 && c0292a.f780d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0292a.f779c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0292a.f780d));
                    }
                    if (c0292a.f781e != 0 || c0292a.f782f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0292a.f781e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0292a.f782f));
                    }
                }
            }
        }
    }

    public C3176c(C3184o c3184o) {
        this.f8149a = c3184o;
    }

    /* renamed from: a */
    void m9460a(C0292a c0292a) {
        this.f8150b.add(c0292a);
        c0292a.f779c = this.f8151c;
        c0292a.f780d = this.f8152d;
        c0292a.f781e = this.f8153e;
        c0292a.f782f = this.f8154f;
    }

    /* renamed from: a */
    public C0326t mo185a(C3178i c3178i, String str) {
        m9450a(0, c3178i, str, 1);
        return this;
    }

    /* renamed from: a */
    public C0326t mo182a(int i, C3178i c3178i) {
        m9450a(i, c3178i, null, 1);
        return this;
    }

    /* renamed from: a */
    public C0326t mo183a(int i, C3178i c3178i, String str) {
        m9450a(i, c3178i, str, 1);
        return this;
    }

    /* renamed from: a */
    private void m9450a(int i, C3178i c3178i, String str, int i2) {
        Class cls = c3178i.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            c3178i = new StringBuilder();
            c3178i.append("Fragment ");
            c3178i.append(cls.getCanonicalName());
            c3178i.append(" must be a public static class to be  properly recreated from");
            c3178i.append(" instance state.");
            throw new IllegalStateException(c3178i.toString());
        }
        c3178i.mFragmentManager = this.f8149a;
        if (str != null) {
            if (c3178i.mTag != null) {
                if (!str.equals(c3178i.mTag)) {
                    i2 = new StringBuilder();
                    i2.append("Can't change tag of fragment ");
                    i2.append(c3178i);
                    i2.append(": was ");
                    i2.append(c3178i.mTag);
                    i2.append(" now ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString());
                }
            }
            c3178i.mTag = str;
        }
        if (i != 0) {
            if (i != -1) {
                if (c3178i.mFragmentId != null) {
                    if (c3178i.mFragmentId != i) {
                        i2 = new StringBuilder();
                        i2.append("Can't change container ID of fragment ");
                        i2.append(c3178i);
                        i2.append(": was ");
                        i2.append(c3178i.mFragmentId);
                        i2.append(" now ");
                        i2.append(i);
                        throw new IllegalStateException(i2.toString());
                    }
                }
                c3178i.mFragmentId = i;
                c3178i.mContainerId = i;
            } else {
                i2 = new StringBuilder();
                i2.append("Can't add fragment ");
                i2.append(c3178i);
                i2.append(" with tag ");
                i2.append(str);
                i2.append(" to container view with no id");
                throw new IllegalArgumentException(i2.toString());
            }
        }
        m9460a(new C0292a(i2, c3178i));
    }

    /* renamed from: a */
    public C0326t mo184a(C3178i c3178i) {
        m9460a(new C0292a(3, c3178i));
        return this;
    }

    /* renamed from: b */
    public C0326t mo188b(C3178i c3178i) {
        m9460a(new C0292a(6, c3178i));
        return this;
    }

    /* renamed from: c */
    public C0326t mo190c(C3178i c3178i) {
        m9460a(new C0292a(7, c3178i));
        return this;
    }

    /* renamed from: a */
    public C0326t m9453a() {
        if (this.f8157i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f8158j = false;
        return this;
    }

    /* renamed from: a */
    void m9459a(int i) {
        if (this.f8157i) {
            if (C3184o.f8191a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bump nesting in ");
                stringBuilder.append(this);
                stringBuilder.append(" by ");
                stringBuilder.append(i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            int size = this.f8150b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0292a c0292a = (C0292a) this.f8150b.get(i2);
                if (c0292a.f778b != null) {
                    C3178i c3178i = c0292a.f778b;
                    c3178i.mBackStackNesting += i;
                    if (C3184o.f8191a) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Bump nesting of ");
                        stringBuilder2.append(c0292a.f778b);
                        stringBuilder2.append(" to ");
                        stringBuilder2.append(c0292a.f778b.mBackStackNesting);
                        Log.v("FragmentManager", stringBuilder2.toString());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m9469b() {
        if (this.f8169u != null) {
            int size = this.f8169u.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.f8169u.get(i)).run();
            }
            this.f8169u = null;
        }
    }

    /* renamed from: c */
    public int mo189c() {
        return m9466b(false);
    }

    /* renamed from: d */
    public int mo191d() {
        return m9466b(true);
    }

    /* renamed from: e */
    public void mo192e() {
        m9453a();
        this.f8149a.m9575b((C0320g) this, false);
    }

    /* renamed from: f */
    public void mo193f() {
        m9453a();
        this.f8149a.m9575b((C0320g) this, true);
    }

    /* renamed from: a */
    public C0326t mo186a(boolean z) {
        this.f8168t = z;
        return this;
    }

    /* renamed from: b */
    int m9466b(boolean z) {
        if (this.f8160l) {
            throw new IllegalStateException("commit already called");
        }
        if (C3184o.f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Commit: ");
            stringBuilder.append(this);
            Log.v("FragmentManager", stringBuilder.toString());
            PrintWriter printWriter = new PrintWriter(new C0451e("FragmentManager"));
            m9462a("  ", null, printWriter, null);
            printWriter.close();
        }
        this.f8160l = true;
        if (this.f8157i) {
            this.f8161m = this.f8149a.m9542a(this);
        } else {
            this.f8161m = -1;
        }
        this.f8149a.m9560a((C0320g) this, z);
        return this.f8161m;
    }

    /* renamed from: a */
    public boolean mo187a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2) {
        if (C3184o.f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Run: ");
            stringBuilder.append(this);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(null));
        if (this.f8157i != null) {
            this.f8149a.m9570b(this);
        }
        return true;
    }

    /* renamed from: b */
    boolean m9470b(int i) {
        int size = this.f8150b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0292a c0292a = (C0292a) this.f8150b.get(i2);
            int i3 = c0292a.f778b != null ? c0292a.f778b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    boolean m9464a(ArrayList<C3176c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f8150b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            C0292a c0292a = (C0292a) this.f8150b.get(i4);
            int i5 = c0292a.f778b != null ? c0292a.f778b.mContainerId : 0;
            if (!(i5 == 0 || i5 == r3)) {
                for (i3 = i; i3 < i2; i3++) {
                    C3176c c3176c = (C3176c) arrayList.get(i3);
                    int size2 = c3176c.f8150b.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        C0292a c0292a2 = (C0292a) c3176c.f8150b.get(i6);
                        if ((c0292a2.f778b != null ? c0292a2.f778b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* renamed from: g */
    void m9477g() {
        int size = this.f8150b.size();
        for (int i = 0; i < size; i++) {
            C0292a c0292a = (C0292a) this.f8150b.get(i);
            C3178i c3178i = c0292a.f778b;
            if (c3178i != null) {
                c3178i.setNextTransition(this.f8155g, this.f8156h);
            }
            int i2 = c0292a.f777a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        c3178i.setNextAnim(c0292a.f780d);
                        this.f8149a.m9599h(c3178i);
                        break;
                    case 4:
                        c3178i.setNextAnim(c0292a.f780d);
                        this.f8149a.m9602i(c3178i);
                        break;
                    case 5:
                        c3178i.setNextAnim(c0292a.f779c);
                        this.f8149a.m9604j(c3178i);
                        break;
                    case 6:
                        c3178i.setNextAnim(c0292a.f780d);
                        this.f8149a.m9606k(c3178i);
                        break;
                    case 7:
                        c3178i.setNextAnim(c0292a.f779c);
                        this.f8149a.m9608l(c3178i);
                        break;
                    case 8:
                        this.f8149a.m9614o(c3178i);
                        break;
                    case 9:
                        this.f8149a.m9614o(null);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown cmd: ");
                        stringBuilder.append(c0292a.f777a);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            c3178i.setNextAnim(c0292a.f779c);
            this.f8149a.m9558a(c3178i, false);
            if (!(this.f8168t || c0292a.f777a == 1 || c3178i == null)) {
                this.f8149a.m9590e(c3178i);
            }
        }
        if (!this.f8168t) {
            this.f8149a.m9549a(this.f8149a.f8209l, true);
        }
    }

    /* renamed from: c */
    void m9473c(boolean z) {
        for (int size = this.f8150b.size() - 1; size >= 0; size--) {
            C0292a c0292a = (C0292a) this.f8150b.get(size);
            C3178i c3178i = c0292a.f778b;
            if (c3178i != null) {
                c3178i.setNextTransition(C3184o.m9537d(this.f8155g), this.f8156h);
            }
            int i = c0292a.f777a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        c3178i.setNextAnim(c0292a.f781e);
                        this.f8149a.m9558a(c3178i, false);
                        break;
                    case 4:
                        c3178i.setNextAnim(c0292a.f781e);
                        this.f8149a.m9604j(c3178i);
                        break;
                    case 5:
                        c3178i.setNextAnim(c0292a.f782f);
                        this.f8149a.m9602i(c3178i);
                        break;
                    case 6:
                        c3178i.setNextAnim(c0292a.f781e);
                        this.f8149a.m9608l(c3178i);
                        break;
                    case 7:
                        c3178i.setNextAnim(c0292a.f782f);
                        this.f8149a.m9606k(c3178i);
                        break;
                    case 8:
                        this.f8149a.m9614o(null);
                        break;
                    case 9:
                        this.f8149a.m9614o(c3178i);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown cmd: ");
                        stringBuilder.append(c0292a.f777a);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            c3178i.setNextAnim(c0292a.f782f);
            this.f8149a.m9599h(c3178i);
            if (!(this.f8168t || c0292a.f777a == 3 || c3178i == null)) {
                this.f8149a.m9590e(c3178i);
            }
        }
        if (!this.f8168t && z) {
            this.f8149a.m9549a(this.f8149a.f8209l, true);
        }
    }

    /* renamed from: a */
    C3178i m9452a(ArrayList<C3178i> arrayList, C3178i c3178i) {
        C3178i c3178i2 = c3178i;
        c3178i = null;
        while (c3178i < this.f8150b.size()) {
            C0292a c0292a = (C0292a) this.f8150b.get(c3178i);
            switch (c0292a.f777a) {
                case 1:
                case 7:
                    arrayList.add(c0292a.f778b);
                    break;
                case 2:
                    C3178i c3178i3 = c0292a.f778b;
                    int i = c3178i3.mContainerId;
                    C3178i c3178i4 = c3178i2;
                    int i2 = c3178i;
                    c3178i = null;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        C3178i c3178i5 = (C3178i) arrayList.get(size);
                        if (c3178i5.mContainerId == i) {
                            if (c3178i5 == c3178i3) {
                                c3178i = true;
                            } else {
                                if (c3178i5 == c3178i4) {
                                    this.f8150b.add(i2, new C0292a(9, c3178i5));
                                    i2++;
                                    c3178i4 = null;
                                }
                                C0292a c0292a2 = new C0292a(3, c3178i5);
                                c0292a2.f779c = c0292a.f779c;
                                c0292a2.f781e = c0292a.f781e;
                                c0292a2.f780d = c0292a.f780d;
                                c0292a2.f782f = c0292a.f782f;
                                this.f8150b.add(i2, c0292a2);
                                arrayList.remove(c3178i5);
                                i2++;
                            }
                        }
                    }
                    if (c3178i != null) {
                        this.f8150b.remove(i2);
                        i2--;
                    } else {
                        c0292a.f777a = 1;
                        arrayList.add(c3178i3);
                    }
                    c3178i = i2;
                    c3178i2 = c3178i4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c0292a.f778b);
                    if (c0292a.f778b != c3178i2) {
                        break;
                    }
                    this.f8150b.add(c3178i, new C0292a(9, c0292a.f778b));
                    c3178i++;
                    c3178i2 = null;
                    break;
                case 8:
                    this.f8150b.add(c3178i, new C0292a(9, c3178i2));
                    c3178i++;
                    c3178i2 = c0292a.f778b;
                    break;
                default:
                    break;
            }
            c3178i += 1;
        }
        return c3178i2;
    }

    /* renamed from: b */
    C3178i m9467b(ArrayList<C3178i> arrayList, C3178i c3178i) {
        for (int i = 0; i < this.f8150b.size(); i++) {
            C0292a c0292a = (C0292a) this.f8150b.get(i);
            int i2 = c0292a.f777a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            c3178i = null;
                            break;
                        case 9:
                            c3178i = c0292a.f778b;
                            break;
                        default:
                            break;
                    }
                }
                arrayList.add(c0292a.f778b);
            }
            arrayList.remove(c0292a.f778b);
        }
        return c3178i;
    }

    /* renamed from: h */
    boolean m9478h() {
        for (int i = 0; i < this.f8150b.size(); i++) {
            if (C3176c.m9451b((C0292a) this.f8150b.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m9461a(C0300c c0300c) {
        for (int i = 0; i < this.f8150b.size(); i++) {
            C0292a c0292a = (C0292a) this.f8150b.get(i);
            if (C3176c.m9451b(c0292a)) {
                c0292a.f778b.setOnStartEnterTransitionListener(c0300c);
            }
        }
    }

    /* renamed from: b */
    private static boolean m9451b(C0292a c0292a) {
        c0292a = c0292a.f778b;
        return (c0292a == null || !c0292a.mAdded || c0292a.mView == null || c0292a.mDetached || c0292a.mHidden || c0292a.isPostponed() == null) ? null : true;
    }

    /* renamed from: i */
    public String m9479i() {
        return this.f8159k;
    }
}
