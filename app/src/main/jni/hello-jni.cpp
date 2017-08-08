//
// Created by Zoom.su on 7/27/2017.
//

#include "com_su_androidsample_MainActivity.h"

JNIEXPORT jstring JNICALL Java_com_su_androidsample_MainActivity_stringFromJNI(JNIEnv* env, jobject thiz) {
    jclass clz = env -> GetObjectClass(thiz);
    jmethodID mid = env -> GetMethodID(clz, "count", "(I)V");
    env -> CallVoidMethod(thiz, mid, 10);
    return (*env).NewStringUTF("Hello Su!");
}