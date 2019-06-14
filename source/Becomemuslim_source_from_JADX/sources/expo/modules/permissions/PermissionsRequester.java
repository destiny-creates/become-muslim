package expo.modules.permissions;

import expo.p304a.C6007d;
import expo.p307b.p315h.C6034b;
import expo.p307b.p315h.C6035c;

public class PermissionsRequester {
    private static final int PERMISSIONS_REQUEST = 13;
    private C6035c mPermissionManager;

    PermissionsRequester(C6007d c6007d) {
        this.mPermissionManager = (C6035c) c6007d.m25133a(C6035c.class);
    }

    boolean askForPermissions(String[] strArr, C6034b c6034b) {
        if (this.mPermissionManager == null) {
            return null;
        }
        this.mPermissionManager.requestPermissions(strArr, 13, c6034b);
        return 1;
    }
}
