LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := hello-jni
LOCAL_SRC_FILES := hello-jni.cpp
LOCAL_MODULE_FILENAME := libhello-jni

include $(BUILD_SHARED_LIBRARY)