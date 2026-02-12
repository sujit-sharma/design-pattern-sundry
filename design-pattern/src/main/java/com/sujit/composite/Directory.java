package com.sujit.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Composite that contains files and other directories. */
public class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Directory name must not be blank");
        }
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Component must not be null");
        }
        if (component == this) {
            throw new IllegalArgumentException("A directory cannot contain itself");
        }
        children.add(component);
    }

    public boolean remove(FileSystemComponent component) {
        return children.remove(component);
    }

    public List<FileSystemComponent> children() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long size() {
        long total = 0;
        for (FileSystemComponent child : children) {
            total = Math.addExact(total, child.size());
        }
        return total;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "+ " + name + "/ (" + size() + " bytes)");
        for (FileSystemComponent child : children) {
            child.print(indent + "  ");
        }
    }
}
