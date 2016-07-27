package DAO.impl;

import DAO.TextDAO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Administrator
 * Created by tbpwang
 * 2016/7/27.
 */
public class FileTextDAO implements TextDAO {
    @Override
    public void create(String file) {
        try {
            Files.createFile(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(FileTextDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public String read(String file) {
        byte[] data = null;
        try {
            data = Files.readAllBytes(Paths.get(file));
        } catch (IOException e) {
            Logger.getLogger(FileTextDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return new String(data != null ? data : new byte[0]);
    }

    @Override
    public void save(String file, String text) {
        BufferedWriter writer;
        try {
            writer = Files.newBufferedWriter(Paths.get(file), Charset.forName(System.getProperty("file.encoding")));
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(FileTextDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
