import javafx.scene.shape.Line;
@FunctionalInterface
public interface LineInfoDisplayer {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ;
    }
      
    public static LineInfoDisplayer createLineInfoDisplayer(InfoType type) {

    	switch(type) {
//    	case DISTANCE: return (Line line) -> "The Distance is ";
    		case DISTANCE:return  (Line line) ->{
    			double deltaX = line.getEndX() - line.getStartX();
    			double deltaY = line.getEndY() - line.getStartY();
    			double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    			return Double.toString(distance);
    		};
    		
    		case MIDPOINT: return (Line line) -> {
    			double midX = (line.getStartX()+ line.getEndX())/2;
    			double midY = (line.getStartY() + line.getEndY())/2;
    			String midpoint = Double.toString(midX)+ ", " + Double.toString(midY);
    			return midpoint;
    		};
    		
    		case VERTHORZ: return (Line line)-> {
    			double rise = line.getEndY() - line.getStartY();
    			double run = line.getEndX() - line.getEndX();
    			boolean horizontal = rise == 0;
    			boolean vertical = run == 0;
    			return "Vertical? " + vertical + " Horizontal? " + horizontal;  
    		};
    	}
    	
    	return null;
    }

}
