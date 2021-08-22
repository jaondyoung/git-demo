package cn.ly.problem;

public class SwitchDemo {

    public static void main(String[] args) {
        String s = "a";
        switch (s){
            case "a":
                System.out.println("you are a ");
                break;
            case "b":
                System.out.println("you are b ");
                break;
            default:
                System.out.println("no");
                break;
        }

    }
}
