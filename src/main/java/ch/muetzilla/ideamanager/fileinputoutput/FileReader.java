package ch.muetzilla.ideamanager.fileinputoutput;

import ch.muetzilla.ideamanager.idea.Idea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReader {


    public Map<Integer, Idea> readIdeas(String fileName) {
        Map<Integer, Idea> gameCharacters = new HashMap<>();
        try {
            List<String> allLines = Files.readAllLines(Path.of(fileName));
            for (String line : allLines) {
                List<String> lineAsStrings = Arrays.asList(line.split(","));
                int nr = Integer.parseInt(lineAsStrings.get(0));
                Idea gameCharacter = new Idea(lineAsStrings.get(1), "M");
                gameCharacters.put(nr, gameCharacter);
            }
        } catch (IOException e) {
            System.out.println("File doesnt exist in : " + fileName);
        }
        return gameCharacters;
    }
}