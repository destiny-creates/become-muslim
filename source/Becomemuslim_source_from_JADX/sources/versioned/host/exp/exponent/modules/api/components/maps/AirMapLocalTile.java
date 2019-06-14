package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5147x;
import com.google.android.gms.maps.model.C5148z;
import com.google.android.gms.maps.model.C7856w;
import com.google.android.gms.maps.model.C7857y;

public class AirMapLocalTile extends AirMapFeature {
    private String pathTemplate;
    private C5147x tileOverlay;
    private C7857y tileOverlayOptions;
    private AIRMapLocalTileProvider tileProvider;
    private float tileSize;
    private float zIndex;

    class AIRMapLocalTileProvider implements C5148z {
        private static final int BUFFER_SIZE = 16384;
        private String pathTemplate;
        private int tileSize;

        public AIRMapLocalTileProvider(int i, String str) {
            this.tileSize = i;
            this.pathTemplate = str;
        }

        public C7856w getTile(int i, int i2, int i3) {
            i = readTileImage(i, i2, i3);
            return i == 0 ? C5148z.f17421a : new C7856w(this.tileSize, this.tileSize, i);
        }

        public void setPathTemplate(String str) {
            this.pathTemplate = str;
        }

        public void setTileSize(int i) {
            this.tileSize = i;
        }

        private byte[] readTileImage(int r7, int r8, int r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = new java.io.File;
            r7 = r6.getTileFilename(r7, r8, r9);
            r0.<init>(r7);
            r7 = 0;
            r8 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0059, OutOfMemoryError -> 0x0046, all -> 0x0041 }
            r8.<init>(r0);	 Catch:{ IOException -> 0x0059, OutOfMemoryError -> 0x0046, all -> 0x0041 }
            r9 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x003e, OutOfMemoryError -> 0x003b, all -> 0x0036 }
            r9.<init>();	 Catch:{ IOException -> 0x003e, OutOfMemoryError -> 0x003b, all -> 0x0036 }
            r0 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            r1 = new byte[r0];	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
        L_0x0018:
            r2 = 0;	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            r3 = r8.read(r1, r2, r0);	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            r4 = -1;	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            if (r3 == r4) goto L_0x0024;	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
        L_0x0020:
            r9.write(r1, r2, r3);	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            goto L_0x0018;	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
        L_0x0024:
            r9.flush();	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            r0 = r9.toByteArray();	 Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            r8.close();	 Catch:{ Exception -> 0x002e }
        L_0x002e:
            r9.close();	 Catch:{ Exception -> 0x0031 }
        L_0x0031:
            return r0;
        L_0x0032:
            r0 = move-exception;
            goto L_0x0049;
        L_0x0034:
            r0 = move-exception;
            goto L_0x005c;
        L_0x0036:
            r9 = move-exception;
            r5 = r9;
            r9 = r7;
            r7 = r5;
            goto L_0x006d;
        L_0x003b:
            r0 = move-exception;
            r9 = r7;
            goto L_0x0049;
        L_0x003e:
            r0 = move-exception;
            r9 = r7;
            goto L_0x005c;
        L_0x0041:
            r8 = move-exception;
            r9 = r7;
            r7 = r8;
            r8 = r9;
            goto L_0x006d;
        L_0x0046:
            r0 = move-exception;
            r8 = r7;
            r9 = r8;
        L_0x0049:
            r0.printStackTrace();	 Catch:{ all -> 0x006c }
            if (r8 == 0) goto L_0x0053;
        L_0x004e:
            r8.close();	 Catch:{ Exception -> 0x0052 }
            goto L_0x0053;
        L_0x0053:
            if (r9 == 0) goto L_0x0058;
        L_0x0055:
            r9.close();	 Catch:{ Exception -> 0x0058 }
        L_0x0058:
            return r7;
        L_0x0059:
            r0 = move-exception;
            r8 = r7;
            r9 = r8;
        L_0x005c:
            r0.printStackTrace();	 Catch:{ all -> 0x006c }
            if (r8 == 0) goto L_0x0066;
        L_0x0061:
            r8.close();	 Catch:{ Exception -> 0x0065 }
            goto L_0x0066;
        L_0x0066:
            if (r9 == 0) goto L_0x006b;
        L_0x0068:
            r9.close();	 Catch:{ Exception -> 0x006b }
        L_0x006b:
            return r7;
        L_0x006c:
            r7 = move-exception;
        L_0x006d:
            if (r8 == 0) goto L_0x0074;
        L_0x006f:
            r8.close();	 Catch:{ Exception -> 0x0073 }
            goto L_0x0074;
        L_0x0074:
            if (r9 == 0) goto L_0x0079;
        L_0x0076:
            r9.close();	 Catch:{ Exception -> 0x0079 }
        L_0x0079:
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.maps.AirMapLocalTile.AIRMapLocalTileProvider.readTileImage(int, int, int):byte[]");
        }

        private String getTileFilename(int i, int i2, int i3) {
            return this.pathTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
        }
    }

    public AirMapLocalTile(Context context) {
        super(context);
    }

    public void setPathTemplate(String str) {
        this.pathTemplate = str;
        if (this.tileProvider != null) {
            this.tileProvider.setPathTemplate(str);
        }
        if (this.tileOverlay != null) {
            this.tileOverlay.m21830b();
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.tileOverlay != null) {
            this.tileOverlay.m21829a(f);
        }
    }

    public void setTileSize(float f) {
        this.tileSize = f;
        if (this.tileProvider != null) {
            this.tileProvider.setTileSize((int) f);
        }
    }

    public C7857y getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    private C7857y createTileOverlayOptions() {
        C7857y c7857y = new C7857y();
        c7857y.m38380a(this.zIndex);
        this.tileProvider = new AIRMapLocalTileProvider((int) this.tileSize, this.pathTemplate);
        c7857y.m38381a(this.tileProvider);
        return c7857y;
    }

    public Object getFeature() {
        return this.tileOverlay;
    }

    public void addToMap(C5125c c5125c) {
        this.tileOverlay = c5125c.m21705a(getTileOverlayOptions());
    }

    public void removeFromMap(C5125c c5125c) {
        this.tileOverlay.m21828a();
    }
}
