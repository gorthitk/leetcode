class Solution {
    public String simplifyPath(String path) {
        List<String> dirs = new ArrayList<>();

        String[] pDirs = path.split("/");

        for (String pDir : pDirs) {
            if (pDir.isEmpty()) {
                continue;
            }

            if (pDir.equals(".")) {
                continue;
            }

            if (pDir.equals("..")) {
                if (!dirs.isEmpty()) {
                    dirs.remove(dirs.size() - 1);
                }
                continue;
            }

            dirs.add(pDir);
        }

        StringBuilder sb = new StringBuilder();

        for (String d : dirs) {
            sb.append("/");
            sb.append(d);
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}