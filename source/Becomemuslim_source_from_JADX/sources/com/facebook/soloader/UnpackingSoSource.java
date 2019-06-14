package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = (byte) 1;
    private static final byte STATE_CLEAN = (byte) 1;
    private static final byte STATE_DIRTY = (byte) 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    private String[] mAbis;
    protected final Context mContext;
    protected String mCorruptedLib;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) {
            if (dataInput.readByte() == (byte) 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            for (int i = 0; i < this.dsos.length; i++) {
                dataOutput.writeUTF(this.dsos[i].name);
                dataOutput.writeUTF(this.dsos[i].hash);
            }
        }
    }

    protected static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso, InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        public void close() {
            this.content.close();
        }
    }

    protected static abstract class InputDsoIterator implements Closeable {
        public void close() {
        }

        public abstract boolean hasNext();

        public abstract InputDso next();

        protected InputDsoIterator() {
        }
    }

    protected static abstract class Unpacker implements Closeable {
        public void close() {
        }

        protected abstract DsoManifest getDsoManifest();

        protected abstract InputDsoIterator openDsoIterator();

        protected Unpacker() {
        }
    }

    protected abstract Unpacker makeUnpacker();

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getApplicationInfo().dataDir);
        stringBuilder.append("/");
        stringBuilder.append(str);
        return new File(stringBuilder.toString());
    }

    public String[] getSoSourceAbis() {
        if (this.mAbis == null) {
            return super.getSoSourceAbis();
        }
        return this.mAbis;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void writeState(java.io.File r3, byte r4) {
        /*
        r0 = new java.io.RandomAccessFile;
        r1 = "rw";
        r0.<init>(r3, r1);
        r1 = 0;
        r3 = 0;
        r0.seek(r1);	 Catch:{ Throwable -> 0x0024 }
        r0.write(r4);	 Catch:{ Throwable -> 0x0024 }
        r1 = r0.getFilePointer();	 Catch:{ Throwable -> 0x0024 }
        r0.setLength(r1);	 Catch:{ Throwable -> 0x0024 }
        r4 = r0.getFD();	 Catch:{ Throwable -> 0x0024 }
        r4.sync();	 Catch:{ Throwable -> 0x0024 }
        r0.close();
        return;
    L_0x0022:
        r4 = move-exception;
        goto L_0x0026;
    L_0x0024:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x0022 }
    L_0x0026:
        if (r3 == 0) goto L_0x0031;
    L_0x0028:
        r0.close();	 Catch:{ Throwable -> 0x002c }
        goto L_0x0034;
    L_0x002c:
        r0 = move-exception;
        r3.addSuppressed(r0);
        goto L_0x0034;
    L_0x0031:
        r0.close();
    L_0x0034:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.writeState(java.io.File, byte):void");
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                String str2;
                if (!(str2.equals(STATE_FILE_NAME) || str2.equals(LOCK_FILE_NAME) || str2.equals(DEPS_FILE_NAME))) {
                    if (!str2.equals(MANIFEST_FILE_NAME)) {
                        Object obj = null;
                        int i = 0;
                        while (obj == null && i < dsoArr.length) {
                            if (dsoArr[i].name.equals(str2)) {
                                obj = 1;
                            }
                            i++;
                        }
                        if (obj == null) {
                            File file = new File(this.soDirectory, str2);
                            str2 = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("deleting unaccounted-for file ");
                            stringBuilder.append(file);
                            Log.v(str2, stringBuilder.toString());
                            SysUtil.dumbDeleteRecursive(file);
                        }
                    }
                }
            }
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("unable to list directory ");
        stringBuilder2.append(this.soDirectory);
        throw new IOException(stringBuilder2.toString());
    }

    private void extractDso(InputDso inputDso, byte[] bArr) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("extracting DSO ");
        stringBuilder.append(inputDso.dso.name);
        Log.i(str, stringBuilder.toString());
        if (this.soDirectory.setWritable(true, true)) {
            RandomAccessFile randomAccessFile;
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable e) {
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("error overwriting ");
                stringBuilder2.append(file);
                stringBuilder2.append(" trying to delete and start over");
                Log.w(str2, stringBuilder2.toString(), e);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile.getFD(), (long) available);
                }
                SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, null) != null) {
                    randomAccessFile.close();
                    return;
                }
                bArr = new StringBuilder();
                bArr.append("cannot make file executable: ");
                bArr.append(file);
                throw new IOException(bArr.toString());
            } catch (InputDso inputDso2) {
                SysUtil.dumbDeleteRecursive(file);
                throw inputDso2;
            } catch (Throwable th) {
                randomAccessFile.close();
            }
        } else {
            bArr = new StringBuilder();
            bArr.append("cannot make directory writable for us: ");
            bArr.append(this.soDirectory);
            throw new IOException(bArr.toString());
        }
    }

    private void regenerate(byte b, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) {
        Throwable th;
        InputDso next;
        Object obj;
        int i;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("regenerating DSO store ");
        stringBuilder.append(getClass().getName());
        Log.v(str, stringBuilder.toString());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, MANIFEST_FILE_NAME), "rw");
        if (b == (byte) 1) {
            try {
                b = DsoManifest.read(randomAccessFile);
            } catch (byte b2) {
                try {
                    Log.i(TAG, "error reading existing DSO manifest", b2);
                } catch (DsoManifest dsoManifest2) {
                    th.addSuppressed(dsoManifest2);
                }
            }
            if (b2 == (byte) 0) {
                b2 = new DsoManifest(new Dso[0]);
            }
            deleteUnmentionedFiles(dsoManifest2.dsos);
            dsoManifest2 = new byte[32768];
            while (inputDsoIterator.hasNext()) {
                next = inputDsoIterator.next();
                obj = 1;
                i = 0;
                while (obj != null) {
                    try {
                        if (i < b2.dsos.length) {
                            break;
                        }
                        if (b2.dsos[i].name.equals(next.dso.name) && b2.dsos[i].hash.equals(next.dso.hash)) {
                            obj = null;
                        }
                        i++;
                    } catch (DsoManifest dsoManifest22) {
                        DsoManifest dsoManifest3 = dsoManifest22;
                        dsoManifest22 = b2;
                        b2 = dsoManifest3;
                    }
                }
                if (obj != null) {
                    extractDso(next, dsoManifest22);
                }
                if (next != null) {
                    next.close();
                }
            }
            randomAccessFile.close();
            b2 = TAG;
            dsoManifest22 = new StringBuilder();
            dsoManifest22.append("Finished regenerating DSO store ");
            dsoManifest22.append(getClass().getName());
            Log.v(b2, dsoManifest22.toString());
            return;
        }
        b2 = STATE_DIRTY;
        if (b2 == (byte) 0) {
            b2 = new DsoManifest(new Dso[0]);
        }
        deleteUnmentionedFiles(dsoManifest22.dsos);
        dsoManifest22 = new byte[32768];
        while (inputDsoIterator.hasNext()) {
            next = inputDsoIterator.next();
            obj = 1;
            i = 0;
            while (obj != null) {
                if (i < b2.dsos.length) {
                    break;
                }
                obj = null;
                i++;
            }
            if (obj != null) {
                extractDso(next, dsoManifest22);
            }
            if (next != null) {
                next.close();
            }
        }
        randomAccessFile.close();
        b2 = TAG;
        dsoManifest22 = new StringBuilder();
        dsoManifest22.append("Finished regenerating DSO store ");
        dsoManifest22.append(getClass().getName());
        Log.v(b2, dsoManifest22.toString());
        return;
        throw b2;
        if (next != null) {
            if (dsoManifest22 != null) {
                try {
                    next.close();
                } catch (InputDsoIterator inputDsoIterator2) {
                    dsoManifest22.addSuppressed(inputDsoIterator2);
                }
            } else {
                next.close();
            }
        }
        throw b2;
    }

    private boolean refreshLocked(com.facebook.soloader.FileLocker r12, int r13, byte[] r14) {
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
        r11 = this;
        r5 = new java.io.File;
        r0 = r11.soDirectory;
        r1 = "dso_state";
        r5.<init>(r0, r1);
        r0 = new java.io.RandomAccessFile;
        r1 = "rw";
        r0.<init>(r5, r1);
        r7 = 1;
        r1 = 0;
        r2 = 0;
        r3 = r0.readByte();	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        if (r3 == r7) goto L_0x004c;	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
    L_0x0019:
        r3 = "fb-UnpackingSoSource";	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r4 = new java.lang.StringBuilder;	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r4.<init>();	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r6 = "dso store ";	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r4.append(r6);	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r6 = r11.soDirectory;	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r4.append(r6);	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r6 = " regeneration interrupted: wiping clean";	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r4.append(r6);	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        r4 = r4.toString();	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
        android.util.Log.v(r3, r4);	 Catch:{ EOFException -> 0x0036, Throwable -> 0x003a }
    L_0x0036:
        r3 = 0;
        goto L_0x004c;
    L_0x0038:
        r12 = move-exception;
        goto L_0x003d;
    L_0x003a:
        r12 = move-exception;
        r1 = r12;
        throw r1;	 Catch:{ all -> 0x0038 }
    L_0x003d:
        if (r1 == 0) goto L_0x0048;
    L_0x003f:
        r0.close();	 Catch:{ Throwable -> 0x0043 }
        goto L_0x004b;
    L_0x0043:
        r13 = move-exception;
        r1.addSuppressed(r13);
        goto L_0x004b;
    L_0x0048:
        r0.close();
    L_0x004b:
        throw r12;
    L_0x004c:
        r0.close();
        r4 = new java.io.File;
        r0 = r11.soDirectory;
        r6 = "dso_deps";
        r4.<init>(r0, r6);
        r0 = new java.io.RandomAccessFile;
        r6 = "rw";
        r0.<init>(r4, r6);
        r8 = r0.length();	 Catch:{ Throwable -> 0x011e }
        r6 = (int) r8;	 Catch:{ Throwable -> 0x011e }
        r6 = new byte[r6];	 Catch:{ Throwable -> 0x011e }
        r8 = r0.read(r6);	 Catch:{ Throwable -> 0x011e }
        r9 = r6.length;	 Catch:{ Throwable -> 0x011e }
        if (r8 == r9) goto L_0x0075;	 Catch:{ Throwable -> 0x011e }
    L_0x006d:
        r3 = "fb-UnpackingSoSource";	 Catch:{ Throwable -> 0x011e }
        r8 = "short read of so store deps file: marking unclean";	 Catch:{ Throwable -> 0x011e }
        android.util.Log.v(r3, r8);	 Catch:{ Throwable -> 0x011e }
        r3 = 0;	 Catch:{ Throwable -> 0x011e }
    L_0x0075:
        r6 = java.util.Arrays.equals(r6, r14);	 Catch:{ Throwable -> 0x011e }
        if (r6 != 0) goto L_0x0083;	 Catch:{ Throwable -> 0x011e }
    L_0x007b:
        r3 = "fb-UnpackingSoSource";	 Catch:{ Throwable -> 0x011e }
        r6 = "deps mismatch on deps store: regenerating";	 Catch:{ Throwable -> 0x011e }
        android.util.Log.v(r3, r6);	 Catch:{ Throwable -> 0x011e }
        r3 = 0;	 Catch:{ Throwable -> 0x011e }
    L_0x0083:
        if (r3 == 0) goto L_0x008c;	 Catch:{ Throwable -> 0x011e }
    L_0x0085:
        r6 = r13 & 2;	 Catch:{ Throwable -> 0x011e }
        if (r6 == 0) goto L_0x008a;	 Catch:{ Throwable -> 0x011e }
    L_0x0089:
        goto L_0x008c;	 Catch:{ Throwable -> 0x011e }
    L_0x008a:
        r8 = r1;	 Catch:{ Throwable -> 0x011e }
        goto L_0x00af;	 Catch:{ Throwable -> 0x011e }
    L_0x008c:
        r6 = "fb-UnpackingSoSource";	 Catch:{ Throwable -> 0x011e }
        r8 = "so store dirty: regenerating";	 Catch:{ Throwable -> 0x011e }
        android.util.Log.v(r6, r8);	 Catch:{ Throwable -> 0x011e }
        writeState(r5, r2);	 Catch:{ Throwable -> 0x011e }
        r6 = r11.makeUnpacker();	 Catch:{ Throwable -> 0x011e }
        r8 = r6.getDsoManifest();	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
        r9 = r6.openDsoIterator();	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
        r11.regenerate(r3, r8, r9);	 Catch:{ Throwable -> 0x00eb, all -> 0x00e8 }
        if (r9 == 0) goto L_0x00aa;
    L_0x00a7:
        r9.close();	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
    L_0x00aa:
        if (r6 == 0) goto L_0x00af;
    L_0x00ac:
        r6.close();	 Catch:{ Throwable -> 0x011e }
    L_0x00af:
        r0.close();
        if (r8 != 0) goto L_0x00b5;
    L_0x00b4:
        return r2;
    L_0x00b5:
        r9 = new com.facebook.soloader.UnpackingSoSource$1;
        r0 = r9;
        r1 = r11;
        r2 = r4;
        r3 = r14;
        r4 = r8;
        r6 = r12;
        r0.<init>(r2, r3, r4, r5, r6);
        r12 = r13 & 1;
        if (r12 == 0) goto L_0x00e4;
    L_0x00c4:
        r12 = new java.lang.Thread;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "SoSync:";
        r13.append(r14);
        r14 = r11.soDirectory;
        r14 = r14.getName();
        r13.append(r14);
        r13 = r13.toString();
        r12.<init>(r9, r13);
        r12.start();
        goto L_0x00e7;
    L_0x00e4:
        r9.run();
    L_0x00e7:
        return r7;
    L_0x00e8:
        r12 = move-exception;
        r13 = r1;
        goto L_0x00f1;
    L_0x00eb:
        r12 = move-exception;
        throw r12;	 Catch:{ all -> 0x00ed }
    L_0x00ed:
        r13 = move-exception;
        r10 = r13;
        r13 = r12;
        r12 = r10;
    L_0x00f1:
        if (r9 == 0) goto L_0x0101;
    L_0x00f3:
        if (r13 == 0) goto L_0x00fe;
    L_0x00f5:
        r9.close();	 Catch:{ Throwable -> 0x00f9, all -> 0x0102 }
        goto L_0x0101;
    L_0x00f9:
        r14 = move-exception;
        r13.addSuppressed(r14);	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
        goto L_0x0101;	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
    L_0x00fe:
        r9.close();	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
    L_0x0101:
        throw r12;	 Catch:{ Throwable -> 0x0105, all -> 0x0102 }
    L_0x0102:
        r12 = move-exception;
        r13 = r1;
        goto L_0x010b;
    L_0x0105:
        r12 = move-exception;
        throw r12;	 Catch:{ all -> 0x0107 }
    L_0x0107:
        r13 = move-exception;
        r10 = r13;
        r13 = r12;
        r12 = r10;
    L_0x010b:
        if (r6 == 0) goto L_0x011b;
    L_0x010d:
        if (r13 == 0) goto L_0x0118;
    L_0x010f:
        r6.close();	 Catch:{ Throwable -> 0x0113 }
        goto L_0x011b;
    L_0x0113:
        r14 = move-exception;
        r13.addSuppressed(r14);	 Catch:{ Throwable -> 0x011e }
        goto L_0x011b;	 Catch:{ Throwable -> 0x011e }
    L_0x0118:
        r6.close();	 Catch:{ Throwable -> 0x011e }
    L_0x011b:
        throw r12;	 Catch:{ Throwable -> 0x011e }
    L_0x011c:
        r12 = move-exception;
        goto L_0x0121;
    L_0x011e:
        r12 = move-exception;
        r1 = r12;
        throw r1;	 Catch:{ all -> 0x011c }
    L_0x0121:
        if (r1 == 0) goto L_0x012c;
    L_0x0123:
        r0.close();	 Catch:{ Throwable -> 0x0127 }
        goto L_0x012f;
    L_0x0127:
        r13 = move-exception;
        r1.addSuppressed(r13);
        goto L_0x012f;
    L_0x012c:
        r0.close();
    L_0x012f:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    protected byte[] getDepsBlock() {
        Throwable th;
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    protected void prepare(int i) {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        try {
            String str = TAG;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("locked dso store ");
            stringBuilder3.append(this.soDirectory);
            Log.v(str, stringBuilder3.toString());
            if (refreshLocked(lock, i, getDepsBlock()) != 0) {
                lock = null;
            } else {
                i = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("dso store is up-to-date: ");
                stringBuilder.append(this.soDirectory);
                Log.i(i, stringBuilder.toString());
            }
            if (lock != null) {
                i = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("releasing dso store lock for ");
                stringBuilder.append(this.soDirectory);
                Log.v(i, stringBuilder.toString());
                lock.close();
                return;
            }
            i = TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("not releasing dso store lock for ");
            stringBuilder2.append(this.soDirectory);
            stringBuilder2.append(" (syncer thread started)");
            Log.v(i, stringBuilder2.toString());
        } catch (Throwable th) {
            if (lock != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("releasing dso store lock for ");
                stringBuilder.append(this.soDirectory);
                Log.v(TAG, stringBuilder.toString());
                lock.close();
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("not releasing dso store lock for ");
                stringBuilder2.append(this.soDirectory);
                stringBuilder2.append(" (syncer thread started)");
                Log.v(TAG, stringBuilder2.toString());
            }
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    protected synchronized void prepare(String str) {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    public int loadLibrary(String str, int i, ThreadPolicy threadPolicy) {
        synchronized (getLibraryLock(str)) {
            str = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return str;
    }
}
