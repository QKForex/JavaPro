package com.qkforex.dev.concurrency.chapter10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassloader extends ClassLoader {

    private static final Path DEFAULT_CLASS_DIR = Paths.get("");
    private final Path classDir;

    public MyClassloader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassloader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassloader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = getClassBytes(name);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("can not load class " + name);
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] getClassBytes(String name) throws ClassNotFoundException {

        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The Class " + name + " not Found.");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("load the class " + name + " occurs error.");

        }
    }

    @Override
    public String toString() {
        return "MyClassLoader";
    }
}
