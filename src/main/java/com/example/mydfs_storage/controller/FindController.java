package com.example.mydfs_storage.controller;

import com.example.mydfs_storage.spaceController.FileSelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class FindController {

    /*
        用于找文件
     */

    @Autowired
    FileSelf fileSelf;

    HashMap<Integer,byte[]> cache = FileSelf.hotCache;
    HashMap<Integer,Integer> timesCount = new HashMap<>();
    public Integer findFileIndex(String hash){
        List<String> hashes = fileSelf.getHashes();
        int index = hashes.indexOf(hash);
        return index;
    }
    public byte[] getFile(Integer index) throws IOException {
        if(cache.containsKey(index)){
            return cache.get(index);
        }
        int startIndex = 4*1024*1024*index;
        byte[] bytes = new byte[4*1024*1024];
        FileInputStream inputStream = new FileInputStream("1GBFile.dat");
        inputStream.read(bytes,startIndex,bytes.length);

        if(timesCount.containsKey(index)){
            Integer currTime = timesCount.get(index);
            if(currTime >= 20){
                cache.put(index,bytes);
            }
        }else {
            timesCount.put(index,1);
        }
        return bytes;
    }
}
