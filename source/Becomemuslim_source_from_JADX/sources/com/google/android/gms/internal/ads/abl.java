package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum abl {
    DOUBLE(0, abn.SCALAR, aby.DOUBLE),
    FLOAT(1, abn.SCALAR, aby.FLOAT),
    INT64(2, abn.SCALAR, aby.LONG),
    UINT64(3, abn.SCALAR, aby.LONG),
    INT32(4, abn.SCALAR, aby.INT),
    FIXED64(5, abn.SCALAR, aby.LONG),
    FIXED32(6, abn.SCALAR, aby.INT),
    BOOL(7, abn.SCALAR, aby.BOOLEAN),
    STRING(8, abn.SCALAR, aby.STRING),
    MESSAGE(9, abn.SCALAR, aby.MESSAGE),
    BYTES(10, abn.SCALAR, aby.BYTE_STRING),
    UINT32(11, abn.SCALAR, aby.INT),
    ENUM(12, abn.SCALAR, aby.ENUM),
    SFIXED32(13, abn.SCALAR, aby.INT),
    SFIXED64(14, abn.SCALAR, aby.LONG),
    SINT32(15, abn.SCALAR, aby.INT),
    SINT64(16, abn.SCALAR, aby.LONG),
    GROUP(17, abn.SCALAR, aby.MESSAGE),
    DOUBLE_LIST(18, abn.VECTOR, aby.DOUBLE),
    FLOAT_LIST(19, abn.VECTOR, aby.FLOAT),
    INT64_LIST(20, abn.VECTOR, aby.LONG),
    UINT64_LIST(21, abn.VECTOR, aby.LONG),
    INT32_LIST(22, abn.VECTOR, aby.INT),
    FIXED64_LIST(23, abn.VECTOR, aby.LONG),
    FIXED32_LIST(24, abn.VECTOR, aby.INT),
    BOOL_LIST(25, abn.VECTOR, aby.BOOLEAN),
    STRING_LIST(26, abn.VECTOR, aby.STRING),
    MESSAGE_LIST(27, abn.VECTOR, aby.MESSAGE),
    BYTES_LIST(28, abn.VECTOR, aby.BYTE_STRING),
    UINT32_LIST(29, abn.VECTOR, aby.INT),
    ENUM_LIST(30, abn.VECTOR, aby.ENUM),
    SFIXED32_LIST(31, abn.VECTOR, aby.INT),
    SFIXED64_LIST(32, abn.VECTOR, aby.LONG),
    SINT32_LIST(33, abn.VECTOR, aby.INT),
    SINT64_LIST(34, abn.VECTOR, aby.LONG),
    DOUBLE_LIST_PACKED(35, abn.PACKED_VECTOR, aby.DOUBLE),
    FLOAT_LIST_PACKED(36, abn.PACKED_VECTOR, aby.FLOAT),
    INT64_LIST_PACKED(37, abn.PACKED_VECTOR, aby.LONG),
    UINT64_LIST_PACKED(38, abn.PACKED_VECTOR, aby.LONG),
    INT32_LIST_PACKED(39, abn.PACKED_VECTOR, aby.INT),
    FIXED64_LIST_PACKED(40, abn.PACKED_VECTOR, aby.LONG),
    FIXED32_LIST_PACKED(41, abn.PACKED_VECTOR, aby.INT),
    BOOL_LIST_PACKED(42, abn.PACKED_VECTOR, aby.BOOLEAN),
    UINT32_LIST_PACKED(43, abn.PACKED_VECTOR, aby.INT),
    ENUM_LIST_PACKED(44, abn.PACKED_VECTOR, aby.ENUM),
    SFIXED32_LIST_PACKED(45, abn.PACKED_VECTOR, aby.INT),
    SFIXED64_LIST_PACKED(46, abn.PACKED_VECTOR, aby.LONG),
    SINT32_LIST_PACKED(47, abn.PACKED_VECTOR, aby.INT),
    SINT64_LIST_PACKED(48, abn.PACKED_VECTOR, aby.LONG),
    GROUP_LIST(49, abn.VECTOR, aby.MESSAGE),
    MAP(50, abn.MAP, aby.VOID);
    
    private static final abl[] ae = null;
    private static final Type[] af = null;
    /* renamed from: Z */
    private final aby f14213Z;
    private final int aa;
    private final abn ab;
    private final Class<?> ac;
    private final boolean ad;

    static {
        af = new Type[0];
        abl[] values = values();
        ae = new abl[values.length];
        int length = values.length;
        int i;
        while (i < length) {
            abl abl = values[i];
            ae[abl.aa] = abl;
            i++;
        }
    }

    private abl(int i, abn abn, aby aby) {
        Class a;
        this.aa = i;
        this.ab = abn;
        this.f14213Z = aby;
        switch (abm.f14214a[abn.ordinal()]) {
            case 1:
            case 2:
                a = aby.m17954a();
                break;
            default:
                a = null;
                break;
        }
        this.ac = a;
        boolean z = false;
        if (abn == abn.SCALAR) {
            switch (abm.f14215b[aby.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.ad = z;
    }

    /* renamed from: a */
    public final int m17928a() {
        return this.aa;
    }
}
