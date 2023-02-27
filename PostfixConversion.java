package project2;

public class PostfixConversion {

    public static boolean validate(String s) {
        //basically just copy pasted from the convert method                                                                                      
        //if it catches any errors, such as a nullpointerexception,                                                                               
        //it should not be in a valid form, so return false                                                                                       
        //otherwise true                                                                                                                          
        try {
            String ret = "";
        LinkedListStack lls = new LinkedListStack();
        for(int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if(isOperand(temp)) {
                ret += temp;
            }
            else if(isOperator(temp)) {
                while(!lls.isEmpty() && isOperator(lls.top().charAt(0))) {
                    if(opPrecedence(lls.top().charAt(0)) - opPrecedence(temp) >= 0) {
                        ret += lls.pop();
                    }
                    else {
                        break;
                    }
                }
                lls.push("" + temp);

            }
            else if(temp == '(') {
                lls.push("" + temp);
            }
            else if(temp == ')') {
                while(lls.top().charAt(0) != '(') {
                    ret += lls.pop();
                }
                lls.pop();
            }
        }
        while(!lls.isEmpty()) {
            Character temp = lls.pop().charAt(0);
            ret += temp;
        }
        return true;
        } catch (Exception e) {

        return false;
        }
    }

    public static String convert(String s) {
        String ret = "";
        LinkedListStack lls = new LinkedListStack();
        for(int i = 0; i < s.length(); i++) { //iterate through the string                                                                        
            Character temp = s.charAt(i);
            if(isOperand(temp)) { //if the char is an operand                                                                                     
                ret += temp;
            }
            else if(isOperator(temp)) { //if the char is an operator                                                                              
                while(!lls.isEmpty() && isOperator(lls.top().charAt(0))) {
                    if(opPrecedence(lls.top().charAt(0)) - opPrecedence(temp) >= 0) { //check if its higher order                                 
                        ret += lls.pop();
                    }
                    else {
                        break;
                    }
                }
                lls.push("" + temp);

            }
            else if(temp == '(') { //if the char is (                                                                                             
                lls.push("" + temp);
            }
            else if(temp == ')') { //if the char is )                                                                                             
                while(lls.top().charAt(0) != '(') { //pop until (                                                                                 
                    ret += lls.pop();
                }
                lls.pop(); //pop the (                                                                                                            
            }
        }
        while(!lls.isEmpty()) { //pop remaining in stack                                                                                          
            Character temp = lls.pop().charAt(0);
            ret += temp;
        }
        return ret;
    }

    public static boolean isOperator(Character c) {
        return c == '-' || c == '+' || c == '*' || c == '/' || c == '^';
    }

    public static int opPrecedence(Character c) {
        if(c == '-' || c == '+') {
            return 0;
        }
        else if(c == '*' || c == '/') {
            return 1;
        }
        else if(c == '^') {
            return 2;
        }
        return -1;
    }

    public static boolean isOperand(Character c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }
}
