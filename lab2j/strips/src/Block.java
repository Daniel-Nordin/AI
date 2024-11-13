public class Block {
   String name = "";
   int weight = 0;
   
   public Block(String name, int weight){
    this.name = name;
    this.weight = weight;
   }

   public String getName() {
       return name;
   }

   public int getWeight() {
       return weight;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void setWeight(int weight) {
       this.weight = weight;
   }

   @Override
   public String toString(){
        return this.name;
    }
}
