/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class FileSystem
{
    private File parent = new File();

    public FileSystem()
    {
        File root = new File("root");
        parent.directories.put("", root);
    }

    public List<String> ls(String path)
    {
        String[] dirs = path.split("/");
        File current = dirs.length == 0 ? parent.directories.get("") : parent;
        for (String dir : dirs)
        {
            current = current.directories.get(dir);
        }
        List<String> result = new ArrayList<String>();
        if (current.isFile)
        {
            result.add(current.name);
            return result;
        }
        result.addAll(current.directories.keySet());
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path)
    {
        String[] dirs = path.split("/");
        File current = dirs.length == 0 ? parent.directories.get("") : parent;
        for (String dir : dirs)
        {
            if (!current.directories.containsKey(dir))
            {
                current.directories.put(dir, new File(dir));
            }
            current = current.directories.get(dir);
        }
    }

    public void addContentToFile(String filePath, String content)
    {
        String[] dirs = filePath.split("/");
        File current = dirs.length == 0 ? parent.directories.get("") : parent;
        for (String dir : dirs)
        {
            if (!current.directories.containsKey(dir))
            {
                current.directories.put(dir, new File(dir));
            }
            current = current.directories.get(dir);
        }
        current.isFile = true;
        current.content.append(content);
    }

    public String readContentFromFile(String filePath)
    {
        String[] dirs = filePath.split("/");
        File current = dirs.length == 0 ? parent.directories.get("") : parent;
        for (String dir : dirs)
        {
            if (!current.directories.containsKey(dir))
            {
                current.directories.put(dir, new File(dir));
            }
            current = current.directories.get(dir);
        }
        return current.content.toString();
    }

    class File
    {
        boolean isFile = false;
        String name;
        Map<String, File> directories = new HashMap<String, FileSystem.File>();
        StringBuilder content = new StringBuilder();

        public File(String name)
        {
            super();
            this.name = name;
        }

        public File()
        {
            super();
        }
    }
}