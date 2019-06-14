package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource.Dso;
import com.facebook.soloader.UnpackingSoSource.DsoManifest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class ExoSoSource extends UnpackingSoSource {

    private final class ExoUnpacker extends Unpacker {
        private final FileDso[] mDsos;
        final /* synthetic */ ExoSoSource this$0;

        private final class FileBackedInputDsoIterator extends InputDsoIterator {
            private int mCurrentDso;

            private FileBackedInputDsoIterator() {
            }

            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            public InputDso next() {
                FileDso[] access$100 = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                Dso dso = access$100[i];
                InputStream fileInputStream = new FileInputStream(dso.backingFile);
                try {
                    return new InputDso(dso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                }
            }
        }

        ExoUnpacker(com.facebook.soloader.ExoSoSource r18, com.facebook.soloader.UnpackingSoSource r19) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r17 = this;
            r1 = r17;
            r0 = r18;
            r1.this$0 = r0;
            r17.<init>();
            r0 = r0.mContext;
            r2 = new java.io.File;
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "/data/local/tmp/exopackage/";
            r3.append(r4);
            r0 = r0.getPackageName();
            r3.append(r0);
            r0 = "/native-libs/";
            r3.append(r0);
            r0 = r3.toString();
            r2.<init>(r0);
            r0 = new java.util.ArrayList;
            r0.<init>();
            r3 = new java.util.LinkedHashSet;
            r3.<init>();
            r4 = com.facebook.soloader.SysUtil.getSupportedAbis();
            r5 = r4.length;
            r6 = 0;
            r7 = 0;
        L_0x003b:
            if (r7 >= r5) goto L_0x0120;
        L_0x003d:
            r8 = r4[r7];
            r9 = new java.io.File;
            r9.<init>(r2, r8);
            r10 = r9.isDirectory();
            if (r10 != 0) goto L_0x004c;
        L_0x004a:
            goto L_0x00e9;
        L_0x004c:
            r3.add(r8);
            r8 = new java.io.File;
            r10 = "metadata.txt";
            r8.<init>(r9, r10);
            r10 = r8.isFile();
            if (r10 != 0) goto L_0x005e;
        L_0x005c:
            goto L_0x00e9;
        L_0x005e:
            r10 = new java.io.FileReader;
            r10.<init>(r8);
            r11 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
            r11.<init>(r10);	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
        L_0x0068:
            r12 = r11.readLine();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            if (r12 == 0) goto L_0x00e3;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x006e:
            r13 = r12.length();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            if (r13 != 0) goto L_0x0075;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x0074:
            goto L_0x0068;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x0075:
            r13 = 32;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r13 = r12.indexOf(r13);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r14 = -1;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            if (r13 == r14) goto L_0x00c7;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x007e:
            r14 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r14.<init>();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r15 = r12.substring(r6, r13);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r14.append(r15);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r15 = ".so";	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r14.append(r15);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r14 = r14.toString();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r15 = r0.size();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x0097:
            if (r6 >= r15) goto L_0x00ae;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x0099:
            r16 = r0.get(r6);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r8 = r16;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r8 = (com.facebook.soloader.ExoSoSource.FileDso) r8;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r8 = r8.name;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r8 = r8.equals(r14);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            if (r8 == 0) goto L_0x00ab;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00a9:
            r6 = 1;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            goto L_0x00af;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00ab:
            r6 = r6 + 1;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            goto L_0x0097;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00ae:
            r6 = 0;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00af:
            if (r6 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00b1:
            r6 = 0;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            goto L_0x0068;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00b3:
            r13 = r13 + 1;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r6 = r12.substring(r13);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r8 = new com.facebook.soloader.ExoSoSource$FileDso;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r12 = new java.io.File;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r12.<init>(r9, r6);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r8.<init>(r14, r6, r12);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r0.add(r8);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            goto L_0x00b1;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00c7:
            r0 = new java.lang.RuntimeException;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r2.<init>();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r3 = "illegal line in exopackage metadata: [";	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r2.append(r3);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r2.append(r12);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r3 = "]";	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r2.append(r3);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r2 = r2.toString();	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            r0.<init>(r2);	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            throw r0;	 Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
        L_0x00e3:
            r11.close();	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
            r10.close();
        L_0x00e9:
            r7 = r7 + 1;
            r6 = 0;
            goto L_0x003b;
        L_0x00ee:
            r0 = move-exception;
            r2 = r0;
            r8 = 0;
            goto L_0x00f7;
        L_0x00f2:
            r0 = move-exception;
            r8 = r0;
            throw r8;	 Catch:{ all -> 0x00f5 }
        L_0x00f5:
            r0 = move-exception;
            r2 = r0;
        L_0x00f7:
            if (r8 == 0) goto L_0x0103;
        L_0x00f9:
            r11.close();	 Catch:{ Throwable -> 0x00fd, all -> 0x0107 }
            goto L_0x0106;
        L_0x00fd:
            r0 = move-exception;
            r3 = r0;
            r8.addSuppressed(r3);	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
            goto L_0x0106;	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
        L_0x0103:
            r11.close();	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
        L_0x0106:
            throw r2;	 Catch:{ Throwable -> 0x010b, all -> 0x0107 }
        L_0x0107:
            r0 = move-exception;
            r2 = r0;
            r8 = 0;
            goto L_0x0110;
        L_0x010b:
            r0 = move-exception;
            r8 = r0;
            throw r8;	 Catch:{ all -> 0x010e }
        L_0x010e:
            r0 = move-exception;
            r2 = r0;
        L_0x0110:
            if (r8 == 0) goto L_0x011c;
        L_0x0112:
            r10.close();	 Catch:{ Throwable -> 0x0116 }
            goto L_0x011f;
        L_0x0116:
            r0 = move-exception;
            r3 = r0;
            r8.addSuppressed(r3);
            goto L_0x011f;
        L_0x011c:
            r10.close();
        L_0x011f:
            throw r2;
        L_0x0120:
            r2 = r3.size();
            r2 = new java.lang.String[r2];
            r2 = r3.toArray(r2);
            r2 = (java.lang.String[]) r2;
            r3 = r19;
            r3.setSoSourceAbis(r2);
            r2 = r0.size();
            r2 = new com.facebook.soloader.ExoSoSource.FileDso[r2];
            r0 = r0.toArray(r2);
            r0 = (com.facebook.soloader.ExoSoSource.FileDso[]) r0;
            r1.mDsos = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.ExoUnpacker.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.UnpackingSoSource):void");
        }

        protected DsoManifest getDsoManifest() {
            return new DsoManifest(this.mDsos);
        }

        protected InputDsoIterator openDsoIterator() {
            return new FileBackedInputDsoIterator();
        }
    }

    private static final class FileDso extends Dso {
        final File backingFile;

        FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    protected Unpacker makeUnpacker() {
        return new ExoUnpacker(this, this);
    }
}
