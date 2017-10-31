/*
 * Copyright (C) 2008 The Android Open Source Project
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

package com.android.server; //org.rrmhearts.foo;

import android.util.Log;
import android.util.Slog;


import android.content.Context;

//import org.rrmhearts.foo.IFooService;
import android.os.IFooService;
import com.android.server.SystemService;

public class FooService extends IFooService.Stub {

	private final Context mContext;
	private static final String TAG = FooService.class.getSimpleName();
	private static final boolean DEBUG = true;


	public FooService(Context context) {
		//super(context);
		if (DEBUG){
		    Slog.d(TAG, "Build Foo service");
		}
		mContext = context;
	}
    
	@Override //BinderCall
	public boolean hasFoobar() {
		if (DEBUG){
		Slog.d(TAG, "Call Foo:hasFoobar service");
		}
		/*
		* We do not really need the nativePointer here;
		* Just to show how arguments are passed to JNI from Java
		*/
		//fooFunction_native(mNativePointer);
		return true;
	}
	@Override
	public void writeData(int data) {
	    if (DEBUG){
		Slog.d(TAG, "Foo: Writing tag.");
	    }
	    /*
	     * We do not really need the nativePointer here;
	     * Just to show how arguments are passed to JNI from Java
	     */
	    //fooFunction_native(mNativePointer);
	}
	@Override
	public int readData() {
	    if (DEBUG){
		Slog.d(TAG, "Foo: Reading tag");
	    }
	    /*
	     * We do not really need the nativePointer here;
	     * Just to show how arguments are passed to JNI from Java
	     */
	    //fooFunction_native(mNativePointer);
		return 0xE0;
	}
	@Override
	public int getFoobar() {
	    if (DEBUG){
		Slog.d(TAG, "Foo: Reading Foobar");
	    }
	    /*
	     * We do not really need the nativePointer here;
	     * Just to show how arguments are passed to JNI from Java
	     */
	    //fooFunction_native(mNativePointer);
		return 0xD0;
	}
    /* Native functions declarations */
    private long mNativePointer;
    private static native long init_native();
    private static native void fooFunction_native(long nativePointer);

}
