package android.support.v7.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: WindowCallbackWrapper */
/* renamed from: android.support.v7.view.i */
public class C0648i implements Callback {
    /* renamed from: e */
    final Callback f1679e;

    public C0648i(Callback callback) {
        if (callback != null) {
            this.f1679e = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1679e.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f1679e.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f1679e.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f1679e.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f1679e.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f1679e.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.f1679e.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f1679e.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f1679e.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f1679e.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f1679e.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f1679e.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.f1679e.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.f1679e.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.f1679e.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f1679e.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f1679e.onPanelClosed(i, menu);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f1679e.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.f1679e.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1679e.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f1679e.onWindowStartingActionMode(callback, i);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f1679e.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f1679e.onActionModeFinished(actionMode);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.f1679e.onProvideKeyboardShortcuts(list, menu, i);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.f1679e.onPointerCaptureChanged(z);
    }
}
