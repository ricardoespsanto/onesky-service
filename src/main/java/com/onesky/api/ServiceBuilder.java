package com.onesky.api;

import java.io.IOException;
import java.util.Map;

import com.onesky.api.security.Authentication;

import org.apache.commons.lang3.StringUtils;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A RetroFit builder that will automatically hook up with the Authentication required to make calls to the OneSky API.
 * This implementation uses Gson and OkHttpClient to due its work.
 */
public class ServiceBuilder {

    private static final String DOMAIN = StringUtils
            .defaultString(System.getenv("onesky.api.url"), "https://platform.api.onesky.io/1/");

    private ServiceBuilder() {
        // Preventing instantiation
    }

    public static Retrofit build(String apiKey, String apiSecret) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(getAuthenticationInterceptor(apiKey, apiSecret)).addInterceptor(getLoggerInterceptor())
                .build();

        return new Retrofit.Builder().baseUrl(DOMAIN).addConverterFactory(GsonConverterFactory.create())
                .client(httpClient).addCallAdapterFactory(new ServicesCallAdaptorFactor()).build();
    }

    private static Interceptor getAuthenticationInterceptor(final String apiKey, final String apiSecret) {
        return new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl.Builder httpUrlBuilder = originalHttpUrl.newBuilder();

                for (Map.Entry<String, String> authEntry : Authentication.getAuthentication(apiSecret, apiKey)
                        .entrySet()) {
                    httpUrlBuilder.addQueryParameter(authEntry.getKey(), authEntry.getValue());
                }

                Request.Builder requestBuilder = original.newBuilder().url(httpUrlBuilder.build());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }

    private static Interceptor getLoggerInterceptor() {
        HttpLoggingInterceptor loggerInterceptor = new HttpLoggingInterceptor();
        loggerInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggerInterceptor;
    }
}
