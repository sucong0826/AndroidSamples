//
// Created by Zoom.su on 7/27/2017.
//

#include "com_su_androidsample_MainActivity.h"

JNIEXPORT jstring JNICALL Java_com_su_androidsample_MainActivity_stringFromJNI(JNIEnv* env, jobject thiz) {
    jclass clz = env -> GetObjectClass(thiz);
    jmethodID mid = env -> GetMethodID(clz, "count", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;");
    jfieldID seat_pos = env -> GetStaticFieldID(clz, "SEAT_POS", "I");


    jstring myPrefix = env->NewStringUTF("Zoom_");
    jstring mySuffix = env->NewStringUTF("_Staff");
    jint count = env->GetStaticIntField(clz, seat_pos);

    jstring result = (jstring) env -> CallObjectMethod(thiz, mid, myPrefix, count, mySuffix);

    env -> DeleteLocalRef(myPrefix);
    env -> DeleteLocalRef(mySuffix);

    return result;
}