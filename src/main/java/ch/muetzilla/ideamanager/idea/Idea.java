package ch.muetzilla.ideamanager.idea;

public class Idea {
    private int ideanumber;
    private boolean finished;
    private String ideaTitle;
    private String ideaDescrition;

    public Idea() {
    }

    public Idea(String ideaTitle, String ideaDescrition) {
        this.ideaTitle = ideaTitle;
        this.ideaDescrition = ideaDescrition;
    }

    public Idea(int ideanumber, String ideaTitle, String ideaDescrition, boolean finished) {
        this.ideaTitle = ideaTitle;
        this.ideaDescrition = ideaDescrition;
        this.ideanumber = ideanumber;
        this.finished = finished;
    }


    public String getIdeaTitle() {
        return ideaTitle;
    }

    public void setIdeaTitle(String ideaTitle) {
        this.ideaTitle = ideaTitle;
    }

    public String getIdeaDescrition() {
        return ideaDescrition;
    }

    public void setIdeaDescrition(String ideaDescrition) {
        this.ideaDescrition = ideaDescrition;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getIdeanumber() {
        return ideanumber;
    }

    public void setIdeanumber(int ideanumber) {
        this.ideanumber = ideanumber;
    }

    @Override
    public String toString() {
        return "Nummer: " + ideanumber + " Titel: " + ideaTitle + " Beschreibung: " + ideaDescrition + " Erledigt: " + finished;
    }
}
