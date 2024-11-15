import java.util.ArrayList;

public class Planner {
   public State state = null;
    State goalState = null;
    ArrayList<State> visited = new ArrayList<>();

    public Planner(State initState, State goalState){
        this.state = initState;
        this.goalState = goalState;
        this.visited.add(initState);

    }

    public void checkViableBlocks(){
        for(int i = 0; i < this.state.facts.size(); i++){
            if (this.state.facts.get(i).type == "clear") {
                this.state.viableBlocks.add(this.state.facts.get(i).blockX);
            }
        }
    }

    public String makeMove(){
        /*for(int i = 1; i < viableBlocks.size(); i++){
            Move move = new Move(this.state, viableBlocks.get(i), viableBlocks.get(i-1));
        }*/

        this.state.checkViableMoves();
        for (int index = 0; index < this.state.viableMoves.size(); index++) {
            State tempState = this.state.copy();
            Move move = tempState.viableMoves.get(index);
            tempState = move.doMoveAction();
            if (!this.visited.contains(tempState)) {
                this.visited.add(this.state);
                this.state = tempState;
                return this.state.toString();
            }              
        }
        int lastState = visited.indexOf(this.state);
        //this.state = visited.get(lastState - 1);
       return "dead end";
    }
}
