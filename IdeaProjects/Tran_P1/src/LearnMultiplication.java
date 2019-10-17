import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;

public class LearnMultiplication {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int right = 0;
        int wrong = 0;
        int level;
        int problem;
        double response;
        char again = 'Y';
        double num1 = 0;
        double num2 = 0;
        boolean incorrect = false;
        int op = 0;

        //checks to see if the user wants to continue learning
        while (again != 'n' && again != 'N') {
            System.out.println("Enter the difficulty level of 1, 2, 3, or 4.");
            level = scnr.nextInt();
            System.out.println("Enter the type of problem to be studied: 1 (Addition), 2 (Subtraction), 3 (Multiplication), 4 (Division), 5 (Mixture of All)");
            problem = scnr.nextInt();

            //implements the question, problem type, and checking of the solution
            for (int i = 0; i <= 9; i++) {
                SecureRandom rng = new SecureRandom();

                //determines whether the program should change the numbers based of whether the response was correct
                if (!incorrect) {
                    num1 = difficulty(level);
                    num2 = difficulty(level);
                }

                //addition
                if (problem == 1) {
                    question(problem, num1, num2);
                    response = scnr.nextDouble();
                    incorrect = check(problem, num1, num2, response);
                    if (incorrect) {
                        wrong++;
                    } else {
                        right++;
                    }

                    //subtraction
                } else if (problem == 2) {
                    question(problem, num1, num2);
                    response = scnr.nextDouble();
                    incorrect = check(problem, num1, num2, response);
                    if (incorrect) {
                        wrong++;
                    } else {
                        right++;
                    }

                    //multiplication
                } else if (problem == 3) {
                    question(problem, num1, num2);
                    response = scnr.nextDouble();
                    incorrect = check(problem, num1, num2, response);
                    if (incorrect) {
                        wrong++;
                    } else {
                        right++;
                    }

                    //division
                } else if (problem == 4) {
                    question(problem, num1, num2);
                    response = scnr.nextDouble();
                    incorrect = check(problem, num1, num2, response);
                    if (incorrect) {
                        wrong++;
                    } else {
                        right++;
                    }

                    //mixture of all
                } else if (problem == 5) {
                    double ans;
                    Random randomNum2 = new Random();
                    //keeps the same problem type if the previous answer was wrong
                    if(!incorrect){
                        op = randomNum2.nextInt(4) + 1;
                    }
                    question(op, num1, num2);
                    ans = scnr.nextDouble();
                    incorrect = check(op, num1, num2, ans);
                    if (incorrect) {
                        wrong++;
                    } else {
                        right++;
                    }
                }
            }

            //prints results
            results(right, wrong);
            System.out.println("Would you like to begin another session? Y or N");
            again = scnr.next().charAt(0);

            //resets values so that way it is a clean reset, should the user choose to use the program again
            num1 = 0;
            num2 = 0;
            right = 0;
            wrong = 0;
            incorrect = false;
        }
    }


    //determines the difficulty of the problems by number of digits
    public static double difficulty(int level)
    {
        SecureRandom rng = new SecureRandom();
        double num1 = 0;
        if (level == 1) {
            num1 = rng.nextInt(9) + 1;
        } else if (level == 2) {
            num1 = rng.nextInt(99) + 1;
        } else if (level == 3) {
            num1 = rng.nextInt(999) + 1;
        } else if (level == 4) {
            num1 = rng.nextInt(9999) + 1;
        }
        return num1;
    }


    //prints results
    public static void results(int right, int wrong) {
        if (right > 7.5) {
            System.out.println("Number of right responses: " + right);
            System.out.println("Number of wrong responses: " + wrong);
            System.out.println("Congratulations, you are ready to go to the next level!");
        } else {
            System.out.println("Number of right responses: " + right);
            System.out.println("Number of wrong responses: " + wrong);
            System.out.println("Please ask your teacher for extra help.");
        }
    }


    //prints type of question depending on the problem type chosen.
    public static void question(int problem, double num1, double num2) {

        if (problem == 1) {
            System.out.println("What is " + num1 + " plus " + num2 + "?");
        }
        else if (problem == 2) {
            System.out.println("What is " + num1 + " minus " + num2 + "?");
        }
        else if (problem == 3) {
            System.out.println("What is " + num1 + " times " + num2 + "?");
        }
        else if (problem == 4) {
            System.out.println("What is " + num1 + " divided by " + num2 + "? (Round to the nearest hundredth.)");
        }
    }


    //checks to see if the response is the correct answer and determines whether to switch the values or not
    public static boolean check(int problem, double num1, double num2, double ans)
    {
        boolean incorrect = false;
        if (problem == 1) {
            if (ans == (num1 + num2)) {
                System.out.println(positive());
                incorrect = false;
            } else {
                System.out.println(negative());
                incorrect = true;
            }
        }
        else if (problem == 2) {
            if (ans == num1 - num2) {
                System.out.println(positive());
                incorrect = false;
            } else {
                System.out.println(negative());
                incorrect = true;
            }
        }
        else if (problem == 3) {
            if (ans == num1 * num2) {
                System.out.println(positive());
                incorrect = false;
            } else {
                System.out.println(negative());
                incorrect = true;
            }
        }
        else if (problem == 4) {
            if (ans == (double) Math.round((num1 / num2) * 100d) / 100d) {
                System.out.println(positive());
                incorrect = false;
            } else {
                System.out.println(negative());
                incorrect = true;
            }
        }
        return incorrect;
    }



    public static String positive() {
        Random randomNum = new Random();
        String s = "";
        switch (randomNum.nextInt(4) + 1) {
            case 1:
                s = ("Very good!");
                break;
            case 2:
                s = ("Excellent!");
                break;
            case 3:
                s = ("Nice work!");
                break;
            case 4:
                s = ("Keep up the good work!");
                break;
            default:
                break;
        }
        return s;
    }

    public static String negative() {
        Random randomNum2 = new Random();
        String s2 = "";
        switch (randomNum2.nextInt(4) + 1) {
            case 1:
                s2 = ("No. Please try again.");
                break;
            case 2:
                s2 = ("Wrong. Try once more.");
                break;
            case 3:
                s2 = ("Don’t give up!");
                break;
            case 4:
                s2 = ("No. Keep trying.");
                break;
            default:
                break;
        }
        return s2;
    }
}