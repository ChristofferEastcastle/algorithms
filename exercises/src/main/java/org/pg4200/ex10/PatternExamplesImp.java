package org.pg4200.ex10;

public class PatternExamplesImp implements PatternExamples {
    @Override
    public String dnaRegex() {
        return "(C|G|A|T)+";
    }

    @Override
    public String telephoneNumberRegex() {
        return "(((00|\\+)[0-9]{2})?[0-9]{8})";
    }

    @Override
    public String emailRegex() {
        return "((?s).+)@(?s).+";
    }

    @Override
    public String isItAJoke() {
        return null;
    }
}
