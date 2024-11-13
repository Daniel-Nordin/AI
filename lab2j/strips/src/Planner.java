import java.util.ArrayList;

public class Planner {
   public State state = null;
    State goalState = null;
    ArrayList<State> visited = new ArrayList<>();

    public Planner(State initState, State goalState){
        this.state = initState;
        this.goalState = goalState;

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
         Move move = this.state.viableMoves.get(index);
         if (!this.visited.contains(move.doMoveAction())) {
            this.state = move.doMoveAction();
            this.state.viableBlocks = new ArrayList<Block>();
            this.state.viableMoves = new ArrayList<Move>();
            this.visited.add(this.state);
            return this.state.toString();
         }              
        }
       return "dead end";
    }
}
