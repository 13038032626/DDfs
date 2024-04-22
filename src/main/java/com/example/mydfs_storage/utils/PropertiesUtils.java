package com.example.mydfs_storage.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

@Component
public class PropertiesUtils {

    public HashMap<Integer,Integer> setHashMap() throws IOException, ClassNotFoundException {
        File file = new File("111");
        FileInputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) objectInputStream.readObject();
        return map;
    }
}
