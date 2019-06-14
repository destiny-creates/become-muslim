package com.facebook.stetho.inspector.network;

import android.annotation.SuppressLint;
import java.util.ArrayList;

public class MimeMatcher<T> {
    private final ArrayList<MimeMatcherRule> mRuleMap = new ArrayList();

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private class MimeMatcherRule {
        private final boolean mHasWildcard;
        private final String mMatchPrefix;
        private final T mResultIfMatched;

        public MimeMatcherRule(String str, T t) {
            if (str.endsWith("*") != null) {
                this.mHasWildcard = true;
                this.mMatchPrefix = str.substring(0, str.length() - 1);
            } else {
                this.mHasWildcard = false;
                this.mMatchPrefix = str;
            }
            if (this.mMatchPrefix.contains("*") == null) {
                this.mResultIfMatched = t;
                return;
            }
            t = new StringBuilder();
            t.append("Multiple wildcards present in rule expression ");
            t.append(str);
            throw new IllegalArgumentException(t.toString());
        }

        public boolean match(String str) {
            boolean z = false;
            if (!str.startsWith(this.mMatchPrefix)) {
                return false;
            }
            if (this.mHasWildcard || str.length() == this.mMatchPrefix.length()) {
                z = true;
            }
            return z;
        }

        public T getResultIfMatched() {
            return this.mResultIfMatched;
        }
    }

    public void addRule(String str, T t) {
        this.mRuleMap.add(new MimeMatcherRule(str, t));
    }

    public void clear() {
        this.mRuleMap.clear();
    }

    public T match(String str) {
        int size = this.mRuleMap.size();
        for (int i = 0; i < size; i++) {
            MimeMatcherRule mimeMatcherRule = (MimeMatcherRule) this.mRuleMap.get(i);
            if (mimeMatcherRule.match(str)) {
                return mimeMatcherRule.getResultIfMatched();
            }
        }
        return null;
    }
}
