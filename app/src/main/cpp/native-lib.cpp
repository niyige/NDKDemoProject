#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_oyy_ndk_MainActivity_stringFromJNI(
        JNIEnv *env, jobject object) {
    std::string hello = "Hello from C++";

    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_oyy_ndk_MainActivity_testFromJni(JNIEnv *env, jobject instance) {

    // TODO
    std::string hello = "my name is EGan";

    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT jint JNICALL
Java_com_oyy_ndk_FieldJni_addNum(JNIEnv *env, jobject instance) {
    //获取到实例对应的class
    jclass jclazz = env->GetObjectClass(instance);
    //通过class获取到相应变量field 的id
    jfieldID fid = env->GetFieldID(jclazz, "number", "I");

    jint num = env->GetIntField(instance, fid);
    num = num + 5;
    return num;

}extern "C"


JNIEXPORT jstring JNICALL
Java_com_oyy_ndk_FieldJni_getStr(JNIEnv *env, jobject instance) {

    jclass classs = env->GetObjectClass(instance);

    jfieldID pID = env->GetFieldID(classs, "name", "Ljava/lang/String;");

    jstring jstr = (jstring) env->GetObjectField(instance, pID);

    const char *str = env->GetStringUTFChars(jstr, JNI_FALSE);

    char ch[] = "ouyangyi";
    strcat(ch, str);
    jstring new_str = env->NewStringUTF(ch);
    env->SetObjectField(instance, pID, new_str);
    return new_str;
}