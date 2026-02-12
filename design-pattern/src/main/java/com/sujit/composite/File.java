package com.sujit.composite;

/** Leaf of the file system tree. */
public class File implements FileSystemComponent {
    private final String name;
    private final long size;

    public File(String name, long size) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("File name must not be blank");
        }
        if (size < 0) {
            throw new IllegalArgumentException("File size must not be negative");
        }
        this.name = name;
        this.size = size;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "- " + name + " (" + size + " bytes)");
    }
}
