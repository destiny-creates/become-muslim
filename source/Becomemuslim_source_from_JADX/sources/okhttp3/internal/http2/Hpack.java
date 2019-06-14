package okhttp3.internal.http2;

import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.places.model.PlaceFields;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import p286d.C5869f;
import p286d.C5870l;
import p286d.C5876t;
import p286d.C7204e;
import p286d.C8037c;

final class Hpack {
    static final Map<C5869f, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, UriUtil.HTTP_SCHEME), new Header(Header.TARGET_SCHEME, UriUtil.HTTPS_SCHEME), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(PlaceFields.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final C7204e source;

        Reader(int i, C5876t c5876t) {
            this(i, i, c5876t);
        }

        Reader(int i, int i2, C5876t c5876t) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = C5870l.m24720a(c5876t);
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount >= this.dynamicTableByteCount) {
                return;
            }
            if (this.maxDynamicTableByteCount == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.dynamicTable.length - 1; length >= this.nextHeaderIndex && i > 0; length--) {
                    i -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, (this.nextHeaderIndex + 1) + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        void readHeaders() {
            while (!this.source.mo6300e()) {
                int h = this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
                if (h == 128) {
                    throw new IOException("index == 0");
                } else if ((h & 128) == 128) {
                    readIndexedHeader(readInt(h, Hpack.PREFIX_7_BITS) - 1);
                } else if (h == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((h & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(h, 63) - 1);
                } else if ((h & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(h, 31);
                    if (this.maxDynamicTableByteCount < 0 || this.maxDynamicTableByteCount > this.headerTableSizeSetting) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid dynamic table size update ");
                        stringBuilder.append(this.maxDynamicTableByteCount);
                        throw new IOException(stringBuilder.toString());
                    }
                    adjustDynamicTableByteCount();
                } else {
                    if (h != 16) {
                        if (h != 0) {
                            readLiteralHeaderWithoutIndexingIndexedName(readInt(h, 15) - 1);
                        }
                    }
                    readLiteralHeaderWithoutIndexingNewName();
                }
            }
        }

        public List<Header> getAndResetHeaderList() {
            List arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i) {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex < 0 || dynamicTableIndex >= this.dynamicTable.length) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Header index too large ");
                stringBuilder.append(i + 1);
                throw new IOException(stringBuilder.toString());
            }
            this.headerList.add(this.dynamicTable[dynamicTableIndex]);
        }

        private int dynamicTableIndex(int i) {
            return (this.nextHeaderIndex + 1) + i;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private C5869f getName(int i) {
            if (isStaticHeader(i)) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0 && dynamicTableIndex < this.dynamicTable.length) {
                return this.dynamicTable[dynamicTableIndex].name;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(i + 1);
            throw new IOException(stringBuilder.toString());
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            if (i2 > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - this.maxDynamicTableByteCount);
            if (i == -1) {
                if (this.headerCount + 1 > this.dynamicTable.length) {
                    i = new Header[(this.dynamicTable.length * 2)];
                    System.arraycopy(this.dynamicTable, 0, i, this.dynamicTable.length, this.dynamicTable.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = i;
                }
                i = this.nextHeaderIndex;
                this.nextHeaderIndex = i - 1;
                this.dynamicTable[i] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i + (dynamicTableIndex(i) + evictToRecoverBytes)] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private int readByte() {
            return this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
        }

        int readInt(int i, int i2) {
            i &= i2;
            if (i < i2) {
                return i;
            }
            i = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i);
                }
                i2 += (readByte & Hpack.PREFIX_7_BITS) << i;
                i += 7;
            }
        }

        C5869f readByteString() {
            int readByte = readByte();
            Object obj = (readByte & 128) == 128 ? 1 : null;
            readByte = readInt(readByte, Hpack.PREFIX_7_BITS);
            if (obj != null) {
                return C5869f.m24699a(Huffman.get().decode(this.source.mo6306h((long) readByte)));
            }
            return this.source.mo6299d((long) readByte);
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final C8037c out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(C8037c c8037c) {
            this(SETTINGS_HEADER_TABLE_SIZE, true, c8037c);
        }

        Writer(int i, boolean z, C8037c c8037c) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.useCompression = z;
            this.out = c8037c;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.dynamicTable.length - 1; length >= this.nextHeaderIndex && i > 0; length--) {
                    i -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, (this.nextHeaderIndex + 1) + i2, this.headerCount);
                Arrays.fill(this.dynamicTable, this.nextHeaderIndex + 1, (this.nextHeaderIndex + 1) + i2, null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            if (i > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - this.maxDynamicTableByteCount);
            if (this.headerCount + 1 > this.dynamicTable.length) {
                Object obj = new Header[(this.dynamicTable.length * 2)];
                System.arraycopy(this.dynamicTable, 0, obj, this.dynamicTable.length, this.dynamicTable.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = obj;
            }
            int i2 = this.nextHeaderIndex;
            this.nextHeaderIndex = i2 - 1;
            this.dynamicTable[i2] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        void writeHeaders(List<Header> list) {
            if (this.emitDynamicTableSizeUpdate) {
                if (this.smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
                    writeInt(this.smallestHeaderTableSizeSetting, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int intValue;
                int i2;
                Header header = (Header) list.get(i);
                C5869f g = header.name.mo5109g();
                C5869f c5869f = header.value;
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(g);
                if (num != null) {
                    intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (Util.equal(Hpack.STATIC_HEADER_TABLE[intValue - 1].value, c5869f)) {
                            i2 = intValue;
                        } else if (Util.equal(Hpack.STATIC_HEADER_TABLE[intValue].value, c5869f)) {
                            i2 = intValue;
                            intValue++;
                        }
                    }
                    i2 = intValue;
                    intValue = -1;
                } else {
                    intValue = -1;
                    i2 = -1;
                }
                if (intValue == -1) {
                    int length = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length; i3++) {
                        if (Util.equal(this.dynamicTable[i3].name, g)) {
                            if (Util.equal(this.dynamicTable[i3].value, c5869f)) {
                                intValue = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (intValue != -1) {
                    writeInt(intValue, Hpack.PREFIX_7_BITS, 128);
                } else if (i2 == -1) {
                    this.out.m38981b(64);
                    writeByteString(g);
                    writeByteString(c5869f);
                    insertIntoDynamicTable(header);
                } else if (!g.m24709a(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(g)) {
                    writeInt(i2, 63, 64);
                    writeByteString(c5869f);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i2, 15, 0);
                    writeByteString(c5869f);
                }
            }
        }

        void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.m38981b(i | i3);
                return;
            }
            this.out.m38981b(i3 | i2);
            i -= i2;
            while (i >= 128) {
                this.out.m38981b(128 | (i & Hpack.PREFIX_7_BITS));
                i >>>= 7;
            }
            this.out.m38981b(i);
        }

        void writeByteString(C5869f c5869f) {
            if (!this.useCompression || Huffman.get().encodedLength(c5869f) >= c5869f.mo5110h()) {
                writeInt(c5869f.mo5110h(), Hpack.PREFIX_7_BITS, 0);
                this.out.m38968a(c5869f);
                return;
            }
            Object c8037c = new C8037c();
            Huffman.get().encode(c5869f, c8037c);
            c5869f = c8037c.m39021p();
            writeInt(c5869f.mo5110h(), Hpack.PREFIX_7_BITS, 128);
            this.out.m38968a(c5869f);
        }

        void setHeaderTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            i = Math.min(i, SETTINGS_HEADER_TABLE_SIZE_LIMIT);
            if (this.maxDynamicTableByteCount != i) {
                if (i < this.maxDynamicTableByteCount) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, i);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = i;
                adjustDynamicTableByteCount();
            }
        }

        private void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount >= this.dynamicTableByteCount) {
                return;
            }
            if (this.maxDynamicTableByteCount == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
            }
        }
    }

    private Hpack() {
    }

    private static Map<C5869f, Integer> nameToFirstIndex() {
        Map linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        for (int i = 0; i < STATIC_HEADER_TABLE.length; i++) {
            if (!linkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static C5869f checkLowercase(C5869f c5869f) {
        int h = c5869f.mo5110h();
        for (int i = 0; i < h; i++) {
            byte a = c5869f.mo5097a(i);
            if (a >= (byte) 65) {
                if (a <= (byte) 90) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                    stringBuilder.append(c5869f.mo5099a());
                    throw new IOException(stringBuilder.toString());
                }
            }
        }
        return c5869f;
    }
}
