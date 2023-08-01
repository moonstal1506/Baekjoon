import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            fileList.add(new File(files[i]));
        }
        Collections.sort(fileList);
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileList.get(i).originalFileName;
        }
        return answer;
    }

    static class File implements Comparable<File> {
        String originalFileName;
        String head;
        int number;

        public File(String originalFileName) {
            this.originalFileName = originalFileName;

            for (int i = 0; i < originalFileName.length(); i++) {
                if (Character.isDigit(originalFileName.charAt(i))) {
                    head = originalFileName.substring(0, i);
                    originalFileName = originalFileName.substring(i, originalFileName.length());
                    break;
                }
            }
            for (int i = 0; i < originalFileName.length(); i++) {
                if (Character.isDigit(originalFileName.charAt(i))) {
                    this.number = this.number * 10 + (originalFileName.charAt(i) - '0');
                } else {
                    break;
                }
            }
        }

        @Override
        public int compareTo(File o) {
            if (this.head.toUpperCase()
                    .equals(o.head.toUpperCase())) {
                return this.number - o.number;
            }
            return this.head.toUpperCase().compareTo(o.head.toUpperCase());
        }
    }
}