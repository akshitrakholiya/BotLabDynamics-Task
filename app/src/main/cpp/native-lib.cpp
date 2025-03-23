#include <jni.h>
#include <string>
#include <opencv2/core.hpp>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_akshit_botlabdynamics_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_akshit_botlabdynamics_MainActivity_initOpenCV(JNIEnv* env, jobject /* this */) {
    if (cv::getBuildInformation().empty()) {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}