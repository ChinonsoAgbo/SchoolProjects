package de.hhn.prog2.lab07;

public class GenericsExercise<T>{
    private T typVariable;

    /**
     * Es soll beim Ausführen folgendes informationen ausgeben
     * @param u parameter variable
     * @param <GenericMethode> dient als platzhalter
     */
    public  <GenericMethode> void checkType(GenericMethode u ){
        System.out.printf(this.typVariable + " is of type  %s%n", u.getClass().getName());


    }
    public T getTypVariable() {
        return typVariable;
    }

    public void setTypVariable(T typVariable) {
        this.typVariable = typVariable;
    }

    public static void main(String[] args) {
        GenericsExercise<String> stringGene = new GenericsExercise<>();
        stringGene.setTypVariable("Hello");
        stringGene.checkType("Hello"); //Typ variable bestimmen:  Hello is of type  java.lang.String

        GenericsExercise< Integer > integerGenericsExercise = new GenericsExercise<>();
        integerGenericsExercise.setTypVariable(41);
        integerGenericsExercise.checkType(41); // 41 is of type  java.lang.Integer

        GenericsExercise<Character> characterGenericsExercise = new GenericsExercise<>();
        characterGenericsExercise.setTypVariable('A');
        characterGenericsExercise.checkType(characterGenericsExercise.getTypVariable()); // A is of type  java.lang.Character

        GenericsExercise<Double> doubleGenericsExercise = new GenericsExercise<>();
        doubleGenericsExercise.setTypVariable(3.1337);
        doubleGenericsExercise.checkType(doubleGenericsExercise.getTypVariable());






    }
}
