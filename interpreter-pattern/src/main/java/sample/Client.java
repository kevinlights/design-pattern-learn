package sample;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        System.out.println(handler.output());
    }
}
