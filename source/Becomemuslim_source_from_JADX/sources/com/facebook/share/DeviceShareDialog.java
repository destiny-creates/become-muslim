package com.facebook.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.C3178i;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

public class DeviceShareDialog extends FacebookDialogBase<ShareContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.DeviceShare.toRequestCode();

    public static class Result {
    }

    protected AppCall createBaseAppCall() {
        return null;
    }

    protected List<ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    public DeviceShareDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public DeviceShareDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    public DeviceShareDialog(C3178i c3178i) {
        super(new FragmentWrapper(c3178i), DEFAULT_REQUEST_CODE);
    }

    protected boolean canShowImpl(ShareContent shareContent, Object obj) {
        if ((shareContent instanceof ShareLinkContent) == null) {
            if ((shareContent instanceof ShareOpenGraphContent) == null) {
                return null;
            }
        }
        return true;
    }

    protected void showImpl(ShareContent shareContent, Object obj) {
        if (shareContent != null) {
            if ((shareContent instanceof ShareLinkContent) == null) {
                if ((shareContent instanceof ShareOpenGraphContent) == null) {
                    obj = new StringBuilder();
                    obj.append(getClass().getSimpleName());
                    obj.append(" only supports ShareLinkContent or ShareOpenGraphContent");
                    throw new FacebookException(obj.toString());
                }
            }
            obj = new Intent();
            obj.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
            obj.setAction(DeviceShareDialogFragment.TAG);
            obj.putExtra(UriUtil.LOCAL_CONTENT_SCHEME, shareContent);
            startActivityForResult(obj, getRequestCode());
            return;
        }
        throw new FacebookException("Must provide non-null content to share");
    }

    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                if (intent.hasExtra("error") != 0) {
                    facebookCallback.onError(((FacebookRequestError) intent.getParcelableExtra("error")).getException());
                    return true;
                }
                facebookCallback.onSuccess(new Result());
                return true;
            }
        });
    }
}
