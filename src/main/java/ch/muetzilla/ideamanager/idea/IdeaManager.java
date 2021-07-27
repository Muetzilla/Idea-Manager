package ch.muetzilla.ideamanager.idea;

import ch.muetzilla.ideamanager.fileinputoutput.FileReader;
import ch.muetzilla.ideamanager.fileinputoutput.FileWriter;
import ch.muetzilla.ideamanager.scanner.Scan;

import java.util.ArrayList;

public class IdeaManager {
    private Scan scanner = new Scan();
    private ArrayList<Idea> allIdeas;
    private final String IDEAS_FILE = "ideas.csv";
    private int highestNumber;

    public IdeaManager() {
        FileReader fr = new FileReader();
        allIdeas = new ArrayList<>(fr.readIdeas(IDEAS_FILE).values());
        highestNumber = getHighestIdeaNumber();
        allIdeas.add(new Idea(1, "JUPPI", "JAHAHAH", false));
        ideacontoller();
    }

    private void ideacontoller() {
        int input;
        System.out.println("\n************************** Der Ideen Manager **************************");
        do {
            do {
                System.out.print("Was möchten Sie tun\n" +
                        "1 Eine Idee erfassen\n" +
                        "2 Alle Ideen anzeigen\n" +
                        "3 Alle erldedigten Ideen anzeigen\n" +
                        "4 Alle offenen Ideen anzeigen\n" +
                        "5 Eine Idee als erleditg markieren\n" +
                        "6 Eine Idee bearbeiten\n" +
                        "7 Eine Idee löschen\n" +
                        "0 Das Programm beenden\n" +
                        "> ");
                input = scanner.scanInt();
            } while (input > 7 || input < 0);
            switch (input) {
                case 1:
                    add();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    showAllFinshed();
                    break;
                case 4:
                    showAllUnfinished();
                    break;
                case 5:
                    markAsFinished();
                    break;
                case 6:
                    edit();
                    break;
                case 7:
                    delete();
                    break;
            }
        } while (input != 0);
        FileWriter fw = new FileWriter();
        if (fw.saveIdeasToCsv(allIdeas, IDEAS_FILE)) {
            System.out.println("Ideen erfolgreich gespeichert und Programm beendet");
        }
    }

    private void edit() {
        Idea ideaToEdit = null;
        int ideaInput;
        String ideaTitleInput;
        String ideaDescInput;
        System.out.print("Die Idee mit welcher Nummer soll bearbeitet werden > ");
        ideaInput = scanner.scanInt();
        for (Idea i : allIdeas) {
            if (i.getIdeanumber() == ideaInput) {
                ideaToEdit = i;
            }
        }
        if (ideaToEdit != null) {
            System.out.print("Wie soll der neue Titel der Idee " + ideaToEdit.getIdeaTitle() + " heissen > ");
            ideaTitleInput = scanner.scanString();
            System.out.print("Was soll an der Beschreibung " + ideaToEdit.getIdeaDescrition() + "geändert werden > ");
            ideaDescInput = scanner.scanString();
            ideaToEdit.setIdeaDescrition(ideaDescInput);
            ideaToEdit.setIdeaTitle(ideaTitleInput);
        } else {
            System.out.println("Keine Idee mit der Nummer " + ideaInput + " gefunden.");
        }
    }

    private void delete() {
        Idea ideaToDelete = null;
        int ideainput;
        showAll();
        System.out.print("Die Idee mit welcher Nummer soll gelöscht werden > ");
        ideainput = scanner.scanInt();
        for (Idea i : allIdeas) {
            if (i.getIdeanumber() == ideainput) {
                ideaToDelete = i;
            }
        }
        if (ideaToDelete != null) {
            allIdeas.remove(ideaToDelete);
            System.out.println("Idee erfolgreich gelöscht");
        } else {
            System.out.println("Keine Idee mit der Nummer " + ideainput + " gefunden.");
        }
    }

    private void markAsFinished() {
        Idea ideaToRemark = null;
        int ideainput;
        showAllUnfinished();
        System.out.print("Die Idee mit welcher Nummer soll als erledigt markiert werden > ");
        ideainput = scanner.scanInt();
        for (Idea i : allIdeas) {
            if (i.getIdeanumber() == ideainput) {
                ideaToRemark = i;
            }
        }
        if (ideaToRemark != null) {
            ideaToRemark.setFinished(true);
            System.out.println("Die Idee " + ideaToRemark.getIdeaTitle() + " wurde auf erldedigt geändert.");
        } else {
            System.out.println("Keine Idee mit der Nummer " + ideainput + " gefunden.");
        }

    }

    private void showAllUnfinished() {
        System.out.println("Alle offenen Ideen:");
        for (Idea i : allIdeas) {
            if (!i.isFinished()) {
                System.out.println(i.toString());
            }
        }
        System.out.println();
    }

    private void showAllFinshed() {
        System.out.println("Alle erledigten Ideen:");
        for (Idea i : allIdeas) {
            if (i.isFinished()) {
                System.out.println(i.toString());
            }
        }
        System.out.println();
    }

    private void showAll() {
        System.out.println("Alle Ideen:");
        if (allIdeas != null) {
            for (Idea i : allIdeas) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("Keine Ideen vorhanden");
        }
        System.out.println();
    }

    private void add() {
        Idea newIdea;
        String ideaTitleInput;
        String ideaDescInput;
        System.out.print("Wie lautet der Titel der Idee > ");
        ideaTitleInput = scanner.scanString();
        System.out.print("Wie lautet die Beschreibung der Idee > ");
        ideaDescInput = scanner.scanString();
        highestNumber++;
        newIdea = new Idea(highestNumber, ideaTitleInput, ideaDescInput, false);
        allIdeas.add(newIdea);
        System.out.println("Idee erfolgreich hinzugefügt");
    }

    private int getHighestIdeaNumber() {
        int highestIdeaNumber = 0;
        for (Idea i : allIdeas) {
            if (i.getIdeanumber() > highestIdeaNumber) {
                highestIdeaNumber = i.getIdeanumber();
            }
        }
        return highestIdeaNumber;
    }
}
