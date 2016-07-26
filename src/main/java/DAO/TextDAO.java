package DAO;

import javax.print.DocFlavor;

/**
 * Administrator
 * Created by tbpwang
 * 2016/7/26.
 */
public interface TextDAO {
    void create(String file);
    String read(String file);
    void save(String file, String text);
}
