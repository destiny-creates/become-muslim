package com.facebook.react.bridge;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;

public class JsonWriter implements Closeable {
    private final Deque<Scope> mScopes = new ArrayDeque();
    private final Writer mWriter;

    private enum Scope {
        EMPTY_OBJECT,
        OBJECT,
        EMPTY_ARRAY,
        ARRAY
    }

    public JsonWriter(Writer writer) {
        this.mWriter = writer;
    }

    public JsonWriter beginArray() {
        open(Scope.EMPTY_ARRAY, '[');
        return this;
    }

    public JsonWriter endArray() {
        close(']');
        return this;
    }

    public JsonWriter beginObject() {
        open(Scope.EMPTY_OBJECT, '{');
        return this;
    }

    public JsonWriter endObject() {
        close('}');
        return this;
    }

    public JsonWriter name(String str) {
        if (str != null) {
            beforeName();
            string(str);
            this.mWriter.write(58);
            return this;
        }
        throw new NullPointerException("name can not be null");
    }

    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter nullValue() {
        beforeValue();
        this.mWriter.write("null");
        return this;
    }

    public JsonWriter rawValue(String str) {
        beforeValue();
        this.mWriter.write(str);
        return this;
    }

    public JsonWriter value(boolean z) {
        beforeValue();
        this.mWriter.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public JsonWriter value(double d) {
        beforeValue();
        this.mWriter.append(Double.toString(d));
        return this;
    }

    public JsonWriter value(long j) {
        beforeValue();
        this.mWriter.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        beforeValue();
        this.mWriter.append(number.toString());
        return this;
    }

    public void close() {
        this.mWriter.close();
    }

    private void beforeValue() {
        Scope scope = (Scope) this.mScopes.peek();
        switch (scope) {
            case EMPTY_ARRAY:
                replace(Scope.ARRAY);
                return;
            case EMPTY_OBJECT:
                throw new IllegalArgumentException(Scope.EMPTY_OBJECT.name());
            case ARRAY:
                this.mWriter.write(44);
                return;
            case OBJECT:
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown scope: ");
                stringBuilder.append(scope);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void beforeName() {
        Scope scope = (Scope) this.mScopes.peek();
        switch (scope) {
            case EMPTY_ARRAY:
            case ARRAY:
                throw new IllegalStateException("name not allowed in array");
            case EMPTY_OBJECT:
                replace(Scope.OBJECT);
                return;
            case OBJECT:
                this.mWriter.write(44);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown scope: ");
                stringBuilder.append(scope);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void open(Scope scope, char c) {
        this.mScopes.push(scope);
        this.mWriter.write(c);
    }

    private void close(char c) {
        this.mScopes.pop();
        this.mWriter.write(c);
    }

    private void string(String str) {
        this.mWriter.write(34);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    this.mWriter.write("\\b");
                    break;
                case '\t':
                    this.mWriter.write("\\t");
                    break;
                case '\n':
                    this.mWriter.write("\\n");
                    break;
                case '\f':
                    this.mWriter.write("\\f");
                    break;
                case '\r':
                    this.mWriter.write("\\r");
                    break;
                case '\"':
                case '\\':
                    this.mWriter.write(92);
                    this.mWriter.write(charAt);
                    break;
                case ' ':
                case ' ':
                    this.mWriter.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    break;
                default:
                    if (charAt > '\u001f') {
                        this.mWriter.write(charAt);
                        break;
                    }
                    this.mWriter.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    break;
            }
        }
        this.mWriter.write(34);
    }

    private void replace(Scope scope) {
        this.mScopes.pop();
        this.mScopes.push(scope);
    }
}
