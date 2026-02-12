package com.sujit.composite;

public class CompositePatternApp {
    public static void main(String[] args) {
        Directory project = new Directory("project");
        project.add(new File("README.md", 1200));

        Directory source = new Directory("src");
        source.add(new File("Main.java", 2400));
        source.add(new File("Utils.java", 1800));

        Directory resources = new Directory("resources");
        resources.add(new File("application.properties", 350));
        source.add(resources);
        project.add(source);

        // Call the same operations on a leaf or a composite.
        FileSystemComponent item = project;
        item.print("");
        System.out.println("Total project size: " + item.size() + " bytes");
    }
}
