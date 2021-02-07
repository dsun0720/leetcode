package ds.leetcode.dailychallenge;

import java.util.Stack;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <p>
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 * <p>
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (char c : path.toCharArray()) {
            if ('/' == c) {
                String s = sb.toString();
                check(stack, s);
                sb = new StringBuffer();
            } else
                sb.append(c);
        }
        if (sb.length() > 0) {
            check(stack, sb.toString());
        }
        sb = new StringBuffer();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return (sb.length() == 0) ? "/" : sb.toString();
    }

    private void check(Stack<String> stack, String s) {
        switch (s) {
            case "..":
                if (!stack.isEmpty())
                    stack.pop();
                break;
            case ".":
                break;
            default:
                if (!s.isEmpty())
                    stack.push(s);
        }
    }

}
