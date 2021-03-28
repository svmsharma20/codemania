package edu.interview_bit.string;

import java.util.HashMap;
import java.util.Map;

public class ValidNumber {

    private static boolean isStatesInitialized = false;

    private static State START_STATE = new State();
    private static State PLUS_STATE = new State();
    private static State MINUS1_STATE = new State();
    private static State MINUS2_STATE = new State();
    private static State DOT1_STATE = new State();
    private static State DOT2_STATE = new State();
    private static State EXPONENTIAL_STATE = new State();
    private static State DIGIT1_STATE = new State();
    private static State DIGIT2_STATE = new State();
    private static State DIGIT3_STATE = new State();
    private static State INVALID_STATE = new State();

    public static void main(String[] args) {
        String[] nums = {"-1.2", "+1.2", "0001234", "-1234", "12e34", "-1.2e-34", "1234",
                    "12.34", "-12.34", "abc", "1 a", "3.", "100L"};
        for(String n : nums){
            System.out.println(n + " => " +isValidNumber(n));
        }

    }

    private static boolean isValidNumber(final String number) {
        initStates();
        String num = number.trim();
        int i=0;
        State curentState = START_STATE;
        while(i<num.length()){
            InputType charType = getInputType(num.charAt(i));
            curentState = curentState.getOutgoingState(charType);
            if(curentState==null || curentState == INVALID_STATE){
                return false;
            }
            i++;
        }

        return curentState.isFinalState();
    }

    private static InputType getInputType(char input) {
       switch (input){
           case 'e':
               return InputType.EXPONENTIAL;

           case '-':
               return InputType.MINUS;

           case '+':
               return InputType.PLUS;

           case '.':
               return InputType.DOT;

           case '0':
           case '1':
           case '2':
           case '4':
           case '5':
           case '3':
           case '6':
           case '7':
           case '8':
           case '9':
               return InputType.DIGITS;

           default :
               return InputType.INVALID;
       }
    }

    private static void initStates(){

        if(!isStatesInitialized){
            Map<InputType, State> outgoingMap = new HashMap<>();

            // initialize start state with outgoing map
            outgoingMap.put(InputType.MINUS, MINUS1_STATE);
            outgoingMap.put(InputType.DIGITS, DIGIT1_STATE);
            outgoingMap.put(InputType.DOT, DOT1_STATE);
            outgoingMap.put(InputType.PLUS, PLUS_STATE);
            outgoingMap.put(InputType.INVALID, INVALID_STATE);
            START_STATE.setOutgoingMap(outgoingMap);
            START_STATE.setIsFinalState(false);

            outgoingMap = new HashMap<>();

            // initialize minus1 state with outgoing map
            outgoingMap.put(InputType.DIGITS,DIGIT1_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            MINUS1_STATE.setOutgoingMap(outgoingMap);
            MINUS1_STATE.setIsFinalState(false);

            // initialize plus state with outgoing map
            outgoingMap.put(InputType.DIGITS,DIGIT1_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            PLUS_STATE.setOutgoingMap(outgoingMap);
            PLUS_STATE.setIsFinalState(false);

            outgoingMap = new HashMap<>();

            // initialize dot1 state with outgoing map
            outgoingMap.put(InputType.DIGITS,DIGIT3_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            DOT1_STATE.setOutgoingMap(outgoingMap);
            DOT1_STATE.setIsFinalState(false);

            outgoingMap = new HashMap<>();

            // initialize digit1 state with outgoing map
            outgoingMap.put(InputType.DOT, DOT2_STATE);
            outgoingMap.put(InputType.EXPONENTIAL,EXPONENTIAL_STATE);
            outgoingMap.put(InputType.DIGITS,DIGIT1_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            DIGIT1_STATE.setOutgoingMap(outgoingMap);
            DIGIT1_STATE.setIsFinalState(true);

            outgoingMap = new HashMap<>();

            // initialize dot2 state with outgoing map
            outgoingMap.put(InputType.DIGITS,DIGIT2_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            DOT2_STATE.setOutgoingMap(outgoingMap);
            DOT2_STATE.setIsFinalState(false);

            outgoingMap = new HashMap<>();

            // initialize exponential state with outgoing map
            outgoingMap.put(InputType.MINUS,MINUS2_STATE);
            outgoingMap.put(InputType.DIGITS,DIGIT3_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            EXPONENTIAL_STATE.setOutgoingMap(outgoingMap);
            EXPONENTIAL_STATE.setIsFinalState(false);

            outgoingMap = new HashMap<>();

            // initialize digit2 state with outgoing map
            outgoingMap.put(InputType.EXPONENTIAL,EXPONENTIAL_STATE);
            outgoingMap.put(InputType.DIGITS,DIGIT2_STATE);
            outgoingMap.put(InputType.INVALID,INVALID_STATE);
            DIGIT2_STATE.setOutgoingMap(outgoingMap);
            DIGIT2_STATE.setIsFinalState(true);

            outgoingMap = new HashMap<>();

            // initialize minus2 state with outgoing map
            outgoingMap.put(InputType.DIGITS, DIGIT3_STATE);
            outgoingMap.put(InputType.INVALID, INVALID_STATE);
            MINUS2_STATE.setOutgoingMap(outgoingMap);
            MINUS2_STATE.setIsFinalState(false);

            outgoingMap = new HashMap<>();

            // initialize digit3 state with outgoing map
            outgoingMap.put(InputType.DIGITS, DIGIT3_STATE);
            outgoingMap.put(InputType.INVALID, INVALID_STATE);
            DIGIT3_STATE.setOutgoingMap(outgoingMap);
            DIGIT3_STATE.setIsFinalState(true);

            isStatesInitialized = true;
        }
    }


    enum InputType {
        DIGITS,
        MINUS,
        DOT,
        EXPONENTIAL,
        INVALID,
        PLUS;
    }

    static class State {

        private Map<InputType, State> outgoing;
        private boolean isFinalState;

        State(){}

        State(Map<InputType, State> outgoing, boolean isFinalState){
            this.outgoing = new HashMap<>(outgoing);
            this.isFinalState = isFinalState;
        }

        public State getOutgoingState(InputType inputType){
            return outgoing.get(inputType);
        }

        public void setOutgoingMap(Map<InputType, State> outgoing){
            this.outgoing = outgoing;
        }

        public void setIsFinalState(boolean isFinalState){
            this.isFinalState = isFinalState;
        }

        public boolean isFinalState(){
            return isFinalState;
        }
    }
}
