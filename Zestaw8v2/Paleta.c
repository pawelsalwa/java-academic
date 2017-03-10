#include"Paleta.h"

JNIEXPORT void JNICALL 
	Java_Paleta_printText (JNIEnv *env, jobject obj, jobject c) {
		
		
		jclass    cls = (*env)->GetObjectClass(env, c); 
		// Pobranie obiektu klasy ('Kolor') dla obiektu 'c'
		jmethodID mid = (*env)->GetStaticMethodID(env, cls, "values", "()[LKolor;");
		// Pobranie identyfikatora metody 'values' w klasie 'Kolor'
		jobjectArray joa = (*env)->CallStaticObjectMethod(env, c, mid);
		// Pobranie wyniku metody 'values' czyli tablicy wszystkich kolorow
		//values() returns an array containing all of the values of the enum
		//-> zwraca obiekt na ktory wskazuje (pointer instead of reference)
		int len = (*env)->GetArrayLength(env, joa);
		// Pobranie dlugosci tablicy
		
		jfieldID  fidr = (*env)->GetFieldID(env, cls, "r", "D");
		jfieldID  fidg = (*env)->GetFieldID(env, cls, "g", "D");
		jfieldID  fidb = (*env)->GetFieldID(env, cls, "b", "D");
		
		jmethodID kolory = (*env)->GetMethodID(env, cls, "name", "()Ljava/lang/String;"); 


			// To samo co typ 'double'=============================================
		printf("java Paleta \n\n");
		printf("Enum type  'Kolor' contains %d   elements \n", len);		
		int i;
		for(i=0 ; i < len ; i++ ){
			jobject kolor = (*env)->GetObjectArrayElement(env, joa, i);//otrzym ity elem tab joa: (values)
			
			jdouble red = (*env)->GetDoubleField(env, kolor, fidr);
			jdouble green = (*env)->GetDoubleField(env, kolor, fidg);
			jdouble blue = (*env)->GetDoubleField(env, kolor, fidb);
			
			jstring jstr = (*env)->CallObjectMethod(env, kolor, mid);//mid- identyfikator vvalues             
			
			const char* str = (*env)->GetStringUTFChars(env, jstr, NULL); //nie umiem sprawdzic 
			
				
			printf("enum: %s  %f %f %f \n", str,red,green,blue);  
			
			(*env)->ReleaseStringUTFChars(env, jstr, str);
		}
		return;
	}
		
		
		
		
		
		
		
		
