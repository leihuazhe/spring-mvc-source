package com.maple.mvc.util;

import java.io.File;
import java.io.IOException;

/**
 * desc: FileUtil
 *
 * @author hz.lei
 * @since 2018年08月22日 下午4:22
 */
public class FileUtil {

    public static final File createTempDir(String prefix, int port) {
        try {
            File tempDir = File.createTempFile(prefix + ".", "." + port);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir;
        } catch (IOException ex) {
            throw new WebServerException(
                    "Unable to create tempDir. java.io.tmpdir is set to "
                            + System.getProperty("java.io.tmpdir"),
                    ex);
        }
    }
}
