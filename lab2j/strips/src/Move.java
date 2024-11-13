import java.util.ArrayList;

public class Move {
    public boolean allowed = false;
    Block blockToMove = null;
    Block destination = null;
    Block fromBlock = null;
    State state = null;

    public Move(State state, Block blockToMove, Block destination){
        this.blockToMove = blockToMove;
        this.destination = destination;
        this.state = state;


        for(int i = 0; i < state.facts.size(); i++){
            if (state.facts.get(i).blockX == blockToMove && state.facts.get(i).type == "on"){
                this.fromBlock = state.facts.get(i).blockY;
            }
        }
        Fact xClear = new Fact("clear", blockToMove);
        Fact destClear = new Fact("clear", destination);
        ArrayList<Fact> preRec = new ArrayList<>();
        preRec.add(destClear);
        preRec.add(xClear);
        this. allowed = state.facts.containsAll(preRec) && (blockToMove.weight > destination.weight) && blockToMove.weight != 0;

    }

    public State doMoveAction(){
        Fact unClearDest = new Fact("clear", destination);
        Fact delOn = new Fact("on", blockToMove, fromBlock);
        ArrayList<Fact> delEffect = new ArrayList<>();
        delEffect.add(delOn);
        delEffect.add(unClearDest);

        Fact onFact = new Fact("on", blockToMove, destination);
        Fact clearLast = new Fact("clear", fromBlock);
        ArrayList<Fact> addEffect = new ArrayList<>();
        addEffect.add(onFact);
        addEffect.add(clearLast);

        this.state.facts.removeAll(delEffect);
        this.state.facts.addAll(addEffect);
        return this.state;
    }
    
}
