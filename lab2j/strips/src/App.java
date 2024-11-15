import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        //Create all blocks
        Block blockA = new Block("A", 3);
        Block blockB = new Block("B", 2);
        Block blockC = new Block("C", 1);
        Block floor1 = new Block("Floor1", 0);
        Block floor2 = new Block("Floor2", 0);
        Block floor3 = new Block("Floor3", 0);

        Fact fact1 = new Fact("on", blockA, blockB);
        Fact fact2 = new Fact("on", blockB, blockC);
        Fact fact3 = new Fact("on", blockC, floor1);
        Fact clear1 = new Fact("clear", blockA);
        Fact clear2 = new Fact("clear", floor2);
        Fact clear3 = new Fact("clear", floor3);



        ArrayList<Fact> initFacts = new ArrayList<Fact>();
        initFacts.add(fact1);
        initFacts.add(fact2);
        initFacts.add(fact3);
        initFacts.add(clear3);
        initFacts.add(clear1);
        initFacts.add(clear2);

        Fact fact4 = new Fact("on", blockC, floor3);
        Fact goal5 = new Fact("clear", floor2);
        Fact goal6 = new Fact("clear", floor1);

        ArrayList<Fact> goalFacts = new ArrayList<Fact>();
        goalFacts.add(fact1);
        goalFacts.add(fact2);
        goalFacts.add(fact4);
        goalFacts.add(clear1);
        goalFacts.add(goal5);
        goalFacts.add(goal6);

        //states created
        State initState = new State(initFacts);
        State goalState = new State(goalFacts);

        //move action
        Planner planner = new Planner(initState, goalState);
        while (!planner.state.facts.containsAll(goalFacts)) {
            planner.checkViableBlocks();
            System.out.println("State: " + planner.makeMove());
            System.out.println("goal: " + goalState);
        }
        System.out.println("Finnished!");
        
       



    }
}
