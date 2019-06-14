package com.facebook.stetho.dumpapp;

class UnexpectedFrameException extends DumpappFramingException {
    public UnexpectedFrameException(byte b, byte b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected '");
        stringBuilder.append(b);
        stringBuilder.append("', got: '");
        stringBuilder.append(b2);
        stringBuilder.append("'");
        super(stringBuilder.toString());
    }
}
