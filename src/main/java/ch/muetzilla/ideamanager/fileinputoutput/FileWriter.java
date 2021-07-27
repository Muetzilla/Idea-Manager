package ch.muetzilla.ideamanager.fileinputoutput;


import ch.muetzilla.ideamanager.idea.Idea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class FileWriter {

    public boolean saveIdeasToCsv(Collection<Idea> ideasCollection, String fileName) {
        try {
            java.io.FileWriter ideaSpeicher = new java.io.FileWriter(fileName, false);
            ArrayList<Idea> ideas = new ArrayList<>(ideasCollection);
            for (int i = 0; i < ideas.size(); i++) {
                ideaSpeicher.write(IdeaToCSVLine(i, ideas.get(i)));
            }
            ideaSpeicher.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }


    public String IdeaToCSVLine(int number, Idea i) {
        return i.getIdeanumber() + "," + i.getIdeaTitle() + ","+ i.getIdeaDescrition() + "," + i.isFinished() + "\n";
    }


}

