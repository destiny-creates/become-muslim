package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RemoteInput */
public final class ah {
    /* renamed from: a */
    private final String f766a;
    /* renamed from: b */
    private final CharSequence f767b;
    /* renamed from: c */
    private final CharSequence[] f768c;
    /* renamed from: d */
    private final boolean f769d;
    /* renamed from: e */
    private final Bundle f770e;
    /* renamed from: f */
    private final Set<String> f771f;

    /* compiled from: RemoteInput */
    /* renamed from: android.support.v4.app.ah$a */
    public static final class C0286a {
        /* renamed from: a */
        private final String f760a;
        /* renamed from: b */
        private CharSequence f761b;
        /* renamed from: c */
        private CharSequence[] f762c;
        /* renamed from: d */
        private boolean f763d = true;
        /* renamed from: e */
        private Bundle f764e = new Bundle();
        /* renamed from: f */
        private final Set<String> f765f = new HashSet();

        public C0286a(String str) {
            if (str != null) {
                this.f760a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        /* renamed from: a */
        public C0286a m837a(CharSequence charSequence) {
            this.f761b = charSequence;
            return this;
        }

        /* renamed from: a */
        public ah m838a() {
            return new ah(this.f760a, this.f761b, this.f762c, this.f763d, this.f764e, this.f765f);
        }
    }

    ah(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
        this.f766a = str;
        this.f767b = charSequence;
        this.f768c = charSequenceArr;
        this.f769d = z;
        this.f770e = bundle;
        this.f771f = set;
    }

    /* renamed from: a */
    public String m841a() {
        return this.f766a;
    }

    /* renamed from: b */
    public CharSequence m842b() {
        return this.f767b;
    }

    /* renamed from: c */
    public CharSequence[] m843c() {
        return this.f768c;
    }

    /* renamed from: d */
    public Set<String> m844d() {
        return this.f771f;
    }

    /* renamed from: e */
    public boolean m845e() {
        return (m846f() || ((m843c() != null && m843c().length != 0) || m844d() == null || m844d().isEmpty())) ? false : true;
    }

    /* renamed from: f */
    public boolean m846f() {
        return this.f769d;
    }

    /* renamed from: g */
    public Bundle m847g() {
        return this.f770e;
    }

    /* renamed from: a */
    static RemoteInput[] m840a(ah[] ahVarArr) {
        if (ahVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[ahVarArr.length];
        for (int i = 0; i < ahVarArr.length; i++) {
            remoteInputArr[i] = m839a(ahVarArr[i]);
        }
        return remoteInputArr;
    }

    /* renamed from: a */
    static RemoteInput m839a(ah ahVar) {
        return new Builder(ahVar.m841a()).setLabel(ahVar.m842b()).setChoices(ahVar.m843c()).setAllowFreeFormInput(ahVar.m846f()).addExtras(ahVar.m847g()).build();
    }
}
