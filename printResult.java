import java.util.ArrayList;
import javax.swing.*;
public class printResult{
    private ArrayList<Result> res = new ArrayList<Result>();

    /* Sort method */
    public String sortByNumber(){
        int count = 0;
        String str = "";
        while(count < res.size()){
            int index = 0, order = 0;
            int largest = 0, largestDiff = 0;
            for(int i = count; i < res.size(); i++){
                if(largest < res.get(i).getBlack()){
                    largest = res.get(i).getBlack();
                    if(largestDiff < largest - res.get(i).getWhite()){
                        largestDiff = largest - res.get(i).getWhite();
                        index = i;
                        order = 1;
                    }
                }
                if(largest < res.get(i).getWhite()){
                    largest = res.get(i).getWhite();
                    if(largestDiff < largest - res.get(i).getBlack()){
                        largestDiff = largest - res.get(i).getBlack();
                        index = i;
                        order = 2;
                    }
                }
            }
            res.add(0, res.remove(index));
            
            if(order == 1){
                str += "Black  ";
                str += String.valueOf(res.get(0).getBlack());
                str += "  ";
                str += String.valueOf(res.get(0).getWhite());
                str += "  White";
            }
            else if(order == 2){
                str += "White  ";
                str += String.valueOf(res.get(0).getWhite());
                str += "  ";
                str += String.valueOf(res.get(0).getBlack());
                str += "  Black";
            }
            str += "\n";
            
            count++;
        }
        return str;
    }

    /* Initialize contructor */
    public printResult(ArrayList<Result> res){
        this.res = res;

        System.out.print("\f" + sortByNumber());
    }

    /* Prints the contents of resArr */
}