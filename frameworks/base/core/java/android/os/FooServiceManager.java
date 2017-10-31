/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 * Author: Ryan McCoppin
 */

package android.os;

import android.app.ActivityThread;
import android.content.Context;
import android.util.Log;

/**
 * Foo implementation that controls the main system Foo module.
 *
 */
public class FooServiceManager {
    private static final String TAG = "Foo";

    private final IFooService mService;
    private final String mPackageName;

    public FooServiceManager() {
	mPackageName = ActivityThread.currentPackageName();
        mService = IFooService.Stub.asInterface(
                ServiceManager.getService("foo"));
    }
    public FooServiceManager(Context context) {
	mPackageName = context.getOpPackageName();
        mService = IFooService.Stub.asInterface(
                ServiceManager.getService("foo"));
    }

    public boolean hasFoobar() {
        if (mService == null) {
            Log.w(TAG, "Failed to load; no Foo service.");
            return false;
        }
        try {
            return mService.hasFoobar();
        } catch (RemoteException e) {
        }
        return false;
    }

    public void writeData(int data) {
        if (mService == null) {
            Log.w(TAG, "Failed to write data; no Foo service.");
            return;
        }
        try {
            mService.writeData(data);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to write tag.", e);
        }
    }

    public int readData() {
        if (mService == null) {
            Log.w(TAG, "Failed to read data; no Foo service.");
            return -1;
        }
        try {
            return mService.readData();
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to read tag.", e);
        }
	return -1;
    }
    public int getFoobar() {
        if (mService == null) {
            Log.w(TAG, "Failed to read Foobar; no Foo service.");
            return -1;
        }
        try {
            return mService.getFoobar();
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to read Foobar.", e);
        }
	return -1;
    }
}
