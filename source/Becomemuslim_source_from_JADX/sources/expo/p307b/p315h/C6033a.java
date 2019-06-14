package expo.p307b.p315h;

/* compiled from: Permissions */
/* renamed from: expo.b.h.a */
public interface C6033a {

    /* compiled from: Permissions */
    /* renamed from: expo.b.h.a$a */
    public interface C6031a {
        /* renamed from: a */
        void m25168a(int i);
    }

    /* compiled from: Permissions */
    /* renamed from: expo.b.h.a$b */
    public interface C6032b {
        void onPermissionsResult(int[] iArr);
    }

    void askForPermissions(String[] strArr, C6032b c6032b);

    int getPermission(String str);

    int[] getPermissions(String[] strArr);
}
