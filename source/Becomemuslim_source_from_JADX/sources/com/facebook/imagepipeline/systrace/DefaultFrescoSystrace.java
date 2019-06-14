package com.facebook.imagepipeline.systrace;

import android.os.Build.VERSION;
import android.os.Trace;
import com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace;

public class DefaultFrescoSystrace implements Systrace {

    private static final class DefaultArgsBuilder implements ArgsBuilder {
        private final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        public void flush() {
            if (this.mStringBuilder.length() > 127) {
                this.mStringBuilder.setLength(127);
            }
            if (VERSION.SDK_INT >= 18) {
                Trace.beginSection(this.mStringBuilder.toString());
            }
        }

        public ArgsBuilder arg(String str, Object obj) {
            StringBuilder stringBuilder = this.mStringBuilder;
            stringBuilder.append(';');
            stringBuilder.append(str);
            stringBuilder.append('=');
            if (obj == null) {
                str = "null";
            } else {
                str = obj.toString();
            }
            stringBuilder.append(str);
            return this;
        }

        public ArgsBuilder arg(String str, int i) {
            StringBuilder stringBuilder = this.mStringBuilder;
            stringBuilder.append(';');
            stringBuilder.append(str);
            stringBuilder.append('=');
            stringBuilder.append(Integer.toString(i));
            return this;
        }

        public ArgsBuilder arg(String str, long j) {
            StringBuilder stringBuilder = this.mStringBuilder;
            stringBuilder.append(';');
            stringBuilder.append(str);
            stringBuilder.append('=');
            stringBuilder.append(Long.toString(j));
            return this;
        }

        public ArgsBuilder arg(String str, double d) {
            StringBuilder stringBuilder = this.mStringBuilder;
            stringBuilder.append(';');
            stringBuilder.append(str);
            stringBuilder.append('=');
            stringBuilder.append(Double.toString(d));
            return this;
        }
    }

    public void beginSection(String str) {
    }

    public void endSection() {
    }

    public boolean isTracing() {
        return false;
    }

    public ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }
}
