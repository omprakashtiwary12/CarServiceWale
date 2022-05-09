package com.commdel.carservicewale.networking;


import android.util.Pair;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.commdel.carservicewale.BuildConfig;
import com.commdel.carservicewale.util.C;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by Lakshay Juneja on 24,January,2019.
 * Contec Global Infotech Limited
 * lakshay.juneja@cg-infotech.com
 */
public class RetrofitClient {

    private OkHttpClient.Builder getBuilder(final ArrayList<Pair<String, String>> header, TIMEOUTTYPE type) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (type == TIMEOUTTYPE.NORMAL) {
            if (C.dynamicValidation.size() > 0) {
                builder.connectTimeout(Integer.parseInt(C.getDynamicValidationValue(C.DynamicCheck.NORMAL_TIMEOUT)), TimeUnit.SECONDS);
                builder.readTimeout(Integer.parseInt(C.getDynamicValidationValue(C.DynamicCheck.NORMAL_TIMEOUT)), TimeUnit.SECONDS);
            } else {
                builder.connectTimeout(60, TimeUnit.SECONDS);
                builder.readTimeout(60, TimeUnit.SECONDS);
            }
        } else if (type == TIMEOUTTYPE.QUERYBILL) {
            if (C.dynamicValidation.size() > 0) {
                builder.connectTimeout(Integer.parseInt(C.getDynamicValidationValue(C.DynamicCheck.QUERY_BILL_TIMEOUT)), TimeUnit.SECONDS);
                builder.readTimeout(Integer.parseInt(C.getDynamicValidationValue(C.DynamicCheck.QUERY_BILL_TIMEOUT)), TimeUnit.SECONDS);
            } else {
                builder.connectTimeout(60, TimeUnit.SECONDS);
                builder.readTimeout(60, TimeUnit.SECONDS);
            }
        } else if (type == TIMEOUTTYPE.PAYBILL) {
            if (C.dynamicValidation.size() > 0) {
                builder.connectTimeout(Integer.parseInt(C.getDynamicValidationValue(C.DynamicCheck.PAY_BILL_TIMEOUT)), TimeUnit.SECONDS);
                builder.readTimeout(Integer.parseInt(C.getDynamicValidationValue(C.DynamicCheck.PAY_BILL_TIMEOUT)), TimeUnit.SECONDS);
            } else {
                builder.connectTimeout(20, TimeUnit.SECONDS);
                builder.readTimeout(20, TimeUnit.SECONDS);
            }
        }


        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Headers.Builder headerBuilder = new Headers.Builder();
                if (header != null && header.size() > 0) {
                    for (int i = 0; i < header.size(); i++) {
                        headerBuilder.add(header.get(i).first, header.get(i).second);
                    }
                }
                Request request = chain.request().newBuilder()
                        .headers(headerBuilder.build())
                        .build();

                return chain.proceed(request);
            }
        };

        builder.addInterceptor(interceptor);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            try {
//                builder.sslSocketFactory(UtilHandler.getSSlConfig(App.getInstance()).getSocketFactory(), UtilHandler.systemDefaultTrustManager());
//            } catch (CertificateException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (KeyStoreException e) {
//                e.printStackTrace();
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            } catch (KeyManagementException e) {
//                e.printStackTrace();
//            }
//        }

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.interceptors().add(loggingInterceptor);
        }

        return builder;
    }

    public Retrofit getRetrofitClient(ArrayList<Pair<String, String>> headerList, String url, boolean hasScaler, TIMEOUTTYPE type) {
//        OkHttpClient okHttpClient = getUnsafeOkHttpClient();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
//        retrofitBuilder.client(okHttpClient);
        if (url != null)
            retrofitBuilder.baseUrl(url);
        retrofitBuilder.client(getBuilder(headerList, type).build());
        if (hasScaler) {
            retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create());
        }
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());

        return retrofitBuilder.build();
    }


//    private static OkHttpClient getUnsafeOkHttpClient() {
//        try {
//            // Create a trust manager that does not validate certificate chains
//            final TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        @Override
//                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
//                        }
//
//                        @Override
//                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
//                        }
//
//                        @Override
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return new java.security.cert.X509Certificate[]{};
//                        }
//                    }
//            };
//
//            // Install the all-trusting trust manager
//            final SSLContext sslContext = SSLContext.getInstance("SSL");
//            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//            // Create an ssl socket factory with our all-trusting manager
//            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
//
//            OkHttpClient.Builder builder = new OkHttpClient.Builder();
//            builder.sslSocketFactory(sslSocketFactory);
//            builder.hostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    return true;
//                }
//            });
//
//            OkHttpClient okHttpClient = builder.build();
//            return okHttpClient;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public enum TIMEOUTTYPE {
        NORMAL, QUERYBILL, PAYBILL;
    }


}
