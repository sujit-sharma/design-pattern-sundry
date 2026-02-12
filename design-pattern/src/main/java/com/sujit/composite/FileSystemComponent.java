package com.sujit.composite;

/** A file system item that can be used uniformly as a file or directory. */
public interface FileSystemComponent {
    String name();

    /** Returns the total size in bytes represented by this item. */
    long size();

    /** Prints this item and any children, indented by the supplied depth. */
    void print(String indent);
}
