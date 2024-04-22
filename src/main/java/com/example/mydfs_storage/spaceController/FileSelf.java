package com.example.mydfs_storage.spaceController;

import com.example.mydfs_storage.utils.JDBCUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Data
public class FileSelf {

    @Autowired
    JDBCUtils jdbcUtils;

    Integer totalSize = 1024 * 1024 * 1024;

    Integer startIndex;
    @Value("${storageNum}")
    Integer storageNum;

    List<String> hashes;

    AtomicInteger vision;

    public static HashMap<Integer, Integer> checkingCount;

    public static HashMap<Integer, byte[]> hotCache = new HashMap<>();

    public FileSelf() {
        startIndex = jdbcUtils.getStartIndex();
    }

    public boolean addFile() {
        int end = startIndex + 1024 * 1024 * 6;
        if (end > totalSize) {
            return false;
        }
        startIndex = end;
        return true;
    }

    public boolean CASToLock() {
        int maxSpins = 15; // 最多自旋次数
        int spins = 0; // 当前自旋次数
        int currentValue;
        int newValue;
        do {
            currentValue = vision.get();
            newValue = currentValue + 1;
            spins++;
        } while (!vision.compareAndSet(currentValue, newValue) && spins < maxSpins);
        if (spins < maxSpins) {
            System.out.println("Vision incremented successfully after " + spins + " spins");
            return true;
        } else {
            System.out.println("Failed to increment vision after maximum spins reached");
            return false;
        }
    }
}
