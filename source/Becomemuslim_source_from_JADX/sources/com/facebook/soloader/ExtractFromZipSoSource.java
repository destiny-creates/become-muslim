package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource.Dso;
import com.facebook.soloader.UnpackingSoSource.DsoManifest;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtractFromZipSoSource extends UnpackingSoSource {
    protected final File mZipFileName;
    protected final String mZipSearchPattern;

    private static final class ZipDso extends Dso implements Comparable {
        final int abiScore;
        final ZipEntry backingEntry;

        ZipDso(String str, ZipEntry zipEntry, int i) {
            super(str, makePseudoHash(zipEntry));
            this.backingEntry = zipEntry;
            this.abiScore = i;
        }

        private static String makePseudoHash(ZipEntry zipEntry) {
            return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", new Object[]{zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())});
        }

        public int compareTo(Object obj) {
            return this.name.compareTo(((ZipDso) obj).name);
        }
    }

    protected class ZipUnpacker extends Unpacker {
        private ZipDso[] mDsos;
        private final UnpackingSoSource mSoSource;
        private final ZipFile mZipFile;

        private final class ZipBackedInputDsoIterator extends InputDsoIterator {
            private int mCurrentDso;

            private ZipBackedInputDsoIterator() {
            }

            public boolean hasNext() {
                ZipUnpacker.this.ensureDsos();
                return this.mCurrentDso < ZipUnpacker.this.mDsos.length;
            }

            public InputDso next() {
                ZipUnpacker.this.ensureDsos();
                ZipDso[] access$100 = ZipUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                Dso dso = access$100[i];
                InputStream inputStream = ZipUnpacker.this.mZipFile.getInputStream(dso.backingEntry);
                try {
                    return new InputDso(dso, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }

        protected boolean shouldExtract(ZipEntry zipEntry, String str) {
            return true;
        }

        ZipUnpacker(UnpackingSoSource unpackingSoSource) {
            this.mZipFile = new ZipFile(ExtractFromZipSoSource.this.mZipFileName);
            this.mSoSource = unpackingSoSource;
        }

        final ZipDso[] ensureDsos() {
            if (this.mDsos == null) {
                ZipDso zipDso;
                Set linkedHashSet = new LinkedHashSet();
                HashMap hashMap = new HashMap();
                Pattern compile = Pattern.compile(ExtractFromZipSoSource.this.mZipSearchPattern);
                String[] supportedAbis = SysUtil.getSupportedAbis();
                Enumeration entries = this.mZipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    Matcher matcher = compile.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        int findAbiScore = SysUtil.findAbiScore(supportedAbis, group);
                        if (findAbiScore >= 0) {
                            linkedHashSet.add(group);
                            ZipDso zipDso2 = (ZipDso) hashMap.get(group2);
                            if (zipDso2 == null || findAbiScore < zipDso2.abiScore) {
                                hashMap.put(group2, new ZipDso(group2, zipEntry, findAbiScore));
                            }
                        }
                    }
                }
                this.mSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
                ZipDso[] zipDsoArr = (ZipDso[]) hashMap.values().toArray(new ZipDso[hashMap.size()]);
                Arrays.sort(zipDsoArr);
                int i = 0;
                for (int i2 = 0; i2 < zipDsoArr.length; i2++) {
                    zipDso = zipDsoArr[i2];
                    if (shouldExtract(zipDso.backingEntry, zipDso.name)) {
                        i++;
                    } else {
                        zipDsoArr[i2] = null;
                    }
                }
                ZipDso[] zipDsoArr2 = new ZipDso[i];
                i = 0;
                for (ZipDso zipDso3 : zipDsoArr) {
                    if (zipDso3 != null) {
                        int i3 = i + 1;
                        zipDsoArr2[i] = zipDso3;
                        i = i3;
                    }
                }
                this.mDsos = zipDsoArr2;
            }
            return this.mDsos;
        }

        public void close() {
            this.mZipFile.close();
        }

        protected final DsoManifest getDsoManifest() {
            return new DsoManifest(ensureDsos());
        }

        protected final InputDsoIterator openDsoIterator() {
            return new ZipBackedInputDsoIterator();
        }
    }

    public ExtractFromZipSoSource(Context context, String str, File file, String str2) {
        super(context, str);
        this.mZipFileName = file;
        this.mZipSearchPattern = str2;
    }

    protected Unpacker makeUnpacker() {
        return new ZipUnpacker(this);
    }
}
