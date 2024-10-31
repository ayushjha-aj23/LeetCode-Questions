class Solution {

    // Step-by-Step Breakdown
    // 1. Initialize Variables:
    //  a. Create a list to store the justified lines.
    //  b. Use a temporary list to collect words for the current line.
    //  c. Track the current length of the line.

    // 2.  Iterate Over Words:
    //  a. For each word, check if adding it to the current line exceeds maxWidth.
    //  b. If it does, justify the current line and reset for the next line.
    //  c. If it doesn't, add the word to the current line and update the length.

    // 3. Justification Logic:
    //  a. For a line with more than one word:
    //  b. Calculate the total number of spaces needed.
    //  c. Determine the number of gaps between words.
    //  d. Distribute spaces evenly, with any extra spaces placed on the left.
    //  e. For the last line or lines with a single word, left-justify by adding spaces only at the end.

    // 4. Return the Result:
    //  a. Return the list of justified lines.

    /*
    public List<String> fullJustify(String[] words, int maxWidth) {
         List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            // Check if adding the next word would exceed maxWidth
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                // Justify the current line
                for (int i = 0; i < maxWidth - currentLength; i++) {
                    currentLine.set(i % (currentLine.size() - 1 == 0 ? 1 : currentLine.size() - 1), 
                                    currentLine.get(i % (currentLine.size() - 1 == 0 ? 1 : currentLine.size() - 1)) + " ");
                }
                StringBuilder justifiedLine = new StringBuilder();
                for (String w : currentLine) {
                    justifiedLine.append(w);
                }
                result.add(justifiedLine.toString());
                currentLine.clear();
                currentLength = 0;
            }

            currentLine.add(word);
            currentLength += word.length();
        }

        // Handle the last line
        StringBuilder lastLine = new StringBuilder(String.join(" ", currentLine));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }
    */




    // Method 2: 
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            // Check if adding the next word would exceed maxWidth
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                // Calculate spaces needed
                int totalSpaces = maxWidth - currentLength;
                if (currentLine.size() == 1) {  // Special case for a single word
                    result.add(currentLine.get(0) + " ".repeat(totalSpaces));
                } else {
                    int spaceBetweenWords = totalSpaces / (currentLine.size() - 1);
                    int extraSpaces = totalSpaces % (currentLine.size() - 1);
                    
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < currentLine.size() - 1; i++) {
                        line.append(currentLine.get(i));
                        line.append(" ".repeat(spaceBetweenWords + (i < extraSpaces ? 1 : 0)));
                    }
                    line.append(currentLine.get(currentLine.size() - 1));  // Add the last word
                    result.add(line.toString());
                }

                // Reset for the next line
                currentLine.clear();
                currentLength = 0;
            }

            currentLine.add(word);
            currentLength += word.length();
        }

        // Handle the last line
        String lastLine = String.join(" ", currentLine);
        result.add(lastLine + " ".repeat(maxWidth - lastLine.length()));

        return result;
    }
}
