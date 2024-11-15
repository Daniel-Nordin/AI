import java.util.ArrayList;
import java.util.Objects;

public class State {
   ArrayList<Fact> facts = new ArrayList<Fact>();
    public ArrayList<Move> viableMoves = new ArrayList<>();
    public ArrayList<Block> viableBlocks = new ArrayList<>();


   public State(ArrayList<Fact> facts){
    this.facts = facts;
    }

    public State copy() {
        // Create a new list for facts and copy each Fact object
        ArrayList<Fact> factsCopy = new ArrayList<>();
        for (Fact fact : this.facts) {
            factsCopy.add(new Fact(fact)); // Ensure Fact class has a copy constructor
        }
    
        // Create a new list for viableBlocks and copy each Block object
        ArrayList<Block> viableBlocksCopy = new ArrayList<>();
        for (Block block : this.viableBlocks) {
            viableBlocksCopy.add(block); // Ensure Block class has a copy constructor
        }
    
        // Create a new list for viableMoves and copy each Move object
        ArrayList<Move> viableMovesCopy = new ArrayList<>();
        for (Move move : this.viableMoves) {
            viableMovesCopy.add(move); // Ensure Move class has a copy constructor
        }
    
        // Create a new State object with the copied facts
        State copy = new State(factsCopy);
        copy.viableBlocks = viableBlocksCopy;
        copy.viableMoves = viableMovesCopy;
    
        return copy;
    }

    public ArrayList<Fact> getFacts() {
        return facts;
    }

    public ArrayList<Move> getMoves(){
        return this.viableMoves;
    }

    public ArrayList<Block> getBlocks(){
        return this.viableBlocks;
    }

    public void addFact(Fact fact){
        this.facts.add(fact);        
    }

    public void delFact(Fact fact){
        this.facts.remove(fact);
    }


    public void checkViableMoves(){
        for (int i = 0; i < this.viableBlocks.size(); i++) {
            Block currentBlock = viableBlocks.get(i);
            for (int index = 0; index < this.viableBlocks.size(); index++) {
                if(i != index){
                    Move curMove = new Move(this, currentBlock, this.viableBlocks.get(index));
                    if (curMove.allowed) {
                        this.viableMoves.add(curMove);
                    }
                }
            }
        }
    }


    @Override
    public boolean equals(Object o){
        State s = (State) o;
        return this.facts.containsAll(s.facts);
    }

    @Override
    public String toString(){
        facts.sort((a, b) -> {return a.toString().compareTo(b.toString());});
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < facts.size(); index++) {
            sb.append(facts.get(index).toString() + ", ");
        }
        return sb.toString();
    }

     @Override
    public int hashCode() {
        return Objects.hash(facts, viableBlocks); // Generate a hash code based on fields
    }
}
