package se.inte;

import java.util.ArrayList;

public class Terminal {

    String commandString;
    Folder currentFolder;
    Command currentCommand;
    CommandHistoryDoskey commandHistory;


    public Terminal() {
        commandHistory = new CommandHistoryDoskey();
    }

    public static void main (String[] args){
        Terminal terminal = new Terminal();
        terminal.theCommandLoop();
    }

    public void theCommandLoop() {
        //while(!(command instanceof CommandExit)) {
        int i = 1;
        while(i != 0){
            i = i - 1;
            Command command = new Command();
            Command subCommand = command.executeCommand(this);
            subCommand.execute(this);
            commandHistory.saveCommandToHistory (commandString);
            saveCommandToHistory(commandString);
            currentCommand = subCommand;
        }
    }

    public Folder setCurrentFolderToHomeFolder(){
        while(currentFolder.getParentFolder()!=null){
            currentFolder = currentFolder.getParentFolder();
        }
        return currentFolder;
    }



    public void saveCommandToHistory (String commandString){
        commandHistory.saveCommandToHistory (commandString);
    }

    public ArrayList getCommandHistory(){
        return commandHistory.getCommandHistory ();
    }



    public void setCommandString(String commandString){
        this.commandString = commandString;
    }

    public String getCommandString(){
        return commandString;
    }

    public Command getCurrentCommand(){
        return currentCommand;
    }

    public Terminal getTerminal(){
        return this;
    }

    public void setCurrentFolder(Folder folder){
        currentFolder = folder;
    }

    public Folder getCurrentFolder(){
        return currentFolder;
    }
}
