#include <jni.h>
#include "strlen.h"
#include <stdio.h>
#include <string.h>

/*
 * Beispiel-Implementierung, getestet mit Borland Compiler BCC32 5.5,
 * kostenlos zu beziehen im Embarcadero Developer Network.
 */
JNIEXPORT jint JNICALL Java_org_meins_jni_StrLen_strlen(
        JNIEnv *env, jclass clazz, jstring s) {
  /*
  printf( "Hallo Welt, aus C!\n" );
  return 0;
   * */
  const char* str;
  int len;

  if (s == NULL) {
    jclass exc = (*env)->FindClass(env, "java/lang/NullPointerException");

    if (exc != NULL)
      (*env)->ThrowNew(env, exc, "(in C code)");

    return -1;
  }

  str = (*env)->GetStringUTFChars(env, s, NULL);

  if (str == NULL) {
    return -1;
  }
  len = strlen(str);

  (*env)->ReleaseStringUTFChars(env, s, str);

  return (jint) len;
  //*/
}