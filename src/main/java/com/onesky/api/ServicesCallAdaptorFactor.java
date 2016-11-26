package com.onesky.api;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.logging.Level;

import lombok.extern.java.Log;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

@Log
class ServicesCallAdaptorFactor extends CallAdapter.Factory {

    public static CallAdapter.Factory create() {
        return new ServicesCallAdaptorFactor();
    }

    @Override
    public CallAdapter<Object> get(final Type returnType, Annotation[] annotations, Retrofit retrofit) {
        // if returnType is retrofit2.Call, do nothing
        if (returnType.getTypeName().contains("retrofit2.Call")) {
            return null;
        }

        return new CallAdapter<Object>() {
            @Override
            public Type responseType() {
                return returnType;
            }

            @Override
            public <R> Object adapt(Call<R> call) {
                try {
                    return call.execute().body();
                } catch (IOException e) {
                    log.log(Level.WARNING, "There was a problem adapting the given call to the required object", e);
                    return null;
                }
            }
        };
    }
}
