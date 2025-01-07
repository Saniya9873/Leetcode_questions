//import java.io.IOException;
public class Exception_handling {
    // TRY , CATRCH  AND FINALLY  BLOCK :
    // public static void main(String[] args) {
    //    try{
    //     int a[]=new int[5];
    //     a[5]=30/0;
    //    }
    //    catch(ArithmeticException a){
    //     System.out.println("task1 is completed");
    //    } 
    //    catch(ArrayIndexOutOfBoundsException b){
    //     System.out.println("task2 is completed");
    //    }
    //    finally{
    //     System.out.println("finally block");
    //    }
    // }


    //THROW  KEYWORD :
    // static void validate(int age){
    //     if(age<18){
    //         throw new ArithmeticException("not valid");
    //     }
    //     else{
    //         System.out.println("welcome to vote");
    //     }
    // }
    // public static void main(String[] args) {
    //     validate(13);
    //     System.out.println("rest of code");
    // }


    //Throws  KEYWORD :
        // SYNTAX:
        //     return_type methodname() throws exception_classname{}

    // void m() throws IOException{
    //     throw new IOException("device error");
    // }
    // void n() throws IOException{
    //     m();
    // }
    // void p(){
    //     try{
    //         n();
    //     }catch(Exception e){
    //         System.out.println("exception handled");
    //     }
    // }
    // public static void main(String[] args) {
    //     Exception_handling obj=new Exception_handling();
    //     obj.p();
    //     System.out.println("normal flow");
    // }


    //CUSTOM  EXCEPTION :
    public static void validateage(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or above");
        }else{
            System.out.println("valid age :"+age);
        }
    }
    public static void main(String[] args) {
        try{
            validateage(16);
        }catch(InvalidAgeException e){
            System.out.println("caught exception :"+e.getMessage());
        }
        try{
            validateage(20);
        }
        catch(InvalidAgeException e){
            System.out.println("caught exception :"+e.getMessage());
        }
    }

}
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}

