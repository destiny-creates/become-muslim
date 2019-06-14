package expo.modules.filesystem;

import android.content.Context;
import expo.p304a.p305a.C5998e;
import expo.p307b.p312e.C6026a;
import expo.p307b.p312e.C6027b;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class FilePermissionModule implements C5998e, C6026a {
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C6026a.class);
    }

    public EnumSet<C6027b> getPathPermissions(Context context, String str) {
        context = getInternalPathPermissions(str, context);
        return context == null ? getExternalPathPermissions(str) : context;
    }

    protected java.util.EnumSet<expo.p307b.p312e.C6027b> getInternalPathPermissions(java.lang.String r4, android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.io.File;	 Catch:{ IOException -> 0x0045 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0045 }
        r4 = r0.getCanonicalPath();	 Catch:{ IOException -> 0x0045 }
        r5 = r3.getInternalPaths(r5);	 Catch:{ IOException -> 0x0045 }
        r5 = r5.iterator();	 Catch:{ IOException -> 0x0045 }
    L_0x0011:
        r0 = r5.hasNext();	 Catch:{ IOException -> 0x0045 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ IOException -> 0x0045 }
    L_0x0017:
        r0 = r5.next();	 Catch:{ IOException -> 0x0045 }
        r0 = (java.lang.String) r0;	 Catch:{ IOException -> 0x0045 }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0045 }
        r1.<init>();	 Catch:{ IOException -> 0x0045 }
        r1.append(r0);	 Catch:{ IOException -> 0x0045 }
        r2 = "/";	 Catch:{ IOException -> 0x0045 }
        r1.append(r2);	 Catch:{ IOException -> 0x0045 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0045 }
        r1 = r4.startsWith(r1);	 Catch:{ IOException -> 0x0045 }
        if (r1 != 0) goto L_0x003a;	 Catch:{ IOException -> 0x0045 }
    L_0x0034:
        r0 = r0.equals(r4);	 Catch:{ IOException -> 0x0045 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ IOException -> 0x0045 }
    L_0x003a:
        r4 = expo.p307b.p312e.C6027b.READ;	 Catch:{ IOException -> 0x0045 }
        r5 = expo.p307b.p312e.C6027b.WRITE;	 Catch:{ IOException -> 0x0045 }
        r4 = java.util.EnumSet.of(r4, r5);	 Catch:{ IOException -> 0x0045 }
        return r4;
    L_0x0043:
        r4 = 0;
        return r4;
    L_0x0045:
        r4 = expo.p307b.p312e.C6027b.class;
        r4 = java.util.EnumSet.noneOf(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FilePermissionModule.getInternalPathPermissions(java.lang.String, android.content.Context):java.util.EnumSet<expo.b.e.b>");
    }

    protected EnumSet<C6027b> getExternalPathPermissions(String str) {
        File file = new File(str);
        if (file.canWrite() != null && file.canRead() != null) {
            return EnumSet.of(C6027b.READ, C6027b.WRITE);
        }
        if (file.canWrite() != null) {
            return EnumSet.of(C6027b.WRITE);
        }
        if (file.canRead() != null) {
            return EnumSet.of(C6027b.READ);
        }
        return EnumSet.noneOf(C6027b.class);
    }

    protected List<String> getInternalPaths(Context context) {
        return Arrays.asList(new String[]{context.getFilesDir().getCanonicalPath(), context.getCacheDir().getCanonicalPath()});
    }
}
