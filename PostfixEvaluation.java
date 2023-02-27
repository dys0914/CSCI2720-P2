package project2;

public class PostfixEvaluation {
    public static boolean validate(String s) {
        //basically copy pasted from the eval method                                                                                              
        //if any part of the eval method goes wrong                                                                                               
        //it will only be because of the form's validness                                                                                         
        //return true if it runs without any errors                                                                                               
        //otherwise false                                                                                                                         
        try
            {
        LinkedListStack lls = new LinkedListStack();
        for(int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if(isOperand(temp)) {
                lls.push("" + temp);
            }
            else if(isOperator(temp)) {
                int a = Integer.parseInt(lls.pop());
                int b = Integer.parseInt(lls.pop());
                if(temp == '-') {
                    lls.push("" + (b - a));
                }
                else if(temp == '+') {
                    lls.push("" + (b + a));
                }
                else if(temp == '*') {
                    lls.push("" + (b * a));
                }
                else if(temp ==  '/') {
                    lls.push("" + (b / a));
                }
                else if(temp == '^') {
                    lls.push("" + pow(b, a));
                }
            }
        }

        return true;
            }
        catch (Exception e) {
            return false;
        }
    }
    public static int eval(String s) {
        LinkedListStack lls = new LinkedListStack();
        for(int i = 0; i < s.length(); i++) { //iterate through the string                                                                        
            Character temp = s.charAt(i);
            if(isOperand(temp)) { //if the char is an operand                                                                                     
                lls.push("" + temp);
            }
            else if(isOperator(temp)) { //if the char is an operator                                                                              
                int a = Integer.parseInt(lls.pop()); //pop twice                                                                                  
                int b = Integer.parseInt(lls.pop()); //and evaluate according to the operator, then push                                          
                if(temp == '-') {
                    lls.push("" + (b - a));
                }
                else if(temp == '+') {
                    lls.push("" + (b + a));
                }
                else if(temp == '*') {
                    lls.push("" + (b * a));
                }
                else if(temp ==  '/') {
                    lls.push("" + (b / a));
                }
                else if(temp == '^') {
                    lls.push("" + pow(b, a));
                }
            }
        }
        return Integer.parseInt(lls.pop()); //return the last number in the stack                                                                 
    }

    public static boolean isOperand(Character c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }

    public static boolean isOperator(Character c) {
        return c == '-' || c == '+' || c == '*' || c == '/' || c == '^';
    }

    public static int pow(int b, int a) {
        int ret = b;
        for(int i = 0; i < a-1; i++) {
            ret *= b;
        }
        return ret;
    }

}


