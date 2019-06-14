package com.facebook.react.views.switchview;

import android.content.Context;
import android.support.v7.widget.bk;

class ReactSwitch extends bk {
    private boolean mAllowChange = true;

    public ReactSwitch(Context context) {
        super(context);
    }

    public void setChecked(boolean z) {
        if (this.mAllowChange && isChecked() != z) {
            this.mAllowChange = false;
            super.setChecked(z);
        }
    }

    void setOn(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
        }
        this.mAllowChange = true;
    }
}
