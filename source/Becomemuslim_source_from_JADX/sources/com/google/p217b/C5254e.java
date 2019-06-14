package com.google.p217b;

import java.util.List;

/* compiled from: DecodeHintType */
/* renamed from: com.google.b.e */
public enum C5254e {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(C5317t.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    /* renamed from: l */
    private final Class<?> f17732l;

    private C5254e(Class<?> cls) {
        this.f17732l = cls;
    }
}
