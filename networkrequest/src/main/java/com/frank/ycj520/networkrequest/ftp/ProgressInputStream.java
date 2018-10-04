package com.frank.ycj520.networkrequest.ftp;

/**
 * PROJECT_NAME:AndroidHttp
 * PACKAGE_NAME:com.frank.ycj520.networkrequest.ftp
 * USER:Frank
 * DATE:2018/10/4
 * TIME:22:23
 * DAY_NAME_FULL:星期四
 * DESCRIPTION:On the description and function of the document
 **/


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import static com.frank.ycj520.networkrequest.ftp.FTPManager.FTP_UPLOAD_LOADING;

public class ProgressInputStream extends InputStream {

    private static final int TEN_KILOBYTES = 1024 * 10; //每上传10K返回一次

    private InputStream inputStream;

    private long progress;
    private long lastUpdate;

    private boolean closed;

    private FTPManager.UploadProgressListener listener;
    private File localFile;

    public ProgressInputStream(InputStream inputStream, FTPManager.UploadProgressListener listener, File localFile) {
        this.inputStream = inputStream;
        this.progress = 0;
        this.lastUpdate = 0;
        this.listener = listener;
        this.localFile = localFile;

        this.closed = false;
    }

    @Override
    public int read() throws IOException {
        int count = inputStream.read();
        return incrementCounterAndUpdateDisplay(count);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int count = inputStream.read(b, off, len);
        return incrementCounterAndUpdateDisplay(count);
    }

    @Override
    public void close() throws IOException {
        super.close();
        if (closed)
            throw new IOException("already closed");
        closed = true;
    }

    private int incrementCounterAndUpdateDisplay(int count) {
        if (count > 0)
            progress += count;
        lastUpdate = maybeUpdateDisplay(progress, lastUpdate);
        return count;
    }

    private long maybeUpdateDisplay(long progress, long lastUpdate) {
        if (progress - lastUpdate > TEN_KILOBYTES) {
            lastUpdate = progress;
            this.listener.onUploadProgress(FTP_UPLOAD_LOADING, progress, this.localFile);
        }
        return lastUpdate;
    }



}

