package com.facebook.react.uimanager;

import java.util.Comparator;

public class ViewAtIndex {
    public static Comparator<ViewAtIndex> COMPARATOR = new C19691();
    public final int mIndex;
    public final int mTag;

    /* renamed from: com.facebook.react.uimanager.ViewAtIndex$1 */
    static class C19691 implements Comparator<ViewAtIndex> {
        C19691() {
        }

        public int compare(ViewAtIndex viewAtIndex, ViewAtIndex viewAtIndex2) {
            return viewAtIndex.mIndex - viewAtIndex2.mIndex;
        }
    }

    public ViewAtIndex(int i, int i2) {
        this.mTag = i;
        this.mIndex = i2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                ViewAtIndex viewAtIndex = (ViewAtIndex) obj;
                if (this.mIndex == viewAtIndex.mIndex && this.mTag == viewAtIndex.mTag) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.mTag);
        stringBuilder.append(", ");
        stringBuilder.append(this.mIndex);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
