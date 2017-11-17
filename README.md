# android-nougat-service
This is an example system service for Android 7.1 Nougat. There are no updated examples for Nougat and onward, so I thought I would contribute for everyone. This is for AOSP development, not application development

Look at the commit "*Foo system service init*" to see an excellent Diff of the implementation.

## How-To
Add the necessary files. Ensure that you modify the files that already exist in your system, do not just overwrite them! For instance, /frameworks/base/Android.mk needs one line added to your system.

You must clean your build before building to ensure the selinux files take hold. Build. Then also update the api! That should do it!
```
make clean
make -j8
make update-api
```

## Test your system
After booting your new system, you can test out your new service independent of an application by the following command:
```
service call foo 1
```
This will call the first function listed in the aidl file. 2 for the second function and so on. It will return a Parceable object containing the return value!

Enjoy!

