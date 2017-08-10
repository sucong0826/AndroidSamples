//
// Created by Clever Su on 09/08/2017.
//

// import header from current workspace using ""
# include "com_su_androidsample_basicjni_BasicJni.h"

JNIEXPORT jobject JNICALL Java_com_su_androidsample_basicjni_BasicJni_generateBooks(JNIEnv *env, jobject thiz) {

    const unsigned int ARRAY_SIZE = 3;
    jobjectArray names = (jobjectArray) (env -> NewObjectArray(ARRAY_SIZE, env -> FindClass("java/lang/String"), 0));
    jdoubleArray prices = env -> NewDoubleArray(ARRAY_SIZE);
    jlongArray sncodes = env -> NewLongArray(ARRAY_SIZE);

    for (int i = 0; i < ARRAY_SIZE; i++) {
        jstring name = env -> NewStringUTF("Java");
        jdouble pricesTmp[3];
        jlong sncodesTmp[3];

        pricesTmp[i] = (i + 1) * 2.4;
        sncodesTmp[i] = (i + 1) * 100;

        env -> SetObjectArrayElement(names, i, name);
        env -> SetDoubleArrayRegion(prices, 0, ARRAY_SIZE, pricesTmp);
        env -> SetLongArrayRegion(sncodes, 0, ARRAY_SIZE, sncodesTmp);
    }

    // get class type by function of FindClass
    jclass arraylist_clz = env -> FindClass("java/util/ArrayList");
    jclass book_clz      = env -> FindClass("com/su/androidsample/basicjni/entity/Book");

    if (arraylist_clz != NULL) {
        // get the method id of ArrayList constructor
        jmethodID arraylist_cst = env -> GetMethodID(arraylist_clz, "<init>", "()V");

        // Now there creates an instance of array list
        jobject booklist_obj    = env -> NewObject(arraylist_clz, arraylist_cst);

        // get the method id of add(Object obj)
        jmethodID arraylist_add = env -> GetMethodID(arraylist_clz, "add", "(Ljava/lang/Object;)Z");

        // get the constructor of Book
        jmethodID book_cst      = env -> GetMethodID(book_clz, "<init>", "()V");

        jmethodID setbookprice_mid  = env -> GetMethodID(book_clz, "setBookPrice", "(D)V");
        jmethodID setbookname_mid   = env -> GetMethodID(book_clz, "setBookName", "(Ljava/lang/String;)V");
        jmethodID setbooksncode_mid = env -> GetMethodID(book_clz, "setSnCode", "(J)V");

        jdouble priceBuf[3];
        jlong sncodeBuf[3];

        env -> GetDoubleArrayRegion(prices, 0, ARRAY_SIZE, priceBuf);
        env -> GetLongArrayRegion(sncodes, 0, ARRAY_SIZE, sncodeBuf);

        for(unsigned int i = 0; i < 3; i++) {
            // create a book object
            jobject book = env -> NewObject(book_clz, book_cst);
            jstring bookName = (jstring) (env -> GetObjectArrayElement(names, i));

            env -> CallVoidMethod(book, setbookname_mid, bookName);
            env -> CallVoidMethod(book, setbookprice_mid, priceBuf[i]);
            env -> CallVoidMethod(book, setbooksncode_mid, sncodeBuf[i]);

            // call add method to add book to list
            env -> CallBooleanMethod(booklist_obj, arraylist_add, book);
        }

        return booklist_obj;
    }

    return NULL;
}
