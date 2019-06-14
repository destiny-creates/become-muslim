package versioned.host.exp.exponent.modules.universal;

import expo.modules.filesystem.FilePermissionModule;
import expo.p304a.C6007d;
import expo.p304a.p305a.C6001h;
import expo.p307b.p310c.C6023a;
import host.exp.exponent.p346j.C6393j;

public class ScopedFilePermissionModule extends FilePermissionModule implements C6001h {
    private C6007d mModuleRegistry;
    private C6393j mScopedContext;

    public ScopedFilePermissionModule(C6393j c6393j) {
        this.mScopedContext = c6393j;
    }

    protected java.util.EnumSet<expo.p307b.p312e.C6027b> getExternalPathPermissions(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.mScopedContext;	 Catch:{ IOException -> 0x004c }
        r0 = r0.m26224a();	 Catch:{ IOException -> 0x004c }
        r1 = new java.io.File;	 Catch:{ IOException -> 0x004c }
        r0 = r0.getApplicationInfo();	 Catch:{ IOException -> 0x004c }
        r0 = r0.dataDir;	 Catch:{ IOException -> 0x004c }
        r1.<init>(r0);	 Catch:{ IOException -> 0x004c }
        r0 = r1.getCanonicalPath();	 Catch:{ IOException -> 0x004c }
        r1 = new java.io.File;	 Catch:{ IOException -> 0x004c }
        r1.<init>(r5);	 Catch:{ IOException -> 0x004c }
        r1 = r1.getCanonicalPath();	 Catch:{ IOException -> 0x004c }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x004c }
        r2.<init>();	 Catch:{ IOException -> 0x004c }
        r2.append(r0);	 Catch:{ IOException -> 0x004c }
        r3 = "/";	 Catch:{ IOException -> 0x004c }
        r2.append(r3);	 Catch:{ IOException -> 0x004c }
        r2 = r2.toString();	 Catch:{ IOException -> 0x004c }
        r2 = r1.startsWith(r2);	 Catch:{ IOException -> 0x004c }
        r0 = r1.equals(r0);	 Catch:{ IOException -> 0x004c }
        r0 = r0 | r2;	 Catch:{ IOException -> 0x004c }
        r1 = r4.shouldForbidAccessToDataDirectory();	 Catch:{ IOException -> 0x004c }
        if (r1 == 0) goto L_0x0047;	 Catch:{ IOException -> 0x004c }
    L_0x003e:
        if (r0 == 0) goto L_0x0047;	 Catch:{ IOException -> 0x004c }
    L_0x0040:
        r5 = expo.p307b.p312e.C6027b.class;	 Catch:{ IOException -> 0x004c }
        r5 = java.util.EnumSet.noneOf(r5);	 Catch:{ IOException -> 0x004c }
        return r5;
    L_0x0047:
        r5 = super.getExternalPathPermissions(r5);
        return r5;
    L_0x004c:
        r5 = expo.p307b.p312e.C6027b.class;
        r5 = java.util.EnumSet.noneOf(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.universal.ScopedFilePermissionModule.getExternalPathPermissions(java.lang.String):java.util.EnumSet<expo.b.e.b>");
    }

    private boolean shouldForbidAccessToDataDirectory() {
        C6023a c6023a = (C6023a) this.mModuleRegistry.m25133a(C6023a.class);
        return c6023a != null && "expo".equals(c6023a.getAppOwnership());
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }
}
