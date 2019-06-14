package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedResultAsyncTask<Result> extends AsyncTask<Void, Void, Result> {
    private final ReactContext mReactContext;

    protected abstract Result doInBackgroundGuarded();

    protected abstract void onPostExecuteGuarded(Result result);

    protected GuardedResultAsyncTask(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    protected final Result doInBackground(Void... voidArr) {
        try {
            return doInBackgroundGuarded();
        } catch (Void[] voidArr2) {
            this.mReactContext.handleException(voidArr2);
            throw voidArr2;
        }
    }

    protected final void onPostExecute(Result result) {
        try {
            onPostExecuteGuarded(result);
        } catch (Result result2) {
            this.mReactContext.handleException(result2);
        }
    }
}
