package com.facebook.react.module.model;

public class ReactModuleInfo {
    private final boolean mCanOverrideExistingModule;
    private final boolean mHasConstants;
    private final boolean mIsCxxModule;
    private final String mName;
    private final boolean mNeedsEagerInit;

    public ReactModuleInfo(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.mName = str;
        this.mCanOverrideExistingModule = z;
        this.mNeedsEagerInit = z2;
        this.mHasConstants = z3;
        this.mIsCxxModule = z4;
    }

    public String name() {
        return this.mName;
    }

    public boolean canOverrideExistingModule() {
        return this.mCanOverrideExistingModule;
    }

    public boolean needsEagerInit() {
        return this.mNeedsEagerInit;
    }

    public boolean hasConstants() {
        return this.mHasConstants;
    }

    public boolean isCxxModule() {
        return this.mIsCxxModule;
    }
}
