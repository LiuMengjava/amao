package com.amao.springboot.manager;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

/**
 *  带证书访问 客户端封装
 */
@Configuration
public class WithCertificateAccessTest {

    private final String PWD = "ros123456";

    /**
     * 带证书访问的httpClient
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            CloseableHttpClient httpClient = acceptsUntrustedCertsHttpClient();
            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            clientHttpRequestFactory.setConnectTimeout(10000);
            clientHttpRequestFactory.setReadTimeout(10000);
            restTemplate = new RestTemplate(clientHttpRequestFactory);

        } catch (Exception e) {
            // restTemplate init 失败  可以打印日志
            e.printStackTrace();
        }
        return restTemplate;
    }

    private CloseableHttpClient acceptsUntrustedCertsHttpClient() throws Exception {
        char[] password = PWD.toCharArray();
        // 跳过服务端证书检查
        SslUtil.ignoreSsl();
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] x509Certificates, String s) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(keyStore("classpath:certificate/amao.jks", password), acceptingTrustStrategy)
                .loadKeyMaterial(keyStore("classpath:certificate/amao.keystore", password), password)    // 加载客户端证书
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();
        return httpClient;
    }

    private KeyStore keyStore(String file, char[] password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream in = ClassUtils.getDefaultClassLoader().getResourceAsStream(file)) {
            keyStore.load(in, password);
        }
        return keyStore;
    }

}