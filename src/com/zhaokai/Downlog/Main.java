package com.zhaokai.Downlog;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

class DownloadTask implements Callable<String>{
    String url;

    public DownloadTask(String url) {
        this.url = url;
    }
   // @Override
//    public String call() throws Exception {
//        System.out.println("start"+url+"....");
//}
public class Main {
}
