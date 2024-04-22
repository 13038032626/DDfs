package com.example.mydfs_storage.init;

import com.example.mydfs_storage.spaceController.FileSelf;
import com.example.mydfs_storage.utils.JDBCUtils;
import com.example.mydfs_storage.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MyDataInitializer implements CommandLineRunner {

    @Autowired
    JDBCUtils jdbcUtils;
    @Autowired
    PropertiesUtils propertiesUtils;

    @Override
    public void run(String... args) throws Exception {
        propertiesUtils.setHashMap();

    }
}
