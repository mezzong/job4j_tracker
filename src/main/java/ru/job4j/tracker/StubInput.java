package ru.job4j.tracker;

public class StubInput implements Input {

    private Output out;
    private String[] answers;
    private int position = 0;

    public StubInput(Output out, String[] answers) {
        this.out = out;
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        out.println(question);
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
