package pairmatching.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.next();
    }
}
