class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");

        List<String> stack = new ArrayList<>();

        for (String dir : dirs) {
            if (dir.isEmpty()) {
                continue;
            }

            if (dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                }
                continue;
            }

            stack.add(dir);
        }


        return "/" + String.join("/", stack);
    }
}