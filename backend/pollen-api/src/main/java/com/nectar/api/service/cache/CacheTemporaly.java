package com.nectar.api.service.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CacheTemporaly<U,V> {
    private Cache<U,V> cache = null;
    public CacheTemporaly() {
        this.cache = Caffeine.newBuilder()
            .maximumSize(50)
            .expireAfterWrite(8,java.util.concurrent.TimeUnit.MINUTES) // 15 minutos
            .build();
    }

    public void put(U key, V value) {
        if(this.cache == null || value == null || key == null) {
            throw new RuntimeException("Cache não inicializado ou valor/chave nulos.");
        }
        if(this.cache.asMap().containsKey(key)) {
            throw new RuntimeException("Chave já existente no cache.");
        }
        this.cache.put(key, value);
    }

    public V getIfPresent(U key) {
        if(this.cache == null) {
            throw new RuntimeException("Cache não inicializado ou chave nula.");
        }
        if(key == null) {
            throw new RuntimeException("Chave não existente.");
        }
        return this.cache.getIfPresent(key);
    }

    public void invalidate(U key) {
        if(this.cache == null) {
            throw new RuntimeException("Cache não inicializado ou chave nula.");
        }
        if(key == null) {
            throw new RuntimeException("Chave não existente.");
        }
        this.cache.invalidate(key);
    }

    public void invalidateAll() {
        if(this.cache == null) {
            throw new RuntimeException("Cache não inicializado.");
        }
        this.cache.invalidateAll();
    }

}


