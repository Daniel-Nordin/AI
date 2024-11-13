public class Fact {
   String type = "";
   Block blockX = null;
   Block blockY = null; 

    public Fact(String type, Block blockX, Block blockY) {
        this.type = type;
        this.blockX = blockX;
        this.blockY = blockY;
    }

    public Fact(String type, Block blockX){
        this.type = type;
        this.blockX = blockX;
    }

    public Block getBlockX() {
        return blockX;
    }

    public Block getBlockY() {
        return blockY;
    }

    public String getType() {
        return type;
    }

    public void setBlockX(Block blockX) {
        this.blockX = blockX;
    }

    public void setBlockY(Block blockY) {
        this.blockY = blockY;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Fact)){
            return false;
        }
        
        Fact f = (Fact) o;


        return f.type == this.type && f.blockX == this.blockX && f.blockY == this.blockY;
    }

    @Override
    public String toString(){
        String s = "{ " + this.type + ", " + this.blockX;
        if (this.blockY != null) {
            return s + ", " + this.blockY + " }";
        }
        else{
            return s + " }";
        }
    }

}
