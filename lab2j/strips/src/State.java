import java.util.ArrayList;

public class State {
   ArrayList<Fact> facts = new ArrayList<Fact>();
    public ArrayList<Move> viableMoves = new ArrayList<>();
    public ArrayList<Block> viableBlocks = new ArrayList<>();


   public State(ArrayList<Fact> facts){
    this.facts = facts;
    }

    public ArrayList<Fact> getFacts() {
        return facts;
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
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < facts.size(); index++) {
            sb.append(facts.get(index).toString() + ", ");
        }
        return sb.toString();
    }
}
