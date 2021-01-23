package com.awad.anthony.demos.cache.callbacks;

import com.awad.anthony.demos.cache.exceptions.CacheTimeOutException;

public interface OnTimeOutListener {
    void onTimeOut(String key) throws CacheTimeOutException;
}
